package ar.unrn.tp4.ejercicios.ejercicio1.DataBase;

import ar.unrn.tp4.ejercicios.ejercicio1.Model.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectionDataBase {

    private Connection dbConn;
    public static String url = "jdbc:derby://localhost:1527/participantes;create=true";
    public static String user = "app";
    public static String password = "app";
    public static String INSERT_PARTICIPANTE = "insert into participantes(nombre, telefono, region) values(?,?,?)";


    public ConectionDataBase() throws SQLException {
//        String url = "jdbc:derby://localhost:1527/participantes";
//        String user = "app";
//        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }


    public void insertarNuevoParticipante(Participante participante) throws SQLException {

        PreparedStatement st = dbConn.prepareStatement(INSERT_PARTICIPANTE);
        try {
            st.setString(1, participante.miNombreEs());
            st.setString(2, participante.miTelefonoEs());
            st.setString(3, participante.miRegionEs());
            st.executeUpdate();
        } finally {
            st.close();
        }
    }


}