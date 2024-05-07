package domain;

public class Persona {

    // CONSIDERO ID STATIC PARA HACERLA AUTOINCREMENTAL CADA VEZ QUE SE CREA UNA PERSONA
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private static int contadorPersonas = 0;

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", contadorPersonas='" + contadorPersonas + '\'' +
                '}';
    }



    public Persona (String nombre, String primerApellido, String segundoApellido) {

        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        contadorPersonas++;
        /* ID AUTOINCREMENTAL Y ÚNICA PARA CADA INSTANCIA DE PERSONA EN FUNCIÓN
        DEL VALOR ACTUAL DE CONTADORPERSONAS */
        id = contadorPersonas;

    }

    public int getId() {
        return id;
    }


}
