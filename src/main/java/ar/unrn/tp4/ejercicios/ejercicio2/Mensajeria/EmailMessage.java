package ar.unrn.tp4.ejercicios.ejercicio2.Mensajeria;

import ar.unrn.tp4.ejercicios.ejercicio2.model.Felicitador;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailMessage implements Felicitador {
    private static final String HOST  = "sandbox.smtp.mailtrap.io";
    private static final String PORT = "2525";
    private static final String USER = "b87e2abe360271";
    private static final String PASSWORD = "1e149bd54796d7";

    static String ASUNTO = "FELIZ CUMPLEAÑOS!!!";



    public EmailMessage(){

    }


    @Override
    public void felicitar(String email, String contenido) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttlss.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(USER));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            mensaje.setSubject(ASUNTO);
            mensaje.setText(contenido);

            Transport.send(mensaje);
        }catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }

        System.out.println("Mensaje enviado Exitosamente");
    }


}
