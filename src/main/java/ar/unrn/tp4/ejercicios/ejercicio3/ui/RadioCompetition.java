package ar.unrn.tp4.ejercicios.ejercicio3.ui;

import ar.unrn.tp4.ejercicios.ejercicio3.model.Concurso;
import ar.unrn.tp4.ejercicios.ejercicio3.model.InscriptionManager;
import ar.unrn.tp4.ejercicios.ejercicio3.model.Participante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class RadioCompetition{
        private JPanel contentPane;
        private JLabel lblName;
        private JTextField txtName;
        private JLabel lblLastName;
        private JTextField txtLastName;
        private JLabel lblDni;
        private JTextField txtDni;
        private JLabel lblPhone;
        private JTextField txtPhone;
        private JLabel lblEmail;
        private JTextField txtEmail;
        private JComboBox<String> comboBox;
        private JButton btnOk;
        private JLabel lblCompetition;

        private InscriptionManager registro;

        public RadioCompetition(InscriptionManager registro) {
            this.registro = registro;

            var frame = new JFrame("Inscription to Competition");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 451, 229);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            frame.setContentPane(contentPane);
            try {
                formElements();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            layout();
            frame.setVisible(true);
        }

        private void formElements() throws IOException {
            lblName = new JLabel("Nombre:");
            txtName = new JTextField();  txtName.setColumns(10);
            lblLastName = new JLabel("Apellido:");
            txtLastName = new JTextField();  txtLastName.setColumns(10);
            lblDni = new JLabel("Dni:");
            txtDni = new JTextField();  txtDni.setColumns(10);
            lblPhone = new JLabel("Telefono:");
            txtPhone = new JTextField();  txtPhone.setColumns(10);
            lblEmail = new JLabel("Email:");
            txtEmail = new JTextField();  txtEmail.setColumns(10);
            btnOk = new JButton("Ok");
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnOk.setEnabled(false);
                    try {
                        saveInscription();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    btnOk.setEnabled(true);

                }
            });
            lblCompetition = new JLabel("Concurso:");
            comboBox = new JComboBox<String>();
            todosLosConcursos();
        }

        private void todosLosConcursos() throws IOException { // carga del archivo de texto concursos.txt los concursos
            List<Concurso> listaconcursos = registro.todosLosConcursos();

            for (Concurso c : listaconcursos){

//                String contenido = String.valueOf(c.MiIdEs()) +" "+ c.MiNombreEs();
//                this.comboBox.addItem( contenido );

                this.comboBox.addItem( String.valueOf(c.MiIdEs()) );

            }

        }

        private void saveInscription() throws IOException {

            String nombre = this.txtName.getText();
            String apellido = this.txtLastName.getText();
            String dni = this.txtDni.getText();
            String email = this.txtEmail.getText();
            String telefono = this.txtPhone.getText();

            String concurso = (String) this.comboBox.getSelectedItem();
            int idConcurso = Integer.parseInt(concurso);

            registro.saveInscription(new Participante(nombre, apellido, dni, email, telefono, idConcurso));

        }

        private void layout () {
            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                .createSequentialGroup()
                                                .addGroup(gl_contentPane
                                                        .createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblLastName)
                                                        .addComponent(lblDni)
                                                        .addComponent(lblPhone)
                                                        .addComponent(lblEmail)
                                                        .addComponent(lblName)
                                                        .addComponent(lblCompetition))
                                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addGroup(gl_contentPane
                                                        .createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtEmail, Alignment.TRAILING)
                                                        .addComponent(txtPhone, Alignment.TRAILING)
                                                        .addComponent(txtDni, Alignment.TRAILING)
                                                        .addComponent(txtLastName, Alignment.TRAILING)
                                                        .addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                        .addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        gl_contentPane.setVerticalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane
                        .createSequentialGroup()
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblLastName)
                                .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblDni)
                                .addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane
                                        .createSequentialGroup()
                                                .addComponent(lblPhone)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(lblEmail))
                                .addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addGroup(gl_contentPane
                                                .createParallelGroup(Alignment.BASELINE)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCompetition))))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));

        contentPane.setLayout(gl_contentPane);
    }
}
