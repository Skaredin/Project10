package lisen15Z2_Dorobotki;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Удаление по автору");
        System.out.println("Автор");
        Scanner scanner2 = new Scanner(System.in);
        String k= scanner2.nextLine();
        System.out.println("Год");
        Scanner scanner = new Scanner(System.in);
        String k2= scanner.nextLine();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(new File("src/lisen1/example1/example.html")));


        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("book");


        int da = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String proverkaAuthor = "";
            String proverkaYear = "";
            String proverkaTitle = "";
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                proverkaAuthor = element.getElementsByTagName("author").item(0).getTextContent();
                proverkaYear = element.getElementsByTagName("year").item(0).getTextContent();
                proverkaTitle = element.getElementsByTagName("title").item(0).getTextContent();

            }


            if (proverkaAuthor.equalsIgnoreCase(k) & proverkaYear.equalsIgnoreCase(k2) )
            {

                System.out.println("Удалена строка:   " + proverkaTitle +" номер строки "+ da);

                Element element = (Element) doc.getElementsByTagName("book").item(da);
                element.getParentNode().removeChild(element);
                doc.normalize();
                prettyPrint(doc);

            }
            da = da+1;

        }





    }

    public static void prettyPrint(Document xml) throws Exception {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        javax.xml.transform.dom.DOMSource source = new DOMSource(xml);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lisen1/example1/example.html"));
        tf.transform(source, result);

    }
}
