--cria��o de usu�rio
create user 
curso1 identified by curso1;

-- concedente permiss�es para conectar e criar objetos
grant connect, resource, create view to curso1;