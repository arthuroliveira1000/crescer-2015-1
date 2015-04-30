
/**
 * Define o erro lançado quando um elfo não pode ser alistado
 * 
 * @author Arthur Oliveira
 */
public class NaoPodeAlistarException extends Exception
{
    public NaoPodeAlistarException()
    {
        super("Erro ao alistar um elfo. Por favor tente novamente e se o error persistir peça ajuda");
    }
}
