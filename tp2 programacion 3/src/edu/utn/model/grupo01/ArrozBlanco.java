package edu.utn.model.grupo01;

import edu.utn.controller.Perfil;

/**
 * @author mcarpio
 * @version 1.0
 * @created 18-abr-2017 12:15:22 p.m.
 */
public class ArrozBlanco extends Arroz {

	private float glucosaConsentrada;

	public ArrozBlanco(){
		this.setTipo(this.getClass().getSimpleName());
		Perfil p = new Perfil(0f,15f,10f,0f,4f,15f,0f,0f,0f,0f,2f,6f,0.5f,0.1f,0f,0f);
		this.setPerfil(p);
	}

	public float getAlmidon(){
		return 23.1f;
	}

	public float getGlucosaConsentrada() {
		return glucosaConsentrada;
	}

	public void setGlucosaConsentrada(float glucosaConsentrada) {
		this.glucosaConsentrada = glucosaConsentrada;
	}
	


}