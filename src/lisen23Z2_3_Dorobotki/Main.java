package lisen23Z2_3_Dorobotki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            Element bobk1 = doc.createElement("book");
            rootElement.appendChild(bobk1);

            org.jsoup.nodes.Document doc2= Jsoup.connect("http://fat.urfu.ru/index.html").get();
            Elements newsParent = doc2.select("body > table > tbody > tr > td > div > table > tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > tr > td:nth-child(1)");

            for (int i = 3; i<20; i++)
            {
                String Tema = "";
                String Date = "";


                if(!(i%2==0))
                {
                    List<Node> nodes = newsParent.get(0).childNodes();

                     Tema = ((org.jsoup.nodes.Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0)+"";
                     Date = ((org.jsoup.nodes.Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0)+"\r";





                }

                Element title1 = doc.createElement("Tema");
                title1.appendChild(doc.createTextNode(Tema));
                bobk1.appendChild(title1);

                Element author1 = doc.createElement("Date");
                author1.appendChild((doc.createTextNode(Date)));
                bobk1.appendChild(author1);

            }



        doc.setXmlStandalone(true);
        doc.normalizeDocument();
        javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "Yes");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "Yes");
        javax.xml.transform.dom.DOMSource source = new DOMSource(doc);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lisen23Z2_3_Dorobotki/example.html"));
        transformer.transform(source, result);
        System.out.println(tf);


    } catch (Exception ig) {

        ig.printStackTrace();
    }


    }
}