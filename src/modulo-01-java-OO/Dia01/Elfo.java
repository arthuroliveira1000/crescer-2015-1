
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
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     */
    public void atirarFlecha(Orc orc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        orc.recebeAtaque();
    }
    
    public int getFlechas() {
            return flechas;
        } 
        
        
    public int getExperiencia() {
            return experiencia;
        } 
        
       
    public String getNome() {
            return this.nome = nome;
        }
    
    
    
    
    /* EXERCICIO 1.4
    //public void setNome(String novoNome) {
    //    nome = novoNome;
}*/
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
}
