package com.company;

import java.util.Comparator;

public class Alumno extends Persona implements Comparator<Alumno> {
    private String nroLE;
    private int materiasAprobadas;
    private int promedio;

    public Alumno(){};
    public Alumno(String id, String nombre, String apellido, int edad, String sexo, String dni, int promedio,int materiasAprobadas, String nroLE) {
        super(id, nombre, apellido, edad, sexo, dni);
        this.nroLE = nroLE;
        this.materiasAprobadas = materiasAprobadas;
        this.promedio = promedio;
    }

    public String getNroLE() {
        return nroLE;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public int getPromedio() {
        return promedio;
    }

    public String getSalida(){ return GenerarSalida(); }

    private String GenerarSalida(){
        return this.getApellido() + " " +
                this.getNombre()+ " "+
                this.getId() + " " +
                this.getDni() + " " +
                this.getSexo() + " " +
                this.getEdad() + " " +
                this.nroLE + " " +
                this.materiasAprobadas+ " " +
                this.promedio+ " " +
                IdentificarPromedio();

    }
    private String IdentificarPromedio(){
        if (promedio > 7){
            return "\u2713";
        }

        else {
            return "";
        }

    }

    public int compare(Alumno o1, Alumno o2) {
        return o1.getPromedio() < o2.getPromedio() ? 1 : o1.getPromedio() == o2.getPromedio() ? 0 : -1;
    }

}
