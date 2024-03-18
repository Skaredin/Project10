package lisen5;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String url ="https://disk.yandex.ru/d/IjydU9VBztndKw/2%20СЕМЕСТР";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links)
            {
                System.out.println(link.attr("abs:href"));

            }
        }catch (IOException e)
        {e.printStackTrace();}
    }
}
