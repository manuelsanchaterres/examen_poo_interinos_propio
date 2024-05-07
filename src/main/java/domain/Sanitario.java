package domain;

public class Sanitario extends Persona{

    private String especialidad;
    private int diasTrabajados;

    @Override
    public String toString() {
        return "Sanitario{" +
                "especialidad='" + especialidad + '\'' +
                ", diasTrabajados=" + diasTrabajados +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                '}';
    }

    public Sanitario(String nombre, String primerApellido, String segundoApellido, String especialidad, int diasTrabajados){

       super(nombre,primerApellido,segundoApellido);
       this.especialidad = especialidad;
       this.diasTrabajados = diasTrabajados;
   }
}

