package lisen3;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Main {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();

        book1.put("title"," Voina");
        book1.put("author"," Voina");
        book1.put("year", 1999);

        JSONObject book2 = new JSONObject();

        book2.put("title"," Voina");
        book2.put("author"," Voina");
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