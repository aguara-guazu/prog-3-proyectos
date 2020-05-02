public class Persona {
    private String nombre;
    private String apellido;
    private int nroRegistro; //numero de enfero detectado
    private String fechaDeteccion; // fecha de deteccion de la persona.
    private String mac;

    public Persona(String nombre, String apellido, int nroRegistro, String fechaDeteccion, String mac){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroRegistro = nroRegistro;
        this.fechaDeteccion = fechaDeteccion;
        this.mac = mac;
    }
    @Override
    public String toString() {
        return   " Nombre: " + getNombre()
                +" Apellido: " + getApellido()
                +"\n Numero de registro: " + getNroRegistro()
                +" Fecha de deteccion: " + getFechaDeteccion()
                +"\n Direccion MAC: " + getMac();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNroRegistro() {
        return nroRegistro;
    }

    public String getFechaDeteccion() {
        return fechaDeteccion;
    }

    public String getMac() {
        return mac;
    }
}
