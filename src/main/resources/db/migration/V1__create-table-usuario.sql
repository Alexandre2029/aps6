create table usuarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cargo varchar(100) not null,
    digital varchar(50) not null unique,

    primary key(id)

);