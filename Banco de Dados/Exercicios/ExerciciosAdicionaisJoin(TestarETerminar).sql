use [Crescer15-1];


-- EXERCICIOS ADICIONAIS JOIN 

--1
select count(distinct situacao) as [contador por situa��o] from produto group by situacao;

--2
select idcliente, nome, RazaoSocial from cliente where nome like '%LTDA%' or RazaoSocial like '%LTDA%';
-- pega os nomes que tenham ltda no nome ou na razao social, �com o %ltda% ele pega todos que tiverem o que esta dentro do like

select * from cliente;
--3
insert into produto (nome, PrecoCusto, PrecoVenda, Situacao) values('Galocha Maragato', 35.67, 77.95, 'A');

--SP_help 'produto' - mostra dados da tabela

--4
select p.IDProduto, p.nome, p.DataCadastro, p.PrecoCusto, p.PrecoVenda, p.Situacao from produto p where not exists(select 1 from PedidoItem pi where p.IDProduto = pi.IDPedidoItem);

--create index IX_PedidoItem_Produto on pedidoItem(IDProduto);

--5
create view vwestados as select cid.UF, count(1) as totalclientes from cidade cid inner join Cliente cli on cli.IDCidade = cid.IDCidade
group by cid.uf;

--ARRUMAR

select * from vwestados where totalclientes = (select MAX(totalclientes) from vwestados) or totalclientes = (select MIN(totalclientes) from vwestados);

--6

select count(idcidade) as totalcidade from cidade where exists(select 1 from cliente cli inner join pedido ped on ped.IDCliente = cli.IDCliente where cli.IDCidade = cidade.IDCidade);


--7

select pro.idproduto, pro.nome from produto pro where not exists (select 1 from ProdutoMaterial pm where pm.IDProduto = pro.IDProduto);


--8

select idproduto, nome, precocusto, dbo.buscaPrecoCustoMaterial(idproduto) as valorDeCusto from produto where idproduto = 123;


create function buscaPrecoCustoMaterial (@IDProduto int)
	returns decimal(9,2) as 
begin 
	declare @preco_custo decimal(9, 2)
	select @preco_custo = sum(ma.PrecoCusto * isnull(pm.Quantidade, 1)) from ProdutoMaterial pm inner join material ma on ma.IDMaterial = pm.IDMaterial where pm.IDProduto = @IDProduto
	
	return @preco_custo;
end;
