package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {

		Maquina clara = new Maquina("Club", "Cerveza artesanal", 0.02, 8000, "038958");

		System.out.println("--------Primera Impresión---------");
		clara.imprimir();
		
		System.out.println("--------Primera Recarga---------");
		boolean resultado;
		resultado = clara.recargarCerveza(7500);
		System.out.println("¿Se recargo? "+resultado);
		clara.imprimir();
		
		System.out.println("--------Servir Cerveza---------");
		double costoCerveza = clara.servirCerveza(400);
		System.out.println("El total a pagar por la cerveza servida es: "+costoCerveza+"$");
		clara.imprimir();
		
		System.out.println("--------Servir Cerveza 2---------");
		double costoCerveza2 = clara.servirCerveza(6700);
		System.out.println("El total a pagar por la cerveza servida es: "+costoCerveza2+"$");
		clara.imprimir();
		
		System.out.println("--------Servir Cerveza 3---------");
		double costoCerveza3 = clara.servirCerveza(500);
		System.out.println("El total a pagar por la cerveza servida es: "+costoCerveza3+"$");
		clara.imprimir();
		
		
		
		
		

	}

}
