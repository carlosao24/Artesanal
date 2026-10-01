package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		
		
		boolean resultado;
		
		Maquina clara = new Maquina("Club","Cerveza artesanal",0.02,8000, "038958");
		
		System.out.println("--------Primera Impresión---------");
		clara.imprimir();
		
		System.out.println("--------Primera Recarga---------");
		resultado = clara.recargarCerveza(2000);
		System.out.println("¿Se logro recargar? "+resultado);
		clara.imprimir();
		
		System.out.println("--------Segunda Recarga---------");
		resultado = clara.recargarCerveza(5000);
		System.out.println("¿Se logro recargar? "+resultado);
		clara.imprimir();
		
		System.out.println("--------Tercera Recarga---------");
		resultado = clara.recargarCerveza(2000);
		System.out.println("¿Se logro recargar? "+resultado);
		clara.imprimir();
		
	}

}
