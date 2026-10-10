package gui;

import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCursos;
import Clase.Alumno;
import Clase.Curso;

public class PruebaArreglos {

    public static void main(String[] args) {

        ArregloAlumnos alumnos = new ArregloAlumnos();

        Alumno alumno1 = new Alumno(
                alumnos.generarCodigo(),
                "Ana",
                "Pérez",
                "12345678",
                18,
                999111222,
                0
        );

        alumnos.adicionar(alumno1);

        System.out.println("Cantidad de alumnos: " + alumnos.tamaño());
        System.out.println("Código generado: " + alumno1.getCodAlumno());
        System.out.println("Alumno encontrado: "
                + alumnos.buscarPorDni("12345678").getNombres());

        ArregloCursos cursos = new ArregloCursos();

        Curso curso1 = new Curso(2002, "Algoritmos", 1, 4, 6);
        Curso curso2 = new Curso(1001, "Base de Datos", 1, 3, 4);

        cursos.adicionar(curso1);
        cursos.adicionar(curso2);

        System.out.println("Cantidad de cursos: " + cursos.tamaño());
        System.out.println("Primer curso ordenado: "
                + cursos.obtener(0).getCodCurso() + " - "
                + cursos.obtener(0).getAsignatura());
    }
}