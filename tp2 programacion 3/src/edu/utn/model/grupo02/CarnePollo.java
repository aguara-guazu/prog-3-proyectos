package edu.utn.model.grupo02;

import edu.utn.controller.Perfil;

public class CarnePollo extends CarneBlanca {

    public CarnePollo(){
        this.setTipo(this.getClass().getSimpleName());
        Perfil p = new Perfil(0f,20f,45f,0f,4.4f,0f,10f,0f,0f,0f,10f,3f,6f,0.1f,0f,0f);
        this.setPerfil(p);
    }
}
