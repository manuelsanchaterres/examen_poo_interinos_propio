package main;

import domain.Docente;
import domain.Persona;
import domain.Sanitario;

public class Main {

    public static void main(String[] args) {

        // CREAR DOCENTE Y SANITARIO

        Docente docente = new Docente("manuel", "sancha", "terres","gade", 42.5);
        Sanitario sanitario = new Sanitario("felipe", "perez", "gonzalez","pediatria",125);

        System.out.println(docente);
        System.out.println(sanitario);
    }
}
