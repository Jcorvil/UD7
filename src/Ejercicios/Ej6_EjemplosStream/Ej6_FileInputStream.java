package Ejercicios.Ej6_EjemplosStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ej6_FileInputStream {
    public static void main(String[] args) {
        //
        File archivo = new File("C:\\Users\\1DAW_2223_18\\Desktop\\Ejemplo1.txt");
        try (FileInputStream input = new FileInputStream(archivo)) {

        } catch (FileNotFoundException excepcion1){
            System.out.println("El fichero no existe");
            excepcion1.printStackTrace();
        } catch (IOException excepcion2) {
            excepcion2.printStackTrace();
        }
    }
}