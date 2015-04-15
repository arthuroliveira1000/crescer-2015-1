import java.util.*;

// FAZERRRRRRRR TESTESSSSS

public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
    
         System.out.println("Estrategia Noturnaaaa!!");
         
         int quantidadeAtaques = elfos.size() * orcs.size();
         int limiteElfosNoturnos = (int) (quantidadeAtaques * 0.3);
         int contadorElfosNoturnosQueTaoLutando = 0;
         
         for (Elfo elfoQueVaiAtacar : elfos) {
             boolean éElfoNoturno  = elfoQueVaiAtacar instanceof ElfoNoturno;
            
             if(éElfoNoturno) {
                     if(contadorElfosNoturnosQueTaoLutando >= limiteElfosNoturnos)
                     continue;
                     contadorElfosNoturnosQueTaoLutando++;
                    
             }
             
             for(Orc orc : orcs) {
                elfoQueVaiAtacar.atirarFlecha(orc);
                }
    }
}
}
