-- Retorna o total de registros por data (aba 1) --
Select Data, Count(1) total
From   LogNavegacaoConsolidado
Group  by Data
Order  by Data;