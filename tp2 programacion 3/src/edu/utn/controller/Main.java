package edu.utn.controller;

import edu.utn.model.Alimento;
import edu.utn.model.AlimentoCompuesto;
import edu.utn.model.VerificadorAlimento;
import edu.utn.model.grupo01.ArrozBlanco;
import edu.utn.model.grupo01.ArrozIntegral;
import edu.utn.model.grupo01.AvenaCruda;
import edu.utn.model.grupo01.AvenaProcesada;
import edu.utn.model.grupo02.CarneCerdo;
import edu.utn.model.grupo02.CarnePescado;
import edu.utn.model.grupo02.CarnePollo;
import edu.utn.model.grupo02.CarneVaca;
import edu.utn.controller.Perfil;

public class Main {

	public static void main(String[] args) {
		ArrozBlanco a = new ArrozBlanco();
		//System.out.println(a.getPerfil());
		AvenaProcesada p = new AvenaProcesada();
		//System.out.println(p.getPerfil());
		ArrozIntegral ai = new ArrozIntegral();
		//System.out.println(ai.getPerfil());
		AvenaCruda avc = new AvenaCruda();
		//System.out.println(avc.getPerfil());
		CarnePescado cp = new CarnePescado();
		//System.out.println(cp.getPerfil());
		CarnePollo cPo = new CarnePollo();
		//System.out.println(cPo.getPerfil());
		CarneVaca cv = new CarneVaca();
		//System.out.println(cv.getPerfil());
		CarneCerdo cd = new CarneCerdo();
		//System.out.println(cd.getPerfil());
		//los outs eran solo para verificar que la salida de datos correspondiera bien con la tabla

		AlimentoCompuesto<Alimento> ac = new AlimentoCompuesto<>();
		ac.addAlimento(a);
		ac.addAlimento(p);
		
		//System.out.println(ac.getPerfil());

		// Verificación
		Perfil min = new Perfil();
		Perfil max = new Perfil(50f,35f,3f,0f,0f,20f,0f,0f,0f,0f,1f,3f,0.2f,0.1f,0f,0f);
		LimitePerfil lp = new LimitePerfil(min, max);
		VerificadorAlimento va = new VerificadorAlimento();
		
		System.out.println("Verificación de Arroz Blanco");
		va.chequearAlimento(a, lp);
		
		System.out.println("Verificación de Avena Procesada");
		va.chequearAlimento(p, lp);
		
		System.out.println("Verificación de Alimento Compuesto");
		va.chequearAlimento(ac, lp);

		//profesor, el punto h pide que cumpla "algun LimitePerfil", como no especifica que limite o lista de limites decidi inventarme uno.
		//creando nuevas variables min y max junto al limite perfil nuevo

		Perfil nMin = new Perfil();
		Perfil nMax = new Perfil(50f,120f,41.5f,0f,2f,40f,2.6f,15f,13f,0f,20f, 16f,15.5f,0.8f,0f,0f);
		LimitePerfil nLp = new LimitePerfil(nMin,nMax);

		//creamos un nuevo alimento compuesto (H).
		AlimentoCompuesto<Alimento> alimentoH = new AlimentoCompuesto<>();
		alimentoH.addAlimento(ai);
		alimentoH.addAlimento(avc);
		alimentoH.addAlimento(cp);

		//reusando el verificador amineto
		System.out.println("Verificacion de alimento compuesto por arroz integral, avena cruda y carne de pescado");
		va.chequearAlimento(alimentoH,nLp);

		//creamos un nuevo alimento compuesto (F)
		AlimentoCompuesto<Alimento> alimentoI = new AlimentoCompuesto<>();
		alimentoI.addAlimento(cv);
		alimentoI.addAlimento(ai);
		alimentoI.addAlimento(avc);

		System.out.println("Verificacion de alimento compuesto por arroz intergral, avena cruda y carne de vaca");
		va.chequearAlimento(alimentoI,nLp);
	}

}
