/*EXERCICIO 1*/

insert into Associado(IDAssociado, Nome, DataNascimento, CPF,Sexo) values (1, 'Julio de Castilhos',convert(date,'14/12/1947', 103),'21234567895','M');

insert into Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) values (2, 'Antonio Augusto Borges de Medeiros',  convert(date,'19/03/1942', 103),'81234567891','M');

insert into Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) values (3, 'Osvaldo Aranha',  convert(date, '08/02/1958', 103),'01234567893','M');


/*EXERCICIO 2*/

select * into CidadeAux from Cidade;


/*EXERCICIO 3*/

truncate table CidadeAux;

insert into CidadeAux select * from Cidade;









