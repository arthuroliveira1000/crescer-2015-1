-----------------SQL TRANSACTION

use [Crescer15-1];

/* SINTAXE
BEGIN
DECLARE @<NomeVariavel> <DataType>
{ blocos de instruções }
END
*/

BEGIN
DECLARE @Nome VarChar(30)
SET @Nome = 'CWI Software'

Print @Nome
END


-----------------------------


BEGIN
DECLARE @vIDCliente int
Select @vIDCliente = IDCliente
From Cliente
Where Nome = 'Mariana Ventura Che'
Print 'Mariana possui o código ' +
Cast(@vIDCliente AS VarChar(10))
END

BEGIN
	SET NOCOUNT ON
	DECLARE @vTamanho int

	--Busca o maior nome (caracteres)
	Select @vTamanho = MAX(Len(Nome))
	From Cliente
	
	--Lista todos os clientes cfe tamanho do nome
	Select IDCliente, Nome
	From Cliente
	Where Len(Nome) = @vTamanho

	SET NOCOUNT OFF
END

	BEGIN
	DECLARE @vCount int
	Select @vCount = COUNT(1)
	From Cliente

	IF (@vCount=0)
	Print 'Nenhum cliente cadastrado.'
		ELSE IF (@vCount=1)
		Print 'Um registro encontrado.'
			ELSE
			Print 'Muitos registros encontrados.'
END

BEGIN
	BEGIN TRY
	Begin Transaction
	Insert into Cidade (IDCidade, Nome, UF)
	Values (1, 'Morro da Pedra', 'RS');
	Commit
	END TRY
	BEGIN CATCH
	Rollback
	Print ERROR_MESSAGE()
	END CATCH
END
go


BEGIN
DECLARE ListaCidade CURSOR
	Local
	Fast_Forward
	FOR Select Nome, Uf
	From Cidade
	Group by Nome, Uf
	Having COUNT(1) > 1;

	DECLARE 
	@vNome varchar(50),
	@vUF varchar(2)

	OPEN ListaCidade;

	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	WHILE (@@FETCH_STATUS=0) BEGIN
	Print @vNome + '/'+@vUF;

	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
END
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END