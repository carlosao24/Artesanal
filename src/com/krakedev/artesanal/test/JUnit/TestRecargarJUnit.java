package com.krakedev.artesanal.test.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test 
	public void testRecargaExitosa() {

		Maquina clara = new Maquina("Club", "Cerveza artesanal", 0.02, 8000, "038958");
		
		boolean resultado = clara.recargarCerveza(4000);
		
		assertTrue(resultado);
		
		assertEquals(4000, clara.getCantidadActual(), 0.0001);
		
	}
	
	@Test 
	public void testRecargaFallida() {

		Maquina oscura = new Maquina("Club", "Cerveza artesanal", 0.02, 7500, "37843");
		
		oscura.recargarCerveza(2000);
		
		boolean resultado = oscura.recargarCerveza(3400);
		
		assertTrue(resultado);
		
		assertEquals(5400, oscura.getCantidadActual(), 0.0001);
		
	}
	
}
