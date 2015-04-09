
/**
 * Classe de um item do inventario
 * 
 * @author Arthur Oliveira
 * 
 */
public class ItemDoInventario
{
    private String descricao;
    private int quantidade;

        /**
         * Constructor for objects of class ItemDoInventario com descrição
         */
        /**
         * Constructor for objects of class ItemDoInventario com descrição e quantidade
         */
    public ItemDoInventario(String novaDescricao, int novaQuantidade)
    {
        this.descricao = novaDescricao;
        this.quantidade = novaQuantidade;
    }
    
        //GETTERS AND SETTERS
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    /* CRIAR METODOS SET SOMENTE QUANDO PRECISAR!!! MA PRATICA
     * 
     public void setDescricao(String novaDescricao) {
        descricao = novaDescricao;
    }
    */
    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }    
}
