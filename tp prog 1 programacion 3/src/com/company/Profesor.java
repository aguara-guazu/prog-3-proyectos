package com.company;

import java.util.Comparator;

public class Profesor extends Persona implements Comparator<Profesor> {
    private String legajo;
    private String titulo;

    public Profesor(){};
    public Profesor(String id, String nombre, String apellido, int edad, String sexo, String dni, String legajo, String titulo) {
        super(id, nombre, apellido, edad, sexo, dni);

        this.legajo = legajo;
        this.titulo = titulo;

    }

    public String getLegajo() {
        return legajo;
    }

    public String getTitulo() {
        return titulo;
    }

    public  String getSalida(){ return GenerarSalida();}

    private String GenerarSalida(){
        return  this.getApellido() + " " +
                this.getNombre()+ " "+
                this.getId() + " " +
                this.getDni() + " " +
                this.getSexo() + " " +
                this.getEdad() + " " +
                this.getLegajo() + " " +
                this.getTitulo() + " " +
                IdentificarTitulo();
    }

    private String IdentificarTitulo(){
        return this.titulo == "Ing. en Sistemas" ? "\u2713" : "" ;
    }

    @Override
    public int compare(Profesor o1, Profesor o2) {
        return  o2.getEdad() - o1.getEdad();
    }
}
