/*
  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  Retorna todos os anúncios do dia 03/04/2015 (entre 00:00 e 23:59) --
  Esta dica está no slide de otimização: https://github.com/CWISoftware/crescer-2015-1/blob/master/slides/modulo-02-banco-SQL/oracle/dia10/08%20-%20Banco%20de%20dados%20(Oracle)-%20Otimizacao.pdf
  ----> Lembre-se das dicas de índices ... leiam sobre "Acessos" no link acima
  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
Select IDLogNavegacao, 
       CodigoAnuncio, 
       DataNavegacao, 
       Acao, 
       IDUsuario, 
       IDLinkPatrocinado, 
       TipoAcao
From   LogNavegacao
Where  DataNavegacao between TO_DATE('03/04/2015', 'DD/MM/YYYY') 
                         and TO_DATE('03/04/2015', 'DD/MM/YYYY')+.99999 -- com isso será considerada a última hora do dia
  and  CodigoAnuncio = 567394
order by DataNavegacao;
