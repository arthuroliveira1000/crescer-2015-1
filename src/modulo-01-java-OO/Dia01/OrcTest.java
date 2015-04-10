import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A classe de teste OrcTest.
 *
 * @author  Arthur Oliveira 
 */
public class OrcTest
{
   
    @Test
    public void OrcTem3ItensNaListaEEstaoTodosOrdenados() {
    
        Orc orc = new Orc();
        
        ItemDoInventario item0 = new ItemDoInventario("Espada de Diamantes", 3);
        ItemDoInventario item1 = new ItemDoInventario("Espada de Ferro", 1);
        ItemDoInventario item2 = new ItemDoInventario("Espada de BeyBlade",2);
            
        orc.adicionarItemDaLista(item0);
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
         
        orc.ordenarItens();
       
        assertEquals(item1, orc.getlistaDeItens().get(0));
        assertEquals(item2, orc.getlistaDeItens().get(1));
        assertEquals(item0, orc.getlistaDeItens().get(2));
    
    }
    
    @Test
    public void OrcTem3ItensNaListaSendoQueDoisTemAMesmaQuantidade() {
    
        Orc orc = new Orc();
        //Arrange - Montagem dos dados de teste
        ItemDoInventario item0 = new ItemDoInventario("Espada de Diamantes", 2);
        ItemDoInventario item1 = new ItemDoInventario("Espada de Ferro", 1);
        ItemDoInventario item2 = new ItemDoInventario("Espada de BeyBlade", 18);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade", 1);
            
        orc.adicionarItemDaLista(item0);
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
        orc.adicionarItemDaLista(item3);
        //Act - execução da ação do teste
        orc.ordenarItens();
        //Assert - teste em si
        assertEquals(item1, orc.getlistaDeItens().get(0));
        assertEquals(item3, orc.getlistaDeItens().get(1));
        assertEquals(item0, orc.getlistaDeItens().get(2));
        assertEquals(item2, orc.getlistaDeItens().get(3));
    
    }
    
    @Test
    public void OrcTem5ItensNaListaSendoQueDoisTemAMesmaQuantidadeEDoisSaoNegativos() {
    
        Orc orc = new Orc();
        //Arrange - Montagem dos dados de teste
        ItemDoInventario item0 = new ItemDoInventario("Espada de Diamantes", 15);
        ItemDoInventario item1 = new ItemDoInventario("Espada de Ferro", 15);
        ItemDoInventario item2 = new ItemDoInventario("Espada de BeyBlade", -2);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade", -5);
        ItemDoInventario item4 = new ItemDoInventario("Espada de BeyBlade", 3);
            
        orc.adicionarItemDaLista(item0);
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
        orc.adicionarItemDaLista(item3);
        orc.adicionarItemDaLista(item4);
        //Act - execução da ação do teste
        orc.ordenarItens();
        //Assert - teste em si
        assertEquals(item3, orc.getlistaDeItens().get(0));
        assertEquals(item2, orc.getlistaDeItens().get(1));
        assertEquals(item4, orc.getlistaDeItens().get(2));
        assertEquals(item0, orc.getlistaDeItens().get(3));
        assertEquals(item1, orc.getlistaDeItens().get(4));
    
    }
    
    @Test
    public void OrcUmItemNaLista() {
    
        //Arrange - Montagem dos dados de teste
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Espada de BeyBlade", 2);
        orc.adicionarItemDaLista(item1);
        
        
        //Act - execução da ação do teste
        orc.ordenarItens();
        //Assert - teste em si
        assertEquals(item1, orc.getlistaDeItens().get(0));
    
    }
    
