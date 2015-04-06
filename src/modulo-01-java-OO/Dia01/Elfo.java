
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
        experiencia = 0;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    
    Elfo() {
    
    }
    
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        //this.nome = umNome;
        this.flechas = flechas;
    }
    
    /**
     * Cria um elfo informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public Elfo(String nome) {
        this.nome = nome;
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
    
    public String getNome() {
        return this.nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    
    public String toString() {
    
      String textoFlechas = this.flechas != 1 ? " flechas" : " flecha";  
      String textoNiveis = this.experiencia == 1 ? " nível" : " níveis";
      return this.nome + " possui " + this.flechas + textoFlechas + " e " + this.experiencia + textoNiveis + " de experiência.";  
    
    }  
    
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
}
