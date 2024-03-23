package lisen14Z2_Dorobotki;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        try {


            System.out.println("Поиск");
            System.out.println("Автор");
            Scanner scanner2 = new Scanner(System.in);
            String k= scanner2.nextLine();
            System.out.println("Год");
            Scanner scanner = new Scanner(System.in);
            String k2= scanner.nextLine();




            File inputFile = new File("src/lisen1/example1/example.html");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String proverkaAuthor = "";
                String proverkaYear = "";
                String proverkaTitle = "";
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    proverkaAuthor =     element.getElementsByTagName("author").item(0).getTextContent();
                    proverkaYear = element.getElementsByTagName("year").item(0).getTextContent();
                    proverkaTitle = element.getElementsByTagName("title").item(0).getTextContent();

                }

                if (proverkaAuthor.equalsIgnoreCase(k) & proverkaYear.equalsIgnoreCase(k2) )
                {

                    System.out.println("Name Title:" + proverkaTitle);
                }


            }
        } catch (Exception e) {

        }

    }

}