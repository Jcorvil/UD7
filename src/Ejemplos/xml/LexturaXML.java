package Ejemplos.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LexturaXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\1DAW_2223_18\\Desktop\\Programación\\UD7\\src\\Ejemplos\\xml\\ejemploXML.xml"));

        //Leer nodos
        Node root = document.getFirstChild();

        NodeList nodos = root.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            Node node = nodos.item(i);
            System.out.println(node.getNodeValue());
        }

    }
}