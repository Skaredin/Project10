package lisen17Z3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/lisen17Z3/example.json"));
        JSONObject jsonObject = (JSONObject) obj;

        System.out.println("Kornevoi element:" + jsonObject.keySet().iterator().next());

        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        JSONObject newBook = new JSONObject();
        newBook.put("title", "Новая книга");
        newBook.put("author", "Новый автор");
        newBook.put("year", 2023);
        jsonArray.add(newBook);

        try(FileWriter file = new FileWriter("src/lisen17Z3/example.json")) {

            file.write(newBook.toJSONString());
            System.out.println("Ypdate");
        }  catch (Exception e) {
            e.printStackTrace();

        }




    }
}
