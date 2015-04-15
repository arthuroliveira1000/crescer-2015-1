import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class ExercitoElfosTest
{
    @Test
    public void alistaUmElfoCorretamente() {
        
        HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
        Elfo elfonew = new ElfoVerde("Legolas");
        exercito.put(elfonew.getNome(), elfonew);
        
        //act
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        try {
            exercitoElfos.alistaElfo(elfonew);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        } finally {
            System.out.println("depois do catch(se tiver), cai no finally");
        }
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
        try {
            exercitoElfos.alistaElfo(elfonew);
            exercitoElfos.alistaElfo(elfonew1);
        } catch (NaoPodeAlistarException error) {
            System.out.println(error);
        }
        //assert
        assertEquals(exercito, exercitoElfos.getExercito());
    }
    
    @Test
    public void buscaUmElfoCorretamenteEntreDois() {
   
        Elfo elfonew = new ElfoVerde("Legolas");
        Elfo elfonew1 = new ElfoNoturno("yaiu");

        //act
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        try {
            exercitoElfos.alistaElfo(elfonew);
            exercitoElfos.alistaElfo(elfonew1);
        } catch (NaoPodeAlistarException error){
            System.out.println(error);
        }
        Elfo elfoRetornado = exercitoElfos.buscarElfo(elfonew.getNome());
  
        //assert
        assertEquals(elfonew, elfoRetornado);
    }
    
    @Test
    public void agrupaVariosElfosPorStatus() {
        
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        
       
        esperado.put(Status.ATACANDO, new ArrayList<>(Arrays.asList(elfoAtacando1, elfoAtacando2)));
        
        esperado.put(Status.VIVO, new ArrayList<>(Arrays.asList(elfoVivo2, elfoVivo3, elfoVivo1)));
        
        ExercitoElfos exercitoElfos = new ExercitoElfos();
        
        try {
            exercitoElfos.alistaElfo(elfoAtacando1);
            exercitoElfos.alistaElfo(elfoAtacando2);
            exercitoElfos.alistaElfo(elfoVivo1);
            exercitoElfos.alistaElfo(elfoVivo2);
            exercitoElfos.alistaElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error){
            System.out.println(error); 
        }
        //ACT
        exercitoElfos.agruparPorStatus();
        
        HashMap<Status, ArrayList<Elfo>> resultado = exercitoElfos.getPorStatus();
        //assert
        assertEquals(esperado, resultado); 
    }
    
    @Test
    public void buscaPorStatusAtacandoComVariosElfos() {
        
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoVerde elfoAtacando1 = new ElfoVerde("Green 2");
        ElfoVerde elfoAtacando2 = new ElfoVerde("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(elfoAtacando1, elfoAtacando2));
        
        ExercitoElfos exercito = new ExercitoElfos();
        try {
            exercito.alistaElfo(elfoAtacando1);
            exercito.alistaElfo(elfoAtacando2);
            exercito.alistaElfo(elfoVivo1);
            exercito.alistaElfo(elfoVivo2);
            exercito.alistaElfo(elfoVivo3);
        } catch (NaoPodeAlistarException error){
            System.out.println(error);
        }
        //ACT
        ArrayList<Elfo> resultado = exercito.buscarElfo(Status.ATACANDO);
        
        //assert
        assertEquals(esperado, resultado);
    }
    /*
    @Test(expected=NaoPodeAlistarException.class)
    public void alistarElfoBaseLançaErro() throws NaoPodeAlistarException {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        try {
            exercito.alistar(elfo);
        } catch (NaoPodeAlistarException error) {
            throw error;
        }
    }
    */
 }