package ar.edu.unrn.modelo;

public class Participante {

    private String nombre;
    private int puntos;

    public Participante(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntos +=puntos;
    }

    public int puntos() {
        return this.puntos;
    }
}
