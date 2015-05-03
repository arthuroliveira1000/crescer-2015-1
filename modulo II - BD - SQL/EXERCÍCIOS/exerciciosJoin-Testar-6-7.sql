use curso;

--------JOINNNN-------------


update associado set idcidade = 1 where idassociado = 1;

update associado set idcidade = 32 where idassociado = 3;

select * from Departamento;
--------Exercicio 1 -------------

select e.NomeEmpregado, d.NomeDepartamento from Empregado e Inner Join Departamento d on  e.IDDepartamento = d.IDDepartamento;


--------Exercicio 2 -------------

select a.Nome as NomeAssociado, c.Nome as NomeCidade from Cidade c Right Join Associado a on a.IDCidade = c.IDCidade;


--- remove o '*' do �nicio dos nomes -> update ciade set nome = replace(nome, '*', ' ') where nome like = '*%'


--------Exercicio 3 -------------

select c.uf, count(1) as [Total de cidades que n�o possuem associados] from cidade c where not exists (select 1 from associado a  where c.IDCidade = a.IDCidade) group by c.UF;  
-- quando usar o exist ou not exist 
--count n�o pode ser usado no exist
--------Exercicio 4 -------------


select a.nome as NomeAssociado, c.nome as NomeCidade, case 
													  when c.uf in ('RS', 'SC', 'PR') then '***'
												      else null
													  end [Cidade � da regi�o sul] from cidade c Inner Join associado a on a.IDCidade = c.IDCidade;  
	
	
--------Exercicio 5 -------------
select e.NomeEmpregado as NomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento
	   from empregado e 
	   inner join departamento d on e.IDDepartamento = d.IDDepartamento
	   inner join empregado g on g.IDEmpregado = e.IDGerente; 

select * from Empregado;

--------Exercicio 6 ------------- Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados 
							-- que o departamento fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%

--select * into AuxEmpregado from Empregado;


update Empregado set salario = salario + ((salario * 0.145) where iddepartamento exists(
select iddepartamento from departamento where departamento.iddepartamento = empregado.iddepartamento and localizacao like '%SAO PAULO%');
--TESTAR
--------Exercicio 7 -------------
/*Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de todos os empregados.*/


select (e.salario - ae.salario) as reajuste from empregado e inner join AuxEmpregado ae on e.idempregado = ae.idempregado; 
--TESTAR


--------Exercicio 8 -------------

select top 1 with ties d.NomeDepartamento as [Departamento de empregados com maior salario] from departamento d inner join AuxEmpregado a  on d.IDDepartamento = a.IDDepartamento order by a.salario desc;


--select * from Departamento;
--select * from AuxEmpregado order by salario desc;

--------Exercicio 9 -------------

select a.nome as [Nome do associado e empregado], c.nome as [Cidade do Associado e localiza��o do departamento do empregado] from Associado a
inner join Cidade c on a.IDCidade = c.IDCidade
union 
select e.nomeempregado, d.Localizacao from AuxEmpregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento;

	

--------Exercicio 10 -------------

select IDCidade, nome from cidade c where exists (select 1 from associado a where c.IDCidade = a.IDCidade);
