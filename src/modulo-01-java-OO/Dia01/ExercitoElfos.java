import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Cria um exercito de elfos
 * 
 * @author Arthur Oliveira
 * 
 */
public class ExercitoElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
    
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito() {
        
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getPorStatus() {
        agruparPorStatus();
        return this.porStatus;
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
    
    public ArrayList<Elfo> buscarElfo(Status status) {
        agruparPorStatus();
        return porStatus.get(status);
    }
    
    
    
    public void  agruparPorStatus() {
        
        porStatus.clear();
        
        //entryset - > par com chave e valor 
        for(Map.Entry<String, Elfo> parChaveValor: exercito.entrySet()) {
        
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            
            if (porStatus.containsKey(status)) {
                
                porStatus.get(status).add(elfo);
            } else {
               
                porStatus.put(status, new ArrayList<>(Arrays.asList(elfo)));
            }
        }
    }
    
    
    
    
 
}
