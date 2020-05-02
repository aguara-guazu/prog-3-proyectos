import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ListaMercaderia lista = new ListaMercaderia();
        lista.AgergarProveedor(new Proveedor("aaaaaa", "12345"));
         String codigoArticulo;
         String nombre;
         double precio;
         int cantidadStock;

         String nroProveedor;
         String nombreProveedor;
         String parar = "no";

         while (!parar.equals("si")){
             nombreProveedor = JOptionPane.showInputDialog("ingrese nombre del proveedor");
             nroProveedor = JOptionPane.showInputDialog("ingrese numero de proveedor");
             parar = JOptionPane.showInputDialog("dejar de agregar proveedores? si/no");
             if (!lista.AgergarProveedor(new Proveedor(nombreProveedor,nroProveedor))){
                 System.out.println("EL PROVEEDOR YA EXISTE EN LA LISTA");
             }
         }
        for (int i = 0; i < 4; i++) {
            nroProveedor = JOptionPane.showInputDialog("ingrese el numero de proveedor del articulo");
            nombre = JOptionPane.showInputDialog("ingrese el nombre del articulo");
            codigoArticulo =JOptionPane.showInputDialog("ingrese el codigo del articulo");
            precio = Double.parseDouble(JOptionPane.showInputDialog("ingrese el preico del articulo"));
            cantidadStock = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad en stock del articulo"));
            Mercaderia unaMercaderia = new Mercaderia(codigoArticulo,nombre,precio,cantidadStock,nroProveedor);
            if (!lista.AgregarMercaderia(unaMercaderia)){
                System.out.println("NO EXISTE EL PROVEEDOR DE ESTA MERCADERIA");
                i--;
            }
        }


        System.out.println("//LISTA NO ORDENADA");
        System.out.println(lista.ObtenerListaMercaderia());
        System.out.println("//LISTA ORDENADA POR PRECIO");
        lista.OrdenarPorPrecio();
        System.out.println(lista.ObtenerListaMercaderia());
        System.out.println("//LISTA ORDENADA POR NOMBRE");
        lista.OrdenarPorNombre();
        System.out.println(lista.ObtenerListaMercaderia());
    }
}