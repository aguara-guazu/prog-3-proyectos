import java.util.*;

public class Cliente implements Comparable<Cliente>, Comparator<Cliente>{
	
	// atributos pedidos en el ejercicio
	private String nombre;
	private String apellido;
	private int nroCliente;
	private int a�oNac;
	private String direccion; // (poruqe tiene que ser calle y n�)
	
	// constructores
	public Cliente (String nombre, String apellido, int nroCliente, int a�oNac, String direccion) { // me equivoque
		this.nombre=nombre;
		this.apellido=apellido;
		this.nroCliente=nroCliente;
		this.a�oNac=a�oNac;
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

	public int getA�oNac() {
		return a�oNac;
	}

	public String getDireccion() {
		return direccion;
	}
	
	// m�todo toString() para imprimir informaci�n de cada cliente
	public String toString() {
		return "N� Cliente "+this.getNroCliente()+" - "+this.getNombre()+" "+this.getApellido()+", naci� en el a�o "+this.getA�oNac()+" y vive en calle "+this.getDireccion();
	}
	
	// m�todo compareTo() para implementar la interfaz Comparable y ordenar por nombre de los clientes
	public int compareTo(Cliente c) {
		return this.getNombre().compareTo(c.getNombre());
	}
	
	// m�todo compare() para implementar la interfaz Comparator y ordenar por fecha de nacimiento de los clientes
	public int compare(Cliente c1, Cliente c2) {
		return c1.getA�oNac()-c2.getA�oNac();
	}
}
