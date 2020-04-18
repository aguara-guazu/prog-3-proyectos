package edu.utn.controller;

public class Perfil {
	
	private float azucares;
	private float calcio;
	private float calorias;
	private float carbohidratos;
	private float colesterol;
	private float fibraDietetica;
	private float grasasMonoinsaturadas;
	private float grasasPoliinsaturadas;
	private float grasasSaturadas;
	private float grasasTrans;
	private float hierro;
	private float potacio;
	private float proteinas;
	private float sodio;
	private float vitaminaA;
	private float vitaminaC;

	public Perfil(){		
	}
	
	public Perfil(float az,float cal,float calo,float carbo, float col,float fDiet,
			float gMono,float gPoli, float gSat, float gTran, float hrr, float pot, float prot,
			float sod, float vitA, float vitC){
		this.azucares=az;
		this.calcio=cal;
		this.calorias=calo;
		this.carbohidratos=carbo;
		this.colesterol=col;
		this.fibraDietetica=fDiet;
		this.grasasMonoinsaturadas=gMono;
		this.grasasPoliinsaturadas=gPoli;
		this.grasasSaturadas=gSat;
		this.grasasTrans=gTran;
		this.hierro=hrr;
		this.potacio=pot;
		this.proteinas=prot;
		this.sodio=sod;
		this.vitaminaA=vitA;
		this.vitaminaC=vitC;
	}
	
	public void sumarPerfil(Perfil p){
		this.azucares+=p.getAzucares();
		this.calcio+=p.getCalcio();
		this.calorias+=p.getCalorias();
		this.carbohidratos+=p.getCarbohidratos();
		this.colesterol+=p.getColesterol();
		this.fibraDietetica+=p.getFibraDietetica();
		this.grasasMonoinsaturadas+=p.getGrasasMonoinsaturadas();
		this.grasasPoliinsaturadas+=p.getGrasasPoliinsaturadas();
		this.grasasSaturadas+=p.getGrasasSaturadas();
		this.grasasTrans+=p.getGrasasTrans();
		this.hierro+=p.getHierro();
		this.potacio+=p.getPotacio();
		this.proteinas+=p.getProteinas();
		this.sodio+=p.getSodio();
		this.vitaminaA+=p.getVitaminaA();
		this.vitaminaC+=p.getVitaminaC();
	}
	
	public Perfil verificarValores(){
		// Para la combinación de cualquier alimento, si la suma de calorías 
		//supera 50, se debe incrementar un 15%
		if (this.calorias>50) this.calorias += this.calorias*0.15;
		// Cuando el colesterol supere a 4, se debe incrementar un 35%
		if (this.colesterol>4) this.colesterol += this.colesterol*0.35;
		//Cuando las proteínas superen 0.8, debe incrementar un 15% más el colesterol total
		if (this.proteinas > 0.8) this.colesterol += this.colesterol*0.15;
		// Cuando la fibra dietética supera los 35 puntos, debe bajar el colesterol un 12 %
		if (this.fibraDietetica > 35) this.colesterol -= this.colesterol*0.12;
		return this;
	}
	
	public String getTipoItem() {
		return "Unimplemented";
	}

	public float getAzucares() {
		return this.azucares;
	}

	public float getCalcio() {
		return this.calcio;
	}

	public float getCalorias() {
		return this.calorias;
	}

	public float getCarbohidratos() {
		return this.carbohidratos;
	}

	public float getColesterol() {
		return this.colesterol;
	}

	public float getFibraDietetica() {
		return this.fibraDietetica;
	}

	public float getGrasasMonoinsaturadas() {
		return this.grasasMonoinsaturadas;
	}

	public float getGrasasPoliinsaturadas() {
		return this.grasasPoliinsaturadas;
	}

	public float getGrasasSaturadas() {
		return this.grasasSaturadas;
	}

	public float getGrasasTrans() {
		return this.grasasTrans;
	}

	public float getHierro() {
		return this.hierro;
	}

	public float getPotacio() {
		return this.potacio;
	}

	public float getProteinas() {
		return this.proteinas;
	}

	public float getSodio() {
		return this.sodio;
	}

	public float getVitaminaA() {
		return this.vitaminaA;
	}

	public float getVitaminaC() {
		return this.vitaminaC;
	}
	
	@Override
	public String toString() {
		String r = "<***** Información Nutricional *****>\n";
		r+="azucares: "+this.getAzucares()+"\n";
		r+="calcio: "+this.getCalcio()+"\n";
		r+="calorias: "+this.getCalorias()+"\n";
		r+="carbohidratos: "+this.getCarbohidratos()+"\n";
		r+="colesterol: "+this.getColesterol()+"\n";
		r+="fibraDietetica: "+this.getFibraDietetica()+"\n";
		r+="grasasMonoinsaturadas: "+this.getGrasasMonoinsaturadas()+"\n";
		r+="grasasPoliinsaturadas: "+this.getGrasasPoliinsaturadas()+"\n";
		r+="grasasSaturadas: "+this.getGrasasSaturadas()+"\n";
		r+="grasasTrans: "+this.getGrasasTrans()+"\n";
		r+="hierro: "+this.getHierro()+"\n";
		r+="potacio: "+this.getPotacio()+"\n";
		r+="proteinas: "+this.getProteinas()+"\n";
		r+="sodio: "+this.getSodio()+"\n";
		r+="vitaminaA: "+this.getVitaminaA()+"\n";
		r+="vitaminaC+: "+this.getVitaminaC();		
		return r;
	}

}
