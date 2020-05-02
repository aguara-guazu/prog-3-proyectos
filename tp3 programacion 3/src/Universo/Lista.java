package Universo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {

    private List<Punto> listaDePuntos = new ArrayList<>();

    public Lista(){
        generarPuntos();
    }

    public String mostrarListaNoFiltrada(){
        return mostrarLista(listaDePuntos);
    }
    public String aplicarPrimerFiltroValores(){
        return mostrarLista(
                listaDePuntos.stream().filter(x -> x.getY() > -20 && x.getY() < 15).collect(Collectors.toList())
        );
    }
    public String aplicarSegundoFiltroValores(){
        //punto B|
        return mostrarLista(
                listaDePuntos.stream().filter(x -> obtenerFx(x.getX()) - x.getX() > 10 && obtenerFx(x.getX()) > 10).collect(Collectors.toList())
        );
    } //filtra debajo de F(x)
    public String aplicarTercerFiltroValores(){
        Punto centroide = obtenerCentroide();
        return mostrarLista(
                listaDePuntos.stream().filter(x -> calcularDistanciaEntrePuntos(centroide,x) > 5).collect(Collectors.toList())
        );
    }
    public String aplicarCuartoFiltroValores(){
       //punto F
        return mostrarLista(
                listaDePuntos.stream().filter(x -> x.getY() <= obtenerFx(x.getX())).collect(Collectors.toList())
        );
    } //filtra la lista por arriba de F(x)
    public String aplicarQuintoFiltroValores(){
        return mostrarLista(
                listaDePuntos.stream().filter(x -> x.getX() <= 0 && (0 >= x.getY() && x.getY() >= obtenerFx(x.getX()))).collect(Collectors.toList())
        );
    } //filtra la lista punto g
    public String aplicarSextoFiltroValores(){
        return mostrarLista(
                listaDePuntos.stream().filter(x -> (x.getX() >= -4 && x.getX() >= 4) && x.getY() < obtenerFx(x.getX())).collect(Collectors.toList())
        );
    } //filtra la lista punto i

    private void generarPuntos(){
        for (int i = 0; i < 300; i++) {
            listaDePuntos.add(new Punto());
        }
    }
    private double obtenerFx(double unPunto){
        return Math.pow(unPunto,3) + (2 * Math.pow(unPunto,2)) - (2 - unPunto) +2;
    }
    public double calcularDistanciaEntrePuntos(@NotNull Punto p1, @NotNull Punto p2){
        return Math.sqrt(
                        Math.pow(
                                (p2.getX() - p1.getX()) ,2)
                                +
                        Math.pow(
                                (p2.getY() - p1.getY()) ,2)
        );
    }
    public Punto obtenerCentroide(){
        double x;
        double y= 0;
        x = listaDePuntos.stream().mapToDouble(Punto::getX).sum();
        y = listaDePuntos.stream().mapToDouble(Punto::getY).sum();
        x = x/ listaDePuntos.size();
        y = y/ listaDePuntos.size();
        return new Punto(x, y);
    }
    private String mostrarLista( List<Punto> lista){
        StringBuilder output = new StringBuilder();
        // se elimino el formato tipo lista={...} de este caso para que el formato sea acorde
        // para usar en la pagina graficadora desmos ya que geogebra me dejaba de responder al cargar 300 puntos
        //output.append("lista={");
        lista.forEach(x -> output.append(x.toString()).append(","));
        output.setLength(output.length() - 1); //esta funcio remueve la ultima coma sobrante del string
        //output.append("}"); //borrar las anotaciones para que la salida tenga el formato compatible con geogebra
        return String.valueOf(output);
    }

}
