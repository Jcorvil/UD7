package Ejercicios.Ej7_4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactosaXML {

    public static class Persona {
        private String nombre;
        private String direccion;
        private String telefono;

        public Persona(String nombre, String direccion, String telefono) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
        }
    }

    public static void main(String[] args) {
        List<Persona> listaContactos = obtenerListaContactos(); // Obtener la lista de contactos

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("contactos");
            doc.appendChild(rootElement);

            for (Persona contacto : listaContactos) {
                Element contactoElement = doc.createElement("contacto");
                rootElement.appendChild(contactoElement);

                Element nombreElement = doc.createElement("nombre");
                Text nombreText = doc.createTextNode(contacto.nombre);
                nombreElement.appendChild(nombreText);
                contactoElement.appendChild(nombreElement);

                Element direccionElement = doc.createElement("direccion");
                Text direccionText = doc.createTextNode(contacto.direccion);
                direccionElement.appendChild(direccionText);
                contactoElement.appendChild(direccionElement);

                Element telefonoElement = doc.createElement("telefono");
                Text telefonoText = doc.createTextNode(contacto.telefono);
                telefonoElement.appendChild(telefonoText);
                contactoElement.appendChild(telefonoElement);
            }

            // Escribir el contenido del documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter("contactos.xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Persona> obtenerListaContactos() {

        List<Persona> listaContactos = new ArrayList<>();
        listaContactos.add(new Persona("Juan", "Calle A, Ciudad X", "1234567890"));
        listaContactos.add(new Persona("María", "Calle B, Ciudad Y", "9876543210"));
        listaContactos.add(new Persona("Pedro", "Calle C, Ciudad Z", "5555555555"));
        return listaContactos;
    }
}
