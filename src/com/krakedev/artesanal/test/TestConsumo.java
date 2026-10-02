package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumo {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Club", "Cerveza artesanal", 0.02);
        negocio.registrarCliente("María Pérez", "0987654321");
        negocio.registrarCliente("Juan López", "1712345678");
        negocio.cargarMaquinas();

        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

        negocio.consumirCerveza("C-1", codigoMaquina, 1000);
        negocio.consumirCerveza("C-2", codigoMaquina, 500);
        negocio.consumirCerveza("C-1", codigoMaquina, 2000);

        System.out.println("-------- Clientes --------");
        for (int i = 0; i < negocio.getClientes().size(); i++) {
            negocio.getClientes().get(i).imprimir();
        }

        System.out.println("-------- Máquina --------");
        negocio.recuperarMaquina(codigoMaquina).imprimir();

        System.out.println("Total vendido: " + negocio.consultarValorVendido() + "$");
    }
}