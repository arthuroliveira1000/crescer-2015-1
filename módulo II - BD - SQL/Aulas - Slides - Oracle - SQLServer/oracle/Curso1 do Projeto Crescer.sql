CREATE TABLE pessoa
  (
    IDPessoa        INTEGER NOT NULL,
    Nome            VARCHAR2(50) NOT NULL,
    Data_Nascimento DATE,
    Endereco        VARCHAR2(35),
    cidade          VARCHAR2(50),
    uf              VARCHAR(2),
    CONSTRAINT PK_Pessoa PRIMARY KEY (IDPessoa)
  );
  
  
CREATE sequence sqPessoa;


  Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF) VALUES(sqPessoa.nextval, 'Maria Cavalcante', to_date('01/02/1990', 'dd/mm/yyyy'), 'Rua A, 230', 'Taquara', 'RS');
  Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF) VALUES(sqPessoa.nextval, 'Pedro de Souza', to_date('21/03/1985', 'dd/mm/yyyy'), 'Av. Ipiranga, 4200', 'Porto Alegre', 'RS');
  Insert into Pessoa (IDPessoa, Nome, Data_Nascimento, Endereco, Cidade, UF) VALUES(sqPessoa.nextval, 'Gustavo Kuerten', to_date('10/09/1976', 'dd/mm/yyyy'), 'Praia', 'Florianópolis', 'SC');
  
  select * from pessoa;
  
  select inicap('arthur oliveira da silva') from dual; 
  
  COMMIT;
  
  create directory CURSOSQL as 'C:\ORACLE\DATAPUMP';
  
  select * from user_objects;
  
  
  
  
  
  