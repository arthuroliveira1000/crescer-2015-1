use cursosql;

--------JOINNNN-------------


update associado set idcidade = 1 where idassociado = 1;

update associado set idcidade = 32 where idassociado = 3;

select * from Departamento;
--------Exercicio 1 -------------

select e.NomeEmpregado, d.NomeDepartamento from Empregado e Inner Join Departamento d on  e.IDDepartamento = d.IDDepartamento;


--------Exercicio 2 -------------

select a.Nome as NomeAssociado, c.Nome as NomeCidade from Cidade c Right Join Associado a on a.IDCidade = c.IDCidade;


--- remove o '*' do ínicio dos nomes -> update ciade set nome = replace(nome, '*', ' ') where nome like = '*%'


--------Exercicio 3 -------------

select c.uf, count(1) as [Total de cidades que não possuem associados] from cidade c where not exists (select 1 from associado a  where c.IDCidade = a.IDCidade) group by c.UF;  
-- quando usar o exist ou not exist 
--count não pode ser usado no exist
--------Exercicio 4 -------------


select a.nome as NomeAssociado, c.nome as NomeCidade, case 
													  when c.uf in ('RS', 'SC', 'PR') then '***'
												      else null
													  end [Cidade é da região sul] from cidade c Inner Join associado a on a.IDCidade = c.IDCidade;  
	
	
--------Exercicio 5 -------------
select e.NomeEmpregado as NomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento
	   from empregado e 
	   inner join departamento d on e.IDDepartamento = d.IDDepartamento
	   inner join empregado g on g.IDEmpregado = e.IDGerente; 

select * from Empregado;

--------Exercicio 6 ------------- Faça uma cópia da tabela Empregado e altere o salário de todos os empregados 
							-- que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%

--select * into AuxEmpregado from Empregado;

begin transaction 

update Empregado set Salario = (salario * 0.145) 


commit

update Empregado set salario = salario + ((salario * 0.145) where iddepartamento in(
select iddepartamento from departamento where departamento.iddepartamento = empregado.iddepartamento where localizacao like '%SAO PAULO%');
--TESTAR
--------Exercicio 7 -------------
/*Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos os empregados.*/

select (empregado.salario - empregadoaux.salario) as reajuste from empregado inner join empregadoaux on empregado.idempregado = empregadoaux.idempregado; 
--TESTAR


--------Exercicio 8 -------------

select top 1 with ties d.NomeDepartamento as [Departamento de empregados com maior salario] from departamento d inner join AuxEmpregado a  on d.IDDepartamento = a.IDDepartamento order by a.salario desc;


--select * from Departamento;
--select * from AuxEmpregado order by salario desc;

--------Exercicio 9 -------------

select a.nome as [Nome do associado e empregado], c.nome as [Cidade do Associado e localização do departamento do empregado] from Associado a
inner join Cidade c on a.IDCidade = c.IDCidade
union 
select e.nomeempregado, d.Localizacao from AuxEmpregado e
inner join Departamento d on e.IDDepartamento = d.IDDepartamento;

	

--------Exercicio 10 -------------

select IDCidade, nome from cidade c where exists (select 1 from associado a where c.IDCidade = a.IDCidade);

