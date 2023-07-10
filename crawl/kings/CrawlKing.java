package crawl.kings;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.select.Elements;
import java.lang.String;
import java.net.URLDecoder;

import com.google.gson.*;
import models.King;

public class CrawlKing {

	public static void crawlKing() throws IOException {
		String name = null;
		String label = null;
		String otherName = null;
		String government = null;
		String birth = null;
		String death = null;
		int count = 0;
		int count1 = 0;
		String[] Eras = new String[25];
		final Gson gson = new Gson();
		final String url = "https://vi.wikipedia.org/wiki/Vua_Việt_Nam";
		try {
			final Document doc = Jsoup.connect(url).get();
			System.out.println(doc.title());
			doc.select("sup").remove();
			Elements rows = doc.select("tr[style*=\"height:50px;\"]");
			King[] kings = new King[rows.size()];
			for (Element row : rows) {
				Element link = row.select("tr td:nth-child(2)").first();
				name = link.text().replaceAll("\\[+[0-9a-zA-Z]+\\]", "");
				Element hrefs = link.select("a[href]").first();
				String hreff = "https://vi.wikipedia.org" + hrefs.attr("href");
				try {
					Document document = Jsoup.connect(URLDecoder.decode(hreff, "UTF-8")).get();
					System.out.println("Dang crawl " + hreff);
					Element box = document.getElementsByClass("infobox").first();
					if (box != null) {
						Elements trs = box.getElementsByTag("tr");
						for (Element tr : trs) {
							death = tr.text();
							if (death.startsWith("Sinh")) {
								birth = tr.text().replaceAll(
										"\\[+[0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+\\]",
										"");
								birth = birth.replaceAll("\\bSinh ?\\b", "");
							}
							if (death.startsWith("Mất")) {
								death = tr.text().replaceAll(
										"\\[+[0-9aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+\\]",
										"");
								death = death.replaceAll("\\bMất ?\\b", "");
								break;
							} else
								death = "?";
						}
					}

				} catch (HttpStatusException e) {
					// handle the HTTP error status code here
					int statusCode = e.getStatusCode();
					if (statusCode == 400 || statusCode == 404) {
						birth = "?";
						death = "?";
						System.out.println("Error: " + e.getMessage());
					} else {
						e.printStackTrace();
					}
				} catch (IOException e) {
					// handle any other IO exceptions here
					e.printStackTrace();
				}
				label = row.select("tr td:nth-child(5)").text().replaceAll("\\[+[0-9a-zA-Z]+\\]", "");
				otherName = row.select("tr td:nth-child(n+8)").text().replaceAll("\\[+[0-9a-zA-Z]+\\]", "");
				government = row.select("tr td:nth-child(7)").text().replaceAll("\\[+[0-9a-zA-Z]+\\]", "");
				kings[count] = new King(count + 1, name, birth, death, null, label, otherName, government);
				birth = "?";
				death = "?";
				count++;

			}
			Elements div = doc.getElementsByClass("vector-toc-text");
			for (Element thoiKy : div) {
				Element thuTu = thoiKy.getElementsByClass("vector-toc-numb").first();
				if (thuTu != null && !NumberUtils.isDigits(thuTu.text()) && Double.parseDouble(thuTu.text()) > 1
						&& Double.parseDouble(thuTu.text()) < 11) {
					Eras[count1] = thoiKy.text().replaceAll("\\((.*?)\\)|[0-9.]|hoặc", "");
					Eras[count1] = Eras[count1].trim();
					count1++;
				}
			}
			count1 = 0;
			int count2 = 0;
			Elements tables = doc.getElementsByTag("table");
			for (Element table : tables) {
				Elements rowss = table.select("tr[style*=\"height:50px;\"]");
				if (rowss.size() != 0) {
					for (Element row : rowss) {
						kings[count1].setEra(Eras[count2]);
						count1++;
					}
					count2++;
				}
			}
			for (int i = 1; i <= count; i++) {
				FileWriter writer = new FileWriter("src/main/resources/Json/Kings/" + "data" + i + ".json");
				String json = gson.toJson(kings[i - 1]);
				writer.write(json);
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
