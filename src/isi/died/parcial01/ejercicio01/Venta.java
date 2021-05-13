package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class Venta {
	private LocalDate fecha;
	private double total;
	
	public Venta(LocalDate fecha, double total) {
		this.fecha = fecha;
		this.total = total;
	}
	
	public double getTotal() {
		return this.total;
	}
}
