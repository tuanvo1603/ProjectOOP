package crawl.war;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.War;

import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class CrawlWar {
    public static void crawlWar() throws IOException{
        String url = "https://vi.wikipedia.org/wiki/C%C3%A1c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia";

        try {
            // Kết nối tới trang web và lấy nội dung HTML
            Document document = Jsoup.connect(url).timeout(5000).get();

            // Lấy bảng chứa thông tin về các cuộc chiến
//            Elements elements = document.select("table.wikitable tbody tr");

//            int k = 1;

            List<War> objects = new ArrayList<>();
            // Bỏ qua hàng tiêu đề
            int j=1;
            
            Elements tables = document.select("table.wikitable");
//            int m = 1;
            for (Element table : tables){
                Elements rows = table.select("tr");
                Element firstRow = table.selectFirst("tr");
                for (int i=1; i<rows.size();i++)
                {
                    
                    Element row = rows.get(i);
                    Element Secondcell = firstRow.select("th").get(1);
                    String era = Secondcell.text();
                    Elements cells = row.select("td");

                    // Kiểm tra số lượng cột để đảm bảo đủ thông tin
                    if (cells.size() >= 4) {
                        String outsideParenthesis = null;
                        String insideParenthesis = null;
                        String name = cells.get(0).text();
                        
                        if (name != null) {

                            // Tách phần trong ngoặc và ngoài ngoặc
                            int openParenthesisIndex = name.indexOf("(");
                            int closeParenthesisIndex = name.indexOf(")");

                            insideParenthesis = name.substring(openParenthesisIndex + 1, closeParenthesisIndex);
                            outsideParenthesis = name.substring(0, openParenthesisIndex).trim();
                        }
                        String enemy = cells.get(2).text();
                        String leader = cells.get(1).text();
                        String result = cells.get(3).text();
                        
                        
                        War object = new War();
                        object.setId(j++);
                      
                        object.setName(outsideParenthesis);
                        object.setLeader(leader);
                        object.setEnemy(enemy);
                        object.setEra(era);
                        object.setPeriod(insideParenthesis);
                        
                        
                        object.setResult(result);
                        

                        objects.add(object);

                        System.out.println("ID: " + (j));
                        System.out.println("Name: " + outsideParenthesis);
                        System.out.println("Period: "+ insideParenthesis);
                        System.out.println("Enemy: " + enemy);
                        System.out.println("Leader: " + leader);
                        System.out.println("Era: " +  era);
                        System.out.println("Result: " + result);
                        
                        System.out.println("-----------------------------");
                    }
                }
//                m++;
            }
            Gson gson = new GsonBuilder().create();
            
            for (int i=0; i<objects.size();i++){
                War object = objects.get(i);
                String json = gson.toJson(object);
                
                try (FileWriter fileWriter = new FileWriter("src/main/resources/Json/Wars/" +"data" + (i+1) + ".json")) {
                    fileWriter.write(json);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

