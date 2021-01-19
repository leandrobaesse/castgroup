create table categoria (
                           id bigint not null auto_increment,
                           codigo bigint not null,
                           descricao varchar(60) not null,
                           primary key (id)
);


create table curso (
                       id bigint not null auto_increment,
                       descricao varchar(60) not null,
                       data_inicio date not null,
                       data_fim date not null,
                       qtde_alunos bigint ,
                       categoria_id bigint not null,
                       primary key (id)
) ;

alter table curso add constraint fk_curso_categoria
    foreign key (categoria_id) references categoria (id);

insert into categoria (id, codigo,descricao) values (1,1, 'Comportamental');
insert into categoria (id, codigo,descricao) values (2,2, 'Programação');
insert into categoria (id, codigo,descricao) values (3,3, 'Qualidade');
insert into categoria (id, codigo,descricao) values (4,4, 'Processos');

