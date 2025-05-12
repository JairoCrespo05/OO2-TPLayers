package ar.unrn.tp4.ejercicios.ejercicio2.persistence;

import ar.unrn.tp4.ejercicios.ejercicio2.model.Empleado;
import ar.unrn.tp4.ejercicios.ejercicio2.model.Registro;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LectorRegistroEmpleados implements Registro {

    private String path;

    public LectorRegistroEmpleados(String path) {
        this.path = path;
    }


    @Override
    public List<Empleado> empleados() {
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();

        try {
            CSVReader reader = new CSVReader(new FileReader(this.path)); //"src/main/resources/cumpleañoEmpleados.csv"
            String[] row = null;

            while ((row = reader.readNext()) != null) {
                if (row.length >= 4) {

                    String apellido = row[0].trim();
                    String nombre = row[1].trim();
                    LocalDate cumpleaños = formatearFecha(row[2].trim());
                    String email = row[3].trim();

                    listaEmpleados.add(new Empleado(apellido, nombre, email, cumpleaños));
                }
            }

            reader.close();
            //csvData.remove(0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return listaEmpleados;
    }


    private LocalDate formatearFecha(String fecha){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaParaseada = LocalDate.parse(fecha, formato);

        return fechaParaseada;
    }


}
