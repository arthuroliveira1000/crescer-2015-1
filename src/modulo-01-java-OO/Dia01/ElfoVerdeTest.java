import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  Arthur Oliveira
 */
public class ElfoVerdeTest
{
  @Test
  public void elfoVerdeNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
  @Test
  public void elfoVerdeNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
  @Test
  public void elfoVerdeNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
  @Test
  public void elfoVerdeAtiraFlechaEmUmOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas", 42);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
  @Test
  public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas", 42);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 4;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
  @Test
  public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 10;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }  
    
  @Test
  public void elfoVerdeConsegueinserirSomenteEspadaDeAcoValirianoOuArcoEFlechaDeVidro() {
    
         ElfoVerde elfoverde = new ElfoVerde("sextafeirauhu", 42);
         ItemDoInventario espadaDeAcoValiriano = new ItemDoInventario("Espada de aço valiriano", 1);
         ItemDoInventario ArcoEFlechaDeVidro = new ItemDoInventario("Arco e Flecha de vidro", 2);
         
         ArrayList<ItemDoInventario> listaDeItensParaComparar = new ArrayList<>();
         listaDeItensParaComparar.add(espadaDeAcoValiriano);
         listaDeItensParaComparar.add(ArcoEFlechaDeVidro);
         
         elfoverde.insereSomenteEspadaDeAcoValirianoOuArcoEFlechaDeVidro(espadaDeAcoValiriano);
         elfoverde.insereSomenteEspadaDeAcoValirianoOuArcoEFlechaDeVidro(ArcoEFlechaDeVidro);
        
         assertEquals(elfoverde.getlistaDeItens().get(0), listaDeItensParaComparar.get(0));
         assertEquals(elfoverde.getlistaDeItens().get(1), listaDeItensParaComparar.get(1));
         
        }
  
  @Test
  public void elfoVerdeNaoAdicionaItemSeNaoForUmaEspadaDeAcoValirianoOuArcoEFlechaDeVidro() {
     
         ElfoVerde elfoverde = new ElfoVerde("sextafeirauhu", 42);
   
         ArrayList<ItemDoInventario> listaDeItensParaComparar = new ArrayList<>();
         
         assertEquals(listaDeItensParaComparar, elfoverde.getlistaDeItens());
        }
    
    
    }

