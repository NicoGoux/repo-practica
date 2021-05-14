package isi.died.parcial01.ejercicio02.dominio;

public class CuposAgotadosExcepcion extends Exception {
	public CuposAgotadosExcepcion(Materia o) {
		super ("La materia '"+o.getNombre()+"' no tiene mas cupos disponibles");
	}
}
