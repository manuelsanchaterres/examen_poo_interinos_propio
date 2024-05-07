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

            if (plaza.getTipo() == 'S') {

                plaza.setPersona(sanitarios.getFirst());
                plaza.setAdjudicada(true);
                sanitarios.removeFirst();
            } else if (plaza.getTipo() == 'D') {

                plaza.setPersona(docentes.getFirst());
                plaza.setAdjudicada(true);
                docentes.removeFirst();
            }
        }

        // BUBBLE SORT DESCENDENTE PLAZAS ASCII CHAR 'S' MAYOR QUE ASCII CHAR 'D'
        for (int i = 0; i < plazas.size(); i++) {

            for (int j = i + 1; j < plazas.size(); j++) {

                if ((int) (plazas.get(j).getTipo()) > (int) (plazas.get(i).getTipo())){

                    Plaza tempPlaza = plazas.get(j);
                    plazas.set(j, plazas.get(i));
                    plazas.set(i, tempPlaza);

                }
            }

        }

        mostrarAdjudicaciones(plazas);

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

        Plaza plaza1 = new Plaza('D');
        Plaza plaza2 = new Plaza('S');
        Plaza plaza3 = new Plaza('S');

        ArrayList<Plaza> plazas = new ArrayList<Plaza>();
        plazas.add(plaza1);
        plazas.add(plaza2);
        plazas.add(plaza3);
        adjudicarPlazas(personas,plazas);
    }

    public static void mostrarAdjudicaciones(ArrayList<Plaza> plazas){

        int currentIndex = 0;

        System.out.print(
                "============================================\n" +
                "La última adjudicación de plazas ha producido\n" +
                "los siguientes resultados para SANITARIOS\n" +
                "============================================\n"
        );

        for (int i = 0; i < plazas.size(); i++) {

            Plaza plaza = plazas.get(i);
            Persona persona = plaza.getPersona();

            if (plaza.getTipo() == 'S') {
                Sanitario sanitario = (Sanitario) plaza.getPersona();
                System.out.println("ID Plaza " + plaza.getId());
                System.out.println("Tipo: " + plaza.getTipo());
                System.out.println("Adjudicada: " + (plaza.isAdjudicada() ? "ADJUDICADA" : "NO_ADJUDICADA"));
                System.out.println("ID: " + persona.getId());
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Apellido1: " + persona.getPrimerApellido());
                System.out.println("Apellido2: " + persona.getSegundoApellido());
                System.out.println("Especialidad: " + sanitario.getEspecialidad());
                System.out.println("Dias experiencia: " + sanitario.getDiasTrabajados());
                System.out.println("____________________________________________");

                currentIndex++;

            } else {

                break;
            }



        }

        System.out.print(
                "============================================\n" +
                        "La última adjudicación de plazas ha producido\n" +
                        "los siguientes resultados para DOCENTES\n" +
                        "============================================\n"
        );

        for (int i = currentIndex; i < plazas.size() ; i++) {

            Plaza plaza = plazas.get(i);
            Persona persona = plaza.getPersona();

            if (plaza.getTipo() == 'D') {
                Docente docente = (Docente) plaza.getPersona();
                System.out.println("ID Plaza " + plaza.getId());
                System.out.println("Tipo: " + plaza.getTipo());
                System.out.println("Adjudicada: " + (plaza.isAdjudicada() ? "ADJUDICADA" : "NO_ADJUDICADA"));
                System.out.println("ID: " + persona.getId());
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Apellido1: " + persona.getPrimerApellido());
                System.out.println("Apellido2: " + persona.getSegundoApellido());
                System.out.println("Titulación: " + docente.getTitulacion());
                System.out.println("Puntos: " + docente.getPuntos());
                System.out.println("____________________________________________");
            } else {

                break;
            }
        }



    }
}
