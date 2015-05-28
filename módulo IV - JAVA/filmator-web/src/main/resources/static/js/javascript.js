function curtiFilme(id_filme) {
	console.log("ID DO FILME : " + id_filme);
	$.ajax({
				url:"/like",
				type:"POST",
				data:{
					id: id_filme
				}
			});
}

function naoCurteFilme(id_filme) {
	console.log("ID DO FILME : " + id_filme);
	$.ajax({
				url:"/dislike",
				type:"POST",
				data:{
					id: id_filme
				}
			});
}




function validaFormulario() {
	var formulario = document.form_cadastro;
	var testaAnoLancamento = isNaN(formulario.anoLancamento.value);
	
		if(formulario.nome.value == "" || formulario.sinopse.value =="" || formulario.genero.value=="" || formulario.anoLancamento.value=="" || formulario.capaDoFilme.value =="") {
			alert("Preencha todos os campos!");
			} else if(testaAnoLancamento && formulario.anoLancamento !== "") {
				alert("Ano de lançamento inválido!");
				formulario.anoLancamento.value = "";
				formulario.anoLancamento.focus();
			} else {
				document.form_cadastro.submit();
			}
}


function validaFormularioPesquisa() {
	var nomeInformado = document.getElementById("nomePesquisa").value;
	if(nomeInformado == "") {
		alert("Preencha o campo de pesquisa!");
		} else {
			$.ajax({
				url:"/buscaFilme",
				type:"POST",
				data:{
					nome: nomeInformado
				}
			}).done(function(resp){	
					console.log(resp.status);
					$("#listaDeFilmesCadastrados").html("");
					$("#listaDeFilmesCadastrados").append("<ul><li><h2>Ficha Técnica</h2><img src="+resp.capaDoFilme+"></br><h3>"+resp.nome+"</h3><h4>"+resp.anoLancamento+"</h4><h4>"+resp.genero+"</h4><h4>"+resp.sinopse+"</h4></li></ul>");
					/*$("<ul>").appendTo("#listaDeFilmesCadastrados");
					$("<li>").appendTo("#listaDeFilmesCadastrados");
					$("<h2>").text("Ficha Técnica").appendTo("#listaDeFilmesCadastrados");
					$("<img>").attr("src", resp.capaDoFilme).appendTo("#listaDeFilmesCadastrados");
					$("</br>").appendTo("#listaDeFilmesCadastrados");
					$("<h3>").text(resp.nome).appendTo("#listaDeFilmesCadastrados");
					$("</br>").appendTo("#filmesSelecionado");
					$("<h3>").text("Lançado em:").appendTo("#listaDeFilmesCadastrados");
					$("<h4>").text(resp.anoLancamento).appendTo("#listaDeFilmesCadastrados");
					$("<p>").appendTo("#filmesSelecionado");
					$("<h3>").text("Gênero: ").appendTo("#listaDeFilmesCadastrados");
					$("<h4>").text(resp.genero).appendTo("#listaDeFilmesCadastrados");
					$("</br>").appendTo("#listaDeFilmesCadastrados");
					$("<h4>").text(resp.sinopse).appendTo("#listaDeFilmesCadastrados");	
					*/
			});
		}
}

function validaFormularioExclusao() {
	var formulario = document.form_exclusao;
	if(formulario.nome.value == "") {
		alert("Digite o nome do filme que deseja excluir!");
		} else {
			formulario.submit();
		}
}

function validaFormidentificacao() {
	var formulario = document.form_identificacao;
	if(formulario.login.value() =="") {
		alert("Preencha seu login!");
	} if(formulario.senha.value == "") {
		alert("Preencha sua senha");
		} else {
			formulario.submit();
		}
}





