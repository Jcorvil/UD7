package Ejemplos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploFile {
    public static void main(String[] args) {
        try {
        //Crea una carpeta con el nombre y la ruta que se le da.
        //Si la carpeta ya existe, no hace nada
        File fichero1 = new File("C:\\Nueva Carpeta");
        fichero1.mkdir();
        //Crea un fichero en la ruta especificada.
        File fichero2 = new File("C:\\Nueva Carpeta\\archivo.txt");
            fichero2.createNewFile();

        //FileWriter permite escribir en un fichero
            //Si se le pone "true" continua escribiendo después del contenido. Si se le pone "false" sobreescribe.
        FileWriter escritura = new FileWriter(fichero2, true);
        //Escribe dentro de un fichero
        escritura.write(" Jorge");
        escritura.close();

        FileReader lectura = new FileReader(fichero2);
        //.read lee cada byte, por lo que hay que hacer un while para que lea cada caracter individualmente.
        int i;
        while ((i = lectura.read()) != -1){
            System.out.print((char) i);
        }
        lectura.close();

        //Bora el fichero que se le da. Si se le pone un directorio, solo lo podrá borrar si está vacío.
        //fichero2.delete();
        //fichero1.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}