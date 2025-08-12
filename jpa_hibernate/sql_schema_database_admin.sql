CREATE TABLE Pessoa (id  integer, cpf varchar(255), data_nascimento date, email varchar(255), idade integer, nome varchar(255), primary key (id))
CREATE TABLE Produto (id  integer, nome varchar(255), preco double precision, quantidade integer, status boolean not null, primary key (id))
