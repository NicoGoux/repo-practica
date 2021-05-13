package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public abstract class Empleado {
	protected int cuil;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaIngreso;
	protected double sueldoBasico;
	
	public Empleado(int cuil, String nombre, String apellido, LocalDate fechaIngreso, double sueldoBasico) {
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBasico = sueldoBasico;
	}
	
	public abstract double calcularSueldo();
	
}
