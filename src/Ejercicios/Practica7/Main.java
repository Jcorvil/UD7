package org.ieslosremedios.daw1.prog.ut7.practica7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Practica7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú");
            System.out.println("1. Importar fichero XML");
            System.out.println("2. Exportar fichero XML");
            System.out.println("3. Seleccionar miembro de la clase");
            System.out.println("4. Reiniciar intervenciones");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Introduce una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    importarXML();
                    break;
                case 2:
                    exportarXML();
                    break;
                case 3:
                    seleccionarAlumnos();
                    break;
                case 4:
                    reiniciarIntervenciones();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    public static void importarXML() {
        try {
            File inputFile = new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");
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

    public static void exportarXML() {
        try {
            File inputFile = new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAWExp.xml"));
            transformer.transform(source, result);

            System.out.println("XML exportado exitosamente");
            System.out.println();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void seleccionarAlumnos() {
        try {
            File inputFile = new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");

            // Crea el objeto DocumentBuilder para analizar el archivo XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Obtiene la lista de nodos de alumno
            NodeList alumnoList = doc.getElementsByTagName("alumno");

            // Crear una lista de alumnos candidatos con menos intervenciones
            List<Element> candidatos = new ArrayList<>();
            int menorIntervenciones = Integer.MAX_VALUE;

            for (int i = 0; i < alumnoList.getLength(); i++) {
                Element alumnoElement = (Element) alumnoList.item(i);
                int intervenciones = Integer.parseInt(alumnoElement.getAttribute("intervenciones"));

                if (intervenciones < menorIntervenciones) {
                    // Se encontró un nuevo mínimo
                    menorIntervenciones = intervenciones;
                    candidatos.clear();
                    candidatos.add(alumnoElement);
                } else if (intervenciones == menorIntervenciones) {
                    // Se encontró otro alumno con el mismo número de intervenciones
                    candidatos.add(alumnoElement);
                }
            }

            if (candidatos.isEmpty()) {
                System.out.println("No hay alumnos disponibles");
                return;
            }

            // Escoge un alumno aleatorio entre los candidatos
            Random random = new Random();
            Element alumnoSeleccionado = candidatos.get(random.nextInt(candidatos.size()));
            String nombreAlumno = alumnoSeleccionado.getElementsByTagName("nombre").item(0).getTextContent();

            System.out.println("Alumno seleccionado: " + nombreAlumno);
            System.out.print("¿Añadir una intervención? (+/0): ");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("+")) {
                // Añade una intervención al alumno seleccionado
                int intervenciones = Integer.parseInt(alumnoSeleccionado.getAttribute("intervenciones"));
                alumnoSeleccionado.setAttribute("intervenciones", String.valueOf(intervenciones + 1));

                // Guarda el documento XML actualizado
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml"));
                transformer.transform(source, result);

                System.out.println("Intervención añadida exitosamente");
                System.out.println();
            } else if (respuesta.equalsIgnoreCase("salir")) {
                System.out.println("No ha sido añadida ninguna intervención");
                System.out.println();
            } else {
                System.out.println("No ha sido añadida ninguna intervención, vuelvo a seleccionar un alumno");
                System.out.println();
                seleccionarAlumnos();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reiniciarIntervenciones() {
        try {

            File inputFile = new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("alumno");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element alumno = (Element) nList.item(temp);
                alumno.setAttribute("intervenciones", "0");
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("G:\\Mi unidad\\1º DAW\\Programación\\Code\\DAW-Programacion\\U7\\src\\org\\ieslosremedios\\daw1\\prog\\ut7\\practica7\\Alumnos1DAW.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}