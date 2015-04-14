
/**
 *Classe descreve elfos verdes :v
 * 
 * Arthur Oliveira
 */
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome) {
       super(nome);
    }
    
    public ElfoVerde(String nomeNovo, int flechasNovas)
    {
        super(nomeNovo);
        this.flechas = flechasNovas;
    }
    
    public void atirarFlechaEGanha2DeExperiencia(Orc umOrc) {
       atirarFlecha(umOrc);
       experiencia++;
    }
    
    public void insereSomenteEspadaDeAcoValirianoOuArcoEFlechaDeVidro(ItemDoInventario itemAInserir) {
        String espadaDeAcoValiriano = "Espada de aço valiriano";
        String arcoEFlechaDeVidro = "Arco e Flecha de vidro";
        
        if((itemAInserir.getDescricao()).equalsIgnoreCase(espadaDeAcoValiriano) || (itemAInserir.getDescricao()).equalsIgnoreCase(arcoEFlechaDeVidro)) {
            
            adicionarItemDaLista(itemAInserir);
        }
        }
       
        /*
         * ArrayList<String> itensPermitidos = new ArrayList<String>();
         * itensPermitidos.add("Espada de Aço Valiriano");
         * itensPermitidos.add("Arco e Flecha de Vidro");
         * 
         * boolean itemPermitidos = itemPermitidos.contains("Espada de Aço Valiriano" || itemPermitidos.contains("Arco e Flecha de Vidro"));
         * 
         * if(itemPermitidos) {
         *      adicionarItemDaLista(itemAInserir);
         *  }
         */
        
        /*
         *   private final String[] ITENS_PERMITIDOS = new String[] {
         "Espada de aço valiriano",
         "Arco e Flecha de vidro"
         };
         
          public void adicionarItem(ItemDoInventario item) {
              boolean descricaoValida = item != null && Arrays.asList(ITENS_PERMITIDOS).contains(item.getDescricao());
              if (descricaoValida) { super.adicionarItem(item); 
                }
            }
         */
        
        
    public String toString() {
        return "Elfo Verde: " + super.toString();
    }
        
}
