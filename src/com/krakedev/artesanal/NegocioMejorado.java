package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int ultimoCodigo;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();

		if (recuperarMaquina(codigo) != null) {
			return false;
		}

		Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
		maquinas.add(maquina);
		return true;
	}

	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		Maquina encontrada = null;
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			if (m.getCodigo().equals(codigo)) {
				encontrada = m;
			}
		}
		return encontrada;
	}

	public void registrarCliente(String nombre, String cedula) {
		ultimoCodigo = ultimoCodigo + 1;
		String codigo = "C-" + ultimoCodigo;
		Cliente cliente = new Cliente(codigo, nombre, cedula);
		clientes.add(cliente);
	}

	public Cliente buscarClientePorCedula(String cedula) {
		Cliente encontrada = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			if (c.getCedula().equals(cedula)) {
				encontrada = c;
			}
		}
		return encontrada;
	}

	public Cliente buscarClientePorCodigo(String codigo) {
		Cliente encontrada = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			if (c.getCodigo().equals(codigo)) {
				encontrada = c;
			}
		}
		return encontrada;
	}
}