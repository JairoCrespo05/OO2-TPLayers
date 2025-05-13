package ar.unrn.tp4.ejercicios.ejercicio3.persistence;

import ar.unrn.tp4.ejercicios.ejercicio3.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class RegistroInscripcion implements DataSetter {

    private String pathInscripciones;

    public RegistroInscripcion(String path) {
        this.pathInscripciones = path; //"src/main/resources/Inscriptos.txt"
    }


    @Override
    public void persistirInscripcion(String nombre, String apellido, String dni, String email, String telefono, int idConcurso) throws IOException {

        Path pathReal = Path.of(this.pathInscripciones);

        StringBuilder builder = new StringBuilder();

        String contenido = String.valueOf( builder.append(System.lineSeparator())
                        .append(nombre).append(", ")
                        .append(apellido).append(", ")
                        .append(dni).append(", ")
                        .append(email).append(", ")
                        .append(telefono).append(", ")
                        .append(idConcurso));


        Files.write(pathReal ,
                contenido.getBytes(),
                Files.exists(pathReal) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE
                );

    }



}
