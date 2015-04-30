import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaPriorizandoElfosVerdesTest
{
    @Test
    public void exercitoEmbaralhadoPriorizaAtaqueComElfosVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.mudaDeEstrategia(new EstrategiaPriorizandoElfosVerdes());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo green1 = new ElfoVerde("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
        Elfo green2 = new ElfoVerde("Green 2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(night3);
        exercito.alistaElfo(green2);
        ArrayList<Elfo> esperado = new ArrayList<>(
               Arrays.asList(green2, green1, night1, night2, night3)
               // Arrays.asList(green2, green1, night3, night2, night1)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
   
    @Test
    public void exercitoSóDeVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitoElfos exercito = new ExercitoElfos();
       exercito.mudaDeEstrategia(new EstrategiaPriorizandoElfosVerdes());
        Elfo green1 = new ElfoVerde("Green 1");
        Elfo green2 = new ElfoVerde("Green 2");
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(green2, green1)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}