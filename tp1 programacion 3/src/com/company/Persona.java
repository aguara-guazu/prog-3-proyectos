package com.company;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String dni;

    public Persona(){};
    public Persona (String id, String nombre, String apellido, int edad, String sexo, String dni){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDni() {
        return dni;
    }

    public  int compareTo(Persona b){
        if ((this.apellido).compareTo(b.apellido) == 0){
            return (this.nombre).compareTo(b.getNombre());
        }
        return (this.apellido).compareTo(b.apellido);
    }
}
