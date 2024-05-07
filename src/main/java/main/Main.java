package main;

import domain.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        simularAdjudicacion();
    }

    private static void adjudicarPlazas (ArrayList<Persona> personas, ArrayList<Plaza> plazas) {

        // CREAR ARRAYLIST SANITARIOS
        ArrayList<Sanitario> sanitarios = new ArrayList<Sanitario>();

        // CREAR ARRAYLIST DOCENTES
        ArrayList<Docente> docentes = new ArrayList<Docente>();

        // ASIGNAMOS A PERSONA EN FUNCIÓN DE SI ES TIPO SANITARIO O DOCENTE
        for (Persona persona: personas) {

            if (persona instanceof Sanitario){

                sanitarios.add((Sanitario) persona);
            } else if (persona instanceof Docente){

                docentes.add((Docente) persona);
            }
        }

        // BUBBLE SORT DESCENDENTE SANITARIOS POR DIAS TRABAJADOS

        for (int i = 0; i < sanitarios.size(); i++) {

            for (int j = i + 1; j < sanitarios.size(); j++) {

                if (sanitarios.get(j).getDiasTrabajados() > sanitarios.get(i).getDiasTrabajados()){

                    Sanitario tempSanitario = sanitarios.get(j);
                    sanitarios.set(j, sanitarios.get(i));
                    sanitarios.set(i, tempSanitario);

                }
            }

        }

        // BUBBLE SORT DESCENDENTE DOCENTES POR PUNTOS ACUMULADOS

        for (int i = 0; i < docentes.size(); i++) {

            for (int j = i + 1; j < docentes.size(); j++) {

                if (docentes.get(j).getPuntos() > docentes.get(i).getPuntos()){

                    Docente tempDocente = docentes.get(j);
                    docentes.set(j, docentes.get(i));
                    docentes.set(i, tempDocente);

                }
            }

        }

        /* ASIGNAMOS PERSONA A CADA PLAZA SEGÚN TIPO DE PLAZA Y SACAMOS DE LISTA DOCENTES Y SANITARIOS
        * EL PRIMER ELEMENTO YA QUE ESTÁN ORDENADOS EN SENTIDO DESCENDENTE
        */

        for (Plaza plaza : plazas) {

            if (plaza.getTipo() == TipoPlaza.S) {

                plaza.setPersona(sanitarios.getFirst());
                plaza.setAdjudicada(true);
                sanitarios.removeFirst();
            } else if (plaza.getTipo() == TipoPlaza.D) {

                plaza.setPersona(docentes.getFirst());
                plaza.setAdjudicada(true);
                docentes.removeFirst();
            }
        }
        System.out.println(plazas);
    }

    public static void simularAdjudicacion() {

        // CREAR DOCENTE Y SANITARIO Y AÑADIR A LISTA

        Docente docente1 = new Docente("manuel", "sancha", "terres","gade", 37);
        Docente docente2 = new Docente("pepe", "flores", "hernandez","derecho", 42.5);
        Sanitario sanitario1 = new Sanitario("felipe", "perez", "gonzalez","pediatria",125);
        Sanitario sanitario2 = new Sanitario("miguel", "marin", "soria","ginecología",175);
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(docente1);
        personas.add(docente2);
        personas.add(sanitario1);
        personas.add(sanitario2);

        // CREAR PLAZAS  Y AÑADIR A LISTA PLAZAS

        Plaza plaza1 = new Plaza(TipoPlaza.D);
        Plaza plaza2 = new Plaza(TipoPlaza.S);
        Plaza plaza3 = new Plaza(TipoPlaza.S);

        ArrayList<Plaza> plazas = new ArrayList<Plaza>();
        plazas.add(plaza1);
        plazas.add(plaza2);
        plazas.add(plaza3);
        adjudicarPlazas(personas,plazas);
    }
}
