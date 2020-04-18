package edu.utn.model.grupo02;

import edu.utn.controller.Perfil;

public class CarneCerdo extends CarneRoja {

    public CarneCerdo(){
        this.setTipo(this.getClass().getSimpleName());
        Perfil p = new Perfil(0f,50f,50f,0f,6f,0f,12f,0f,0f,0f,10f,6f,5f,0.1f,0f,0f);
        this.setPerfil(p);
    }
}
