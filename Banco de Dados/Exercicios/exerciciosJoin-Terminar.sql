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

select * from associado;

insert into Associado values (4, 'Ana Paula ');
insert into Associado values (5, 'João Soares');