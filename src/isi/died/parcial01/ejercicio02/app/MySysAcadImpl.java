package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;
import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		
		try {
			m.addInscripcion(insc);
		} catch (CuposAgotadosExcepcion e1) {
			e1.printStackTrace();
		}
		
		try {
			DB.guardar(insc);
		} 
		catch (BaseDeDatosExcepcion e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	public void registrarNota(Examen e, int nota) {
		e.setNota(nota);
		
		if (nota>=6) {
			List<Inscripcion> cursadasMateria = e.getAlumno().getListaIncripciones()
															 .stream()
															 .filter((i)->(i.getMateria()==e.getMateria()))
															 .collect(Collectors.toList());
			
			cursadasMateria.get(cursadasMateria.size()-1).setEstado(Estado.PROMOCIONADO);
		}
	}


	@Override
	public List<Examen> topNExamenes(Alumno a, Integer n, Integer nota) {
		List<Examen> listaExamenesMasNota = a.getListaExamenes()
											 .stream()
											 .filter((e)->(e.getNota()>=nota))
											 .collect(Collectors.toList());
		
		if (listaExamenesMasNota.size()>n) {
			
			List<Examen> listaFinal = new ArrayList<Examen>(1);
			for (int i=0;i<n.intValue();i++) {
				listaFinal.add(listaExamenesMasNota.get(i));
			}
			Collections.sort(listaFinal,(e1,e2)->(e2.getNota().compareTo(e1.getNota())));
			
			return listaFinal;
		}
		else {
			Collections.sort(listaExamenesMasNota,(e1,e2)->(e2.getNota().compareTo(e1.getNota())));
			return listaExamenesMasNota;
		}
		
	}
}
