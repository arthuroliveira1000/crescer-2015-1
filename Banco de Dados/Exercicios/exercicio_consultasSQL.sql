/*EXERCÍCIOS*/

/*1*/

select NomeEmpregado as Nome from Empregado order by DataAdmissao;

/*2*/

select NomeEmpregado as Nome, (salario * 12)  as SalarioAnual from empregado where cargo = 'Atendente' or (salario * 12) < 18.500;

/*3*/

select idCidade, Nome from cidade where Nome = 'Uberlândia';

/*4*/

select Nome from cidade where UF = 'RS';

select * from cidade;