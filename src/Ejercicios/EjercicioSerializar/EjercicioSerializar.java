package Ejercicios.EjercicioSerializar;

import java.io.*;

public class EjercicioSerializar {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Persona objeto1 = new Persona();

        FileOutputStream archivo1 = new FileOutputStream("C:\\Users\\1DAW_2223_18\\Desktop\\nombreOculto.bin");
        ObjectOutputStream oos = new ObjectOutputStream(archivo1);

        oos.writeObject(objeto1);

        oos.close();

        FileInputStream archivo2 = new FileInputStream("C:\\Users\\1DAW_2223_18\\Desktop\\nombreOculto.bin");
        ObjectInputStream ois = new ObjectInputStream(archivo2);
        Persona osSalida = (Persona)ois.readObject();

        System.out.println("El nombre es " + osSalida.nombre + " " + osSalida.apellidos);
        System.out.println("Tiene " + osSalida.edad + " años.");

        ois.close();

    }
}