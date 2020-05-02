public class Mercaderia implements Comparable<Mercaderia> {
    private String codigoArticulo;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String nroProveedor;

    public Mercaderia(){};
    public Mercaderia(String codigoArticulo, String nombre, double precio, int cantidadStock, String nroProveedor){
        this.codigoArticulo = codigoArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.nroProveedor = nroProveedor;
    }
    @Override
    public int compareTo(Mercaderia o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return    "\nCodigo del articulo: " + getCodigoArticulo()
                + "\nNombre del articulo:" + getNombre()
                + "\nPrecio: " + getPrecio()
                + "\nCantidad actual en stock: " + getCantidadStock()
                + "\nNumero de proveedor: " + getNroProveedor();
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public String getNroProveedor() {
        return nroProveedor;
    }
}
