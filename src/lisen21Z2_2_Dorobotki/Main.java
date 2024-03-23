package lisen21Z2_2_Dorobotki;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) throws Exception {

        {
            File file = new File("src/lisen3/example.json");
            if (!file.exists()) {
                System.out.println("No file");
            } else {
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(new FileReader("src/lisen3/example.json"));
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONArray jsonItemInfo = (JSONArray) jsonObject.get("books");

                    JSONObject newObject = new JSONObject();

                    newObject.put("item", "dada");
                    newObject.put("name", "dsdd");

                    StringWriter out = new StringWriter();
                    newObject.writeJSONString(out);
                    String jsonText = out.toString();
                    System.out.println(jsonText);

                    jsonItemInfo.add(newObject);

                    FileWriter fileToWrite = new FileWriter("src/lisen21Z2_2_Dorobotki/example2.json", true);
                    try {
                        fileToWrite.write(jsonItemInfo.toJSONString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileToWrite.flush();
                    fileToWrite.close();

                } catch (IOException  e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}
