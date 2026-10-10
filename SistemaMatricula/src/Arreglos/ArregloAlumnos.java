package Arreglos;

import java.util.ArrayList;
import Clase.Alumno;

public class ArregloAlumnos {

    private ArrayList<Alumno> lista;

    public ArregloAlumnos() {
        lista = new ArrayList<Alumno>();
    }

    public void adicionar(Alumno alumno) {
        lista.add(alumno);
    }

    public int tamaño() {
        return lista.size();
    }

    public Alumno obtener(int posicion) {
        return lista.get(posicion);
    }

    public Alumno buscarPorCodigo(int codigo) {
        for (Alumno alumno : lista) {
            if (alumno.getCodAlumno() == codigo) {
                return alumno;
            }
        }
        return null;
    }

    public Alumno buscarPorDni(String dni) {
        for (Alumno alumno : lista) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }

    public void eliminar(Alumno alumno) {
        lista.remove(alumno);
    }

    public int generarCodigo() {
        if (lista.size() == 0) {
            return 202010001;
        }

        int mayor = lista.get(0).getCodAlumno();

        for (Alumno alumno : lista) {
            if (alumno.getCodAlumno() > mayor) {
                mayor = alumno.getCodAlumno();
            }
        }

        return mayor + 1;
    }
}