package org.ieslosremedios.daw1.prog.ut7.practica7;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ExportarXML {
    public static void exportarXML() {
        try {
            File inputFile = new File("X:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("X:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAWExp.xml"));
            transformer.transform(source, result);

            System.out.println("XML exportado exitosamente");
            System.out.println();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}