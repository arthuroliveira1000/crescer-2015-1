function validaFormulario() {
	var formulario = document.form_cadastro;
		if(formulario.nome.value == "" || formulario.sinopse.value =="" || formulario.genero.value=="" || formulario.anoLancamento.value=="" || formulario.capaDoFilme.value =="") {
			alert("Preencha todos os campos!");
			} else {
				document.form_cadastro.submit();
		}
}


function validaFormularioPesquisa() {
	var formulario = document.form_pesquisa;
	if(formulario.nome.value == "") {
		alert("Preencha o campo de pesquisa!");
		else {
			formulario.submit();
		}
}
