package Ejercicios;

import java.io.*;

public class Ej7_2Ficheros {
    //5 En este último fichero, añade al final un alumno nuevo
    //6 Sustituye el segundo y tercer caracter del nombre de cada alumno por una X

    public static void main(String[] args) {
        try {
    //1 Crea un fichero llamado alumnos.txt dentro de una nueva carpeta con nombre 1DAW, controlando que si ya existe
    //no haga nada. La carpeta debe estar en la raíz de tu usuario.
            File carpeta = new File("C:\\Users\\1DAW_2223_18");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
            File fichero1 = new File("C:\\Users\\1DAW_2223_18\\alumnos.txt");
            if (!fichero1.exists()) {
                fichero1.createNewFile();
            }
    //2 Introduce los nombres de los alumnos de la clase, un alumno por línea del fichero1. Utiliza un buffer
    //para realizar esta operación
            FileWriter escritura = new FileWriter(fichero1);
            BufferedWriter buffer = new BufferedWriter(escritura);
            buffer.write("J.María \n");
            buffer.write("Adrián \n");
            buffer.write("Antonio \n");
            buffer.write("Daniel \n");
            buffer.write("Diego \n");
            buffer.write("David \n");
            buffer.write("Jorge \n");
            buffer.write("John \n");
            buffer.write("Julián \n");
            buffer.write("Johnnatan \n");
            buffer.write("Juanma \n");
            buffer.write("Jossie \n");
            buffer.write("J.M. Saborido \n");
            buffer.write("Pablo \n");
            buffer.write("Ricardo \n");
            buffer.write("Victor \n");
            buffer.close();

    //3 Copia (lee y escribe) el contenido del anterior fichero1 a uno nuevo con nombre prog.txt


    //4 Renombra el fichero1 a prog_codificado.txt
            File fichero2 = new File("C:\\Users\\1DAW_2223_18\\prog_codificado.txt");
            fichero1.renameTo(fichero2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}