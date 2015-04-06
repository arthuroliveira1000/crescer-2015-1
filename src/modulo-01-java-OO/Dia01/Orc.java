
/**
 * Write a description of class Orcs here.
 * 
 * @author Arthur Oliveira 
 * @version (a version number or a date)
 */
public class Orc
{
    // instance variables - replace the example below with your own
    private int vida;

    {
    vida = 110;
    }
    
    public Orc() {
        
    }
    
    
    public int getVida() {
            return vida;
        }   

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void recebeAtaque() {
      this.vida -= 10;  
    }
}
