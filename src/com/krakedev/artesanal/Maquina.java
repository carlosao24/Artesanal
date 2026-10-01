package com.krakedev.artesanal;

public class Maquina {

	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double cantidadMaxima;
	private double cantidadActual;
	private String codigo;

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double cantidadMaxima, String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.cantidadMaxima = cantidadMaxima;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl,String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.cantidadMaxima = 10000;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}
	
	
	
	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCantidadMaxima() {
		return cantidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void imprimir() {
		String mensaje;
		mensaje = "Nombre de cerveza: " + nombreCerveza + ", Descripción: " + descripcion + ", Precio: " + precioPorMl
				+ ", Capacidad maxima: " + cantidadMaxima + ", Cantidad actual: " + cantidadActual + ", Codigo: " + codigo;

		System.out.println(mensaje);
	}

	public void llenarMaquina() {
		this.cantidadActual = this.cantidadMaxima - 200;
	}

	public boolean recargarCerveza(double cantidad) {

		double limitePermitido = cantidadMaxima - 200;
		if (cantidadActual + cantidad <= limitePermitido) {

			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}
	
	public double servirCerveza(double cantidad) {
		if(cantidadActual >= cantidad) {
			double valor;
			valor = cantidad * precioPorMl;
			cantidadActual = cantidadActual - cantidad;
			return valor;
		}else {
			System.out.println("Cantidad solicitada no disponible");
			return 0;
		}
	}

}
