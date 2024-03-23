package lisen10Z2;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static List<Element> nodeList1;
    public static void main(String[] args)
    {
        try {
            File inputFile = new File("src/lisen1/example1/example.html");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Kornevoi element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                nodeList1 = (List<Element>) node;
                System.out.println("\nTekusii element: " + node.getNodeName());


                List<Element> books = nodeList1.stream().filter(node1 -> node.getNodeType() == Node.ELEMENT_NODE).map(node1 -> (Element) node).filter(element ->
                {


                    String author = ((org.w3c.dom.Element) nodeList).getElementsByTagName("author").item(0).getTextContent();
                    String year = ((org.w3c.dom.Element) nodeList).getElementsByTagName("year").item(0).getTextContent();
                    return author.equalsIgnoreCase("Лев Толстой") && year.equals("1869");

                } ).collect(Collectors.toList());
            }











        } catch (Exception e) {

        }
    }
}
