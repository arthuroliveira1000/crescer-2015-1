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
	FOR select nome, uf from cidade c 
	where exists(select 1 from Cliente cli 
	where cli.IDCidade = c.IDCidade) 
	group by nome, uf having count(1) > 1;

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

BEGIN
         
 DECLARE @vQtdeProd   int,
         @vIDMaterial int,
         @vDataPedido datetime,
         @vDescricaoMaterial varchar(50),
         @vTotalPedidos int,
         @vTotalVendas  decimal(12,2)
 
 --	IDENTIFICA O MATERIAL MAIS UTILIZADO POR TODOS OS PRODUTOS
 -- IMPORTANTE: não é a quantidade, e sim a frequência em Produtos distintos
 Select TOP(1) 
        @vIDMaterial = IDMaterial, 
        @vQtdeProd   = Count(distinct IDProduto)
 From   ProdutoMaterial
 Group  by IDMaterial
 Order  by Count(distinct IDProduto) Desc

 -- BUSCA A DESCRICAO DO MATERIAL
 Select @vDescricaoMaterial = Descricao 
 From   Material
 Where  IDMaterial = @vIDMaterial

 -- BUSCA O TOTAL DE PEDIDOS
 Select @vTotalPedidos = COUNT(distinct IDPedido)
 From   PedidoItem
 Where  IDProduto in (Select IDProduto             -- todos produtos com material selecionado acima
                      From   ProdutoMaterial pm
                      Where  pm.IDMaterial = @vIDMaterial);
 
 -------------------------------------------
 -- TOTAL DOS PEDIDOS DOS ÚLTIMOS 60 DIAS --
 -------------------------------------------
 /* define parametro de data para desconsiderar a hora                               |
  | deve-se sempre considerar o uso da data e hora em buscas                         |
  | faça um teste exbibindo o resultado abaixo e depois apenas o calculo de -60 dias */
 Set @vDataPedido = convert(datetime,  convert(varchar, DATEADD(DAY, -60, GETDATE()), 103)  , 103)
 
 -- faz consulta para buscar informação
 Select @vTotalVendas = SUM(ValorPedido) 
 From   Pedido
 Where  DataPedido >= @vDataPedido
 
 ------------------------
 -- IMPRIME RESULTADOS --
 ------------------------
 Print 'Material mais utilizado: ' + cast(@vIDMaterial as varchar) + ' - '+ @vDescricaoMaterial
 Print 'Total de pedidos com produtos que utilizam o material: ' + cast(@vTotalPedidos as varchar)
 Print 'Total de vendas R$ ' + cast(@vTotalVendas as varchar(50)) + ' (últimos 60 dias)'
END
go
--4


BEGIN
  SET NOCOUNT ON
  -- LISTA PARA AUXILIAR NA CONSULTA
  Declare @CidadeDuplicada table 
    (
     IDCidadeMenor  int,
     Nome           varchar(50),
     UF             varchar(2)
     )

  -- CARREGA LISTA DE CIDADES DUPLICADAS, E MENOR IDCIDADE
  Insert @CidadeDuplicada 
         (IDCidadeMenor, Nome, UF)
     select MIN(IDCidade) MenorID, 
            Nome, 
            UF
     from   Cidade dup
     group  by Nome, UF
     having COUNT(1) > 1

  -- BUSCA TODOS OS CLIENTES RELACIONANDO COM CIDADE
  -- E FILTRANDO PARA EXIBIR AS CIDADES DUPLICADAS (IGNORANDO IDCIDADE = MIN(IDCIDADE))
  Select Cli.IDCliente, cli.Nome,  cid.IDCidade, cid.Nome as Nome_Cidade
    From  Cliente cli
   inner join Cidade cid on cid.IDCidade = cli.IDCidade
   Where exists (Select 1
                 From   @CidadeDuplicada dup
                 Where  dup.Nome          = cid.Nome
                 and    dup.UF            = cid.UF
                 and    dup.IDCidadeMenor < cid.IDCidade)
  order by Nome_Cidade
  --
  SET NOCOUNT OFF  
END 