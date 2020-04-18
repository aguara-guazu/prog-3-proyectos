package edu.utn.model.grupo01;

import edu.utn.controller.Perfil;

/**
 * @author mcarpio
 * @version 1.0
 * @created 18-abr-2017 12:15:22 p.m.
 */
public class ArrozIntegral extends Arroz {

	private float hierro;
	private static float porcentajeAlmidon;

	public ArrozIntegral(){
		this.setTipo(this.getClass().getSimpleName());
		Perfil p = new Perfil(0f,20f,3f,0f,0f,15f,0f,0f,0f,0f,2f,6f,0.6f,0.1f,0f,0f);
		this.setPerfil(p);
	}

	public float getHierro() {
		return hierro;
	}

	public void setHierro(float hierro) {
		this.hierro = hierro;
	}

	public static float getPorcentajeAlmidon() {
		return porcentajeAlmidon;
	}

	public static void setPorcentajeAlmidon(float porcentajeAlmidon) {
		ArrozIntegral.porcentajeAlmidon = porcentajeAlmidon;
	}

	

}