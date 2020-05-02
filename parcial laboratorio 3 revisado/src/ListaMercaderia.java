import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaMercaderia {
    private List<Mercaderia> listaDeMercaderia = new ArrayList<>();
    private List<Proveedor> listaDeProveedores = new ArrayList<>();

    public String ObtenerListaMercaderia(){
        Iterator iterator = listaDeMercaderia.iterator();
        String output ="";
        while (iterator.hasNext()){
            output = output +"\n" + iterator.next().toString();
        }
        return output;
    }

    public boolean AgregarMercaderia(@NotNull Mercaderia unaMercaderia){
        if (ComprobarExistenciaProveedor(unaMercaderia.getNroProveedor())){
            getListaDeMercaderia().add(unaMercaderia);
            return true;
        }
        else {return false;}
    }
    public boolean RemoverMercaderia(@NotNull Mercaderia unaMercaderia){
        if (getListaDeMercaderia().contains(unaMercaderia)){
            return false;
        }
        else {
            getListaDeMercaderia().remove(unaMercaderia);
            return true;
        }
    }

    public boolean AgergarProveedor(@NotNull Proveedor unProveedor){
        if (getListaDeProveedores().contains(unProveedor)){
            return false;
        }
        else {
            getListaDeProveedores().add(unProveedor);
            return true;
        }
    }

    public void OrdenarPorNombre(){
        Collections.sort(getListaDeMercaderia());
    }
    public void  OrdenarPorPrecio(){
        Collections.sort(getListaDeMercaderia(),new OrdenarPorPrecio());
    }

    private boolean ComprobarExistenciaProveedor(String nroProveedor){
        for (Proveedor p :
                getListaDeProveedores()) {
            if (p.getNroProveedor().equals(nroProveedor)){return true;}
        }
        return false;
    }

    public List<Mercaderia> getListaDeMercaderia() {
        return listaDeMercaderia;
    }

    public List<Proveedor> getListaDeProveedores() {
        return listaDeProveedores;
    }
}
