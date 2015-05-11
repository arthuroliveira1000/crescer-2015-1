/*
1 - Brewdog

Escreva uma função em JS que retorne o número de caracteres diferentes entre dois textos. */

	function brewdog(var1, var2) {
	
		var cont = Math.max(var1.length, var2.length);
		
		var retorno = 0;
		
		for(var i = 0; i < cont; i++) {
			if(var1.charAt(i) !== var2.charAt(i)) 
			retorno++;
		}
		
		return retorno;
		
	}
	
	
/*
2.A - Faça uma classe em JS que gerencie cálculos de empréstimos com juros compostos, de acordo com a tabela Price. Para isso:
Escreva um construtor que receba o valor total do empréstimo, a taxa de juros a ser aplicada e o número de parcelas para 
quitação total do empréstimo. Caso o número de parcelas não seja informado,
deve-se assumir o valor padrão 3. Ex:
	
*/

	function Emprestimo (valortotal, taxajuros, numeroparcelas) {
		this.valortotal = valortotal;
		this.taxajuros = taxajuros;
		this.numeroparcelas = numeroparcelas || 3;
	}
	
/*
2.B - Escreva uma função que retorne o valor da parcela do financiamento. Formate o número de saída com até duas casas de precisão numérica. 
São permitidos apenas arredondamentos numéricos para cima.
*/
	
	function valorparcela() {
	
		var parcela =   //ARRUMAR
		
		return parcela.toFixed(2);
	}
	
	Emprestimo.prototype.valorParcela = valorparcela;
	


/*
2.C - Escreva uma função que retorne o valor total de juros aplicados em um financiamento. 
Formate o número de saída com até duas casas de precisão numérica. São permitidos apenas arredondamentos numéricos para cima.
*/














/*
3 - palindromo 	


Faça uma função que receba uma String e verifica se a mesma é um Palíndromo Iluminatti.

O quê é um Palíndromo Iluminatti?

Palíndromo Iluminatti possui as mesmas características de um palíndromo tradicional e também as seguintes regras:

Caractéres especiais, espaços em branco e diacríticos devem ser desconsiderados, bem como se as letras são MAIÚSCULAS ou minúsculas.
Também pode ser um Palíndromo Iluminatti se a String informada for uma das abaixo:

'iluminatti'
'ledesma'
'dante'
'verde musgo'
'bacon'
*/

	function palindromoIluminatti(text) {
	
		var textinvertido = text;
		textinvertido = text.split('').reverse().join('');
		
			if(text.contains(textinvertido) || text === 'iluminatti' ||  text === 'ledesma' ||  text === 'dante' ||  text === 'verde musgo' || text === 'bacon') {
				return true;
			} else {
				return false;
			}
	}
