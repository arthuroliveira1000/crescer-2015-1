Create table Cidade
(
IDCidade	int NOT NULL, 
Nome		varchar(30) NOT NULL, 
UF			varchar(2)	NOT NULL,
	constraint PK_Cidade Primary Key (IDCidade), 
	constraint UKCidade_Nome Unique (Nome)
);


Create table Cliente 
(
IDCliente int IDENTITY NOT NULL, /*IDENTITY EQUIVALENTE AO AUTO_INCREMENT*/
Nome varchar(30) NOT NULL,
Endereco  varchar(35),
Bairro varchar(35),
IDCidade int
);

INSERT INTO Cliente (Nome, Endereco, Bairro) VALUES('Maria','Rua Bento Gonçalves, 123', 'Centro');
INSERT INTO Cidade VALUES (1, 'Novo Hamburgo', 'RS');

select * from Cidade;
select * from Cliente;


