import java.util.*;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lista de personas con datos de nroCliente y DNI
		
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(15418, 37080129));
		personas.add(new Persona(15821, 16166691));
		personas.add(new Persona(15645, 37080546));
		personas.add(new Persona(15942, 36852357));

		// Creo una lista de clientes
		List<Cliente> clientes = new ArrayList<Cliente>();

		// variables que necesito para ingresar los datos de cliente
		
		int nroCliente; // atributo que tiene tanto personas como cliente
		String nombre;
		String apellido;
		int añoNac;
		String direccion;
		boolean iguales;

		// Para respuesta dentro del do-while del primer caso y del segundo caso
		String respuesta;
		
		// Mostrar menú e ingresar al DO-WHILE GENERAL
		String opcion = JOptionPane
				.showInputDialog("Introduzca alguna de las siguientes opciones:\n1- Agregar clientes a la lista."
						+ "\n2- Quitar clientes de la lista.\n3- Listar los clientes de la lista por Nombre.\n4- Listar clientes por año de nacimiento.\n5-Salir");
		do {
			switch (opcion) {
			case "1": {
				do {
					iguales = false; // variable para determinar si nroCliente
					nroCliente = Integer
							.parseInt(JOptionPane.showInputDialog("Ingrese el numero del cliente (5 dígitos)"));

					// Genero un iterator de personas para poder recorrerlo y preguntar
					Iterator<Persona> iterador = personas.iterator();

					// iterador para recorrer la lista de personas
					while (iterador.hasNext()) {
						Persona p = (Persona) iterador.next(); // pido el objeto
						if (p.getNroCliente() == nroCliente) { // evalúo si el nroCliente de Persona es igual al ingresado para un Cliente
							iguales = true;
						}
					}
					
					// evaluo en la condicion el valor de la variable iguales y que la lista de
					// clientes no supere los 4 elementos
					if (iguales) {
						nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
						apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
						añoNac = Integer
								.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento del cliente"));
						direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente");

						// Creo el cliente una vez validado el nroCliente con la lista de Personas (que
						// exista el cliente-persona)
						clientes.add(new Cliente(nombre, apellido, nroCliente, añoNac, direccion));
						respuesta = JOptionPane.showInputDialog("¿Desea seguir ingresando clientes?\n1- para seguir operando.\n2- para finalizar");
					} else {
						respuesta = JOptionPane.showInputDialog(
								"No exite el cliente ingresado.\n¿Desea seguir cargando clientes?\n1- para seguir operando.\n2- para finalizar");
					}
				} while (respuesta.toLowerCase().equals("1"));
				
				System.out.println("\n--------------------------------- CLIENTES CARGADOS -------------------------------------------\n");
				for (Cliente c : clientes) {
					System.out.println(c.toString());
				}
				opcion = JOptionPane
						.showInputDialog("Introduzca alguna de las siguientes opciones:\n1- Agregar clientes a la lista."
								+ "\n2- Quitar clientes de la lista.\n3- Listar los clientes de la lista por Nombre.\n4- Listar clientes por año de nacimiento.\n5-Salir");
				break;
			} // FIN DE CASE "1"

			case "2": {
				// variable para guardar el objeto cliente que corresponde con el buscado
				Cliente clienteBuscado = new Cliente();
				do {
					nroCliente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n° de cliente que desea eliminar de la lista"));
					
					// En este caso uso un for para buscar el cliente. Arriba usé iterator para la busqueda en la lista de personas
					for(int i=0; i<clientes.size(); i++) {
						// evalúo si el nroCliente que pasó el usuario es igual a alguno cargado
						if (clientes.get(i).getNroCliente() == nroCliente) {
							clienteBuscado=clientes.get(i); // obetengo el objeto 
						}

					}
					
					// El metodo remove de Collections remueve el objeto indica y devuelve un boolean
					// entonces pregunto si fue eliminado ese clienteBuscado. Si es true imprime la lista, sino imprime que el numero
					// de cliente ingresado no existe y si deas segiur operando
					if(clientes.remove(clienteBuscado)) {
						System.out.println("\n------------------------------ CLIENTES ACTUALIZADOS ----------------------------------\n");
						for (Cliente c : clientes) {
						System.out.println(c.toString());}
					}
					else {
						respuesta = JOptionPane.showInputDialog("El n° de cliente ingresado no existe.\n¿Desea seguir eliminando clientes?\n1- para seguir operando.\n2- para finalizar");
					}
					respuesta = JOptionPane.showInputDialog("¿Desea seguir eliminando clientes?\n1- para seguir operando.\n2- para finalizar");
					
				}while(respuesta.toLowerCase().equals("1"));
				
				opcion = JOptionPane
						.showInputDialog("Introduzca alguna de las siguientes opciones:\n1- Agregar clientes a la lista."
								+ "\n2- Quitar clientes de la lista.\n3- Listar los clientes de la lista por Nombre.\n4- Listar clientes por año de nacimiento.\n5-Salir");
				break;
			} // FIN DE CASE 2 
			
			case "3": {
				System.out.println("\n------------------------------ CLIENTES ORDENADOS POR NOMBRE ----------------------------------\n");
				Collections.sort(clientes); // este sort ordena por nombre llamando a Comparable
				for (Cliente c : clientes) {
					System.out.println(c.toString());
				}
				opcion = JOptionPane
						.showInputDialog("Introduzca alguna de las siguientes opciones:\n1- Agregar clientes a la lista."
								+ "\n2- Quitar clientes de la lista.\n3- Listar los clientes de la lista por Nombre.\n4- Listar clientes por año de nacimiento.\n5-Salir");
				break;
			} // FIN DE CASE 3
			
			case "4": {
				System.out.println("\n------------------------- CLIENTES ORDENADOS POR AÑO DE NACIMIENTO ----------------------------\n");
				Collections.sort(clientes, new Cliente()); // este sor ordena por fecha de nacimiento llamando a Comparator
				for (Cliente c : clientes) {
					System.out.println(c.toString());
				}
				opcion = JOptionPane
						.showInputDialog("Introduzca alguna de las siguientes opciones:\n1- Agregar clientes a la lista."
								+ "\n2- Quitar clientes de la lista.\n3- Listar los clientes de la lista por Nombre.\n4- Listar clientes por año de nacimiento.\n5-Salir");
				break;
			} // FIN DE CASE 4
		}// FIN DE SWITCH

		} while (!(opcion.toLowerCase().equals("5"))); // FIN DE DO-WHILE GENERAL
	}
}
