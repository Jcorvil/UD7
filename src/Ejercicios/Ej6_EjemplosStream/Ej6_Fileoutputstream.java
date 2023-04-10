package Ejercicios.Ej6_EjemplosStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej6_Fileoutputstream {
    /* Ejercicio 6
    Investiga cada una de estas clases y crea un
    ejemplo para explicar su funcionamiento al resto
    de la clase.
    Elabora la jerarquía de clases e indica los
    paquetes a los que pertenecen.
    ¿Eres capaz de encontrar más flujos a parte de
    los de la lista?
     */
    public static void main(String[] args) {
        // FileOutputStream siempre se debe poner con un try & catch
        try {
            //Se declara que se va a crear un archivo y se establece la ruta y nombre
            FileOutputStream archivo = new FileOutputStream("C:\\Users\\1DAW_2223_18\\Desktop\\Ejemplo1.txt");
            //Se escribe en el archivo. Produce una excepcion, que hay que capturar
            archivo.write("Contenido del archivo".getBytes());
            //Se cierra el stream
            archivo.close();
            System.out.println("Archivo creado correctamente.");
        } catch (FileNotFoundException excepcion1){
            System.out.println("El fichero no existe");
            excepcion1.printStackTrace();
        } catch (IOException excepcion2) {
            excepcion2.printStackTrace();
        } finally {
            System.out.println("•:Fin ejecución del programa:•");
        }
    }

}