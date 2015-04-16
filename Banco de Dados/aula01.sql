Create table Cidade
(
IDCidade	int NOT NULL, 
Nome	varchar(30) NOT NULL, 
UF		varchar(2)	NOT NULL
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

select * from Cliente;

