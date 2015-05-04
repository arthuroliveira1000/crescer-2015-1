use [Crescer15-1];


-- EXERCICIOS ADICIONAIS JOIN 

--1
select count(distinct situacao) as [contador por situação] from produto;

--2
select idcliente, nome, RazaoSocial from cliente where upper(nome) like '%LTDA%' or upper(RazaoSocial) like '%LTDA%';
-- pega os nomes que tenham ltda no nome ou na razao social, ´com o %ltda% ele pega todos que tiverem o que esta dentro do like

select * from cliente;

--3
insert into produto (nome, PrecoCusto, PrecoVenda, Situacao) values('Galocha Maragato', 35.67, 77.95, 'A');

--SP_help 'produto' - mostra dados da tabela

--4
select p.IDProduto, p.nome from produto p where not exists(select 1 from PedidoItem pi where p.IDProduto = pi.IDProduto);

--create index IX_PedidoItem_Produto on pedidoItem(IDProduto);

--5
create view vwestados as select cid.UF, count(1) as totalclientes from cidade cid inner join Cliente cli on cli.IDCidade = cid.IDCidade
group by cid.uf;

select * from vwestados where totalclientes = (select MAX(totalclientes) from vwestados) or totalclientes = (select MIN(totalclientes) from vwestados);

--6

select count(distinct nome) as totalcidade from cidade where exists(select 1 from cliente cli inner join pedido ped on ped.IDCliente = cli.IDCliente where cli.IDCidade = cidade.IDCidade);


--7

select pro.idproduto, pro.nome from produto pro where not exists (select 1 from ProdutoMaterial pm where pm.IDProduto = pro.IDProduto);


--8

  select pro.IDProduto,
          pro.Nome,
	      pro.PrecoCusto,
          SUM (ma.PrecoCusto * ISNULL(pm.Quantidade, 1) ) as Preco_Custo_Material
	from Produto pro
	 inner join produtoMaterial pm  on pm.idproduto = pro.idproduto
	 inner join Material ma         on ma.IDMaterial = pm.IDMaterial
   group by pro.IDProduto,
            pro.Nome,
	        pro.PrecoCusto


--9

Create view vwCustoProduto as
 Select pr.IDProduto, 
        pr.Nome, 
        pr.PrecoCusto, 
        ROUND( SUM( ISNULL(pm.Quantidade,1) * ma.PrecoCusto ),2) as TotalMateriais
 From   Produto pr
   inner join ProdutoMaterial pm on pm.IDProduto  = pr.IDProduto
   inner join Material        ma on ma.IDMaterial = pm.IDMaterial
 Group by pr.IDProduto, 
          pr.Nome, 
          pr.PrecoCusto 
--10

select nome as Clientes_Com_O_Mesmo_Nome from cliente group by Nome having count(1) > 1;
select * from cliente;


--11

select top 1 with ties substring(nome, 1, CHARINDEX(' ', nome) - 1) as NomeMaisPopular, count(1) as Quantidade from cliente group by substring(nome, 1, CHARINDEX(' ', nome) - 1) order by Quantidade desc;



--12

select top 1 with ties nome Produto_Mais_Pedido from produto inner join pedidoitem on produto.idproduto = pedidoitem.idproduto group by nome order by count(pedidoitem.quantidade) desc;






