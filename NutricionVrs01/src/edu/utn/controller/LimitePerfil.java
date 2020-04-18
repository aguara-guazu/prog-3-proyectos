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
					"Pasa validación de Azucares\n":
					"No Pasa validación de Azucares. Valor: "+p.getAzucares()+ " ["+min.getAzucares()+","+max.getAzucares()+"]\n";
		return rsl;
	}
	
	public String checkCalcio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCalcio() >= min.getCalcio() && p.getCalcio() <= max.getCalcio())?
					"Pasa validación de Calcio\n":
					"No Pasa validación de Calcio. Valor: "+p.getCalcio()+ " ["+min.getCalcio()+","+max.getCalcio()+"]\n";
		return rsl;
	}
	
	public String checkCalorias(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCalorias() >= min.getCalorias() && p.getCalorias() <= max.getCalorias())?
					"Pasa validación de Calorías\n":
					"No Pasa validación de Calorías. Valor: "+p.getCalorias()+ " ["+min.getCalorias()+","+max.getCalorias()+"]\n";
		return rsl;
	}
	
	public String checkCarbohidratos(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getCarbohidratos()  >= min.getCarbohidratos() && p.getCarbohidratos() <= max.getCarbohidratos())?
					"Pasa validación de Carbohidratos\n":
					"No Pasa validación de Carbohidratos. Valor: "+p.getCarbohidratos()+ " ["+min.getCarbohidratos()+","+max.getCarbohidratos()+"]\n";
		return rsl;
	}
	
	public String checkColesterol(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getColesterol() >= min.getColesterol() && p.getColesterol() <= max.getColesterol())?
					"Pasa validación de Colesterol\n":
					"No Pasa validación de Colesterol. Valor: "+p.getColesterol()+ " ["+min.getColesterol()+","+max.getColesterol()+"]\n";
		return rsl;
	}
	
	public String checkFibraDietetica(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getFibraDietetica() >= min.getFibraDietetica() && p.getFibraDietetica() <= max.getFibraDietetica())?
					"Pasa validación de FibraDietetica\n":
					"No Pasa validación de FibraDietetica. Valor: "+p.getFibraDietetica()+ " ["+min.getFibraDietetica()+","+max.getFibraDietetica()+"]\n";
		return rsl;
	}
	
	public String checkGrasasMonoinsaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasMonoinsaturadas() >= min.getGrasasMonoinsaturadas() && p.getGrasasMonoinsaturadas() <= max.getGrasasMonoinsaturadas())?
					"Pasa validación de GrasasMonoinsaturadas\n":
					"No Pasa validación de GrasasMonoinsaturadas. Valor: "+p.getGrasasMonoinsaturadas()+ " ["+min.getGrasasMonoinsaturadas()+","+max.getGrasasMonoinsaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasPoliinsaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasPoliinsaturadas() >= min.getGrasasPoliinsaturadas() && p.getGrasasPoliinsaturadas() <= max.getGrasasPoliinsaturadas())?
					"Pasa validación de GrasasPoliinsaturadas\n":
					"No Pasa validación de GrasasPoliinsaturadas. Valor: "+p.getGrasasPoliinsaturadas()+ " ["+min.getGrasasPoliinsaturadas()+","+max.getGrasasPoliinsaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasSaturadas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasSaturadas() >= min.getGrasasSaturadas() && p.getGrasasSaturadas() <= max.getGrasasSaturadas())?
					"Pasa validación de GrasasSaturadas\n":
					"No Pasa validación de GrasasSaturadas. Valor: "+p.getGrasasSaturadas()+ " ["+min.getGrasasSaturadas()+","+max.getGrasasSaturadas()+"]\n";
		return rsl;
	}
	
	public String checkGrasasTrans(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getGrasasTrans() >= min.getGrasasTrans() && p.getGrasasTrans() <= max.getGrasasTrans())?
					"Pasa validación de GrasasTrans\n":
					"No Pasa validación de GrasasTrans. Valor: "+p.getGrasasTrans()+ " ["+min.getGrasasTrans()+","+max.getGrasasTrans()+"]\n";
		return rsl;
	}
	
	public String checkHierro(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getHierro() >= min.getHierro() && p.getHierro() <= max.getHierro())?
					"Pasa validación de Hierro\n":
					"No Pasa validación de Hierro. Valor: "+p.getHierro()+ " ["+min.getHierro()+","+max.getHierro()+"]\n";
		return rsl;
	}
	
	public String checkPotacio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getPotacio() >= min.getPotacio() && p.getPotacio() <= max.getPotacio())?
					"Pasa validación de Potacio\n":
					"No Pasa validación de Potacio. Valor: "+p.getPotacio()+ " ["+min.getPotacio()+","+max.getPotacio()+"]\n";
		return rsl;
	}
	
	public String checkProteinas(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getProteinas() >= min.getProteinas() && p.getProteinas() <= max.getProteinas())?
					"Pasa validación de Proteinas\n":
					"No Pasa validación de Proteinas. Valor: "+p.getProteinas()+ " ["+min.getProteinas()+","+max.getProteinas()+"]\n";
		return rsl;
	}
	
	public String checkSodio(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getSodio() >= min.getSodio() && p.getSodio() <= max.getSodio())?
					"Pasa validación de Sodio\n":
					"No Pasa validación de Sodio. Valor: "+p.getSodio()+ " ["+min.getSodio()+","+max.getSodio()+"]\n";
		return rsl;
	}
	
	public String checkVitaminaA(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getVitaminaA() >= min.getVitaminaA() && p.getVitaminaA() <= max.getVitaminaA())?
					"Pasa validación de VitaminaA\n":
					"No Pasa validación de VitaminaA. Valor: "+p.getVitaminaA()+ " ["+min.getVitaminaA()+","+max.getVitaminaA()+"]\n";
		return rsl;
	}
	
	public String checkVitaminaC(Alimento a){
		Perfil p = a.getPerfil();
		String rsl = (p.getVitaminaC() >= min.getVitaminaC() && p.getVitaminaC() <= max.getVitaminaC())?
					"Pasa validación de VitaminaC\n":
					"No Pasa validación de VitaminaC. Valor: "+p.getVitaminaC()+ " ["+min.getVitaminaC()+","+max.getVitaminaC()+"]\n";
		return rsl;
	}
}
