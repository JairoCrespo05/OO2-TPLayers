package ar.unrn.tp4.ejercicios.ejercicio3.model;

import java.io.IOException;
import java.util.List;

public class Inscripcion implements InscriptionManager{

    private DataSetter registroInscripcion;
    private DataGetter registroConcurso;

    public Inscripcion(DataSetter registro, DataGetter registroConcurso) {
        this.registroInscripcion = registro;
        this.registroConcurso = registroConcurso;
    }



    @Override
    public void saveInscription(Participante p) throws IOException {

        registroInscripcion.persistirInscripcion(p.MiNombreEs(), p.MiApellidoEs(), p.MiDniEs(), p.MiEmailEs(), p.MiTelefonoEs(), p.ElIdDelConcursoEs());
    }

    @Override
    public List<Concurso> todosLosConcursos() throws IOException {
        return registroConcurso.recuperarConcursos();
    }
}
