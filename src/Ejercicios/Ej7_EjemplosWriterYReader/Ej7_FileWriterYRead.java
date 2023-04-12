package Ejercicios.Ej7_EjemplosWriterYReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej7_FileWriterYRead {
    public static void main(String[] args) {
        try {
            //Crea un fichero en la ruta especificada.
            File fichero1 = new File("C:\\texto.txt");
            fichero1.createNewFile();

            //FileWriter permite escribir en un fichero
            //Si se le pone "true" continua escribiendo después del contenido. Si se le pone "false" sobreescribe.
            FileWriter escritura = new FileWriter(fichero1, true);
            //Escribe dentro de un fichero
            escritura.write("Este es el contenido del fichero.");
            escritura.close();

            //Con FileReader podemos leer el contenido del fichero.
            FileReader lectura = new FileReader(fichero1);
            //.read lee cada byte, por lo que hay que hacer un while para que lea cada caracter individualmente.
            int i;
            while ((i = lectura.read()) != -1){
                System.out.print((char) i);
            }
            lectura.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}