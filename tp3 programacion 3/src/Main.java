import Universo.Lista;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("Lista origial si filtrar");
        System.out.println(lista.mostrarListaNoFiltrada());

        System.out.println("\nLista filtrada por el punto A");
        System.out.println(lista.aplicarPrimerFiltroValores());

        System.out.println("\nLista filtrada por el punto B");
        System.out.println(lista.aplicarSegundoFiltroValores());

        System.out.println("\nLista filtrada por el punto D");
        System.out.println("centroide: " + lista.obtenerCentroide());
        System.out.println("\nLista:");
        System.out.println(lista.aplicarTercerFiltroValores());

        System.out.println("\nLista filtrada por el punto F");
        System.out.println(lista.aplicarCuartoFiltroValores());

        System.out.println("\nLista filtrada por el punto G");
        System.out.println(lista.aplicarQuintoFiltroValores());

        System.out.println("\nLista filtrada por el punto I");
        System.out.println(lista.aplicarSextoFiltroValores());

        System.out.println("\nNota adicional: la salida tiene un formato diferente para usarse en la web https://www.desmos.com/calculator " +
                "\nPara habilitar el formato para geogebra se pueden desmarcar los comentarios en la clase lista dentro de la funcion mostrarLista()");
    }
}