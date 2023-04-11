package Ejercicios.Ej7_EjemplosWriterYReader;

import java.io.FileWriter;
import java.io.IOException;

public class Ej7_FileWriter {
    public static void main(String[] args)  {
        //FileWriter permite escribir en un archivo
        try{
            //Con "FileWriter" se crea el archivo y su nombre
            FileWriter escritura = new FileWriter("C:\\texto.txt");
            escritura.write("Contenido del archivo de texto");
            escritura.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}