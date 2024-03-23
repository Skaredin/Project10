package lisen3;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Main {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();

        book1.put("title","Anime");
        book1.put("author","Vladika vselennoi");
        book1.put("year", 9999);

        JSONObject book2 = new JSONObject();

        book2.put("title","Syrovaia voina");
        book2.put("author","Sunduit");
        book2.put("year", 1999);

        books.add(book1);
        books.add(book2);
        library.put("books", books);

        try(FileWriter file = new FileWriter("src/lisen3/example.json")) {

            file.write(library.toJSONString());
            System.out.println("json file trye");
        }  catch (Exception e) {
            e.printStackTrace();

        }
    }



}
