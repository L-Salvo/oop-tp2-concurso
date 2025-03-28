package ar.edu.unrn.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Concurso {

    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechafinInscripcion;
    private Set<Participante> participantes;

    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechafinInscripcion){

        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechafinInscripcion = fechafinInscripcion;
        this.participantes = new HashSet<>();
    }

    public void inscribirParticipante(Participante participante, LocalDate fechaInscripcion){
        if(participantes.contains(participante)){
           throw new RuntimeException("El participante ya esta inscripto.");
        }
        if(fechaInscripcion.isAfter(this.fechafinInscripcion) || fechaInscripcion.isBefore(this.fechaInicioInscripcion)){
            throw new RuntimeException("No es posible inscribirse fuera del rango de inscripcion.");
        }
        participantes.add(participante);
        if (fechaInscripcion.equals(this.fechaInicioInscripcion)){
            participante.sumarPuntos(10);
        }

    }

    public int cantidadPuntos(Participante participante){
        if(!participantes.contains(participante)){
            throw new RuntimeException("El participante no se encuentra inscripto en el concurso.");
        }
        return participante.puntos();
    }


    public int cantInscriptos() {
        return this.participantes.size();
    }
}
