package Ejercicios;

import java.io.*;

public class Ej9_EscrituraYLecturaDirecta {
    public static void main(String[] args) {
        try {
        //1.-Crea un fichero eliminando el que ya existía en su caso.
        File fichero1 = new File("C:\\Users\\1DAW_2223_18\\Desktop\\fichero_texto.txt");
        if (fichero1.exists()){
            fichero1.delete();
        }
        fichero1.createNewFile();

            //2.-Abre un flujo de acceso aleatorio al fichero e introduce la cadena "defg"
            RandomAccessFile aleatorio1 = new RandomAccessFile(fichero1, "rw");
            aleatorio1.write("defg".getBytes());
            aleatorio1.seek(0);

            //3.-Imprime por consola el contenido del fichero
            System.out.println(aleatorio1.readLine());

            //4.-Añade al principio del fichero "abc" y al final "hij"
            aleatorio1.write("hij".getBytes());
            aleatorio1.seek(0);
            String temporal = aleatorio1.readLine();
            aleatorio1.seek(0);
            aleatorio1.write("abc".getBytes());
            aleatorio1.write(temporal.getBytes());
            aleatorio1.seek(0);
            System.out.println(aleatorio1.readLine());

            //5.-Sustituye las vocales por "*"


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}