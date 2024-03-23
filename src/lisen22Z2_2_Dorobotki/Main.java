package lisen22Z2_2_Dorobotki;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Element;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
            System.out.println("Удаление по автору");
            System.out.println("Автор");
            Scanner scanner2 = new Scanner(System.in);
            String k = scanner2.nextLine();
            System.out.println("Год");
            Scanner scanner = new Scanner(System.in);
            String k2 = scanner.nextLine();

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("src/lisen3/example.json"));

            JSONObject jsonObject = (JSONObject) obj;


            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            String proverkaAuthor = "";
            String proverkaYear = "";
            String proverkaTitle = "";
            int da = 0;
            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                proverkaAuthor = book.get("author").toString();
                proverkaYear = book.get("year").toString();
                proverkaTitle = book.get("title").toString();
                if (proverkaAuthor.equalsIgnoreCase(k) & proverkaYear.equalsIgnoreCase(k2)) {

                    System.out.println("Тут чёт не получилось сделать:" + proverkaTitle);







                }
                da = da+1;
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
