package ar.unrn.tp4.ejercicios.ejercicio3.model;

import java.io.IOException;
import java.util.List;

public interface InscriptionManager {

    void saveInscription(Participante p) throws IOException;

    List<Concurso> todosLosConcursos() throws IOException;

}
