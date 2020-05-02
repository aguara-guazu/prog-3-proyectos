import java.util.*;

public class Lista {
    List<Persona> listaPersonas = new ArrayList<>();

    public boolean agregarPersona(String nombre, String apellido, int nroRegistro, String fechaDeteccion, String mac){
        if (!controlarMac(mac)){
            return false;
        }
        else {
            listaPersonas.add(new Persona(nombre,apellido,nroRegistro,fechaDeteccion,mac));
            return true;
        }
    }

    private boolean controlarMac(String mac){
        String[] numeros = mac.split("-");
        if (numeros.length != 6){
            return false;
        }
        int lugar;
        for (String numero : numeros) {

            //le asigno a lugar el int dentro de numeros
            lugar = Integer.parseInt(numero);

            //compruebo que este en los limites.
            if (lugar < 0 || lugar > 255) {
                return false;
            }
        }
        //si paso todo retorna true
        return true;
    }

    public String obtenerLista(){
        Iterator<Persona> iterator = listaPersonas.iterator();
        String salida ="";
        while (iterator.hasNext()){
            salida = salida + iterator.next().toString() +"\n";
        }
        return salida;
    }

    public boolean removerPersona(int numeroRegistro){
        for (Persona p :
                listaPersonas) {
            if (p.getNroRegistro() == numeroRegistro) {
                listaPersonas.remove(p);
                return true;
            }
        }
        return false;
    }

    public void ordenarPorNombre(){
        Collections.sort(listaPersonas, new sortByNombre());
    }
    public void  ordenarPorApellido(){
        Collections.sort(listaPersonas, new sortByApellido());
    }
    public void  ordenarPorFecha(){
        Collections.sort(listaPersonas, new sortByFechaDeteccion());
    }
    public  void  ordenarPorRegistro(){
        Collections.sort(listaPersonas, new sortByNroRegistro());
    }
    public void  ordenarPorMac(){
        Collections.sort(listaPersonas, new sortByMac());
    }
}
