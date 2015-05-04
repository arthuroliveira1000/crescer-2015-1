
/**
 *Classe descreve elfos noturnos :v
 * 
 * Arthur Oliveira
 */
public class ElfoNoturno extends Elfo
{        
    public ElfoNoturno(String nome) {
       super(nome);
    }
    
    public ElfoNoturno(String nomeNovo, int flechasNovas)
    {
        super(nomeNovo);
        this.flechas = flechasNovas;
    }
    
    public void atirarFlecha(Orc umOrc) {
       
         super.atirarFlecha(umOrc);
         this.experiencia += 2;
         double qtdVidaAPerder = this.vida * 0.05;
         //double qtdVidaAPerder = this.vida * 5/100;
         this.vida -= qtdVidaAPerder;
         
         this.status = (int)this.vida == 0 ? Status.MORTO : this.status;
    }
   
    public String toString() {
        return "Elfo Noturno: " + super.toString();
    }
}
