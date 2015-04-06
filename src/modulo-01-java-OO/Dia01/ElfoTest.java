

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  Arthur Oliveira
 * 
 */
public class ElfoTest
{
   @Test
    public void ElfoAtiraFlecha()
    {
        Elfo elfoTeste = new Elfo();
        
        elfoTeste.atirarFlecha();
       
        int flechasEsperadas = 41;
        int resultadoflechas = elfoTeste.getFlechas();
        
        
        int experienciaEsperada = 1;
        int resultadoExperiencia = elfoTeste.getExperiencia();
        
        int VidaOrcEsperada = 100;
        int resultadoVidaOrcEsperada = elfoTeste.getVidaOrc();
        
        assertEquals(resultadoflechas, flechasEsperadas);
        
        assertEquals(resultadoExperiencia, experienciaEsperada);
       
       assertEquals(resultadoVidaOrcEsperada, VidaOrcEsperada);
    }
}
