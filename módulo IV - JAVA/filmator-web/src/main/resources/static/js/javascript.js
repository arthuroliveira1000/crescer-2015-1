
		function validaFormulario() {
			var formulario = document.form_cadastro;
			if(formulario.nome.value == "" || formulario.anoLancamento.value == "" || formulario.sinopse.value =="" || formulario.genero.value=="" || formulario.imagem.value =="") {
				alert("Para o cadastramento do filme, todos os campos precisam estar preenchidos!");
				} else {
					document.form_cadastro.submit();
					alert(formulario.nome.value + " cadastrado com sucesso!");
				}
		}
