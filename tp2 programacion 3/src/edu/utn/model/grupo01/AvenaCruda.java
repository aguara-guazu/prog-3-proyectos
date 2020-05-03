package edu.utn.model.grupo01;

import edu.utn.controller.Perfil;

/**
 * @version 1.0
 * @created 18-abr-2017 12:15:22 p.m.
 */
public class AvenaCruda extends Avena {

	private float sodio;
	public AvenaCruda(){
		this.setTipo(this.getClass().getSimpleName());
		Perfil p = new Perfil(0f,35f,3f,0f,0f,20f,0f,0f,0f,0f,1f,3f,0.2f,0.1f,0f,0f);
		this.setPerfil(p);
	}
	
	public float getSodio() {
		return sodio;
	}
	public void setSodio(float sodio) {
		this.sodio = sodio;
	}
	
}