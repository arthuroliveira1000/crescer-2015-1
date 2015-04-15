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
  private final double DELTA = 0.005;
    
  @Test
  public void elfoNoturnoAtiraUmaFlechaEmUmOrcEGanhaOTriploDeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        
        double vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        // Assert
        int experienciaEsperada = 3;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida(), DELTA);
    }
    
  @Test
  public void elfoNoturnoAtiraDuasFlechasEmUmOrcEGanha6DeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        double vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        
        // Assert
        int experienciaEsperada = 6;
        int flechasEsperadas = 40;
        
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida(), DELTA);
    }
    
    @Test
  public void elfoNoturnoAtiraCincoFlechasEmUmOrcEGanha15DeExperienciaEPerdeCincoPorCentoDeVidaAtual() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        double vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        vidaEsperada = elfo.getVida() - ((elfo.getVida() * 5)/ 100);
        elfo.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(orc);
        // Assert
        int experienciaEsperada = 15;
        int flechasEsperadas = 37;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida(), DELTA);
    }
    
    
  @Test
  public void quandoatirarFlechaStatusAtacando() {
    ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
    Status statusEsperado = Status.ATACANDO;
    elfoNoturno.atirarFlecha(new Orc());
    Status obtido = elfoNoturno.getStatus();
    assertEquals(statusEsperado, obtido);
  }
    
  @Test
  public void quandoAtirarMuitasFlechasStatusMorto() {
     
      ElfoNoturno elfoSuiçida = new ElfoNoturno("Night Legolas");
      Status statusEsperado = Status.MORTO;

      for (int i = 0; i < 100; i++)
        elfoSuiçida.atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(new Orc());

        Status obtido = elfoSuiçida.getStatus();

        assertEquals(statusEsperado, obtido);
  } 
}
