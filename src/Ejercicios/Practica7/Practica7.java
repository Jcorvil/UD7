package org.ieslosremedios.daw1.prog.ut7.practica7;

import java.util.Scanner;
import static org.ieslosremedios.daw1.prog.ut7.practica7.ExportarXML.exportarXML;
import static org.ieslosremedios.daw1.prog.ut7.practica7.ImportarXML.importarXML;
import static org.ieslosremedios.daw1.prog.ut7.practica7.ReiniciarIntervenciones.reiniciarIntervenciones;
import static org.ieslosremedios.daw1.prog.ut7.practica7.SeleccionarAlumnos.seleccionarAlumnos;

public class Practica7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú");
            System.out.println("1. Importar fichero XML");
            System.out.println("2. Exportar fichero XML");
            System.out.println("3. Seleccionar miembro de la clase");
            System.out.println("4. Reiniciar intervenciones");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Introduce una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    importarXML();
                    break;
                case 2:
                    exportarXML();
                    break;
                case 3:
                    seleccionarAlumnos();
                    break;
                case 4:
                    reiniciarIntervenciones();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    System.out.println();
            }
        } while (opcion != 5);
    }
}