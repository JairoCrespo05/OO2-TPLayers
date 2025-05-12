package ar.unrn.tp4.ejercicios.ejercicio1.DataBase;

import ar.unrn.tp4.ejercicios.ejercicio1.Model.Participante;

import java.sql.SQLException;

public class AgregarParticipante implements NewParticipante {

    private ConectionDataBase DB;

    public AgregarParticipante() throws SQLException {
        this.DB = new ConectionDataBase();
    }


    @Override
    public void crearNuevoParticipante(String nombre, String telefono, String region) throws SQLException {

        Participante participante = new Participante(nombre, telefono, region);

        this.DB.insertarNuevoParticipante(participante);


    }

}
