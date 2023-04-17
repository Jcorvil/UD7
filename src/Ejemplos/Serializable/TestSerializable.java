package Ejemplos.Serializable;

import java.io.*;

public class TestSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Se crea el objeto a serializar para escribirlo en un fichero
        ObjetoSerializable objeto1 = new ObjetoSerializable(5, 5, 5);

        //Se crea el fichero
        FileOutputStream archivo1 = new FileOutputStream("C:\\Users\\1DAW_2223_18\\Desktop\\archivoObjeto.bin");
        ObjectOutputStream oos = new ObjectOutputStream(archivo1);

        //Serializar el objeto
        oos.writeObject(objeto1);

        //Se cierra el flujo
        oos.close();

        //Leer fichero al objeto
        FileInputStream archivo2 = new FileInputStream("C:\\Users\\1DAW_2223_18\\Desktop\\archivoObjeto.bin");
        ObjectInputStream ois = new ObjectInputStream(archivo2);

        //Deserializar el contenido del fichero (bytes) a un Object
        ObjetoSerializable osSalida = (ObjetoSerializable)ois.readObject();

        System.out.println("Atributo 1: " + osSalida.atributo1);
        System.out.println("Atributo 2: " + osSalida.atributo2);
        System.out.println("Atributo 3: " + osSalida.atributo3);

        ois.close();
    }
}