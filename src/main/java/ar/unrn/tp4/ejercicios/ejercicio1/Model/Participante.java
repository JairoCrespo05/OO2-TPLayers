package ar.unrn.tp4.ejercicios.ejercicio1.Model;

public class Participante {

    public static String NAME_VACIO = "Debe cargar un nombre";
    public static String TELEFONO_VACIO = "Debe cargar un telefono";
    public static String TELEFONO_INVALIDO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static String REGION_DESCONOCIDA = "Region desconocida. Las conocidas son: China, US, Europa";
    private String nombre;
    private String telefono;
    private String region;


    public Participante(String nombre, String telefono, String region) {
        checkName(nombre);
        validarTelefono(telefono);
        checkRegion(region);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }


    private void checkName(String nombre){
        if (nombre.isBlank()){throw new RuntimeException(NAME_VACIO);}
    }


    private void checkRegion(String region){
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")){
            throw new RuntimeException(REGION_DESCONOCIDA);
        }
    }

    private void validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";

        if (telefono.isBlank()){
            throw new RuntimeException(TELEFONO_VACIO);
        }

        if(!telefono.matches(regex)){
            throw new RuntimeException(TELEFONO_INVALIDO);
        }
    }



    public String miNombreEs(){return this.nombre;}

    public String miTelefonoEs(){return this.telefono;}

    public String miRegionEs(){return this.region;}

}
