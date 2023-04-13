package Ejercicios.Ej6_EjemplosStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej6_BufferOutputStream {
    public static void main(String[] args) throws IOException {
        //BufferOutputStream realiza las inserciones mucho mas rápido.
        //FileOutputStream podría tardar 5 segundos (por ejemplo) en insertar el texto, pero con BufferOutputStream
        //tardaría 1.
        FileOutputStream archivoFile = null;
        BufferedOutputStream archivoBuffer = null;
        try {
            archivoFile = new FileOutputStream("C:\\Users\\1DAW_2223_18\\Desktop\\Ejemplo2.txt");
            archivoBuffer = new BufferedOutputStream(archivoFile);
            archivoBuffer.write("Este es el contenido que se encuentra dentro del archivo.".getBytes());
        } catch (FileNotFoundException excepcion1){
            System.out.println("El fichero no existe");
            excepcion1.printStackTrace();
        } catch (IOException excepcion2) {
            excepcion2.printStackTrace();
        } finally {
            archivoBuffer.close();
            archivoFile.close();
            System.out.println("•:Fin ejecución del programa:•");
        }
    }
}