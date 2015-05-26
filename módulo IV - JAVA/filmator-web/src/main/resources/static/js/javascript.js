function validaFormulario() {
	var formulario = document.form_cadastro;
		if(formulario.nome.value == "" || formulario.sinopse.value =="" || formulario.genero.value=="" || formulario.anoLancamento.value=="") || formulario.capaDoFilme.value =="" {
			alert("Preencha todos os campos!");
			} else {
				formulario.submit();
		}
}
