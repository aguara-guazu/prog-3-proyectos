package edu.utn.model;

import edu.utn.controller.Perfil;

public abstract class Alimento {
	private Perfil perfil;
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
