package Ejercicios.Ej7_4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Persona> listaContactos = new ArrayList<>();

        // Agregar contactos a la lista
        listaContactos.add(new Persona("Juan", "Dirección A", "1234567890"));
        listaContactos.add(new Persona("María", "Dirección B", "9876543210"));
        listaContactos.add(new Persona("Pedro", "Dirección C", "5555555555"));

        // Recorrer y mostrar la lista de contactos
        for (Persona contacto : listaContactos) {
            System.out.println("Nombre: " + contacto.getNombre());
            System.out.println("Dirección: " + contacto.getDireccion());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println();
        }
    }
}