    @Test
    public void OrcNaoTemNenhumItemNaLista() {
        //Arrange - Montagem dos dados de teste
        Orc orc = new Orc();
         ArrayList<ItemDoInventario> listaTeste = new ArrayList<>();
        //Act - execução da ação do teste
        orc.ordenarItens();
        //Assert - teste em si
        assertEquals(listaTeste, orc.getlistaDeItens());
    }
    
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nomaooooooo");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nomaooooooo");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nomaooooooo");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nomaooooooo");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = -10;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc("Nomaooooooo");
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Nomaooooooo");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Nomaooooooo");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: -10";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroMenorQue0() {
    
        Orc orc = new Orc("Nomin");
        
        orc.recebeAtaque();
        
        int ExperienciaEsperada = 2;
        int VidaEsperada =  110;
        int ExperienciaObtida = orc.getExperiencia();
        int vidaObtida = orc.getVida();
        
        assertEquals(ExperienciaEsperada, ExperienciaObtida);
        assertEquals(VidaEsperada, vidaObtida);

    }
    
    @Test
    public void orcRecebeAtaqueEntre0E100() {
        
        Orc orc = new Orc("Nomiee");
        
        orc.setExperiencia(1);
        orc.recebeAtaque();
       
        
        int ExperienciaEsperada = 1;
        int VidaEsperada =  110;
        int ExperienciaObtida = orc.getExperiencia();
        int vidaObtida = orc.getVida();
        
        assertEquals(ExperienciaEsperada, ExperienciaObtida);
        assertEquals(VidaEsperada, vidaObtida);
    
        
    }
    
    @Test
    public void orcRecebeAtaqueMaior100() {
        
        Orc orc = new Orc("Nomiee");
        
        orc.setExperiencia(0);
        orc.recebeAtaque();
       
        
        int ExperienciaEsperada = 0;
        int VidaEsperada =  100;
        int ExperienciaObtida = orc.getExperiencia();
        int vidaObtida = orc.getVida();
        
        assertEquals(ExperienciaEsperada, ExperienciaObtida);
        assertEquals(VidaEsperada, vidaObtida);
    
        
    }
    
    @Test
    public void orcConseguePerder1ItemDoInventario() {
        
       Orc orc = new Orc();
       ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 1);
       ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 2);
        
       orc.adicionarItemDaLista(item1);
       orc.adicionarItemDaLista(item2);
       
       orc.removerItemDaLista(item2);
       assertEquals(1, orc.getlistaDeItens().size());      
    }
    
    @Test
    public void orcConsegueAdicionar2ItensDoInventarioComDescricaoEQuantidadeCorretos() {
    
         Orc orc = new Orc();
         ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 1);
         ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 2);
         
         ArrayList<ItemDoInventario> listaDeItensParaComparar = new ArrayList<ItemDoInventario>();
         listaDeItensParaComparar.add(item1);
         listaDeItensParaComparar.add(item2);
         
         orc.adicionarItemDaLista(item1);
         orc.adicionarItemDaLista(item2);
        
         assertEquals(orc.getlistaDeItens().get(0), listaDeItensParaComparar.get(0));
         assertEquals(orc.getlistaDeItens().get(1), listaDeItensParaComparar.get(1));
        
        }
        
    @Test
    public void Lista2ItensCorretamente() {
    
         Orc orc = new Orc();
         ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 1);
         ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 2);
         
         orc.adicionarItemDaLista(item1);
         orc.adicionarItemDaLista(item2);
         
         String resultadoEsperado = "Espada de Diamantes,Espada de Ferro";
         
         assertEquals(resultadoEsperado, orc.getDescricoesItens());
    }
    
    @Test 
    public void inseriTresItensNaListaERetornaOitem2QueTemAMaiorQuantidade() {
    
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 1);
        ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 3);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade",2);
        
         orc.adicionarItemDaLista(item1);
         orc.adicionarItemDaLista(item2);
         orc.adicionarItemDaLista(item3);
    
         assertEquals(item2, orc.getItemComMaiorQuantidade());
    }
    
   
    
    @Test 
    public void inseriQuatroItensNaListaERetornaitem1QueTemAMaiorQuantidade() {
    
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 10);
        ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 5);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade",2);
        ItemDoInventario item4 = new ItemDoInventario("Espada de seila",4);
        
         orc.adicionarItemDaLista(item1);
         orc.adicionarItemDaLista(item2);
         orc.adicionarItemDaLista(item3);
         orc.adicionarItemDaLista(item4);
    
         assertEquals(item1, orc.getItemComMaiorQuantidade());
    }
    
    @Test 
    public void inseriCincoItensNaListaERetornaitem5QueTemAMaiorQuantidade() {
    
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 15);
        ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 2);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade",17);
        ItemDoInventario item4 = new ItemDoInventario("Espada de seila",9);
        ItemDoInventario item5 = new ItemDoInventario("Espada de vaisaber",18);
        
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
        orc.adicionarItemDaLista(item3);
        orc.adicionarItemDaLista(item4);
        orc.adicionarItemDaLista(item5);
    
        assertEquals(item5, orc.getItemComMaiorQuantidade());
    }
    
    @Test 
    public void inseriCincoItensNaListaComDoisComQuantidadesIguaisERetornaUmDosItensQueTemAMaiorQuantidade() {
    
        Orc orc = new Orc();
        ItemDoInventario item1 = new ItemDoInventario("Espada de Diamantes", 1);
        ItemDoInventario item2 = new ItemDoInventario("Espada de Ferro", 2);
        ItemDoInventario item3 = new ItemDoInventario("Espada de BeyBlade",18);
        ItemDoInventario item4 = new ItemDoInventario("Espada de seila",9);
        ItemDoInventario item5 = new ItemDoInventario("Espada de vaisaber",18);
        
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
        orc.adicionarItemDaLista(item3);
        orc.adicionarItemDaLista(item4);
        orc.adicionarItemDaLista(item5);
   
        //retorna o primeiro item com quantidade maior pq meu if só muda para o outro se for maior, como não é maior fica o primeiro mesmo
        assertEquals(item3, orc.getItemComMaiorQuantidade());
    }
    
    
    @Test
    public void ListaVaziaEMetodoGetItemComMaiorQuantidadeRetornaNulo() {
        //Arrange
        Orc orc = new Orc();
        //Act
        ItemDoInventario esperado = null;
        //Assert
        
        ItemDoInventario resultado =  orc.getItemComMaiorQuantidade();
        assertEquals(esperado, resultado);
    
    }
    
    
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc orc = new Orc();
        orc.setStatus(Status.DORMINDO);
        orc.setExperiencia(3);
        ItemDoInventario item1 = new ItemDoInventario("Poção de mana", 3);
        ItemDoInventario item2 = new ItemDoInventario("Poção Lança", 1);
        
        orc.adicionarItemDaLista(item1);
        orc.adicionarItemDaLista(item2);
        // Act
        orc.tentaSorte();
        // Assert
        ItemDoInventario pocaoTeste = orc.getlistaDeItens().get(0);
        ItemDoInventario lancaTeste = orc.getlistaDeItens().get(1);
        
        
        assertEquals(1003, pocaoTeste.getQuantidade());
        assertEquals(1001, lancaTeste.getQuantidade());
    }
  
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario item1 = new ItemDoInventario("Poção de mana", 3);
        ItemDoInventario item2 = new ItemDoInventario("Poção Lança", 1);
        
        urukhai.adicionarItemDaLista(item1);
        urukhai.adicionarItemDaLista(item2);
        // Act
        urukhai.tentaSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getlistaDeItens().get(0);
        ItemDoInventario lanca = urukhai.getlistaDeItens().get(1);
        
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }  
}




