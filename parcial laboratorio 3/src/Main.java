import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args) {
        Boolean salida = false;
        while (!salida) {
            String opcion;
            switch (opcion){
                case "1":
                    AgregarProveedor();
                    break;
                case "2":
                    AgregarMercaderia();
                    break;
                case "3":
                    EliminarMercaderia();
                    break;
                case "4":
                    OrdenarMercaderiaPorNombre();
                    break;
                case "5":
                    OrdenarMercaderiaPorPrecio();
                    break;
                case "6":
                    MostrarDatosPorConsola();
                    break;
                case "7":
                    salida = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(new JFrame(), "opcion incorrecta, escriba una correcta");
                    break;

            }

        }

    List<Mercaderia> listaDeMercaderia = new ArrayList<>();
    List<Proveedor> listaDeProveedores = new ArrayList<>();

    public  void AgregarProveedor(){
        String numeroProveedor = showInputDialog("ingrese el numero  de proveedor");
        String nombreProveedor = showInputDialog("ingrese el nombre del proveedor");
        Proveedor unProveedor = new Proveedor(numeroProveedor,nombreProveedor);
        if (listaDeProveedores.contains(unProveedor)){
            showMessageDialog(new JFrame(),"el proveedor ya existe en la lista");
        }
        else {
            listaDeProveedores.add(unProveedor);

        }
    }
    public  void  OrdenarMercaderiaPorPrecio(){
        listaDeMercaderia.sort(new ComparePorPrecio());
    }
    public  void  OrdenarMercaderiaPorNombre(){
        Collections.sort(listaDeMercaderia);
    }
    public  void MostrarDatosPorConsola(){
        for (int i = 0; i < listaDeMercaderia.size(); i++) {
            System.out.println(ObtenerDatosMercaderia(i));
        }
    }
    public String ObtenerDatosMercaderia(int index){
        Mercaderia unaMercaderia = listaDeMercaderia.get(index);
        String salida = unaMercaderia.toString() + ObtenerDatosProveedor(unaMercaderia.getNroProveedor());
        return salida;
    }
    public  void AgregarMercaderia(){
        Mercaderia unaMercaderia;
        String codigoArticulo = showInputDialog();
        String nombre = showInputDialog();
        double precio = showInputDialog();
        int cantidadStock = showInputDialog();
        String nroProveedor = showInputDialog();
        if (ComprobarProveedor(nroProveedor)){
            unaMercaderia = new Mercaderia(codigoArticulo,nombre,nroProveedor,cantidadStock,precio);
            listaDeMercaderia.add(unaMercaderia);
            showMessageDialog(new JFrame(), "Mercaderia agregada con exito");
        }
        else{
            showMessageDialog(new JFrame(), "El Proveedor no existe");
        }
    }
    public  void  EliminarMercaderia(){
        String codigoArticulo = showInputDialog("ingrese el codigo del articulo a eliminar");
        boolean exito = false;
        for (Mercaderia m:
             listaDeMercaderia) {
            if (m.getCodigoArticulo().equals(codigoArticulo)){
                listaDeMercaderia.remove(m);
                showMessageDialog(new JFrame(),"articulo borrado con exito");
                exito = true;
                break;
            }
        }
        if (!exito){
            showMessageDialog(new JFrame(),"el codigo del articulo no se encontro");
        }
        }


    public boolean  ComprobarProveedor(String nroProveedor){
        for (Proveedor p :
                listaDeProveedores) {
            if (p.getNroProveedor().equals(nroProveedor)){
                return true;
            }
        }
        return false;
    }
    public String ObtenerDatosProveedor(String nroProveedor){
        for (Proveedor p :
                listaDeProveedores) {
            if (p.getNroProveedor().equals(nroProveedor)){
                return p.toString();
            }
        }
        return "";
    }
}