-- Exibe a consolida��o dos dados do dia 03/04/2015 para 2 an�ncios --
Select *
  From   LogNavegacaoConsolidado
  Where  Data          = to_date('03/04/2015', 'dd/mm/yyyy')
    And  CodigoAnuncio in (567394, 1182616);