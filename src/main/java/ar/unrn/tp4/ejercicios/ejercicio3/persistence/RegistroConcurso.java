package ar.unrn.tp4.ejercicios.ejercicio3.persistence;


import ar.unrn.tp4.ejercicios.ejercicio3.model.Concurso;
import ar.unrn.tp4.ejercicios.ejercicio3.model.DataGetter;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroConcurso implements DataGetter {

    private String pathConcursos;

    public RegistroConcurso(String pathConcursos) {
        this.pathConcursos = pathConcursos;

    }

    @Override
    public List<Concurso> recuperarConcursos() throws IOException {

        List<Concurso> concursos = new ArrayList<>();
        try {

            CSVReader reader = new CSVReader(new FileReader(this.pathConcursos)); //"src/main/resources/Concursos.txt"
            String[] row = null;

            while ((row = reader.readNext()) != null) {
                if (row.length >= 4) {

                    int id = Integer.parseInt(row[0].trim());
                    String nombreConcurso = row[1].trim();
                    LocalDate FechaInicio = formatoDeFecha(row[2].trim());
                    LocalDate FechaFin = formatoDeFecha(row[3].trim());


                    concursos.add(new Concurso(id, nombreConcurso, FechaInicio, FechaFin));
                }
            }

            reader.close();
            //csvData.remove(0);

        } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return concursos;
    }


    private LocalDate formatoDeFecha(String fecha){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaParseada = LocalDate.parse(fecha, formato);

        return fechaParseada;
    }
}
