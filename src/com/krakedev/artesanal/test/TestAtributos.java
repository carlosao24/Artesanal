package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		Maquina rubia = new Maquina("Club", "Cerveza clara", 0.02, 5000, "097487");
		rubia.imprimir();
		
		rubia.setNombreCerveza("Budweaser");
		rubia.setDescripcion("Aroma más profundo");
		rubia.imprimir();
		

	}

}
