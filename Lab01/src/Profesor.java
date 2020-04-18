import java.util.*;

public class Profesor extends Persona implements Comparable <Profesor>, Comparator<Profesor>{
	
	private int legajo;
	private String titulo;
	
	public Profesor (int id, String apellido, String nombre, int edad, char sexo, int dni, 
			int legajo, String titulo) {
		
				super(id, apellido, nombre, edad, sexo, dni);
				this.legajo=legajo;
				this.titulo=titulo;
	}
	public Profesor () {} // constr. por defecto
	
	// Getters
	public String getTitulo() {
		return titulo;
	}
	
	// Implementación de compareTo de Comparable
	public int compareTo(Profesor p){
		// Si el resultado de comparar por apellido me da 0, significa que son apellidos iguales.
		// Entonces paso a compararlo por nombre. Sino, sigue comparando por apellido.
		if(getApellido().compareTo(p.getApellido())==0) {
				return (getNombre()).compareTo(p.getNombre());
		}
		return (getApellido()).compareTo(p.getApellido());  
	}
	
	// Implementación de compare de Comparator
	public int compare(Profesor p, Profesor p1) {
		      return (p.getEdad() - p1.getEdad())*-1; // Multiplico por -1 para que los ordene de Mayor a menor
	}
}