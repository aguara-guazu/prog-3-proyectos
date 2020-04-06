package com.company;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        listaDeAlumnos.add(new Alumno("4906", "Freddie ", "Porter", 20, "hombre", "63723712", 8, 14, "05021"));
        listaDeAlumnos.add(new Alumno("6316", "Jodi ", "Little", 25, "mujer", "99629004", 4, 10, "84345"));
        listaDeAlumnos.add(new Alumno("3932", "Constance", "Roberts ", 21, "hombre", "92583522", 9, 17, "23617"));
        listaDeAlumnos.add(new Alumno("1672", " Cecil", "Berry ", 26, "mujer", "70824904", 5, 13, "81989"));
        listaDeAlumnos.add(new Alumno("1672", " Arya", "Berry ", 26, "mujer", "23224904", 8, 14, "81329"));
        listaDeAlumnos.add(new Alumno("3095", " Jacquelyn", "Hill ", 22, "mujer", "08080792", 8, 16, "74094"));
        listaDeAlumnos.add(new Alumno("9629", " Domingo", "Hammond ", 29, "hombre", "72425840", 4, 11, "68490"));


        listaDeProfesores.add(new Profesor("2531", "Mae", "Rodriguez ", 56, "mujer", "12993053", "68237", "Ing. en Sistemas"));
        listaDeProfesores.add(new Profesor("0429", "Essie", "Francis ", 55, "mujer", "70394668", "35166", "Ing. Hidrico"));
        listaDeProfesores.add(new Profesor("6771", "Kristine", "Cole ", 49, "mujer", "48736578", "45484", "Ing. en Sistemas"));
        listaDeProfesores.add(new Profesor("2954", "Bradley ", "Barker ", 50, "hombre", "71013009", "79652", "Ing. Civil"));
        listaDeProfesores.add(new Profesor("1972", "Kelvin", "Shelton ", 43, "hombre", "54510573", "92836", "Ing. Mecanico"));
        listaDeProfesores.add(new Profesor("7669", "Cesar", "Doyle ", 51, "hombre", "80033343", "54479", "Ing. en Sistemas"));


        System.out.println("Lista no ordenada: \n");

        Imprimir();


        Collections.sort(listaDeAlumnos);
        Collections.sort(listaDeProfesores);

        System.out.println("\n Lista ordenada por apellido y nombre: \n ");

        Imprimir();

        System.out.println("\n Lista ordenada por promedio y edad del profesor: \n ");

        Collections.sort(listaDeAlumnos, new Alumno());
        Collections.sort(listaDeProfesores, new Profesor());

        Imprimir();

    }

    static LinkedList<Alumno> listaDeAlumnos = new LinkedList<>();
    static LinkedList<Profesor> listaDeProfesores = new LinkedList<>();

    private static void Imprimir() {
        for (Alumno a :
                listaDeAlumnos) {
            System.out.println(a.getSalida());
        }
        System.out.println("----------------------------------");
        for (Profesor a :
                listaDeProfesores) {
            System.out.println(a.getSalida());
        }
    }

}
