select NomeEmpregado as Nome, salario as SalarioMensal, (salario*12) as SalarioAnual from empregado;


select NomeEmpregado as Nome from empregado order by NomeEmpregado;

/*order by -> pode ser ordenado por uma coluna ou uma expressao(calculo) 
ASC - ascendente - default 
DESC - descendente*/

select idcidade, nome uf from cidade where nome like '% %';
/*verifica se o caracter exxiste dentro do nome*/

select idcidade, nome uf from cidade where nome like '%e';
/*verifica se o caracter exxiste no final do nome*/

select idcidade, nome uf from cidade where nome like 'e%';
/*verifica se o caracter exxiste no inicio do nome*/



select IDCidade, Nome, uf from cidade where uf ='RS' or uf='SC';

Select IDEmpregado, NomeEmpregado
From Empregado
Where salario between 1000
and 1500;

select count(idempregado) from empregado;


/*count não considera valores nulos*/
/*mesma coisa, sem diferença de performance*/
select count(*) from empregado;
select count(1) from empregado;

--possivel usar vaios counts juntos

select count(comissao) as [Contador comissao], count(idempregado) as [contador empregados] from empregado;

select count(1) as TotalEmpregados, count(Distinct Cargo) as totalcargos from empregado;

select distinct cargo from empregado;

select count(Distinct Cargo) as total_cargos from empregado;


select cargo, count(1) as total from empregado group by cargo;

-- group by já faz um distinct no dado selecionado 

-- Com GROUP BY usa-se HAVING ao inves de WHERE

-- HAVING somente quando for restringir a função de grupo COUNT, SUM, ADV


select nomeempregado, (salario + comissao) as total_sal_a, 
(Salario + (ISNULL(comissao, 0))) as total_sal_b, 
comissao from empregado;


select nome, replace(replace(nome, 'ção', 'cion'), 'são', 'san') nomeCidade, UF from cidade;










