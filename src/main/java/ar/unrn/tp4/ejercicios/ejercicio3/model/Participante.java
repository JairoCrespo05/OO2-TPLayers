package ar.unrn.tp4.ejercicios.ejercicio3.model;

public class Participante {

    public static String NOMBRE_VACIO = "Nombre no puede ser vacio";
    public static String APELLIDO_VACIO = "apellido no puede ser vacio";
    public static String DNI_VACIO = "dni no puede ser vacio";
    public static String EMAIL_INVALLIDO = "email debe ser válido";
    public static String TELEFONO_INVALLIDO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static String ID_CONCURSO_VACIO = "Debe elegir un Concurso";

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private int idConcurso;

    public Participante(String nombre, String apellido, String dni, String email, String telefono, int idConcurso) {
        checkName(nombre);
        checkLastName(apellido);
        checkdni(dni);
        checkEmail(email);
        checkPhone(telefono);
        checkIdConcurso(idConcurso);

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.idConcurso = idConcurso;
    }




    private void checkName(String name){
        if(name.isBlank()){
            throw new RuntimeException(NOMBRE_VACIO);
        }
    }

    private void checkLastName(String lastName){
        if(lastName.isBlank()){
            throw new RuntimeException(APELLIDO_VACIO);
        }
    }

    private void checkdni(String dni){
        if(dni.isBlank()){
            throw new RuntimeException(DNI_VACIO);
        }
    }

    private void checkIdConcurso(int idConcurso){
        if (idConcurso <= 0){
            throw new RuntimeException(ID_CONCURSO_VACIO);
        }
    }


    private void checkEmail (String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(regex)){
            throw new RuntimeException(EMAIL_INVALLIDO);
        }
    }

    private void checkPhone (String telefono){
        String regex = "\\d{4}-\\d{6}";
        if(telefono.matches(regex)){
            throw new RuntimeException(TELEFONO_INVALLIDO);
        }
    }

    public String MiDniEs() {
        return this.dni;
    }

    public String MiApellidoEs() {
        return this.apellido;
    }

    public String MiNombreEs() {
        return this.nombre;
    }

    public String MiEmailEs() {
        return this.email;
    }


    public String MiTelefonoEs() {
        return this.telefono;
    }

    public int ElIdDelConcursoEs() {
        return this.idConcurso;
    }

}
