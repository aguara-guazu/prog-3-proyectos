package edu.utn.model;

import edu.utn.controller.LimitePerfil;

public class VerificadorAlimento{
	
	public <T extends Alimento> void chequearAlimento(T alimento, LimitePerfil p){
		String result = "Resultado del An�lisis--------->\n";
		if(p.esCoherente()){
			result+= p.checkAzucares(alimento);			
			result+= p.checkCalcio(alimento);
			result+= p.checkCalorias(alimento);
			result+= p.checkCarbohidratos(alimento);
			result+= p.checkColesterol(alimento);
			result+= p.checkFibraDietetica(alimento);
			result+= p.checkGrasasMonoinsaturadas(alimento);
			result+= p.checkGrasasPoliinsaturadas(alimento);
			result+= p.checkGrasasSaturadas(alimento);
			result+= p.checkGrasasTrans(alimento);
			result+= p.checkHierro(alimento);
			result+= p.checkPotacio(alimento);
			result+= p.checkProteinas(alimento);
			result+= p.checkSodio(alimento);
			result+= p.checkVitaminaA(alimento);
			result+= p.checkVitaminaC(alimento);
		}else{
			result+="L�mites incoherentes. Imposible analizar.";
		}
		System.out.println(result);
	}
	
}
