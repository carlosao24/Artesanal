package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestMaquinaJUnit {

    // ============ CONSTRUCTORES ============

    @Test
    public void testConstructorConCuatroParametros() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 5000, "20849");

        assertEquals("Pilsener", maquina.getNombreCerveza());
        assertEquals("Cerveza rubia", maquina.getDescripcion());
        assertEquals(0.05, maquina.getPrecioPorMl(), 0.0001);
        assertEquals(5000.0, maquina.getCantidadMaxima(), 0.0001);
        // La máquina debe iniciar vacía
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testConstructorConTresParametros() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, "087873");

        assertEquals("Club", maquina.getNombreCerveza());
        assertEquals("Cerveza premium", maquina.getDescripcion());
        assertEquals(0.08, maquina.getPrecioPorMl(), 0.0001);
        // Capacidad por defecto: 10000
        assertEquals(10000.0, maquina.getCantidadMaxima(), 0.0001);
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

    // ============ SETTERS Y GETTERS ============

    @Test
    public void testSetters() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 5000, "20849");

        maquina.setNombreCerveza("Club");
        maquina.setDescripcion("Cerveza premium");
        maquina.setPrecioPorMl(0.08);

        assertEquals("Club", maquina.getNombreCerveza());
        assertEquals("Cerveza premium", maquina.getDescripcion());
        assertEquals(0.08, maquina.getPrecioPorMl(), 0.0001);
    }

    // ============ llenarMaquina ============

    @Test
    public void testLlenarMaquinaConCapacidadPersonalizada() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 5000, "20849");

        maquina.llenarMaquina();

        // Llena hasta cantidadMaxima - 200
        assertEquals(4800.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testLlenarMaquinaConCapacidadPorDefecto() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, "087873");

        maquina.llenarMaquina();

        // 10000 - 200 = 9800
        assertEquals(9800.0, maquina.getCantidadActual(), 0.0001);
    }

    // ============ recargarCerveza ============

    @Test
    public void testRecargarCervezaExitosa() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000, "20849");
        // Límite permitido: 1000 - 200 = 800

        boolean resultado = maquina.recargarCerveza(500);

        assertTrue(resultado);
        assertEquals(500.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testRecargarCervezaRechazada() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000, "20849");

        maquina.recargarCerveza(500); 
        boolean resultado = maquina.recargarCerveza(500); // 500 + 500 = 1000 > 800

        assertFalse(resultado);
        // La cantidad actual NO debe cambiar
        assertEquals(500.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testRecargarCervezaEnLimiteExacto() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000, "20849");

        // 0 + 800 = 800, exactamente el límite → permitido
        boolean resultado = maquina.recargarCerveza(800);

        assertTrue(resultado);
        assertEquals(800.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testRecargarConMaquinaLlena() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, "087873");
        maquina.llenarMaquina(); // actual = 9800, límite = 9800

        // 9800 + 100 = 9900 > 9800 → rechazado
        boolean resultado = maquina.recargarCerveza(100);

        assertFalse(resultado);
        assertEquals(9800.0, maquina.getCantidadActual(), 0.0001);
    }

    // ============ servirCerveza ============

    @Test
    public void testServirCervezaConStockSuficiente() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, 10000, "087873");
        maquina.llenarMaquina(); // actual = 9800

        double valor = maquina.servirCerveza(1000);

        // 1000 * 0.08 = 80
        assertEquals(80.0, valor, 0.0001);
        assertEquals(8800.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testServirCervezaSinStockSuficiente() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, "087873");
        // actual = 0

        double valor = maquina.servirCerveza(500);

        // Sin stock: retorna 0 y la cantidad no cambia
        assertEquals(0.0, valor, 0.0001);
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testServirCervezaCantidadExacta() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000, "20849");
        maquina.recargarCerveza(500); // actual = 500

        double valor = maquina.servirCerveza(500);

        // 500 * 0.05 = 25, y queda en 0
        assertEquals(25.0, valor, 0.0001);
        assertEquals(0.0, maquina.getCantidadActual(), 0.0001);
    }

    // ============ imprimir ============

    @Test
    public void testImprimirNoGeneraErrores() {
        Maquina maquina = new Maquina("Club", "Cerveza premium", 0.08, "087873");
        maquina.llenarMaquina();

        // Verifica que el método se ejecute sin lanzar excepciones
        maquina.imprimir();
    }
}