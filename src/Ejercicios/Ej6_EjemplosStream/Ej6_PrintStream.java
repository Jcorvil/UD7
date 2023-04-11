package Ejercicios.Ej6_EjemplosStream;

import java.io.PrintStream;

public class Ej6_PrintStream {
    public static void main(String[] args) {
        PrintStream printstream1 = new PrintStream(System.out);
        String cadena1 = "Esto es una cadena de texto";
        Double doble1 = 5.2;
        Integer entero1 = 15;

        printstream1.println(cadena1);
        printstream1.println(doble1);
        printstream1.println(entero1);

        printstream1.close();
    }
}