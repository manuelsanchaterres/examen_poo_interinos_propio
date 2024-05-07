package domain;

public class Plaza {

    private final int id;

    // ENUM PARA CERRAR LA SELECCIÓN DE POSIBLES VALORES 'D' o 'S'
    private final TipoPlaza tipo;
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


    public Plaza (TipoPlaza tipo) {

        this.tipo = tipo;
        totalPlazas++;
        id = totalPlazas;
    }

    public TipoPlaza getTipo() {
        return tipo;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setAdjudicada(boolean adjudicada) {
        this.adjudicada = adjudicada;
    }
}


