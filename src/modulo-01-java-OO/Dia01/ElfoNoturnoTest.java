import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  Arthur Oliveira
 * 
 */
public class ElfoNoturnoTest
{
    @Test
  public void elfoNoturnoAtiraUmaFlechaEmUmOrcEGanhaOTriploDeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas", 42);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        // Assert
        int experienciaEsperada = 3;
        int flechasEsperadas = 41;
        int vidaEsperada = 95;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
  @Test
  public void elfoNoturnoAtiraDuasFlechasEmUmOrcEGanha6DeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas", 42);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        
        // Assert
        int experienciaEsperada = 6;
        int flechasEsperadas = 40;
        int vidaEsperada = 90;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
    @Test
  public void elfoNoturnoAtiraCincoFlechasEmUmOrcEGanha15DeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas", 42);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        // Assert
        int experienciaEsperada = 15;
        int flechasEsperadas = 37;
        int vidaEsperada = 75;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
   
}
