package crawl.festivals;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Festival;

public class CrawlFestivals {
	public static void crawlFestivals() throws IOException {
		String url = "https://vi.wikipedia.org/wiki/Lễ_hội_Việt_Nam#Danh_sách_một_số_lễ_hội";
		Document doc = null;
		Document doc1 = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
		    doc = Jsoup.connect(url).get();
		} catch (HttpStatusException e) {
		    System.out.println("Could not find the web page: " + url);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Elements table = doc.select("table[class^=prettytable wikitable]");
		Elements rows = table.select("tr");
		
		for(int i=1; i<rows.size(); i++) {
			Element row = rows.get(i);
			Elements columns = row.select("td");
			
			String date = columns.get(0).text();
			String location = columns.get(1).text();
			String name = columns.get(2).text();
			String firstTime = columns.get(3).text();
			String relatedFigures = columns.get(4).text();
			
			String note = null;
			String regexLink = columns.get(2).select("a[href]").attr("abs:href");
			String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(regexLink);
	        while(matcher.find()) {
	            String Link = matcher.group();
	            Link = URLDecoder.decode(Link, "UTF-8");
        
	            try {
	                doc1 = Jsoup.connect(Link).get();
	                Element firstPara = doc1.select("p").first();
	                String textPara = firstPara.text();
	                note = textPara.split("\\.\\s+")[0];
	            } catch (HttpStatusException e) {
	                if (e.getStatusCode() == 404) {
	                    note = null;
	                    System.out.println(Link);
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
			
			if(columns.get(0).text() == "")
				date = "Chưa rõ";
			if(columns.get(1).text() == "")
				location = "Chưa rõ";
			if(columns.get(2).text() == "")
				name =  "Chưa rõ";
			if(columns.get(3).text() == "")
				firstTime = "Chưa rõ";
			if(columns.get(4).text() == "")
				relatedFigures = "Chưa rõ";
			if(note == null) 
				note = "Không có";
			
			Festival festival = new Festival(date, location, name, firstTime, relatedFigures, note);
			
			
            String jsonData = objectMapper.writeValueAsString(festival);

            String fileName = "data" + (i+1) + ".json";
            String directory = "src/main/resources/Json/Festivals/";
            FileWriter fileWriter = new FileWriter(new File(directory, fileName));
            fileWriter.write(jsonData);
            fileWriter.close();
		}
	}
}
