<script>

	// EXERCICIO 1 



	var contagemtitulos = [ arsenal, chelsea, liverpool, manchesterunited];

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
	
	
	/* EXERCICIO 2.A
	Crie uma função chamada ordenaPorNacionais(Array) que recebe o array de clubes e retorna o array ordenado pela 
	quantidade de títulos Nacionais descendente (Z->A).
	*/
	function ordenaPorNacionais(array) {
	
		return array.sort(
			function(a, b)
			{	return a.titulos[0].qtd < b.titulos[0].qtd}
			);
	}
	
	/* EXERCICIO 2.B
	Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes e retorna o array ordenado 
	pela quantidade de títulos Continentais descendente (Z->A).
	*/
	
	
	function ordenaPorContinentais(array) {
	
		return array.sort(
			function(a, b) 
			{	return a.titulos[1].qtd < b.titulos[1].qtd
			});
	
	}
	
		/* EXERCICIO 2.C
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
		*/
		
	function somarPorNacionais(array) {
	
		return array.reduce(
			function(i) {
				return i.titulos[0].qtd}
		);
		
	}	
	
		

	
</script>