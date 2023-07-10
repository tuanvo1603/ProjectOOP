package crawl.eras;

import com.google.gson.Gson;
import org.jsoup.*;
import org.jsoup.nodes.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import org.jsoup.select.Elements;
import java.lang.String;

import org.apache.commons.lang3.math.NumberUtils;
import models.Era;

public class CrawlEra {
    public static void crawlEra() throws IOException{
        final String url = "https://vi.wikipedia.org/wiki/Vua_Việt_Nam";
        Era[] trieuDai = new Era[25];
        int count = 0;
        String era = null;
        String period = null;
        String time = null;
        final Gson gson = new Gson();
        final String regex = "\\((.*?)\\)";
        try{
            Document document = Jsoup.connect(url).get();
            document.select("sup").remove();
            Elements div = document.getElementsByClass("vector-toc-text");
            for(Element thoiKy : div){
                Element thuTu = thoiKy.getElementsByClass("vector-toc-numb").first();
                if(thuTu != null && NumberUtils.isDigits(thuTu.text())&& Double.parseDouble(thuTu.text())>1 && Double.parseDouble(thuTu.text()) < 11 ) {
                    period = thoiKy.text().replaceAll("[0-9]","");
                }
                if(thuTu != null && !NumberUtils.isDigits(thuTu.text())&& Double.parseDouble(thuTu.text())>1 && Double.parseDouble(thuTu.text()) < 11 ){
                    era = thoiKy.text().replaceAll("\\((.*?)\\)|[0-9.]|hoặc","");
                    era = era.trim();
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(thoiKy.text());
                    while (matcher.find())
                        time = matcher.group(1);
                    trieuDai[count] = new Era(count+1,era,period,time,null);
                    count++;
                }
            }
            count = 0;
            Elements tables = document.getElementsByTag("table");
            for (Element table : tables) {
                Elements rows = table.select("tr[style*=\"height:50px;\"]");
                if (rows.size() != 0) {
                    List<String> vua = new ArrayList<String>();
                    for (Element row : rows) {
                        vua.add(row.select("tr td:nth-child(2)").text());
                    }
                    trieuDai[count].setKings(vua);
                    count++;
                }
            }
            for (int i = 1; i <= count; i++) {
                FileWriter writer = new FileWriter("src/main/resources/Json/Eras/" + i + ".json");
                String json = gson.toJson(trieuDai[i - 1]);
                writer.write(json);
                writer.close();
                System.out.println(i);
            }
        }
        catch (IOException e) {
            // handle any other IO exceptions here
            e.printStackTrace();
        }
    }

}
