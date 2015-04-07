/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110, experiencia;
    private Status status;
    private String nome;
   

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
      Construtor para objetos da classe Orc vazio pq estava dando erro nas outras classes onde criava um orc e não passava nenhum parametro
   **/ 
   public Orc() {
 
   }
    
    
    /**
      Construtor para objetos da classe Orc com nome 
   **/
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
   
   public void adicionandoStatusAoOrc() {
       
       if(this.vida == 0) {
           status = Status.MORTO;
    }
   
}
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        
        if(this.gerarNumero() < 0) {
            //this.vida -= 10;
            // this.vida = this.vida - 10;
            this.experiencia += 2;
        } if(this.gerarNumero() >= 0 && this.gerarNumero() <= 100) {
            // nada acontece
            //this.vida -= 10;
            //this.experiencia = this.experiencia + 2;
        } else {
            this.vida -= 10;
        }
    }
    
    private double gerarNumero() {
        double numeroMagico = 0.0;
      
            // B
        if(this.vida >= 30 && this.vida <= 60) {
          numeroMagico *= 2;
        } else if(this.vida < 20) {
            numeroMagico *= 3;
            //C
        } if(status == Status.FUGINDO) {
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
            //A
            // booelan possuiNomeComMaisDe%Caracteres = this.nome != nukkk && this.nome.length() > 5;
            if(this.nome != null && this.nome.length() > 5) {
                numeroMagico += 65;
            } else {
                numeroMagico -= 60;
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