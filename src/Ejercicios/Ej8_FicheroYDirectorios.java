package Ejercicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej8_FicheroYDirectorios {
    public static void main(String[] args) {
        File fichero1 = new File("C:\\Users\\1DAW_2223_18\\Desktop\\fichero_texto.txt");
        try {
            FileWriter escribir = new FileWriter(fichero1, true);
            escribir.write(". Continuación del texto.");
            escribir.close();
            FileReader leerFichero = new FileReader(fichero1);
            int i;
            while ((i = leerFichero.read()) != -1){
                System.out.print((char) i);
            }
            leerFichero.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}