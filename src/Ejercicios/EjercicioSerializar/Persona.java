package Ejercicios.EjercicioSerializar;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    String nombre;
    String apellidos;
    int edad;

    public Persona(){
        this.nombre = "El";
        this.apellidos = "Fari";
        this.edad = 69;
    }

    public Persona(String nombre){
        this.nombre = nombre;
    }


    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, String apellidos, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
    }





    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}