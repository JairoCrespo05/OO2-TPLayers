package ar.unrn.tp4.ejercicios.ejercicio2;


import ar.unrn.tp4.ejercicios.ejercicio2.model.SaludadorEmpleados;
import org.junit.jupiter.api.Test;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

class CumpleañosEmpleadosTest {

    @Test
    public void Test01(){
        var registro = new FakeRegistroEmpleados();
        var mensajeria = new FakeMensajeria();
        var saludadorEmpleados = new SaludadorEmpleados(mensajeria, registro);



        saludadorEmpleados.enviarSaludos(MonthDay.of(10, 5));

        assertEquals("2002.gmail.com",  mensajeria.emailFake());



    }
}