select * from Associado;

select * from CidadeAux;

select * from Cidade;



Select * into CopiaCidade from Cidade; /* COPIA DADOS E ESTRUTURA DA TABELA, MENOS CONSTRAINT */

begin transaction /*transaçõesss */

Update Cidade set nome = 'São Leopoldo' where IDCidade =  2;

rollback /*desfaz alterações*/

commit /*efetiva alterações*/


select * from cidade with(nolock) where idcidade = 1; /**/
