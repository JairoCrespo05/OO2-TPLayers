package ar.unrn.tp4.ejercicios.ejercicio2.Main;

import ar.unrn.tp4.ejercicios.ejercicio2.Mensajeria.EmailMessage;
import ar.unrn.tp4.ejercicios.ejercicio2.model.SaludadorEmpleados;
import ar.unrn.tp4.ejercicios.ejercicio2.persistence.LectorRegistroEmpleados;

import java.time.MonthDay;

public class MainEjercicio2 {
    public static void main(String[] args){

        SaludadorEmpleados felicitador = new SaludadorEmpleados(
                new EmailMessage(),
                new LectorRegistroEmpleados("src/main/resources/cumpleañoEmpleados.csv")
        );
//        var lectorArchivo = new LectorRegistroEmpleados("src/main/resources/cumpleañoEmpleados.csv");
//
//        System.out.println( lectorArchivo.empleados() );

        felicitador.enviarSaludos(MonthDay.of(10, 8));
    }
}
