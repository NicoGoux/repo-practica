package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.time.Month;

public class ReciboSueldo {
	private int numeroRecibo;
	private Month mesRecibo;
	private double total;
	private Empleado empleado;
	
	public ReciboSueldo(int numeroRecibo, Month mesRecibo, double total, Empleado empleado) {
		this.numeroRecibo = numeroRecibo;
		this.mesRecibo = mesRecibo;
		this.total = total;
		this.empleado = empleado;
	}
}
