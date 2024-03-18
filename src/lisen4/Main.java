package lisen4;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        try {

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("src/lisen3/example.json"));

            JSONObject jsonObject = (JSONObject) obj;

            System.out.println("Kornevoi element:" + jsonObject.keySet().iterator().next());

            JSONArray jsonArray = (JSONArray) jsonObject.get("books");


            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nTekusii element: book");
                System.out.println("Name knigi: " + book.get("title"));
                System.out.println("Avtor: " + book.get("author"));
                System.out.println("God izdania: " + book.get("year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
