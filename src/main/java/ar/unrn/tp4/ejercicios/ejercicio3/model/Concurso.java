package ar.unrn.tp4.ejercicios.ejercicio3.model;

import java.time.LocalDate;

public class Concurso {

    public static String ID_INVALIDO = "El concurso no es valido";
    public static String NOMBRE_CONCURSO_VACIO = "El nombre del Concurso no puede estar vacio";
    public static String FECHA_VACIA = "La Fecha no es valida";
    public static String CRONOLOGIA_INVALIDA = "Error en la cronologia de las fechas";


    private int idConcurso;
    private String nombreConcurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    public Concurso(int idConcurso, String nombreConcurso, LocalDate fechaInicio, LocalDate fechaFin) {
        checkId(idConcurso);
        checkNombreConcurso(nombreConcurso);
        checkFechasInicioYFin(fechaInicio, fechaFin);

        this.idConcurso = idConcurso;
        this.nombreConcurso = nombreConcurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    private void checkId(int id){
        if (id <= 0){
            throw new RuntimeException(ID_INVALIDO);
        }
    }

    private void checkNombreConcurso(String name){
        if (name.isBlank()){
            throw new RuntimeException(NOMBRE_CONCURSO_VACIO);
        }
    }

    private void checkFechasInicioYFin(LocalDate fechaInicio, LocalDate fechaFin){
        if (fechaInicio == null){
            throw new RuntimeException(FECHA_VACIA);
        }
        if(fechaFin == null){
            throw new RuntimeException(FECHA_VACIA);
        }

        if (fechaFin.isBefore(fechaInicio)){
            throw new RuntimeException(CRONOLOGIA_INVALIDA);
        }
    }

    public int MiIdEs(){
        return this.idConcurso;
    }

    public String MiNombreEs(){
        return this.nombreConcurso;
    }

    public LocalDate FechaInicio(){
        return this.fechaInicio;
    }

    public LocalDate FechaFin(){
        return this.fechaFin;
    }
}
