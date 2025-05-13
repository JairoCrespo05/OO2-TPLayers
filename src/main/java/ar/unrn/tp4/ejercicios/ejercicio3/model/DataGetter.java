package ar.unrn.tp4.ejercicios.ejercicio3.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataGetter {

    List<Concurso> recuperarConcursos() throws IOException;

}
