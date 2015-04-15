import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;


public class ExercitoElfosTest
{
    @Test
    public void alistaUmElfoCorretamente() {
        
        HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
        Elfo elfonew = new ElfoVerde("Legolas");
        exercito.put(elfonew.getNome(), elfonew);
        
        //act
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        exercitoElfos.alistaElfo(elfonew);
        //assert
        assertEquals(exercito, exercitoElfos.getExercito());
    }
    
    @Test
    public void alistaDoisElfosCorretamente() {
        
        HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
        Elfo elfonew = new ElfoVerde("Legolas");
        Elfo elfonew1= new ElfoNoturno("vamp");
        exercito.put(elfonew.getNome(), elfonew);
        exercito.put(elfonew1.getNome(), elfonew1);
        
        //act
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        exercitoElfos.alistaElfo(elfonew);
        exercitoElfos.alistaElfo(elfonew1);
        //assert
        assertEquals(exercito, exercitoElfos.getExercito());
    }
    
    @Test
    public void buscaUmElfoCorretamenteEntreDois() {
   
        Elfo elfonew = new ElfoVerde("Legolas");
        Elfo elfonew1 = new ElfoNoturno("yaiu");

        //act
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        exercitoElfos.alistaElfo(elfonew);
        exercitoElfos.alistaElfo(elfonew1);
        Elfo elfoRetornado = exercitoElfos.buscarElfo(elfonew.getNome());
  
        //assert
        assertEquals(elfonew, elfoRetornado);
    
    }
    
 
}
