
/**
 *Classe descreve elfos noturnos :v
 * 
 * Arthur Oliveira
 */
public class ElfoNoturno extends Elfo
{    
    private int cincoPorCentoDaVida = (vida * 5) / 100;
    
    
    public ElfoNoturno(String nomeNovo, int flechasNovas)
    {
        super(nomeNovo);
        Setflechas(flechasNovas);
    }
    
    public void atirarFlechaEGanha3DeExperienciaEPerdeCincoPorCentoDeVida(Orc umOrc) {
       atirarFlecha(umOrc);
       experiencia++;
       experiencia++;
       
       vida = vida - cincoPorCentoDaVida;
       
    }
}
