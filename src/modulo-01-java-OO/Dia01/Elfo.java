
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
    private int vidaOrcs;
    
    Orcs orc = new Orcs();
    
    

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        //this(umNome);
        this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     */
    public void atirarFlecha() {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        vidaOrcs = orc.getVida();
        vidaOrcs = vidaOrcs - 10;
        orc.setVida(vidaOrcs);        
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
