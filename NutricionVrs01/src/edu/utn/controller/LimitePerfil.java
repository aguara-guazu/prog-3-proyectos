package edu.utn.controller;

import edu.utn.model.Alimento;

public class LimitePerfil {
	private Perfil min;
	private Perfil max;
	
	
	public LimitePerfil(Perfil min, Perfil max){
		this.min=min;
		this.max=max;
	}

	public Perfil getMin() {
		return min;
	}

	public Perfil getMax() {
		return max;
	}
	
	public boolean esCoherente(){
		return  (max.getAzucares()>=min.getAzucares())
				&& (max.getCalcio()>=min.getCalcio())
				&& (max.getCalorias()>= min.getCalorias())
				&& (max.getCarbohidratos()>=min.getCarbohidratos())
				&& (max.getColesterol()>=min.getColesterol())
				&& (max.getFibraDietetica()>=min.getFibraDietetica())
				&& (max.getGrasasMonoinsaturadas()>=min.getGrasasMonoinsaturadas())
				&& (max.getGrasasPoliinsaturadas()>=min.getGrasasPoliinsaturadas())
				&& (max.getGrasasSaturadas()>=min.getGrasasSaturadas())
				&& (max.getGrasasTrans()>=min.getGrasasTrans())
				&& (max.getHierro()>=min.getHierro())
				&& (max.getPotacio()>=min.getPotacio())
				&& (max.getProteinas()>=min.getProteinas())
				&& (max.getSodio()>=min.getSodio())
				&& (max.getVitaminaA()>=min.getVitaminaA())
				&& (max.getVitaminaC()>=min.getVitaminaC());
	}
	
