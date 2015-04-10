/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Orc
{
    private int vida = 110, experiencia;
    private Status status;
    private String nome;
    ArrayList<ItemDoInventario> listaDeItens = new ArrayList<>();
    private final int NUMERO_SORTE = 3481;

 
    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
    public Orc()
    {
        //vida = 110;
    }
    **/
    
    /**
     * Construtor para objetos da classe Orc vazio pq estava dando erro nas outras classes onde criava um orc e não passava nenhum parametro
   */
   public Orc() {
 
   }
    
    
    /**
     *   Construtor para objetos da classe Orc com nome 
   */
   public Orc(String nome) {
        this.nome = nome;
   } 
    
   /**
      Construtor para objetos da classe Orc com nome e experiencia
   **/
   public Orc(String nome, int experiencia) {
        this.nome = nome;
        this.experiencia = experiencia;
   } 
   
  /**
   * MÉTODO ORDENA OS ITENS QUE O ORC TEM
   * 
   * for para percorrer o arrayList, caso a quantidade de determinado item for maior que a do anterior
   * o itemAnterior recebe o itematual e o itematual se torna o anterior
   * itemAnterior = itemAtual
   * itematual = itemAuxiliar(itemAnterior)
   * 
   */
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
    }
   
   /**
    * CASO ORC TENHA SORTE --> GANHAR 1000 UNIDADES DE CADA ITEM EM SEU INVENTARIO;
    */ 
   
   public void tentaSorte() {
        double numeroGerado = gerarNumero();
        
        if (numeroGerado == NUMERO_SORTE) {
            for (ItemDoInventario item : this.listaDeItens) {
                int novaQuantidadeItem = item.getQuantidade() + 1000;
                item.setQuantidade(novaQuantidadeItem);
            }
        }
        
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
   
   public void adicionandoStatusAoOrc() {   
           if(this.vida == 0) {
               status = Status.MORTO;
        }
    }
    
    public void recebeAtaque() {
        if(this.gerarNumero() < 0) {
            //this.vida -= 10;
            // this.vida = this.vida - 10;
            this.experiencia += 2;
        } else if(this.gerarNumero() > 100){
            this.vida -= 10;
            this.status = Status.FERIDO;
        }
    }
    
    private double gerarNumero() {
        double numeroMagico = 0.0;
         //A
            // booelan possuiNomeComMaisDe%Caracteres = this.nome != nukkk && this.nome.length() > 5;
        if(this.nome != null && this.nome.length() > 5) {
            numeroMagico += 65;
        } else {
            numeroMagico -= 60;
        }
        
        // B
        if(this.vida >= 30 && this.vida <= 60) {
          numeroMagico *= 2;
        } else if(this.vida < 20) {
            numeroMagico *= 3;
            //C
        } 
        
        if(status == Status.FUGINDO) {
            numeroMagico /= 2;
        } else if((status == Status.CAÇANDO) || (status == Status.DORMINDO)) {
            numeroMagico += 1;
        }
        //D
         if(this.experiencia % 2 == 0) {
            numeroMagico = numeroMagico * numeroMagico * numeroMagico;
        } else if(this.experiencia % 2 != 0 && this.experiencia > 2) {
            numeroMagico = numeroMagico * numeroMagico;
        } 
           
        return numeroMagico;
   }
 
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
    
      public int getVida() {
        return this.vida;
    }
    
    public ArrayList<ItemDoInventario> getlistaDeItens() {
        return this.listaDeItens;
    }
    
    public void setStatus(Status novoStatus) {
        status = novoStatus;
    }
    
    public void setVida(int novaVida) {
            vida = novaVida;
    }
    
    public String getNome() {
        return this.nome;
    }
    
      public int getExperiencia() {
        return this.experiencia;
    }
    
    public void setNome(String nomeNovo) {
        nome = nomeNovo;
    }
    
    public void setExperiencia(int experienciaNova) {
        experiencia = experienciaNova;
    }
    
}