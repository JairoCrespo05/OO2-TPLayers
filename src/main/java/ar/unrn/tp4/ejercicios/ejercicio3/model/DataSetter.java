package ar.unrn.tp4.ejercicios.ejercicio3.model;

import java.io.IOException;

public interface DataSetter {

    void persistirInscripcion(String nombre, String apellido, String dni, String email, String telefono, int idConcurso) throws IOException;

}
