package edu.utn.model.grupo01;

import edu.utn.controller.Perfil;

/**
 * @author mcarpio
 * @version 1.0
 * @created 18-abr-2017 12:15:22 p.m.
 */
public class AvenaProcesada extends Avena {

	private int densidadVoluvble;
	private int fructosa;
	private int sacarosa;

	public AvenaProcesada(){
		this.setTipo(this.getClass().getSimpleName());
		Perfil p = new Perfil(15f,35f,50f,0f,3f,35f,0f,0f,0f,0f,1f,3f,0.2f,1.5f,0f,0f);
		this.setPerfil(p);
	}
	
	public float getSolubilidadColesterol(){
		return super.getSolubilidadColesterol();
	}

	public int getDensidadVoluvble() {
		return densidadVoluvble;
	}

	public void setDensidadVoluvble(int densidadVoluvble) {
		this.densidadVoluvble = densidadVoluvble;
	}

	public int getFructosa() {
		return fructosa;
	}

	public void setFructosa(int fructosa) {
		this.fructosa = fructosa;
	}

	public int getSacarosa() {
		return sacarosa;
	}

	public void setSacarosa(int sacarosa) {
		this.sacarosa = sacarosa;
	}

}