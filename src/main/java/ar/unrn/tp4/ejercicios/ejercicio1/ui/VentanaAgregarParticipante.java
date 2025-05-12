package ar.unrn.tp4.ejercicios.ejercicio1.ui;

import ar.unrn.tp4.ejercicios.ejercicio1.DataBase.NewParticipante;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaAgregarParticipante extends JFrame{

    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private NewParticipante api;



public VentanaAgregarParticipante(NewParticipante api)throws Exception{
    this.api = api;

    setTitle("Add Participant");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.nombre = new JTextField(10);
    this.telefono = new JTextField(10);
    this.region = new JTextField(10);
    this.nombre.setText("");
    this.telefono.setText("");
    this.region.setText("China");
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new FlowLayout());
    contentPane.add(new JLabel("Nombre: "));
    contentPane.add(nombre);
    contentPane.add(new JLabel("Telefono: "));
    contentPane.add(telefono);
    contentPane.add(new JLabel("Region: "));
    contentPane.add(region);
    JButton botonCargar = new JButton("Cargar");
    botonCargar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                onBotonCargar(nombre.getText(), telefono.getText(), region.getText());
            } catch (SQLException e1) {
                throw new RuntimeException(e1.getMessage());
            }
        }
    });
    contentPane.add(botonCargar);
    setContentPane(contentPane);
    contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    pack();
    setVisible(true);
}

    private void onBotonCargar(String nombre, String telefono, String region) throws SQLException {
        api.crearNuevoParticipante(nombre, telefono, region);
    }

}
