package lisen1;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.dom.DOMSource;

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

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Lev Tolstoi"));
            bobk1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild((doc.createTextNode("Voina i mir")));
            bobk1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild((doc.createTextNode("1869")));
            bobk1.appendChild(year1);


            Element bobk2 = doc.createElement("book");
            rootElement.appendChild(bobk2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("leni"));
            bobk2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild((doc.createTextNode("Mihail Bulgakov")));
            bobk2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild((doc.createTextNode("1867")));
            bobk2.appendChild(year2);


            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "Yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "Yes");
            javax.xml.transform.dom.DOMSource source = new DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lisen1/example1/example.html"));
            transformer.transform(source, result);
            javax.xml.transform.stream.StreamResult result2 = new javax.xml.transform.stream.StreamResult(new File("src/lisen11Z2/example.html"));
            transformer.transform(source, result2);
            System.out.println(tf);


        } catch (Exception ig) {

            ig.printStackTrace();
        }
    }
}