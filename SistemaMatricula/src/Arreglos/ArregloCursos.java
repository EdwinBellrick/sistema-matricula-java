package Arreglos;

import java.util.ArrayList;
import Clase.Curso;

public class ArregloCursos {

    private ArrayList<Curso> lista;

    public ArregloCursos() {
        lista = new ArrayList<Curso>();
    }

    public void adicionar(Curso curso) {
        lista.add(curso);
        ordenarPorCodigo();
    }

    public int tamaño() {
        return lista.size();
    }

    public Curso obtener(int posicion) {
        return lista.get(posicion);
    }

    public Curso buscarPorCodigo(int codigo) {
        for (Curso curso : lista) {
            if (curso.getCodCurso() == codigo) {
                return curso;
            }
        }
        return null;
    }

    public void eliminar(Curso curso) {
        lista.remove(curso);
    }

    public void ordenarPorCodigo() {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getCodCurso() > lista.get(j).getCodCurso()) {
                    Curso auxiliar = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, auxiliar);
                }
            }
        }
    }
}