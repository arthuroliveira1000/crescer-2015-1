-----------------SQL TRANSACTION

use [Crescer15-1];


--EXERCICIOS

--1 - Imprima qual produto é o mais vendido, considerea quantidade(PedidoItem).


begin 
	declare @idproduto integer,
			@nome	   varchar(100),
			@total_itens integer

			select top 1 
			@idproduto = PedidoItem.IDProduto,
			@nome = Produto.Nome,
			@total_itens = sum(quantidade) 
			from PedidoItem 
			inner join produto on produto.IDProduto = PedidoItem.IDProduto  
			group by pedidoItem.IDProduto, produto.Nome 
			order by sum(Quantidade) desc;

			print 'Produto: ' + @nome + 'Total vendido: ' + cast(@total_itens as varchar(10))
end;

--2 - Liste as cidades com nome e UF duplicados que tenham clientes relacionados.
/*
BEGIN 
	DECLARE CidadesDuplacadasComRelacionamentos CURSOR
	LOCAL 
	FAST_FORWARD
	FOR select nome, uf from cidade c where exists(select 1 from Cliente cli 
	where cli.IDCidade = c.IDCidade) group by nome, uf having count(1) > 1;

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
*/

BEGIN 
	DECLARE ListaCidade CURSOR Local Fast_Forward 
		
		FOR Select Nome, Uf From Cidade Group by Nome, Uf Having COUNT(1) > 1; 
		DECLARE @vNome varchar(50), @vUF varchar(2), @Total integer; 
	
		OPEN ListaCidade; 
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF 
		WHILE (@@FETCH_STATUS = 0) 
		BEGIN 

		Select @Total = count(1) From Cliente cli Where 
		EXISTS (Select 1 From Cidade ci Where ci.IDCidade = cli.IDCidade and ci.Nome = @vNome and ci.UF = @vuf); 

		if @Total > 0 
		Print @vNome + '/'+ @vUF + ' total de clientes: ' + cast(@Total as varchar(10)); 
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF 
		END 
	CLOSE ListaCidade; 
	DEALLOCATE ListaCidade; 
END


--3 - Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados, com 
	--produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.

create index IX_pedidodatapedido on pedido(datapedido);


create view vwMateriaisMaisUtilizados as 
select top 1 with ties ma.idmaterial, ma.descricao, count(distinct pm.IDProduto) total_produtos_distintos from material ma 
inner join produtomaterial pm on pm.idmaterial = ma.idmaterial
inner join produto pr on pr.IDProduto = pm.idproduto group by ma.IDMaterial, ma.Descricao order by total_produtos_distintos desc;



select ped.IDPedido, item.IDPedidoItem, pro.IDProduto, pro.Nome, item.Quantidade from pedido ped 

inner join pedidoitem		item on item.IDPedido = ped.IDPedido
inner join produto			pro on pro.idproduto = item.idproduto
--inner join produtomaterial  pm on pm.IDProduto = pro.IDProduto

where ped.DataPedido between dateadd(day, -60, getdate()) and GETDATE()



