import java.util.HashMap;
import java.util.Map;
/**
 * Cria um exercito de elfos
 * 
 * @author Arthur Oliveira
 * 
 */
public class ExercitoElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
    
    public HashMap<String, Elfo> getExercito() {
        
        return this.exercito;
    }
    
    public void alistaElfo(Elfo elfo) {
    
        boolean ElfoisGreenOrNoturno = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        // para ver se uma classe pertence a outra
        if(ElfoisGreenOrNoturno) {
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public Elfo buscarElfo(String nome) {
    
        return exercito.get(nome);
    }
    
    public void buscaElfoPorStatus(Status status) {
        
        for(String key: exercito.keySet()) {
        
        if((exercito.get(key).getStatus()).equals(status)) {
            System.out.println(exercito.get(key));
        }
        }
    }
    
    
 
}
