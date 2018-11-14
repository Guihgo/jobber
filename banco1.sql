create table trabalho(
trabalho_id int unsigned not null primary key auto_increment,
conta_id int unsigned not null,
trabalho_nome varchar(100),
trabalho_descricao varchar(255),
trabalho_soma float,
trabalho_qtdFeedback int unsigned,
foreign key (conta_id) references conta(conta_id)
);


create table processo(
processo_id int unsigned not null primary key auto_increment,
conta_id int unsigned not null,
trabalho_id int unsigned
);


create table feedback(
feedback_id int unsigned not null primary key auto_increment,
trabalho_id int unsigned not null,
conta_id int unsigned not null,
nota float,
comentario varchar(255),
foreign key (trabalho_id) references trabalho(trabalho_id),
foreign key (conta_id) references conta(conta_id)
);




