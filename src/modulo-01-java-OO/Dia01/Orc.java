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
        super(nome, 110);
    }  
    
    public Orc() {
        this("");
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

    public void adicionandoStatusAoOrc() {   
           if(this.vida == 0) {
               status = Status.MORTO;
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
}