	public String checkAzucares(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getAzucares() >= min.getAzucares() && p.getAzucares() <= max.getAzucares())?
					"Pasa validaci�n de Azucares\n":
					"No Pasa validaci�n de Azucares. Valor: "+p.getAzucares()+ " ["+min.getAzucares()+","+max.getAzucares()+"]\n";
		return rsl;
	}
	
	public String checkCalcio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCalcio() >= min.getCalcio() && p.getCalcio() <= max.getCalcio())?
					"Pasa validaci�n de Calcio\n":
					"No Pasa validaci�n de Calcio. Valor: "+p.getCalcio()+ " ["+min.getCalcio()+","+max.getCalcio()+"]\n";
		return rsl;
	}
	
	public String checkCalorias(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCalorias() >= min.getCalorias() && p.getCalorias() <= max.getCalorias())?
					"Pasa validaci�n de Calor�as\n":
					"No Pasa validaci�n de Calor�as. Valor: "+p.getCalorias()+ " ["+min.getCalorias()+","+max.getCalorias()+"]\n";
		return rsl;
	}
	
	public String checkCarbohidratos(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCarbohidratos()  >= min.getCarbohidratos() && p.getCarbohidratos() <= max.getCarbohidratos())?
					"Pasa validaci�n de Carbohidratos\n":
					"No Pasa validaci�n de Carbohidratos. Valor: "+p.getCarbohidratos()+ " ["+min.getCarbohidratos()+","+max.getCarbohidratos()+"]\n";
		return rsl;
	}
	
	public String checkColesterol(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getColesterol() >= min.getColesterol() && p.getColesterol() <= max.getColesterol())?
					"Pasa validaci�n de Colesterol\n":
					"No Pasa validaci�n de Colesterol. Valor: "+p.getColesterol()+ " ["+min.getColesterol()+","+max.getColesterol()+"]\n";
		return rsl;
	}
	
	public String checkFibraDietetica(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getFibraDietetica() >= min.getFibraDietetica() && p.getFibraDietetica() <= max.getFibraDietetica())?
					"Pasa validaci�n de FibraDietetica\n":
					"No Pasa validaci�n de FibraDietetica. Valor: "+p.getFibraDietetica()+ " ["+min.getFibraDietetica()+","+max.getFibraDietetica()+"]\n";
		return rsl;
	}
	
	public String checkGrasasMonoinsaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasMonoinsaturadas() >= min.getGrasasMonoinsaturadas() && p.getGrasasMonoinsaturadas() <= max.getGrasasMonoinsaturadas())?
					"Pasa validaci�n de GrasasMonoinsaturadas\n":
					"No Pasa validaci�n de GrasasMonoinsaturadas. Valor: "+p.getGrasasMonoinsaturadas()+ " ["+min.getGrasasMonoinsaturadas()+","+max.getGrasasMonoinsaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasPoliinsaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasPoliinsaturadas() >= min.getGrasasPoliinsaturadas() && p.getGrasasPoliinsaturadas() <= max.getGrasasPoliinsaturadas())?
					"Pasa validaci�n de GrasasPoliinsaturadas\n":
					"No Pasa validaci�n de GrasasPoliinsaturadas. Valor: "+p.getGrasasPoliinsaturadas()+ " ["+min.getGrasasPoliinsaturadas()+","+max.getGrasasPoliinsaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasSaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasSaturadas() >= min.getGrasasSaturadas() && p.getGrasasSaturadas() <= max.getGrasasSaturadas())?
					"Pasa validaci�n de GrasasSaturadas\n":
					"No Pasa validaci�n de GrasasSaturadas. Valor: "+p.getGrasasSaturadas()+ " ["+min.getGrasasSaturadas()+","+max.getGrasasSaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasTrans(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasTrans() >= min.getGrasasTrans() && p.getGrasasTrans() <= max.getGrasasTrans())?
					"Pasa validaci�n de GrasasTrans\n":
					"No Pasa validaci�n de GrasasTrans. Valor: "+p.getGrasasTrans()+ " ["+min.getGrasasTrans()+","+max.getGrasasTrans()+"]\n";
		return rsl;
	}
	
	public String checkHierro(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getHierro() >= min.getHierro() && p.getHierro() <= max.getHierro())?
					"Pasa validaci�n de Hierro\n":
					"No Pasa validaci�n de Hierro. Valor: "+p.getHierro()+ " ["+min.getHierro()+","+max.getHierro()+"]\n";
		return rsl;
	}
	
	public String checkPotacio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getPotacio() >= min.getPotacio() && p.getPotacio() <= max.getPotacio())?
					"Pasa validaci�n de Potacio\n":
					"No Pasa validaci�n de Potacio. Valor: "+p.getPotacio()+ " ["+min.getPotacio()+","+max.getPotacio()+"]\n";
		return rsl;
	}
	
	public String checkProteinas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getProteinas() >= min.getProteinas() && p.getProteinas() <= max.getProteinas())?
					"Pasa validaci�n de Proteinas\n":
					"No Pasa validaci�n de Proteinas. Valor: "+p.getProteinas()+ " ["+min.getProteinas()+","+max.getProteinas()+"]\n";
		return rsl;
	}
	
	public String checkSodio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getSodio() >= min.getSodio() && p.getSodio() <= max.getSodio())?
					"Pasa validaci�n de Sodio\n":
					"No Pasa validaci�n de Sodio. Valor: "+p.getSodio()+ " ["+min.getSodio()+","+max.getSodio()+"]\n";
		return rsl;
	}
	
	public String checkVitaminaA(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getVitaminaA() >= min.getVitaminaA() && p.getVitaminaA() <= max.getVitaminaA())?
					"Pasa validaci�n de VitaminaA\n":
					"No Pasa validaci�n de VitaminaA. Valor: "+p.getVitaminaA()+ " ["+min.getVitaminaA()+","+max.getVitaminaA()+"]\n";
		return rsl;
	}
	
	public String checkVitaminaC(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getVitaminaC() >= min.getVitaminaC() && p.getVitaminaC() <= max.getVitaminaC())?
					"Pasa validaci�n de VitaminaC\n":
					"No Pasa validaci�n de VitaminaC. Valor: "+p.getVitaminaC()+ " ["+min.getVitaminaC()+","+max.getVitaminaC()+"]\n";
		return rsl;
	}
}
