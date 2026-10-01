package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("Beer", "Cerveza para seco", 0.02, 8000, "9378048");
		rubia.imprimir();
		
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina oscura = new Maquina("Pilsener", "Cerveza de borracho", 0.03, "37843");
		oscura.imprimir();
		
		oscura.llenarMaquina();
		oscura.imprimir();

	}

}
