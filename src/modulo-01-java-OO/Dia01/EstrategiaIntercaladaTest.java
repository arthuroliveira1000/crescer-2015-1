import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaIntercaladaTest
{
    @Test
    public void exercitoIntercaladoComeçandoComElfoVerde() throws NaoPodeAlistarException {
        // Arrange
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo green1 = new ElfoVerde("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
        Elfo green2 = new ElfoVerde("Green 2");
        Elfo green3 = new ElfoVerde("Green 3");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(night3);
        exercito.alistaElfo(green2);
        exercito.alistaElfo(green3);
        ArrayList<Elfo> esperado = new ArrayList<>(
             Arrays.asList(green2, night1, green3, night2, green1, night3)
             //Arrays.asList(night3, green2, night1, green1, night2, green3)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void exercitoIntercaladoComeçandoComElfoNoturno() throws NaoPodeAlistarException {
        // Arrange
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");
        Elfo green2 = new ElfoVerde("Green 2");
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(night2, green1, night1, green2)
            //Arrays.asList(night1, green2, night2, green1)
            
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void exercitoDesproporcionalNãoAtaca() throws NaoPodeAlistarException {
        // Arrange
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.mudaDeEstrategia(new EstrategiaIntercalada());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfoVerde("Elfo Verde 1");
        exercito.alistaElfo(green1);
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        ArrayList<Elfo> esperado = new ArrayList<>();
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }
}