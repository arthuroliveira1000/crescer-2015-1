<<<<<<< HEAD

/**
 * Classe que conta até 3. :v
 * 
 * @author Arthur Oliveira 
 * 
 */
public class ContadorDeNumeros
{
    public ContadorDeNumeros()
    {
       
    }
    
    public void contaAteTres(int limite) {
    
        for(int i = 1; i <= limite; i++) {
            System.out.println(i);
        }
        
        //ctrl + k -> limpa terminal
        //ctrl + t -> mostra terminal
    }
=======
/**
 * Objeto que sabe contar números em ordem!
 * 
 * @author CWI Software
 */
public class ContadorDeNumeros
{
    public void contarAte3() {
        
        for (int i = 0; i < 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i + 1);
        }
        
        for (int i = 1; i <= 3; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
        
        for (int i = 1; i < 4; i++) {
            // execute tudo que tem aqui dentro
            //System.out.println(i);
        }
    } 
    
    public void contarAte(int numero) {
        for (int i = 0; i < numero; i++) {
            // execute tudo que tem aqui dentro
            System.out.println(i + 1);
        }
    }
    
    public void contarRegressivamente(int numero) {
        for (int i = numero; i > 0; i--) {
            // execute tudo que tem aqui dentro
            System.out.println(i);
        }
    }
    
    
    
    
    
    
    
    
    
>>>>>>> 2526e6513dac7607052531cdaefcd566da4ab8f4
}
