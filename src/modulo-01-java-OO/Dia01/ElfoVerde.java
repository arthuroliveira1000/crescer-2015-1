
/**
 *Classe descreve elfos verdes :v
 * 
 * Arthur Oliveira
 */
public class ElfoVerde extends Elfo
{    
    public ElfoVerde(String nomeNovo, int flechasNovas)
    {
        super(nomeNovo, 0);
        Setflechas(flechasNovas);
    }
    
    public void atirarFlechaEGanha2DeExperiencia(Orc umOrc) {
       atirarFlecha(umOrc);
       experiencia++;
    }
    
    public void insereSomenteEspadaDeAcoValirianoOuArcoEFlechaDeVidro(ItemDoInventario itemAInserir) {
        String espadaDeAcoValiriano = "Espada de aço valiriano";
        String arcoEFlechaDeVidro = "Arco e Flecha de vidro";
        
        if((itemAInserir.getDescricao()).equals(espadaDeAcoValiriano) || (itemAInserir.getDescricao()).equals(arcoEFlechaDeVidro)) {
            
            adicionarItemDaLista(itemAInserir);
        }
        }
}
