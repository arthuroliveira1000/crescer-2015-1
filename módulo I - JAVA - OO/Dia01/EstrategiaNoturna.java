import java.util.*;

// FAZERRRRRRRR TESTESSSSS

public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        System.out.println("Super estratégia noturna.. ATIVAR!!!");
        
        int qtdAtaques = elfos.size() * orcs.size();
        System.out.println(qtdAtaques);
        int limiteElfosNoturnos = (int)(qtdAtaques * 0.3);
        System.out.println(limiteElfosNoturnos);
        int qtdElfosNoturnosQueJáAtacaram = 0;
        System.out.println(qtdElfosNoturnosQueJáAtacaram);
        for (Elfo elfoQueVaiAtacar : elfos) {
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;
            
            if (éElfoNoturno) {
                if (qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos) 
                    continue;
                
                        qtdElfosNoturnosQueJáAtacaram++;
                        System.out.println(qtdElfosNoturnosQueJáAtacaram);
                        ordemAtaque.add(elfoQueVaiAtacar);
            }
            
            for (Orc orc : orcs) {
                   elfoQueVaiAtacar.atirarFlecha(orc);
                   System.out.println(elfoQueVaiAtacar.getVida());
                   System.out.println(elfoQueVaiAtacar.getFlechas());
                   System.out.println(elfoQueVaiAtacar.getNome());
            }
            
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
}