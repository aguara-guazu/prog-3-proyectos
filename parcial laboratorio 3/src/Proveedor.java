public class Proveedor {
    private String nroProveedor;
    private String nombre_Proveedor;

    public Proveedor(String nroProveedor, String nombre_Proveedor){
        this.nombre_Proveedor = nombre_Proveedor;
        this.nroProveedor = nroProveedor;
    }

    @Override
    public String toString() {
        return " nombre proveedor: " + nombre_Proveedor + " numero de proveedor: " + nroProveedor;
    }

    public String getNroProveedor() {
        return nroProveedor;
    }

    public String getNombre_Proveedor() {
        return nombre_Proveedor;
    }
}
