package Ejemplos;

import java.io.IOException;
import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) throws IOException {
        //Pedir al usuario que introduzca 3 caracteres por teclado

        System.out.println("Introduzca tres(3) caracteres individuales: ");
        int char1 = System.in.read();
        int char2 = System.in.read();
        int char3 = System.in.read();

        //Vamos a imprimirlos concatenados
        System.out.println("1.Usando 'write'");
        System.out.write(char1);
        System.out.write(char2);
        System.out.write(char3);
        System.out.flush();
        System.out.println();
        System.out.printf("\n •:•:•:•:•:•:•:•:•:•\n");
        System.out.println("2.Usando 'print'");
        System.out.print((char)char1 +""+ (char)char2 +""+ (char)char3);
        System.out.printf("\n •:•:•:•:•:•:•:•:•:•\n");
        System.out.println("3.Usando 'println':");
        System.out.println((char)char1 +""+ (char)char2 +""+ (char)char3);
        System.out.printf("\n •:•:•:•:•:•:•:•:•:•\n");


        System.out.println("Usando scanner");
        Scanner caracteres = new Scanner(System.in);
        char char4 = caracteres.next().charAt(0);
        char char5 = caracteres.next().charAt(0);
        char char6 = caracteres.next().charAt(0);
        System.out.println("1.Usando 'write'");
        System.out.write(char4 + char5 + char6);
        System.out.printf("\n •:•:•:•:•:•:•:•:•:•\n");
        System.out.println("2.Usando 'print'");
        System.out.print(char4 +""+ char5 +""+ char6);
        System.out.printf("\n •:•:•:•:•:•:•:•:•:•\n");
        System.out.println("3.Usando 'println':");
        System.out.println(char4 +""+ char5 +""+ char6);


        /*
        System.out.println("Introduzca su nombre: ");
        Scanner scannerInput = new Scanner(System.in);
        String nombre = scannerInput.nextLine();
        System.out.println(nombre);
        */

        /*
        System.out.println("Introduzca su nombre de hasta 4 caracteres: ");
        //.read permite introducir cosas por teclado.
        //Se pone int porque la info se almacena como bytes.
        int c1 = System.in.read();
        int c2 = System.in.read();
        int c3 = System.in.read();
        int c4 = System.in.read();

        System.out.write("Hola ".getBytes());
        System.out.write(c1);
        System.out.write(c2);
        System.out.write(c3);
        System.out.write(c4);
        System.out.flush();
        */

        /*
        //System.out.write imprime usando bytes. 65 es el código para 'A'
        System.out.write(72); //H
        System.out.write(111); //o
        System.out.write(108); //l
        System.out.write(97); //a
        //.flush imprime por consola lo que hay en el .write.
        //System.out.println realiza un .write y un .flush automaticamente
        System.out.flush();
        System.out.println("");
        */

        /*
        if(args.length > 0){
            System.out.println("Hola: " + args[0]);
        } else {
            //System.err.println imprime un mensaje como error
            System.err.println("Error: no se encontró ningún argumento");
        }
        */

    }
}