package ar.unrn.tp4.ejercicios.ejercicio1.Main;

import ar.unrn.tp4.ejercicios.ejercicio1.DataBase.AgregarParticipante;
import ar.unrn.tp4.ejercicios.ejercicio1.DataBase.NewParticipante;
import ar.unrn.tp4.ejercicios.ejercicio1.ui.VentanaAgregarParticipante;



import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    NewParticipante api = new AgregarParticipante();
                    VentanaAgregarParticipante frame = new VentanaAgregarParticipante(api);

                    frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}