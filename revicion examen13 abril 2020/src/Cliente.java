import java.util.*;

public class Cliente implements Comparable<Cliente>, Comparator<Cliente>{
	
	// atributos pedidos en el ejercicio
	private String nombre;
	private String apellido;
	private int nroCliente;
	private int añoNac;
	private String direccion; // (poruqe tiene que ser calle y n°)
	
	// constructores
	public Cliente (String nombre, String apellido, int nroCliente, int añoNac, String direccion) { // me equivoque
		this.nombre=nombre;
		this.apellido=apellido;
		this.nroCliente=nroCliente;
		this.añoNac=añoNac;
		this.direccion=direccion;
	}
	public Cliente() {}
	
	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public int getAñoNac() {
		return añoNac;
	}

	public String getDireccion() {
		return direccion;
	}
	
	// método toString() para imprimir información de cada cliente
	public String toString() {
		return "N° Cliente "+this.getNroCliente()+" - "+this.getNombre()+" "+this.getApellido()+", nació en el año "+this.getAñoNac()+" y vive en calle "+this.getDireccion();
	}
	
	// método compareTo() para implementar la interfaz Comparable y ordenar por nombre de los clientes
	public int compareTo(Cliente c) {
		return this.getNombre().compareTo(c.getNombre());
	}
	
	// método compare() para implementar la interfaz Comparator y ordenar por fecha de nacimiento de los clientes
	public int compare(Cliente c1, Cliente c2) {
		return c1.getAñoNac()-c2.getAñoNac();
	}
}
