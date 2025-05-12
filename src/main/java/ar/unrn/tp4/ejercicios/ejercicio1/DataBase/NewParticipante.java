package ar.unrn.tp4.ejercicios.ejercicio1.DataBase;

import java.sql.SQLException;

public interface NewParticipante {

    void crearNuevoParticipante(String nombre, String telefono, String region) throws SQLException;
}
