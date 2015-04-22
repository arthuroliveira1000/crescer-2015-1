--EXERCICIOS 

--1
select substring(nome, 1, CHARINDEX(' ', nome) - 1) [Primeiro Nome] from associado;

--2
select nome , DATEDIFF(yy, DataNascimento , GETDATE()) Idade from associado;

--3
select nomeempregado, datediff(mm, DataAdmissao, '31/12/2000') Total_De_Meses_trabalhodos_At�_31122000 from empregado where dataadmissao between convert(DateTime, '01/05/1980', 103) and convert(DateTime, '20/01/1982', 103);

--4
select top 1 with ties cargo, count(1) [Total de Empregados] from empregado group by cargo order by [Total de Empregados] desc;

--5
select top 1 with ties nome from associado order by len(nome) desc;

--6
select nome, DateAdd(year, 50, DataNascimento) as [Ano que Completa 50 Anos], 
dateName(weekday, DateAdd(year, 50, DataNascimento)) as [Dia da Semana] from associado;

select * from associado;

--7
select uf, count(nome) as [Quantidade de Cidades por Estado] from cidade group by uf; 

select nome from cidade where uf = 'rs';

--8
select Nome, UF, count(1) as Total from cidade group by Nome, UF having count(1) > 1;

--9
select count(IDAssociado) + 1 as [Proximo id que ser� usado] from Associado;

begin transaction 
go 

delete from associado;

rollback

--10

delete from CidadeAux;

insert into CidadeAux(IDCidade, Nome, UF) 
select min(IDCidade) Menor_IDCidade, Nome, UF from cidade group by Nome, UF;

--11


--12
