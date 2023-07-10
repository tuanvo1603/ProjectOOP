package crawl.historicsites;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.fasterxml.jackson.databind.ObjectMapper;

import crawl.Crawl;
import models.HistoricSite;

public class CrawlHistoricalSites extends Crawl {
	public static void crawlSites() throws IOException {
		String url = "https://vi.wikipedia.org/wiki/Danh_sách_Di_tích_quốc_gia_Việt_Nam";
		Document doc = null;
		Document doc1 = null;
		ObjectMapper objectMapper = new ObjectMapper();
		int count = 0;
		try {
			doc = Jsoup.connect(url).timeout(1200000).get();

		} catch (Exception e) {
			System.out.println("Can not connect url!");
		}
		Elements sups = doc.select("sup");
		for (Element sup : sups) {
			sup.remove();
		}
		Elements tables = doc.select("table.wikitable.sortable");
		System.out.println(tables.size());

		for (int i = 0; i < tables.size(); i++) {
			Element table = tables.get(i);
			Elements rows = table.select("tr");
			for (int j = 1; j < rows.size(); j++) {
				Element row = rows.get(j);
				Elements columns = row.select("td");
				Matcher matcher;
				String historicSiteString;
				String location;
				String type;
				String approvedYear;
				String describe = "";
				String note = "";
				String relatedFestival;
				ArrayList<String> relatedThings = new ArrayList<String>();

				if (i == 21) {
					historicSiteString = columns.get(1).text();
					location = "";
					type = "";
					approvedYear = "";
					relatedFestival = "";

					String regexLink = columns.get(1).select("a[href]").attr("abs:href");
					String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
					Pattern pattern = Pattern.compile(regex);
					matcher = pattern.matcher(regexLink);
				} else {

					historicSiteString = columns.get(0).text();
					location = "";
					type = columns.get(2).text();
					describe = "";
					note = "";
					relatedFestival = "";

					if (columns.size() < 4)
						approvedYear = null;
					else
						approvedYear = columns.get(3).text();
					if (columns.size() < 5)
						note = "";
					else
						note = columns.get(4).text();

					// Connect href to continue to crawl data
					String regexLink = columns.get(0).select("a[href]").attr("abs:href");
					String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
					Pattern pattern = Pattern.compile(regex);
					matcher = pattern.matcher(regexLink);
				}
				while (matcher.find()) {
					String Link = matcher.group();
					Link = URLDecoder.decode(Link, "UTF-8");

					try {
						doc1 = Jsoup.connect(Link).get();
						sups = doc.select("sup");
						sups.remove();

						try {
							Element firstPara = doc1.select("p").first();
							String textPara = firstPara.text();

							// Crawl describe and location
							describe = extractWordsAfterKeyword(textPara, "là");
							location = extractLocation(textPara);
							if (location.equals("") || location == null)
								if (i == 21)
									location = columns.get(2).text();
								else
									location = columns.get(1).text();

							// Crawl related things
							Elements hrefText = doc1.select("a[href]");
							for (int m = 0; m < hrefText.size(); m++) {
								// Filter
								if (notCharName(hrefText.get(m).attr("title")))
									continue;
								// Filter more
								if (countSpaces(hrefText.get(m).attr("title")) < 3
										&& !hrefText.get(m).attr("title").equals("")
										&& !hrefText.get(m).attr("title").contains("null")) {
									if (peopleCheck(hrefText.get(m).attr("title")))
										if (checkOccurrence(hrefText.get(m).attr("title"), relatedThings))
											relatedThings.add(hrefText.get(m).attr("title"));
										else
											continue;
								} else
									continue;
							}
							// Crawl festival
							Elements paraFestivals = doc1.select("h2");
							for (Element paraFestival : paraFestivals) {
								if (paraFestival.text().contains("Lễ hội")) {
									String[] textFestival = paraFestival.nextElementSibling().text().split("\\.");
									for (String sentence : textFestival) {
										if (sentence.contains("Lễ hội") || sentence.contains("lễ hội")
												|| sentence.contains("Hội") || sentence.contains("hội")) {
											relatedFestival += sentence;

											break;
										}
									}
								}
							}
							// Crawl time
						} catch (Exception e) {
							continue;
						}
					} catch (HttpStatusException e) {
						if (e.getStatusCode() == 404) {
							break;
						} else {
							System.out.println("A different HTTP error occurred: " + e.getStatusCode());
							// Handle other HTTP errors as needed.
						}
					} catch (IOException e) {
						System.out.println("An error occurred while connecting to the website: " + e.getMessage());
						// Handle other types of IOExceptions as needed.
					}
				}
				// Edit other cases
				if (describe == "")
					describe = "Không có";
				else
					describe = "là " + describe;
				if (note.equals(""))
					note = "Không có";
				if (location.equals("") || location == null)
					location = "Chưa rõ";
				if (relatedFestival.equals("") || relatedFestival == null)
					relatedFestival = "Chưa rõ";

				HistoricSite historicSite = new HistoricSite(historicSiteString, location, type, approvedYear, describe,
						note, relatedThings, relatedFestival);

				String jsonData = objectMapper.writeValueAsString(historicSite);
				String fileName = "data" + (count + 1) + ".json";
				System.out.println(count);
				count++;
				String directory = "src/main/resources/Json/HistoricSites";
				FileWriter fileWriter = new FileWriter(new File(directory, fileName));
				fileWriter.write(jsonData);
				fileWriter.close();
			}
		}
	}
}
