import java.util.ArrayList;

/**
 * Classe Personagem que generaliza os mesmos
 * 
 * @author Arthur Oliveira
 */
public class Personagem
{
    // instance variables [
    
    protected Status status = Status.VIVO;
    protected int vida;
    protected String nome;
    protected int experiencia;
    ArrayList<ItemDoInventario> listaDeItens = new ArrayList<>();
    
    protected Personagem(String nome, int vida) 
    {
        this.nome = nome;
        this.vida = vida;
    }
    
    protected Status getStatus()
    {
        return status;
    }
    ///// GETS //////
    protected int getVida() 
    {
        return vida;
    }
    
    protected String getNome() 
    {
        return nome;
    }
    
    protected int getExperiencia() 
    {
        return experiencia;
    }
    
    protected void setExperiencia(int novaExperiencia) 
    {
        this.experiencia = novaExperiencia;
    }
    
    public void setStatus(Status novoStatus) {
        status = novoStatus;
    }
    
    public ArrayList<ItemDoInventario> getlistaDeItens() {
        return this.listaDeItens;
    }
    
    public void adicionarItemDaLista(ItemDoInventario i) {
       
      listaDeItens.add(i);
       
       //int tamanhoLista = listaDeItens.size();
       //return tamanhoLista; 
    }

   public void removerItemDaLista(ItemDoInventario i) {
       
       listaDeItens.remove(i);
       
       //int tamanhoLista = listaDeItens.size();
       //return tamanhoLista; 
   }
   
    /**
    * Concatena as informações SEM ESPAÇO E SEM PONTO FINAL
    * 
    * "adaga,escudo,bracelete"
    */

   public String getDescricoesItens()  {
       
       StringBuilder builder = new StringBuilder();
       int tamanhoLista = listaDeItens.size();
             
       for(int x = 0; x < tamanhoLista; x++) {
           builder.append(listaDeItens.get(x).getDescricao());
           builder.append(x != (tamanhoLista - 1) ? "," : "");    
           //System.out.println(listaDeItens.get(x).getDescricao());
        }

       return builder.toString();
       
                                       /*
                                + * Utilizando for tradicional
                                + int numeroDeItens = this.itens.size();
                                +
                                + for (int i = 0; i < numeroDeItens; i++) {
                                + ItemDoInventario itemAtual = this.itens.get(i);
                                +
                                + boolean éÚltimoÍndice = i == numeroDeItens - 1;
                                +
                                + builder.append(
                                + éÚltimoÍndice ?
                                + itemAtual.getDescricao() :
                                + itemAtual.getDescricao() + ","
                                + );
                                + }
                                + */
                                
                                 // C#
                                 //foreach (ItemDoInventario item in this.itens) { }
                                
                                /*
                                + * Utilizando FOREACH!!
                                + for (ItemDoInventario itemAtual : this.itens) {
                                + int i = this.itens.indexOf(itemAtual);
                                + int numeroDeItens = this.itens.size();
                                + boolean éÚltimoÍndice = i == numeroDeItens - 1;
                                +
                                + builder.append(
                                + éÚltimoÍndice ?
                                + itemAtual.getDescricao() :
                                + itemAtual.getDescricao() + ","
                                + );
                                + }
                                + */
                                
                                 /*
                                + * JavaScript
                                + for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
                                + }
                                + */
                                
                                 /*
                                + * WHILE (ENQUANTO)
                                + int i = 0;
                                + int numeroDeItens = this.itens.size();
                                +
                                + while (i < numeroDeItens) {
                                + ItemDoInventario itemAtual = this.itens.get(i);
                                + boolean éÚltimoÍndice = i == numeroDeItens - 1;
                                +
                                + builder.append(
                                + éÚltimoÍndice ?
                                + itemAtual.getDescricao() :
                                + itemAtual.getDescricao() + ","
                                + );
                                + //
                                + i++;
                                + }
                                + */
    }

    
   public ItemDoInventario getItemComMaiorQuantidade(){
       
       ItemDoInventario itemMaiorQuantidade = null;
        
       boolean temItens = !this.listaDeItens.isEmpty();
       if (temItens) {
       itemMaiorQuantidade = this.listaDeItens.get(0);
        
       for (int i = 1; i < this.listaDeItens.size(); i++) {
         ItemDoInventario itemAtual = this.listaDeItens.get(i);
         boolean encontreiAMaiorQuantidade =
         itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
        
         if (encontreiAMaiorQuantidade) {
         // atualizar a minha referência para o maior parcial
         itemMaiorQuantidade = itemAtual;
         }
         }
        }
        
         return itemMaiorQuantidade;
   }
   
   public void ordenarItens() {
       if(this.listaDeItens.size() > 1) {
        
           ItemDoInventario itemAuxiliarContendoItemAtual;
           ItemDoInventario proximoItem;
           int indexItemAnterior;
           
           
           for(int y = 0; y < listaDeItens.size(); y++) {
                   //No bubblesort, compara-se o itematual[x] com o proximoitem[x + 1]
                   // Desta forma, se o laço for até a última posição do vetor, ele irá comparar com um valor que não existe, 
                   //e conseqüentemente irá retornar mensagem de erro.
                   for(int x = 0; x < (listaDeItens.size() - 1); x++) {
                       //SE O ITEM ATUAL TEM A QUANTIDADE MAIOR QUE A DO PROXIMO ITEM, ENTÃO TROCA DE POSIÇÃO
                      
                           itemAuxiliarContendoItemAtual = this.listaDeItens.get(x);
                           proximoItem = this.listaDeItens.get(x + 1);
                       
                       if(this.listaDeItens.get(x).getQuantidade() > this.listaDeItens.get(x + 1).getQuantidade() ) {
                           this.listaDeItens.set(x, proximoItem);// ITEM ATUAL = PROXIMO ITEM
                           this.listaDeItens.set(x + 1, itemAuxiliarContendoItemAtual); // PROXIMO ITEM = ITEMATUAL
                    }
                }
            }
        }
   } 
   
   
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
