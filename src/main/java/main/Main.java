package main;

import domain.Persona;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("manuel", "sancha", "terres");
        Persona persona2 = new Persona("maximo", "fernandez", "riera");
        Persona persona3 = new Persona("joaquin", "fernandez", "torres");
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);
    }
}
