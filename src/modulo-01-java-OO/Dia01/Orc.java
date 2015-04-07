/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status;
    private String nome;
    private int experiencia;

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
        this.vida -= 10;
        // this.vida = this.vida - 10;
    }
    
    private int gerarNumero() {
        
        int numeroMagico = 0;
      
        
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
}