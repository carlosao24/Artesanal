package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoJUnit {


    @Test
    public void testGenerarCodigo() {
        NegocioMejorado negocio = new NegocioMejorado();

        for (int i = 0; i < 100; i++) {
            String codigo = negocio.generarCodigo();
            assertNotNull(codigo);
            assertTrue(codigo.startsWith("M-"));
            int numero = Integer.parseInt(codigo.substring(2));
            assertTrue(numero >= 1 && numero <= 100);
        }
    }


    @Test
    public void testAgregarMaquinaExitosa() {
        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02);

        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());

        Maquina agregada = negocio.getMaquinas().get(0);
        assertEquals("Club", agregada.getNombreCerveza());
        assertEquals("Cerveza artesanal", agregada.getDescripcion());
        assertEquals(0.02, agregada.getPrecioPorMl(), 0.0001);

        assertNotNull(negocio.recuperarMaquina(agregada.getCodigo()));
    }

    @Test
    public void testAgregarMaquinaDuplicada() {
        NegocioMejorado negocio = new NegocioMejorado();

        for (int i = 1; i <= 100; i++) {
            negocio.getMaquinas().add(new Maquina("Ocupada", "placeholder", 0.01, "M-" + i));
        }

        boolean resultado = negocio.agregarMaquina("Club", "Cerveza", 0.02);

        assertFalse(resultado);
        assertEquals(100, negocio.getMaquinas().size()); 
    }


    @Test
    public void testRecuperarMaquinaExistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.getMaquinas().add(new Maquina("Club", "Cerveza", 0.02, "M-50"));

        Maquina recuperada = negocio.recuperarMaquina("M-50");

        assertNotNull(recuperada);
        assertEquals("Club", recuperada.getNombreCerveza());
    }

    @Test
    public void testRecuperarMaquinaInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.getMaquinas().add(new Maquina("Club", "Cerveza", 0.02, "M-50"));

        Maquina recuperada = negocio.recuperarMaquina("M-77");

        assertNull(recuperada);
    }


    @Test
    public void testCargarMaquinas() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.getMaquinas().add(new Maquina("Club", "Cerveza", 0.02, "M-10"));
        negocio.getMaquinas().add(new Maquina("Pilsener", "Cerveza", 0.03, "M-20"));

        negocio.cargarMaquinas();


        for (int i = 0; i < negocio.getMaquinas().size(); i++) {
            assertEquals(9800.0, negocio.getMaquinas().get(i).getCantidadActual(), 0.0001);
        }
    }
}