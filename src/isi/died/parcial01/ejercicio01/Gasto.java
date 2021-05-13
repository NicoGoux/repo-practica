package isi.died.parcial01.ejercicio01;

public class Gasto {
	private int numeroComprobante;
	private String descripcion;
	private double total;
	
	public Gasto(int numeroComprobante, String descripcion, double total) {
		this.numeroComprobante = numeroComprobante;
		this.descripcion = descripcion;
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
}
