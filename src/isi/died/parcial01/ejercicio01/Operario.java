package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.List;

public class Operario extends Empleado{
	private List<Viajante> listaViajantes;

	public Operario(int cuil, String nombre, String apellido, LocalDate fechaIngreso, double sueldoBasico, List<Viajante> listaViajantes) {
		super(cuil, nombre, apellido, fechaIngreso, sueldoBasico);
		this.listaViajantes = listaViajantes;
	}

	@Override
	public double calcularSueldo() {
		double ventasViajantes = this.listaViajantes.stream()
													.map((viajante)->(viajante.getTotalVentas()))
													.reduce(0.0, (total,venta)->(total+venta));
		double sueldo = this.sueldoBasico + ventasViajantes;
		LocalDate fechaActual = LocalDate.now();
		if (this.fechaIngreso.getMonthValue() == fechaActual.getMonthValue()) {
			sueldo += this.sueldoBasico*0.5;
			
			/*
			 * No tome en consideracion que haya pasado mas de un a�o desde su ingreso
			 * pero en ese caso se debera agregar otra condicion al if que sera:
			 * (this.fechaIngreso.getYear() < fechaActual.getYear);
			 */
		}
		
		return sueldo;
	}
	
	public void agregarViajante(Viajante unViajante) {
		this.listaViajantes.add(unViajante);
	}
	
	
}
