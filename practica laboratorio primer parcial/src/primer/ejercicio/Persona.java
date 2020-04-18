package primer.ejercicio;

import java.util.Comparator;

public class Persona implements Comparator<Persona> {
    private String nombre;
    private String apellido;
    private int añoDeNacimiento;

    public Persona(){}
    public Persona(String nombre, String apellido, int añoDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoDeNacimiento = añoDeNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre y apellido:"+ getNombre() + " " + getApellido() + " nacido en " + getAñoDeNacimiento();
    }

    Comparator<Persona> ComparePorNombre = Comparator.comparing(Persona::getNombre);
    Comparator<Persona> ComparePorApellido = Comparator.comparing(Persona::getApellido);
    Comparator<Persona> ComparePorAño = Comparator.comparing(Persona::getAñoDeNacimiento);

    @Override
    public int compare(Persona o1, Persona o2) {
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getAñoDeNacimiento() {
        return añoDeNacimiento;
    }

}