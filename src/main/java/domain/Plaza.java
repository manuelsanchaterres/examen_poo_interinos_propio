package domain;

public class Plaza {



    private final int id;

    // ENUM PARA CERRAR LA SELECCIÓN DE POSIBLES VALORES 'D' o 'S'
    private char tipo;



    private boolean adjudicada;
    private Persona persona;
    private static int totalPlazas = 0;

    @Override
    public String toString() {
        return "Plaza{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", adjudicada=" + adjudicada +
                ", persona=" + persona +
                ", totalPlazas=" + totalPlazas +
                '}';
    }


    public Plaza (char tipo) {

        this.tipo = tipo;
        totalPlazas++;
        id = totalPlazas;
    }

    public char getTipo() {
        return tipo;
    }

    public int getId() {
        return id;
    }

    public boolean isAdjudicada() {
        return adjudicada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setAdjudicada(boolean adjudicada) {
        this.adjudicada = adjudicada;
    }


}


