package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppRRHH {
	
	private static int numRecibo;
	/*
	 * La idea de la variable global es que si se llama al metodo
	 * varias veces en la misma ejecucion los valores de los numeros de comprobante
	 * sean acordes a los de la lista anterior
	 * 
	 */
	
	public AppRRHH() {
		numRecibo=0;
	}
	
	public List<ReciboSueldo> obtenerListaRecibos(List<Empleado> listaEmpleados) {
		
		List<ReciboSueldo> listaRecibos = new ArrayList<ReciboSueldo>(1);
		
		for (Empleado unEmpleado : listaEmpleados) {
			listaRecibos.add(new ReciboSueldo(numRecibo, LocalDate.now().getMonth(), unEmpleado.calcularSueldo(), unEmpleado));
			numRecibo++;
		}
		return listaRecibos;
		
	}
}
