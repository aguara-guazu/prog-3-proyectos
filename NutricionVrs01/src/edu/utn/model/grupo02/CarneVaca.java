package edu.utn.model.grupo02;

import edu.utn.controller.Perfil;

public class CarneVaca extends CarneRoja {

    public CarneVaca(){
        this.setTipo(this.getClass().getSimpleName());
        Perfil p = new Perfil(0f,55f,70f,0f,6.8f,0f,15f,0f,0f,0f,12f,6f,6.9f,0.1f,0f,0f);
        this.setPerfil(p);
    }

}
