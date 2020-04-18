package edu.utn.model;

import java.util.ArrayList;
import java.util.List;

import edu.utn.controller.Perfil;

public class AlimentoCompuesto<T extends Alimento> extends Alimento {
	
	private List<T> alimentosBase;
	
	public AlimentoCompuesto() {
		this.alimentosBase = new ArrayList<T>();
	}
	
	public void addAlimento(T alimento){
		this.alimentosBase.add(alimento);
	}
	
	
	@Override
	public Perfil getPerfil() {
		Perfil p = new Perfil();
		for(T pf:this.alimentosBase){
			p.sumarPerfil(pf.getPerfil());
		}
		return p.verificarValores();
	}
	
	
	
}
