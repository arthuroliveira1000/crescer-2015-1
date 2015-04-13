
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
    
    public void atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(Orc umOrc) {
       
       double cincoPorCentoDaVida = (int) (vida * 5) / 100;
        
       atirarFlecha(umOrc);
       experiencia += 2;
       
       vida -= cincoPorCentoDaVida;
       
       if(vida == 0) {
           atualizaStatus();
        }     
    }
}
