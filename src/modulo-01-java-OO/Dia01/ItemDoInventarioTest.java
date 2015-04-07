import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemDoInventarioTest.
 *
 * @author  Arthur Oliveira
 * @version (a version number or a date)
 */
public class ItemDoInventarioTest
{
   @Test
    public void ItemDoInventarioComDescricaoEQuantidade()
    {
        String descricaoColocada = "arma foda";
        int quantidadeColocada = 1;
        
        ItemDoInventario item = new ItemDoInventario(descricaoColocada, quantidadeColocada);
        
        assertEquals(descricaoColocada, item.getDescricao());
        assertEquals(quantidadeColocada, item.getQuantidade());

    }
        
    @Test
    public void ItemDoInventarioComDescricaoNuçaEQuantidadeNegativa()
    {
        String descricaoColocada = null;
        int quantidadeColocada = - 1;
        
        ItemDoInventario item = new ItemDoInventario(descricaoColocada, quantidadeColocada);
        
        assertEquals(descricaoColocada, item.getDescricao());
        assertEquals(quantidadeColocada, item.getQuantidade());
    
    }
}
