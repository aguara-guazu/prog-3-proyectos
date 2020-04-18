import java.util.*;

public class Alumno extends Persona implements Comparable<Alumno>, Comparator<Alumno>{
	
	private int nroLE;
	private int materiasAprobadas; 
	private double promedio;
	
	public Alumno (int id, String apellido, String nombre, int edad, char sexo, int dni, 
			int nroLE, int materiasAprobadas, double promedio) {
		
				super(id, apellido, nombre, edad, sexo, dni);
				this.nroLE=nroLE;
				this.materiasAprobadas=materiasAprobadas;
				this.promedio=promedio;
		
	}
	public Alumno() {} // constrc. por defecto
	
	// Getters
	public double getPromedio() {
		return promedio;
	}
	
	//comparo el apellido del alumno a, con el apellido dentro de la clase
	public int compareTo(Alumno a){
		// Si el resultado de comparar por apellido me da 0, significa que son apellidos iguales.
		// Entonces paso a compararlo por nombre. Sino, sigue comparando por apellido.
		if(getApellido().compareTo(a.getApellido())==0) {
				return (getNombre()).compareTo(a.getNombre());
		}
		return (getApellido()).compareTo(a.getApellido());  
	}
	
	// Implementación de compare de Comparator
	public int compare(Alumno a, Alumno a1) {
		      return (int)(Math.round(a1.getPromedio()*100) - Math.round(a.getPromedio()*100));
		      // Invierto el objeto a y a1 para que ordene la lista de Mayor a menor
	}
}
