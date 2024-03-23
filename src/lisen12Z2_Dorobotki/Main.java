package lisen12Z2_Dorobotki;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.File;

public class Main {
    public static void main(String[] args) {
    try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("library");
        doc.appendChild(rootElement);


        Element bobk1 = doc.createElement("book");
        bobk1.appendChild(doc.createTextNode("Книги"));
        rootElement.appendChild(bobk1);

        Element title1 = doc.createElement("Product");
        title1.appendChild(doc.createTextNode("Покупки/продукты "));
        bobk1.appendChild(title1);

        Element author1 = doc.createElement("Task");
        author1.appendChild((doc.createTextNode("Задачи ")));
        bobk1.appendChild(author1);

        Element year1 = doc.createElement("Birthday");
        year1.appendChild((doc.createTextNode("Дни рождений людей ")));
        bobk1.appendChild(year1);


        Element title2 = doc.createElement("Animals");
        title2.appendChild(doc.createTextNode("Домашние животные "));
        bobk1.appendChild(title2);

        Element author2 = doc.createElement("Lesson");
        author2.appendChild((doc.createTextNode("Предметы в университете ")));
        bobk1.appendChild(author2);

        Element year2 = doc.createElement("Automobile");
        year2.appendChild((doc.createTextNode("Автомобили ")));
        bobk1.appendChild(year2);

        Element year3 = doc.createElement("Employee");
        year3.appendChild((doc.createTextNode("Сотрудники  ")));
        bobk1.appendChild(year3);

        Element year4 = doc.createElement("Movies");
        year4.appendChild((doc.createTextNode("Фильмы  ")));
        bobk1.appendChild(year4);

        Element year5 = doc.createElement("Songs");
        year5.appendChild((doc.createTextNode("Музыкальные произведений  ")));
        bobk1.appendChild(year5);


        doc.setXmlStandalone(true);
        doc.normalizeDocument();
        javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
        javax.xml.transform.Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "Yes");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "Yes");
        javax.xml.transform.dom.DOMSource source = new DOMSource(doc);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lisen12Z2_Dorobotki/example.html"));
        transformer.transform(source, result);
        System.out.println("Ok");


    } catch (Exception ig) {

        ig.printStackTrace();
    }
}
}
