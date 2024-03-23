package lisen11Z2;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main   {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(new File("src/lisen11Z2/example.html")));
        Element element = (Element) doc.getElementsByTagName("title").item(0);
        element.getParentNode().removeChild(element);
        doc.normalize();
        prettyPrint(doc);
    }

    public static void prettyPrint(Document xml) throws Exception {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        javax.xml.transform.dom.DOMSource source = new DOMSource(xml);
        javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lisen11Z2/example.html"));
        tf.transform(source, result);

    }
}
