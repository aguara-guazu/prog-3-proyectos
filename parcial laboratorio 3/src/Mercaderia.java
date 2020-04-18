public class Mercaderia implements Comparable<Mercaderia>{
    private String codigoArticulo;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String nroProveedor;

    public Mercaderia(String codigoArticulo, String nombre, String nroProveedor, int cantidadStock, double precio) {
        this.setCodigoArticulo(codigoArticulo);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setCantidadStock(cantidadStock);
        this.setNroProveedor(nroProveedor);
    }

    @Override
    public int compareTo(Mercaderia o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return " nombre del articulo:"+
                nombre +
                " codigo del articulo: "+
                codigoArticulo +
                " precio del articulo: "+
                precio +
                " cantidad en stock: "+
                cantidadStock;
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

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getNroProveedor() {
        return nroProveedor;
    }

    public void setNroProveedor(String nroProveedor) {
        this.nroProveedor = nroProveedor;
    }
}
