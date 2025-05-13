package ar.unrn.tp4.ejercicios.ejercicio3.Main;

import ar.unrn.tp4.ejercicios.ejercicio3.model.Inscripcion;
import ar.unrn.tp4.ejercicios.ejercicio3.model.InscriptionManager;
import ar.unrn.tp4.ejercicios.ejercicio3.persistence.RegistroConcurso;
import ar.unrn.tp4.ejercicios.ejercicio3.persistence.RegistroInscripcion;
import ar.unrn.tp4.ejercicios.ejercicio3.ui.RadioCompetition;

import javax.swing.*;
import javax.swing.SwingUtilities;

public class MainEjercicio3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainEjercicio3().start();
                } catch (Exception e) {
                    // log exception...
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                    System.out.println(e);
                }
            }
        });
    }

    private void start () {

        var persistenceInscripcion = new RegistroInscripcion("src/main/resources/Inscriptos.txt");
        var persistenceConcurso = new RegistroConcurso("src/main/resources/Concursos.txt");

        var api = new Inscripcion(persistenceInscripcion, persistenceConcurso);

        new RadioCompetition(api);
    }

}





