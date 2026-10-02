package com.krakedev.artesanal.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoJUnit {


    @Test
    public void testConsumirCerveza() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02); 
        negocio.registrarCliente("María Pérez", "0987654321"); 
        negocio.cargarMaquinas(); 

        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

        double valor = negocio.consumirCerveza("C-1", codigoMaquina, 1000);

        assertEquals(20.0, valor, 0.0001);

        Cliente cliente = negocio.buscarClientePorCodigo("C-1");
        assertEquals(20.0, cliente.getTotalConsumido(), 0.0001);
        Maquina maquina = negocio.recuperarMaquina(codigoMaquina);
        assertEquals(8800.0, maquina.getCantidadActual(), 0.0001);
    }

    @Test
    public void testConsumoAcumulado() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02);
        negocio.registrarCliente("María Pérez", "0987654321");
        negocio.cargarMaquinas();

        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

        negocio.consumirCerveza("C-1", codigoMaquina, 1000); 
        negocio.consumirCerveza("C-1", codigoMaquina, 500);  

        assertEquals(30.0, negocio.buscarClientePorCodigo("C-1").getTotalConsumido(), 0.0001);
    }

    @Test
    public void testConsumirConClienteInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02);
        negocio.cargarMaquinas();

        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

        double valor = negocio.consumirCerveza("C-99", codigoMaquina, 100);

        assertEquals(0.0, valor, 0.0001);
    }

    @Test
    public void testConsumirConMaquinaInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.registrarCliente("María Pérez", "0987654321");

        double valor = negocio.consumirCerveza("C-1", "M-999", 100);

        assertEquals(0.0, valor, 0.0001);
    }

    @Test
    public void testConsumirSinStockSuficiente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.getMaquinas().add(new Maquina("Club", "Cerveza", 0.02, 1000, "M-1"));
        negocio.registrarCliente("María Pérez", "0987654321");
        negocio.cargarMaquinas(); 

        double valor = negocio.consumirCerveza("C-1", "M-1", 5000);

        assertEquals(0.0, valor, 0.0001);
        assertEquals(800.0, negocio.recuperarMaquina("M-1").getCantidadActual(), 0.0001);
        assertEquals(0.0, negocio.buscarClientePorCodigo("C-1").getTotalConsumido(), 0.0001);
    }


    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02);
        negocio.cargarMaquinas();

        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

        negocio.registrarCliente("María", "111"); 
        negocio.registrarCliente("Juan", "222");  
        negocio.registrarCliente("Ana", "333");   

        negocio.consumirCerveza("C-1", codigoMaquina, 1000); 
        negocio.consumirCerveza("C-2", codigoMaquina, 500);  
        negocio.consumirCerveza("C-3", codigoMaquina, 2000); 

        assertEquals(70.0, negocio.consultarValorVendido(), 0.0001);
    }

    @Test
    public void testConsultarValorVendidoSinClientes() {
        NegocioMejorado negocio = new NegocioMejorado();

        assertEquals(0.0, negocio.consultarValorVendido(), 0.0001);
    }
}