package com.krakedev.artesanal.test.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test
	public void testLlenarMaquina() {
		Maquina clara = new Maquina("Club", "Cerveza artesanal", 0.02, 8000, "038958");

		clara.llenarMaquina();

		assertEquals(7800, clara.getCantidadActual(), 0.0001);
	}

}
