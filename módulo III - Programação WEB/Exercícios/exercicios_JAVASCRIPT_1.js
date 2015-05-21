	//1  
	
	var contagemtitulos = [arsenal, chelsea, liverpool, manchesterunited];

	var arsenal = {
	  nome: 'Arsenal Football Club',
	  titulos: [
		{ desc: 'Nacionais', qtd: 39 },
		{ desc: 'Continentais', qtd: 0 },
		{ desc: 'Mundiais', qtd: 0 }
		]
	};

	var chelsea = {
	  nome: 'Chelsea Football Club',
	  titulos: [
		{ desc: 'Nacionais', qtd: 5 },
		{ desc: 'Continentais', qtd: 1 },
		{ desc: 'Mundiais', qtd: 0 }
		]
	};
	var liverpool  = {
	  nome: 'Liverpool Football Club',
	  titulos: [
		{ desc: 'Nacionais', qtd: 18},
		{ desc: 'Continentais', qtd: 3 },
		{ desc: 'Mundiais', qtd: 0 }
		]
	};

	var manchesterunited = {
	  nome: 'Manchester United Football Club',
	  titulos: [
		{ desc: 'Nacionais', qtd: 5 },
		{ desc: 'Continentais', qtd: 3 },
		{ desc: 'Mundiais', qtd: 57 }
		]
	};
	
	
	/* 
	2.A
	Crie uma função chamada ordenaPorNacionais(Array) que recebe o array de clubes e retorna o array ordenado pela 
	quantidade de títulos Nacionais descendente (Z->A).
	*/
	function ordenaPorNacionais(array) {
	
		return array.sort(
			function(a, b)
			{	return a.titulos[0].qtd < b.titulos[0].qtd}
			);
	}
	
	/* 
	2.B
	Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes e retorna o array ordenado 
	pela quantidade de títulos Continentais descendente (Z->A).
	*/
	
	
	function ordenaPorContinentais(array) {
	
		return array.sort(
			function(a, b) 
			{	return a.titulos[1].qtd < b.titulos[1].qtd
			});
	
	}
	
	/* 
	2.C
	Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes e 
	retorna o array ordenado pela quantidade de títulos Mundiais descendente (Z->A).
	*/
	
	
	function ordenaPorMundiais(array) {
	
		return array.sort(
		function(a, b)
		{ return a.titulos[2].qtd < b.titulos[2].qtd});
	
	}
	
	
	
	
	/*
	3.A
	Crie uma função chamada somarPorNacionais(Array) que recebe o array de clubes e retorna o 
	somatório de todas quantidades de títulos nacionais entre os clubes do array.
		
		var somarPorMap = function(arr, mapFn) {
		  return arr.map(mapFn).reduce(function(a,b) {
		  return a + b;
		  });
		};
		*/
		
	function somarPorNacionais(array) {
	
		var soma = 0;
		
		for(var i = 0; i < array.length; i++) {
			soma+= array[i].titulos[0].qtd; 
		} 
		 return soma;
	}	
	
	
	
	
	/*
	3.B
	Crie uma função chamada somarPorContinentais(Array) que recebe o array de clubes e retorna o somatório de todas quantidades de títulos continentais entre os clubes do array.
		
			
		USANDO MAP	
		var somatorio3B = (function somarPorContinentais(arr) {
		  return somarPorMap(arr,
			function(i) { return i.titulos[1].qtd; }
		  );
		})(clubes);
		
		MAP - tem que ter uma function(i) para pegar cada item do array
		REDUCE - também precisa de uma function(a, b) para fazer o método de ordenação tipo bubblesort para "reduzir" os 
		valores de um array em um só
		
		*/
		
	function somarPorContinentais(array) {
		
		var soma = 0;
		
		for(var i = 0; i  < array.length; i++) {
			soma += array[i].titulos[1].qtd;
		}
		
		return soma;
	
	}
	
	
	/*
	3.C
	Crie uma função chamada somarPorTodosTitulos(Array) que recebe o array de clubes e retorna o somatório de todas quantidades de todos os títulos entre os clubes do array.
	
	USANDO MAP
	var somatorio3C = (function somarPorTodosTitulos(arr) {
	  return somarPorMap(arr,
		function(i) { return i.titulos[0].qtd + i.titulos[1].qtd + i.titulos[2].qtd; }
	  );
	})(clubes);
	 
	
	
	*/

	function somarPorTodosTitulos(array) {
	
		var soma = 0;
		
		for(var i = 0; i < array.length; i++) {
			for(var j = 0; j < array[i].titulos.length; j++) {
				soma += array[i].titulos[j].qtd;
			}
		}
		
		return soma;
	}	
	
	/* 
	4
	Escreva uma função chamada apenasOsMelhores(Array) que recebe o array de clubes e retorna apenas os clubes que têm mais de 18 títulos ingleses
	*/
	
		function apenasOsMelhores(array) {
		
			var arraynovo = [0]; 
			
				for(var j = 0; j < array.length; j++) {
					if(array[j].titulos[0].qtd > 18) {
						arraynovo.push(array[j]);
					}
			}	
			arraynovo.shift();
			return arraynovo;
		
		} 
		
	
	/*
	5.A
	Escreva uma função chamada apenasOsMelhoresParaJSON(Array) que recebe o array dos clubes que têm mais de 18 títulos ingleses e retorna a representação JSON deles.
	*/
	
	function apenasOsMelhoresParaJSON(array) {
	
		return JSON.stringify(array); // transforma array em uma string no formato JSON (chave, valor)
	
	
	}
	
	/*
	5.B
	Escreva uma função chamada apenasOsMelhoresRecebendoJSON(String) que recebe uma String no formato JSON e retorna o Array de objetos JavaScript.
	
	JSON is a format for storing and transporting data.

	JSON is often used when data is sent from a server to a web page.

	JSON - par (chave, valor)
	*/

	
	function apenasOsMelhoresRecebendoJSON(array) {
	
		return JSON.parse(array); // transforma string no formato json em um array
	}