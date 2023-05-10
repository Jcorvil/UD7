package org.ieslosremedios.daw1.prog.ut7.practica7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ImportarXML {
    public static void importarXML() {
        try {
            File inputFile = new File("X:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("alumno");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element alumno = (Element) nList.item(temp);
                String nombre = alumno.getTextContent();
                int intervenciones = Integer.parseInt(alumno.getAttribute("intervenciones"));

                // Procesar datos importados
                System.out.println(nombre + "Intervenciones: " + intervenciones);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
