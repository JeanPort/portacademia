
create table tbl_plano(
	id bigint not null auto_increment primary key,
    nome varchar(50) not null,
    descricao varchar(255) not null,
    valor decimal(10,2) not null
)Engine=innoDB;