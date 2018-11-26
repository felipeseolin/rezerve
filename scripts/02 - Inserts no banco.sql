-- Inserts no baco de dados

--Table BLOCO
insert into bloco
    (BLOC_LETRA, BLOC_NOME, BLOC_DESCRICAO)
values
    ('A', 'Bloco A', 'Bloco Geral'),
    ('B', 'Bloco B', 'Bloco Geral'),
    ('C', 'Bloco C', 'Bloco Geral'),
    ('D', 'Bloco D', 'Bloco Geral'),
    ('E', 'Bloco E', 'Bloco Geral'),
    ('F', 'Bloco F', 'Bloco Geral'),
    ('G', 'Bloco G', 'Bloco Geral'),
    ('H', 'Bloco H', 'Bloco Geral'),
    ('I', 'Bloco I', 'Bloco Geral'),
    ('J', 'Bloco J', 'Bloco Geral'),
    ('K', 'Bloco K', 'Bloco Geral'),
    ('L', 'Bloco L', 'Bloco Geral'),
    ('M', 'Bloco M', 'Bloco Geral'),
    ('N', 'Bloco N', 'Bloco Geral'),
    ('O', 'Bloco O', 'Bloco Geral'),
    ('P', 'Bloco P', 'Bloco Geral'),
    ('Q', 'Bloco Q', 'Bloco Geral');

--Table DEPARTAMENTO
insert into departamento
    (DEP_SIGLA, DEP_NOME)
values
    ('DAMEC', 'Departamento Acadêmico de Mecânica'),
    ('DAELE', 'Departamento Acadêmico de Elétrica'),
    ('DACOM', 'Departamento Acadêmico de Computação'),
    ('DAMAT', 'Departamento Acadêmico de Matemática'),
    ('DACIN', 'Departamento Acadêmico de Ciências da Natureza'),
    ('DACHS', 'Departamento Acadêmico de Ciências Humanas e Sociais'),
    ('COGETI', 'Comitê Gestor de Tecnologia da Informação'),
    ('DEMAP', 'Departamento de Materiais e Patrimônio'),
    ('DIREC', 'Diretoria de Relações Empresariais e Comunitárias'),
    ('DIRPPG', 'Diretoria de Pesquisa e Pós-Graduação'),
    ('DIRGRAD', 'Diretoria de Graduação e Educação Profissional'),
    ('DEBIB', 'Departamento de Biblioteca'),
    ('DERAC', 'Departamento de Registros Acadêmicos'),
    ('DERDI', 'Departamento de Recursos Didáticos'),
    ('DIPROSI', 'Divisão de Projetos de Sistemas de Informação');

--Table TIPO_DE_SALA
insert into tipo_de_sala
    (TIPSAL_NOME)
values
    ('Sala de Aula'),
    ('Laboratório de Informática'),
    ('Sala de Estudos'),
    ('Sala de Reuniões'),
    ('Laboratório de Elétrica'),
    ('Laboratório de Redes'),
    ('Laboratório de Eletrônica'),
    ('Laboratório de Mecânica');

--Table SITUACAO
insert into situacao
    (SIT_NOME, SIT_MENSAGEM)
values
    ('Reserva Aprovada pelo Coordenador', 'A sala está Reservada.'),
    ('Aguardando decisão do coordenador', 'Esta sala está aguardando decisão de reserva.'),
    ('Cancelada pelo Usuário', 'O usuário cancelou a solicitação de reserva'),
    ('Cancelada pelo Coordenador', 'O coordenador não aceitou a solicitação de reserva');

--Table TIPO_DE_USUARIO
insert into tipo_de_usuario
    (TIPUS_SIGLA, TIPUS_NOME)
values
    ('ADMIN', 'Administrador'),
    ('COORD', 'Coordenador'),
    ('COMUM', 'Comum');

--Table USUARIO
insert into usuario
values
    (1, 'Felipe', 'Seolin Bento', 'fb@email.com', '$2a$10$ciewnTUMsQ.hHY9NW6lqQeTlsvRagSWne/zbi5PAJvzt74WMEGhQW', true, 15, 1);

--Table SALA
insert into sala
values
    ('A040', 040, 40, 40, 'Possui Datashow', true, 1, 1, 1),
    ('A032', 032, 45, 0, 'Datashow e Computador para professor', true, 2, 1, 1);

--Table RESERVA
insert into reserva
values ();

-- Fim dos inserts