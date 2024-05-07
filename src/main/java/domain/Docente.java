package domain;

public class Docente extends Persona{

    private String titulacion;

    private double puntos;

    @Override
    public String toString() {
        return "Docente{" +
                "titulacion='" + titulacion + '\'' +
                ", puntos=" + puntos +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                '}';
    }

    public Docente (String nombre, String primerApellido, String segundoApellido, String titulacion, double puntos){

       super(nombre,primerApellido,segundoApellido);
       this.titulacion = titulacion;
       this.puntos = puntos;
   }

    public double getPuntos() {
        return puntos;
    }
}

