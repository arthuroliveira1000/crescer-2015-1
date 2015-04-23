--EXERCICIOS 

--1
select substring(nome, 1, CHARINDEX(' ', nome) - 1) [Primeiro Nome] from associado;

--2
select nome , DATEDIFF(yy, DataNascimento , GETDATE()) Idade from associado;

--3
select nomeempregado, datediff(mm, DataAdmissao, '31/12/2000') Total_De_Meses_trabalhodos_Até_31122000 from empregado where dataadmissao between convert(DateTime, '01/05/1980', 103) and convert(DateTime, '20/01/1982', 103);

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
select count(IDAssociado) + 1 as [Proximo id que será usado] from Associado;

begin transaction 
go 

delete from associado;

rollback

--10

delete from CidadeAux;

insert into CidadeAux(IDCidade, Nome, UF) 
select min(IDCidade) Menor_IDCidade, Nome, UF from cidade group by Nome, UF;

--11
begin transaction 
go

update cidade set nome = '*' + nome where nome in (
select nome from cidade group by nome, uf having count(1) > 1);

--12
select Nome, case when sexo = 'F' then 'Feminino'
				  when sexo = 'M' then 'Masculino' 
				  else 'Indeterminado' 
		      end as Sexo
		      from Associado;


--13

select NomeEmpregado, Salario, case
							   when salario between 1164.01 and 2326 then (salario*0.15)
							   when salario > 2326 then (salario*0.275)
							   else 0
							   end [Desconto para imposto de renda] 
							   from Empregado;

--14
begin transaction 
go

Delete from cidade where idcidade in (select max(idcidade) from cidade group by nome, uf having count(1) > 1);

commit 

--15

alter table cidade add constraint UK_Cidade_Nome_UF unique(Nome, uf);

/*constraint são regras para a tabela - nesse caso não deixa adicionar um dado que tenha um nome e uf já existentes no banco*/




