import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestesIntegrados.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestesIntegrados
{
    /**
     * Default constructor for test class TestesIntegrados
     */
   
        @Test
        public void umElfoAtiraEmDoisOrcsDiferentes(){
        //Arrange
        Elfo elfoTeste = new Elfo("Cusco 1000");
        Orc orc1 = new Orc();
        Orc orc2 = new Orc();
        
        
        //Act
        elfoTeste.atirarFlecha(orc1);
        elfoTeste.atirarFlecha(orc2);
        
        //Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc = 100;
      
        
        assertEquals(experienciaEsperada, elfoTeste.getExperiencia());
        assertEquals(flechasEsperadas, elfoTeste.getFlechas());
        assertEquals(vidaEsperadaOrc, orc1.getVida());
        assertEquals(vidaEsperadaOrc, orc2.getVida());
        }
}
