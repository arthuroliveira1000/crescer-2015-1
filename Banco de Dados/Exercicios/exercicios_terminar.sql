--EXERCICIOS 

--1
select substring(nome, 1, CHARINDEX(' ', nome)) [Primeiro Nome] from associado where idassociado = 1;

--2
select nome , DATEDIFF(yy, DataNascimento , GETDATE()) Idade from associado;

--3
select nomeempregado, datediff(mm, DataAdmissao, '31/12/2000') Total_De_Meses_trabalhodos_Até_31122000 from empregado where dataadmissao between '01/05/1980' and '20/01/1982';

--5
select * from associado group by max(Nome);