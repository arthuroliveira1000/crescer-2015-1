select * from Associado;

select * from CidadeAux;

select * from Cidade;



Select * into CopiaCidade from Cidade; /* COPIA DADOS E ESTRUTURA DA TABELA, MENOS CONSTRAINT */

begin transaction /*transa��esss */

Update Cidade set nome = 'S�o Leopoldo' where IDCidade =  2;

rollback /*desfaz altera��es*/

commit /*efetiva altera��es*/


select * from cidade with(nolock) where idcidade = 1; /**/
