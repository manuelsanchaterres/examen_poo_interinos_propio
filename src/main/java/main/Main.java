package main;

import domain.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // CREAR DOCENTE Y SANITARIO Y AÑADIR A LISTA

        Docente docente1 = new Docente("manuel", "sancha", "terres","gade", 42.5);
        Docente docente2 = new Docente("pepe", "flores", "hernandez","derecho", 37);
        Sanitario sanitario = new Sanitario("felipe", "perez", "gonzalez","pediatria",125);

        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(docente1);
        personas.add(docente2);
        personas.add(sanitario);

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

    private static void adjudicarPlazas (ArrayList<Persona> personas, ArrayList<Plaza> plazas) {

        // CREAR ARRAYLIST SANITARIOS
        ArrayList<Persona> sanitarios = new ArrayList<Persona>();

        // CREAR ARRAYLIST DOCENTES
        ArrayList<Persona> docentes = new ArrayList<Persona>();

        // ASIGNAMOS A PERSONA EN FUNCIÓN DE SI ES TIPO SANITARIO O DOCENTE
        for (Persona persona: personas) {

            if (persona instanceof Sanitario){

                sanitarios.add(persona);
            } else if (persona instanceof Docente){

                docentes.add(persona);
            }
        }

        // TODO ORDENAR SANITARIOS POR DIAS TRABAJADOS

        for (int i = 0; i < sanitarios.size(); i++) {

            for (int j = 0; j < sanitarios.size(); j++) {

                if (sanitarios.get(j). > sanitarios.get(i)){


                }
            }

        }


    }
}
