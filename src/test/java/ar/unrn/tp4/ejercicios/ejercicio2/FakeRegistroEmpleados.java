package ar.unrn.tp4.ejercicios.ejercicio2;

import ar.unrn.tp4.ejercicios.ejercicio2.model.Empleado;
import ar.unrn.tp4.ejercicios.ejercicio2.model.Registro;

import java.time.LocalDate;
import java.util.List;

public class FakeRegistroEmpleados implements Registro {
    @Override
    public List<Empleado> empleados() {
        return List.of(
                new Empleado( "Muller","Javier","2002.gmail.com", LocalDate.of(2002, 10, 5)),
                new Empleado("Borja","Miguel","2001.gmail.com", LocalDate.of(2001, 2, 19))
        );
    }


}
