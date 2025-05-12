package ar.unrn.tp4.ejercicios.ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

public class Empleado {

    private String apellido;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;

    public Empleado(String apellido, String nombre, String email, LocalDate fechaNacimiento) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }


    public boolean esTuCumpleaños(MonthDay diaDelMes){
        return MonthDay.from(this.fechaNacimiento).equals(diaDelMes);
    }

    public String email(){return this.email;}

    @Override
    public String toString() {
        return "apellido: "+ this.apellido +" "+ "nombre: " + this.nombre +" "+ "email: " + this.email +" "+ "cumpleaños: " + this.fechaNacimiento +" "+ "\n";
    }
}
