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
// Testes
[
  { params: ['american ipa','american ipa'], esperado: 0 },
  { params: ['russian imperial stout','russian imperial vodka'], esperado: 5 },
  { params: ['1002012','dfgdf12'], esperado: 5 },
  { params: ['k4rol1n','k4thr1n'], esperado: 3 },
  { params: ['a1df222266%334op;','ssdfjfdkjgsdfgofdgudf9g8dufsg'], esperado: 26 },
].forEach(
  function(ct) {
    var res = brewdog(ct.params[0], ct.params[1]);
    console.assert(res === ct.esperado, 'Errooooou! CT:', ct.params, 'Esperado:', ct.esperado, 'Obtido:', res);
  }
);

2.A - Faça uma classe em JS que gerencie cálculos de empréstimos com juros compostos, de acordo com a tabela Price. Para isso:
Escreva um construtor que receba o valor total do empréstimo, a taxa de juros a ser aplicada e o número de parcelas para 
quitação total do empréstimo. Caso o número de parcelas não seja informado,
deve-se assumir o valor padrão 3. Ex:
	
*/

	function Emprestimo (valorTotal, taxaJuros, valorParcela) {
		this.valorTotal = valorTotal;
		this.taxaJuros = taxaJuros;
		this.valorParcela = valorParcela || 3;
	}
	
/*
2.B - Escreva uma função que retorne o valor da parcela do financiamento. Formate o número de saída com até duas casas de precisão numérica. 
São permitidos apenas arredondamentos numéricos para cima.
*/
	
	Emprestimo.prototype.valorParcela = function() {
	  var valor = (this.valorTotal * this.taxaJuros) / (1 - 1/Math.pow((1 + this.taxaJuros), this.quantidadeParcelas));
	  return valor.arredondar();
	};

	
	/*
	
// Testes para 2B
[
{ emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 269.03 },
{ emprestimo: new Emprestimo(1800, 0.05, 8),  esperado: 278.5 },
{ emprestimo: new Emprestimo(500, 0.05),      esperado: 183.6 },
].forEach(
  function(ct) {
    var res = ct.emprestimo.valorParcela();
    console.assert(res == ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
  }
);
	

2.C - Escreva uma função que retorne o valor total de juros aplicados em um financiamento. 
Formate o número de saída com até duas casas de precisão numérica. São permitidos apenas arredondamentos numéricos para cima.
*/

	Emprestimo.prototype.valorTotalJuros = function() {
	  return (this.valorParcela() * this.quantidadeParcelas - this.valorTotal).arredondar();
	};
	 
	Number.prototype.arredondar = function() {
	  // http://jsperf.com/tofixed-vs-math-round-100-100
	  return Math.round(this * 100)/100;
	};

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

	var palindromo = function(palavra) {

	 String.prototype.sanitize = function() {
    var diacritics = [
      { original: /[âáàã]/gi,  sanitized: 'a' },
      { original: /[éèê]/gi,   sanitized: 'e' },
      { original: /[íìî]/gi,   sanitized: 'i' },
      { original: /[ôõóò]/gi,  sanitized: 'o' },
      { original: /[úùû]/gi,   sanitized: 'u' },
    ];
   
   var self = this;
    diacritics.forEach(function(i) {
      self = self.replace(i.original, i.sanitized);
    });
    return self.replace(/[^a-zA-Z_-]/g, '').toLowerCase();
  };
 
  String.prototype.inverter = function() {
    return this.split('').reverse().join('');
  };
 
  Array.prototype.contains = function(str) {
    return this.indexOf(str) !== -1;
  }
 
  palavra = palavra.sanitize();
 
  return (
    ['iluminatti', 'ledesma', 'dante', 'verdemusgo', 'bacon'].contains(palavra) || 
    palavra.inverter() === palavra
  );
 
};



/*

/ Casos de teste
[
  { teste: 'ovo', esperado: true },
  { teste: 'ôvo', esperado: true },
  { teste: 'arara', esperado: true },
  { teste: 'rodador', esperado: true },
  { teste: 'O tRoTe ToRtO', esperado: true },
  { teste: 'bacon', esperado: true },
  { teste: 'A miss é péssima!', esperado: true },
  { teste: 'VERDE musgo!!', esperado: true },
  { teste: 'Nova Schin, cervejão!', esperado: false },
  { teste: 'camigoal', esperado: false },
  { teste: 'ledesma@@@@@@@@', esperado: true },
  { teste: '!!d@ante!?!?', esperado: true },
  { teste: '1@ilu$$$m1in$$$$$$$$$$4att$$$$$$$$1i!!!!!', esperado: true }
].forEach(
  function(ct) {
    var res = palindromo(ct.teste);
    console.assert(res === ct.esperado, 'Errooooou! CT:', ct.teste, 'Esperado:', ct.esperado, 'Obtido:', res);
  }
);



*/
 