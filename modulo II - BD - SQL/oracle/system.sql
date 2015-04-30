--criação de usuário
create user 
curso1 identified by curso1;

-- concedente permissões para conectar e criar objetos
grant connect, resource, create view to curso1;