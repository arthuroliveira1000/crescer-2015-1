--------JOINNNN-------------


update associado set idcidade = 1 where idassociado = 1;

update associado set idcidade = 32 where idassociado = 3;

select * from Departamento;
--------Exercicio 1 -------------

select e.NomeEmpregado, d.NomeDepartamento from Empregado e Inner Join Departamento d on  e.IDDepartamento = d.IDDepartamento;


--------Exercicio 2 -------------

select a.Nome as NomeAssociado, c.Nome as NomeCidade from Cidade c Right Join Associado a on a.IDCidade = c.IDCidade;

--------Exercicio 3 -------------

select c.uf, count(1) as [Total de cidades que não possuem associados] from cidade c where exists (select 1 from associado a  where ISNULL(a.idcidade, 0) = 0) group by c.UF;  

--------Exercicio 4 -------------

select a.nome as NomeAssociado, c.nome as NomeCidade, case 
													  when c.uf in ('RS', 'SC', 'PR') then '***'
												      else ''
													  end [Cidade é da região sul] from cidade c Inner Join associado a on a.IDCidade = c.IDCidade;  
	
	
--------Exercicio 5 -------------
select e.NomeEmpregado as NomeEmpregado,
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento
	   from empregado e 
	   inner join departamento d on e.IDDepartamento = d.IDDepartamento
	   inner join empregado g on g.IDEmpregado = e.IDGerente; 

select * from Empregado;

--------Exercicio 6 -------------

begin transaction 

select * into AuxEmpregado from Empregado;

commit

update AuxEmpregado e set e.salario = salario + ((salario * 14.5) / 100) as SalarioComReajuste where exists (select 1 from departamento d where e.iddepartamento = d.iddepartamento and d.localidade = 'SP'); 

--------Exercicio 7 -------------



--------Exercicio 8 -------------

select top 1 with ties nome from departamento where exists (select 1 from empregado where max(count(salario)));

--nome? exists? innner join?

--------Exercicio 9 -------------

select a.nome, c.nome, e.nomeempregado, departamento.localidade from cidade c 
	join associado a on a.idcidade = c.idcidade,
	join empregado e on e.nomeempregado = departamento.departamento.

--------Exercicio 10 -------------

select IDCidade, nome from cidade c where exists (select 1 from associado a where c.cidade = a.associado);

