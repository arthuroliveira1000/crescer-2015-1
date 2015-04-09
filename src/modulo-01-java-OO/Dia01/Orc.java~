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
    ArrayList<ItemDoInventario> listaDeItens = new ArrayList<ItemDoInventario>();
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
   * MÉTODO RETORNA O ITEM COM MAIOR QUANTIDADE
   */
   
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
       
       
       /*
       int maiorQuantidade = listaDeItens.get(0).getQuantidade();
       
       ItemDoInventario itemComMaiorQuantidade = null;
      
       int tamanhoDaLista = listaDeItens.size();
       
       if(this.listaDeItens.isEmpty() == false) {
           
           itemComMaiorQuantidade =  listaDeItens.get(0);
           
           for(int x = 1; x < tamanhoDaLista; x++) {
           if(listaDeItens.get(x).getQuantidade() > maiorQuantidade) {
               maiorQuantidade = listaDeItens.get(x).getQuantidade();
               itemComMaiorQuantidade = listaDeItens.get(x);
            }   
        }
        
            return itemComMaiorQuantidade;
        
        } else {
           
            return itemComMaiorQuantidade;
        }
}*/
   
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