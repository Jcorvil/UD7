package Ejercicios.Ej6_EjemplosStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Ej6_PipedInputYOutput {
    public static void main(String[] args) throws IOException {
        //Permite realizar conexiones. Se conecta el "PipedInputStream" con el "PipedOutputStream"
        try {
            //Se crea el output...
            PipedOutputStream salida = new PipedOutputStream();
            //...y se conecta con el input
            PipedInputStream entrada = new PipedInputStream(salida);
            //Se escribe lo que se desea imprimir...
            String cadena = "Esto es una cadena de texto";
            salida.write(cadena.getBytes());
            salida.flush();
            //...y se imprime
            System.out.println(cadena);
            salida.close();

        } catch (IOException excepcion1){
            excepcion1.printStackTrace();
        }
    }
}