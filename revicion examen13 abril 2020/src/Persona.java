
public class Persona {
	
	// atributos
	private int nroCliente;
	private int DNI;
	
	// constructores
	public Persona (int nroCliente, int DNI) {
		this.nroCliente=nroCliente;
		this.DNI=DNI;
	}
	public Persona() {}
	
	// Getters
	public int getNroCliente() {
		return nroCliente;
	}
	public int getDNI() {
		return DNI;
	}
	
}
