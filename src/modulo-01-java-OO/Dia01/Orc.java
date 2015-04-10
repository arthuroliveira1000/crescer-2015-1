/**
 * Define objetos do tipo Orc
 * 
 * @author Arthur Oliveira 
 */

import java.util.ArrayList;
import java.util.Arrays;


public class Orc extends Personagem 
{
    private final int NUMERO_SORTE = 3481;

   public Orc(String nome) {
       super("", 110);
   }  
    
    /**
     * Construtor para objetos da classe Orc vazio pq estava dando erro nas outras classes onde criava um orc e não passava nenhum parametro
   */
   public Orc() {
       this("");
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
    

  public void setStatus(Status novoStatus) {
        status = novoStatus;
    }
   
  public int getExperiencia() {
        return this.experiencia;
    }
}