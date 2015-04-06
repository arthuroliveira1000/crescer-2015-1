

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcTest
{
   @Test
   public void orcNasceCom110Vida() {
    // Arrange - Montagem dos dados de test
     Orc orc = new Orc();
    // Act - execução da ação de testes
    orc.getVida();
    // Assert - verificação se o resultado é o esperado
    int esperado = 110;
    int resultadoObtido = orc.getVida();
    
    assertEquals(resultadoObtido, esperado);
   
       
    }
    
}
