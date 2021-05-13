package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viajante extends Empleado{
	private List<Gasto> listaGastos;
	private List<Venta> listaVentas;
	
	public Viajante(int cuil, String nombre, String apellido, LocalDate fechaIngreso, double sueldo, List<Gasto> listaGastos, List<Venta> listaVentas) {
		super(cuil, nombre, apellido, fechaIngreso, sueldo);
		this.listaGastos = new ArrayList<Gasto>(1);
		this.listaVentas = new ArrayList<Venta>(1);
	}

	@Override
	public double calcularSueldo() {
		double gastos = this.getTotalGastos();
		double ventas = this.getTotalVentas();		
		double sueldo = this.sueldoBasico + gastos + (ventas*0.15);
		
		LocalDate fechaActual = LocalDate.now();
		if (this.fechaIngreso.getMonthValue() == fechaActual.getMonthValue()) {
			sueldo += this.sueldoBasico*0.5;
			
			/*
			 * No tome en consideracion que haya pasado mas de un año desde su ingreso
			 * pero en ese caso se debera agregar otra condicion al if que sera:
			 * (this.fechaIngreso.getYear() < fechaActual.getYear);
			 */
		}
		
		return sueldo;
	}
	
	public double getTotalVentas() {
		return this.listaVentas.stream()
							   .map((venta)->(venta.getTotal()))
							   .reduce(0.0, (venT,ven2)->(venT+ven2));
	}
	
	public double getTotalGastos() {
		return this.listaGastos.stream()
							   .map((gasto)->(gasto.getTotal()))
							   .reduce(0.0, (gasT,gas2)->(gasT+gas2));
	}
	
	public void realizarVenta(double totalVenta) {
		this.listaVentas.add(new Venta(LocalDate.now(),totalVenta));
	}
	
	public void realizarGasto(int numeroComprobante, String descripcion, double totalGasto) {
		this.listaGastos.add(new Gasto(numeroComprobante, descripcion,totalGasto));
	}
}
