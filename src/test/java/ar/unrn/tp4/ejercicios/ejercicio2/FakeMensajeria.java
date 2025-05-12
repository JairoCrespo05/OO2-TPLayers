package ar.unrn.tp4.ejercicios.ejercicio2;

import ar.unrn.tp4.ejercicios.ejercicio2.model.Felicitador;

public class FakeMensajeria implements Felicitador {

    private String data;

    public FakeMensajeria() {

    }


    @Override
    public void felicitar(String email, String contenidos) {
        this.data = email;
    }

    public String emailFake(){return this.data;}

}
