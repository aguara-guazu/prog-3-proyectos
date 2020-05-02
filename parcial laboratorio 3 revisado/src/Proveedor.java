public class Proveedor {
    private String nroProveedor;
    private String nombreProveedor;
    public Proveedor(String nombreProveedor, String nroProveedor){
        this.nombreProveedor = nombreProveedor;
        this.nroProveedor = nroProveedor;
    }
    @Override
    public String toString() {
        return "\nnombre del proveedor: " + getNombreProveedor() + "\nnumero del provedor: " + getNroProveedor();
    }

    public String getNroProveedor() {
        return nroProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }
}
