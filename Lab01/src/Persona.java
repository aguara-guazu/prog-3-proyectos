
public class Persona {
	
	private int id;
	private String apellido;
	private String nombre;
	private int edad;
	private char sexo;
	public int dni;
	
	// Constructores
	public Persona (int id, String apellido, String nombre, int edad, char sexo, int dni) {
		this.id=id;
		this.apellido=apellido;
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=sexo;
		this.dni=dni;
	}
	
	public Persona () {}
	
	// Getters-Setters
	public String getApellido() {
		return apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public int getEdad() {
		return edad;
	}
	
	
	// M�todo para obtener informaci�n de la clase padre y 
	// luego ser sobreescrito en las clases hijas (Alumno y Profesor). Opci�n: ToString()
	public String getInformaci�n() {
		return getApellido()+", "+getNombre()+" - "+getEdad()+" a�os";
	}
}
