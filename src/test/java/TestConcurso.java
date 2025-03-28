import ar.edu.unrn.modelo.Concurso;
import ar.edu.unrn.modelo.Participante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestConcurso {

    private Concurso miConcurso;
    private Participante participante1;

    @BeforeEach
    public void setup(){
        miConcurso = new Concurso("prueba",
                LocalDate.of(2025, 2, 25),
                LocalDate.of(2025, 3, 21));
        participante1 = new Participante("Lautaro");
    }


    @Test
    public void testInscribir(){

        miConcurso.inscribirParticipante(participante1, LocalDate.now());

        //Verificacion
        assertEquals(1, miConcurso.cantInscriptos());
        //Agregar assert participante inscripto en el concurso
    }

    @Test
    public void testPrimerDiaInscripcion(){

        Participante participante2 = new Participante("Brian");

        //Ejercitar
        miConcurso.inscribirParticipante(participante1, LocalDate.of(2025, 2, 25));
        miConcurso.inscribirParticipante(participante2, LocalDate.of(2025, 2, 26));

        //Verificar
        assertEquals(10, miConcurso.cantidadPuntos(participante1));
        assertEquals(0, miConcurso.cantidadPuntos(participante2));


    }

    @Test
    public void testFueraRangoInscripcion(){


        Concurso miConcurso = new Concurso("prueba",
                LocalDate.of(2025, 2, 25),
                LocalDate.of(2025, 3, 21));
        Participante participante1 = new Participante("Lautaro");
        Participante participante2 = new Participante("Brian");


        assertThrows(RuntimeException.class, ()->miConcurso.inscribirParticipante(participante1, LocalDate.of(2025, 2, 24)));
        assertThrows(RuntimeException.class, ()->miConcurso.inscribirParticipante(participante2, LocalDate.of(2025, 3, 22)));


    }



}
