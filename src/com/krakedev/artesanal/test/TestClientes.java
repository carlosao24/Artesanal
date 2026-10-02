package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();

        negocio.registrarCliente("María Pérez", "0987654321");
        negocio.registrarCliente("Juan López", "1712345678");
        negocio.registrarCliente("Ana Gómez", "0998765432");

        System.out.println("-------- Clientes registrados ---------");
        for (int i = 0; i < negocio.getClientes().size(); i++) {
            negocio.getClientes().get(i).imprimir();
        }

        System.out.println("-------- Búsqueda por cédula ---------");
        Cliente porCedula = negocio.buscarClientePorCedula("1712345678");
        if (porCedula != null) {
            porCedula.imprimir();
        } else {
            System.out.println("Cliente no existe");
        }

        Cliente cedulaInexistente = negocio.buscarClientePorCedula("0000000000");
        System.out.println("Cédula inexistente: " + cedulaInexistente);

        System.out.println("-------- Búsqueda por código ---------");
        Cliente porCodigo = negocio.buscarClientePorCodigo("C-2");
        if (porCodigo != null) {
            porCodigo.imprimir();
        } else {
            System.out.println("Cliente no existe");
        }

        Cliente codigoInexistente = negocio.buscarClientePorCodigo("C-99");
        System.out.println("Código inexistente: " + codigoInexistente);
    }
}