create database jobber;
use jobber;


create table conta(
conta_id int unsigned not null primary key auto_increment,
email varchar(255) not null unique,
nome varchar(100) not null,
senha varchar(45),
tipo int(1) not null
);

create table trabalho(
trabalho_id int unsigned not null primary key auto_increment,
conta_trabalhador_id int unsigned not null,
trabalho_nome varchar(100),
trabalho_descricao varchar(255),
trabalho_soma float,
trabalho_qtdFeedback int unsigned,
foreign key (conta_trabalhador_id) references conta(conta_id)
);

create table feedback(
feedback_id int unsigned not null primary key auto_increment,
trabalho_id int unsigned not null,
nota float,
comentario varchar(255),
foreign key (trabalho_id) references trabalho(trabalho_id)
);

create table processo(
processo_id int unsigned not null primary key auto_increment,
conta_cliente_id int unsigned not null,
trabalho_id int unsigned not null,
processo_status int,
chat_idChat int unsigned not null,
foreign key (conta_cliente_id) references conta(conta_id),
foreign key (trabalho_id) references trabalho(trabalho_id)
);

create table chat(
chat_id int unsigned not null auto_increment primary key ,
processo_id int unsigned not null,
foreign key (processo_id) references processo(processo_id)
);

create table mensagem(
mensagem_id int unsigned not null primary key auto_increment,
chat_id int unsigned not null,
conta_id int unsigned not null,
mensagem varchar(255),
foreign key (chat_id) references chat(chat_id),
foreign key (conta_id) references conta(conta_id)
);







