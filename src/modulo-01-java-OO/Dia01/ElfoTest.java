

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
    public void elfoNasceComNomeInformado() {
    //Arrange
    String nomeEsperado = "Cusco";
    //Act
     Elfo elfoTeste = new Elfo(nomeEsperado);
    //Assert
    assertEquals(nomeEsperado, elfoTeste.getNome());
   
    }
    
    @Test
    public void elfoNasceComNomeEFlechas() {
   
    
    String nomeEsperado = "Cusco";
    int quantidadeFlechasEsperada = 12;
 
    Elfo elfoTeste = new Elfo(nomeEsperado, quantidadeFlechasEsperada);

    assertEquals(nomeEsperado, elfoTeste.getNome());
    assertEquals(quantidadeFlechasEsperada, elfoTeste.getFlechas());
    
    }
    
    
    @Test
    public void ElfoAtiraFlecha()
    {
        Elfo elfoTeste = new Elfo();
        Orc orc = new Orc();
        
        elfoTeste.atirarFlecha(orc);
       
        int flechasEsperadas = 41;
        int resultadoflechas = elfoTeste.getFlechas();
        
        int experienciaEsperada = 1;
        int resultadoExperiencia = elfoTeste.getExperiencia();
        
        assertEquals(resultadoflechas, flechasEsperadas);
        
        assertEquals(resultadoExperiencia, experienciaEsperada);
    }
    
    @Test
    public void ElfoAtiraDuasVezesNoMesmoOrc() {
    
         Elfo elfoTeste = new Elfo();
         Orc orc = new Orc();
           
         elfoTeste.atirarFlecha(orc);
         elfoTeste.atirarFlecha(orc);
         
         
        int flechasEsperadas = 40;
        int resultadoflechas = elfoTeste.getFlechas();
        
        
        int experienciaEsperada = 2;
        int resultadoExperiencia = elfoTeste.getExperiencia();
        
        
        assertEquals(resultadoflechas, flechasEsperadas);
        
        assertEquals(resultadoExperiencia, experienciaEsperada);
        
    }
    
    
    @Test
    public void ElfoAtiraCincoVezesNoMesmoOrc() {
    
         Elfo elfoTeste = new Elfo("Cusco", 4);
         Orc orc = new Orc();
           
         elfoTeste.atirarFlecha(orc);
         elfoTeste.atirarFlecha(orc);
         elfoTeste.atirarFlecha(orc);
         elfoTeste.atirarFlecha(orc);
         elfoTeste.atirarFlecha(orc);
         
         
        int flechasEsperadas = -1;
        int resultadoflechas = elfoTeste.getFlechas();
        
        
        int experienciaEsperada = 5;
        int resultadoExperiencia = elfoTeste.getExperiencia();
        
        
        assertEquals(resultadoflechas, flechasEsperadas);
        
        assertEquals(resultadoExperiencia, experienciaEsperada);
        
    }
    
    
    
    
    
    
    
}
