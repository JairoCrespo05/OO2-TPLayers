package ar.unrn.tp4.ejercicios.ejercicio2.model;

import java.time.MonthDay;

public class SaludadorEmpleados {

    private Felicitador mensajeria;
    private Registro registroEmpleados;



    public SaludadorEmpleados(Felicitador mensajeria, Registro registroEmpleados) {
        this.mensajeria = mensajeria;
        this.registroEmpleados = registroEmpleados;

    }

    public void enviarSaludos(MonthDay fecha){
        var empleados = this.registroEmpleados.empleados();
        for(var empleado : empleados){
            if(empleado.esTuCumpleaños(fecha)){
                this.mensajeria.felicitar(empleado.email(), "Te deseamos un muy feliz cumpleaños, que pases un dia excelente!!!");
            }
        }
    }


}
