package domain;

public abstract class Persona {

    // CONSIDERO ID STATIC PARA HACERLA AUTOINCREMENTAL CADA VEZ QUE SE CREA UNA PERSONA
    protected final int id;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected static int contadorPersonas = 0;

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

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

}
