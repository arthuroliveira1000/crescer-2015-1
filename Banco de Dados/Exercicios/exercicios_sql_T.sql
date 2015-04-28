-----------------SQL TRANSACTION

use [Crescer15-1];


--EXERCICIOS

--1 - Imprima qual produto é o mais vendido, considerea quantidade(PedidoItem).

BEGIN 

	DECLARE @


END 




--2 - Liste as cidades com nome e UF duplicados que tenham clientes relacionados.

BEGIN 
	DECLARE CidadesDuplacadasComRelacionamentos CURSOR
	LOCAL 
	FAST_FORWARD
	FOR select nome, uf from cidade c where exists(select 1 from Cliente cli where cli.IDCidade = c.IDCidade having count(1) > 1);

	DECLARE @nomeCidade varchar(50),
			@ufCidade char(2)

	OPEN CidadesDuplacadasComRelacionamentos

	FETCH NEXT FROM CidadesDuplacadasComRelacionamentos INTO @nomeCidade, @ufCidade
	WHILE(@@FETCH_STATUS = 0)
		BEGIN 
		PRINT @nomeCidade + ' /' + @ufCidade;
		FETCH NEXT FROM CidadesDuplacadasComRelacionamentos INTO @nomeCidade, @ufCidade
	END
		CLOSE CidadesDuplacadasComRelacionamentos;
		DEALLOCATE CidadesDuplacadasComRelacionamentos;
END
