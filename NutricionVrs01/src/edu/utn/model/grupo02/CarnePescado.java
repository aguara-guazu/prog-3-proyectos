package edu.utn.model.grupo02;

import edu.utn.controller.Perfil;

public class CarnePescado extends  CarneBlanca{

    public CarnePescado(){
        this.setTipo(this.getClass().getSimpleName());
        Perfil p = new Perfil(0f,45f,25f,0f,1f,0f,2f,0f,0f,0f,12f,3f,4f,0.1f,0f,0f);
        this.setPerfil(p);
    }
}
