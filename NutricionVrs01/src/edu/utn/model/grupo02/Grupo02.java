package edu.utn.model.grupo02;

import edu.utn.model.Alimento;

public class Grupo02 extends Alimento {

    private String codigo;
    private String tipo;


    public Grupo02(){

    }

    public String getDescripción(){
        return "Grupo 1: base de la pirámide consiste en alimentos ricos en carbohidratos. Los hidratos carbono "
                + "en forma de glucosa, fructosa, sacarosa, maltosa, lactosa, almidón, entre otros son "
                + "la principal fuente de energía para el cuerpo. La glucosa es esencial para mantener "
                + "la integridad funcional del tejido nervioso y, en circunstancias normales, la única "
                + "fuente de energía para el cerebro. La presencia de carbohidratos es necesaria para "
                + "el metabolismo normal de las grasas. Se recomienda el consumo de 6 a 11 porciones diarias. "
                + "Ejemplos de alimentos en este grupo: una porción de pan, cereales y masas, arroz, te "
                + "o macarrones cocidos.";
    }



    public String getCodigo() {
        return codigo;
    }



    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
