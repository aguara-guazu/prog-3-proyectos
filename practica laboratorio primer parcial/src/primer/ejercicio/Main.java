package primer.ejercicio;
import com.sun.istack.internal.Nullable;

import  javax.swing.*;
import java.util.Collections;
import java.util.LinkedList;


public class Main {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(new JFrame(),"test");

		for (int i = 0; i < 4; i++){
			AgregarPersona();
		}

		System.out.println("Lista incial");
		MostrarLista();

		System.out.println("Lista ordenada de manera natural:");
		Collections.sort(listaDePersonas, new Persona());
		MostrarLista();

		System.out.println("Lista ordenada por año");
		Collections.sort(listaDePersonas, new Persona().ComparePorAño);
		MostrarLista();

		System.out.println("Lista ordenada por nombre");
		Collections.sort(listaDePersonas, new Persona().ComparePorNombre);
		MostrarLista();

		System.out.println("Lista ordenada por apelido");
		Collections.sort(listaDePersonas, new Persona().ComparePorAño);
		MostrarLista();


	}
	static  LinkedList<Persona> listaDePersonas = new LinkedList<Persona>();

	public static void AgregarPersona(){
			String nombre = JOptionPane.showInputDialog("Nombre");
			String apellido = JOptionPane.showInputDialog("Apellido");
			int año = Integer.parseInt(JOptionPane.showInputDialog("año"));
			listaDePersonas.add(new Persona(nombre, apellido, año));
	}

	static void MostrarLista(){
		for (Persona p: listaDePersonas
		) {
			System.out.println(p.toString());
		}
	}


}
