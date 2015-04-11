
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo extends Personagem  {

    private int flechas = 42;

    public Elfo(String nomeNovo, int flechasNovas) {
    
        super(nomeNovo, 0);
        this.flechas = flechasNovas;
    }

    public Elfo(String nome) {
       super(nome, 110);
    }
    
    public void Setflechas(int novasFlechas) {
        this.flechas = novasFlechas;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    
    /**
     * Atira uma flecha e perde uma unidade.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        umOrc.recebeAtaque();
    }
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    /**
     * Retorna o nome do elfo, sua quantidade de flechas e seus níveis de experiência.
     * 
     * @return Informações gerais sobre o elfo, ex:
     * 
     * "Legolas possui 42 flechas e 0 níveis de experiência."
     */
    public String toString() {
        
        /*StringBuilder builder = new StringBuilder();
        
        builder.append(
            String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            )
        );

        return builder.toString();
        
        */
        
        return String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            );
       
        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."
       
        // C# null-coalsing:
        // String texto = this.nome ?? "Sem Nome";
                
        /*if (this.flechas == 1) {
            textoFlechas = "flecha";
        } else {
            textoFlechas = "flechas";
        }*/
        
        /*builder.append(this.nome);
        builder.append(" possui ");
        builder.append(this.flechas);
        builder.append(" ");
        builder.append(textoFlechas);
        builder.append(" e ");
        builder.append(this.experiencia);
        builder.append(" ");
        builder.append(textoNiveis);
        builder.append(" de experiência.");*/
    }
}
