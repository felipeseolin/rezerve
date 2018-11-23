-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-18 23:52:03.524

-- enum
CREATE TYPE horario AS ENUM
(
    'M1',
    'M2', 
    'M3', 
    'M4', 
    'M5', 
    'M6', 
    'T1', 
    'T2', 
    'T3', 
    'T4', 
    'T5', 
    'T6', 
    'N1', 
    'N2', 
    'N3', 
    'N4', 
    'N5'
);

-- end

-- tables
-- Table: bloco
CREATE TABLE bloco
(
    BLOC_ID SERIAL NOT NULL,
    BLOC_LETRA char(1) NOT NULL,
    BLOC_NOME varchar(50) NOT NULL,
    BLOC_DESCRICAO text NULL,
    BLOC_ATIVO boolean DEFAULT TRUE NOT NULL,
    CONSTRAINT bloco_pk PRIMARY KEY (BLOC_ID)
);
insert into bloco
    (BLOC_LETRA, BLOC_NOME, BLOC_DESCRICAO)
values
    ('A', 'Bloco A', 'Bloco Geral'),
    ('B', 'Bloco B', 'Bloco Geral'),
    ('P', 'Bloco P', 'Bloco Geral'),
    ('G', 'Bloco G', 'Bloco Geral');

-- Table: departamento
CREATE TABLE departamento
(
    DEP_ID SERIAL NOT NULL,
    DEP_NOME varchar(150) NOT NULL,
    DEP_SIGLA varchar(10) NOT NULL,
    DEP_ATIVO boolean DEFAULT TRUE NOT NULL,
    CONSTRAINT departamento_pk PRIMARY KEY (DEP_ID)
);
insert into departamento
    (DEP_SIGLA, DEP_NOME)
values
    ('DACOM', 'Departamento Acadêmico de Computação'),
    ('DAMEC', 'Departamento Acadêmico de Mecânica'),
    ('DIPROSI', 'Divisão de Projetos de Sistemas de Informação');

-- Table: reserva
CREATE TABLE reserva
(
    RESER_ID SERIAL NOT NULL,
    RESER_MOTIVO varchar(300) NOT NULL,
    RESER_DATA date NOT NULL,
    RESER_HORARIO_INICIAL horario NOT NULL,
    RESER_HORARIO_FINAL horario NOT NULL,
    RESER_CONFIRMADA boolean NOT NULL DEFAULT FALSE,
    USU_ID int NOT NULL,
    SALA_ID varchar(15) NOT NULL,
    SIT_ID int NOT NULL,
    CONSTRAINT reserva_pk PRIMARY KEY (RESER_ID)
);

-- Table: sala
CREATE TABLE sala
(
    SALA_ID varchar(15) NOT NULL,
    SALA_NUM int NOT NULL,
    SALA_NUM_CADEIRAS int NOT NULL,
    SALA_NUM_COMP int NULL,
    SALA_DETALHES text NULL,
    SALA_ATIVA boolean DEFAULT TRUE NOT NULL,
    TIPSAL_ID int NOT NULL,
    DEP_ID int NOT NULL,
    BLOC_ID int NOT NULL,
    CONSTRAINT sala_pk PRIMARY KEY (SALA_ID)
);
insert into sala
values
    ('A040', 040, 40, 40, 'Possui Datashow', true, 1, 1, 1),
    ('A032', 032, 45, 0, 'Datashow e Computador para professor', true, 2, 1, 1);

-- Table: situacao
CREATE TABLE situacao
(
    SIT_ID SERIAL NOT NULL,
    SIT_NOME varchar(50) NOT NULL,
    SIT_MENSAGEM varchar(100) NOT NULL,
    CONSTRAINT situacao_pk PRIMARY KEY (SIT_ID)
);
insert into situacao
    (SIT_NOME, SIT_MENSAGEM)
values
    ('Reservada', 'A sala está Reservada'),
    ('Aguardando decisão', 'Esta sala está aguardando decisão de reserva'),
    ('Cancelada pelo Usuário', 'O usuário cancelou a reserva');

-- Table: tipo_de_sala
CREATE TABLE tipo_de_sala
(
    TIPSAL_ID SERIAL NOT NULL,
    TIPSAL_NOME varchar(50) NOT NULL,
    CONSTRAINT tipo_de_sala_pk PRIMARY KEY (TIPSAL_ID)
);
insert into tipo_de_sala
    (TIPSAL_NOME)
values
    ('Laboratório de Informática'),
    ('Sala de aula'),
    ('Sala de Estudos'),
    ('Sala de reuniões'),
    ('Sala de Elétrica');

-- Table: tipo_de_usuario
CREATE TABLE tipo_de_usuario
(
    TIPUS_ID SERIAL NOT NULL,
    TIPUS_SIGLA varchar(20) NOT NULL,
    TIPUS_NOME varchar(30) NOT NULL,
    CONSTRAINT tipo_de_usuario_pk PRIMARY KEY (TIPUS_ID)
);
insert into tipo_de_usuario
    (TIPUS_SIGLA, TIPUS_NOME)
values
    ('COORD', 'Coordenação'),
    ('ADMIN', 'Administrador'),
    ('NORMAL', 'Normal');

-- Table: usuario
CREATE TABLE usuario
(
    USU_ID SERIAL NOT NULL,
    USU_PNOME varchar(100) NOT NULL,
    USU_UNOME varchar(100) NOT NULL,
    USU_EMAIL varchar(30) NOT NULL,
    USU_SENHA varchar(20) NOT NULL UNIQUE,
    USU_ATIVO boolean NOT NULL DEFAULT TRUE,
    DEP_ID int NOT NULL,
    TIPUS_ID int NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (USU_ID)
);
insert into usuario
values
    (1, 'Felipe', 'Seolin Bento', 'fb@email.com', 'senha', true, 1, 2);

-- foreign keys

-- Reference: reserva_sala (table: reserva)
ALTER TABLE reserva ADD CONSTRAINT reserva_sala
    FOREIGN KEY (SALA_ID)
    REFERENCES sala (SALA_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: reserva_situacao (table: reserva)
ALTER TABLE reserva ADD CONSTRAINT reserva_situacao
    FOREIGN KEY (SIT_ID)
    REFERENCES situacao (SIT_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: reserva_usuario (table: reserva)
ALTER TABLE reserva ADD CONSTRAINT reserva_usuario
    FOREIGN KEY (USU_ID)
    REFERENCES usuario (USU_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sala_bloco (table: sala)
ALTER TABLE sala ADD CONSTRAINT sala_bloco
    FOREIGN KEY (BLOC_ID)
    REFERENCES bloco (BLOC_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sala_departamento (table: sala)
ALTER TABLE sala ADD CONSTRAINT sala_departamento
    FOREIGN KEY (DEP_ID)
    REFERENCES departamento (DEP_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sala_tipo_de_sala (table: sala)
ALTER TABLE sala ADD CONSTRAINT sala_tipo_de_sala
    FOREIGN KEY (TIPSAL_ID)
    REFERENCES tipo_de_sala (TIPSAL_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: usuario_departamento (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_departamento
    FOREIGN KEY (DEP_ID)
    REFERENCES departamento (DEP_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: usuario_tipo_de_usuario (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_tipo_de_usuario
    FOREIGN KEY (TIPUS_ID)
    REFERENCES tipo_de_usuario (TIPUS_ID)
NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Fuction to select all BLOCO
CREATE OR REPLACE FUNCTION listaBlocos
() RETURNS setof bloco AS 
'select * from BLOCO order by BLOC_NOME;'
language 'sql';

-- Fuction to select all DEPARTAMENTO
CREATE OR REPLACE FUNCTION listaDepartamentos
() RETURNS setof departamento AS 
'select * from DEPARTAMENTO order by DEP_NOME;'
language 'sql';

-- Fuction to select all TIPO DE SALA
CREATE OR REPLACE FUNCTION listaTipoDeSalas
() RETURNS setof tipo_de_sala AS 
'select * from TIPO_DE_SALA order by TIPSAL_NOME;'
language 'sql';

-- Fuction to select all SALA
CREATE OR REPLACE FUNCTION listaSalas
() RETURNS setof sala AS
'select * from SALA order by SALA_ID;'
LANGUAGE 'sql';

-- Fuction to select all TIPO_DE_USUARIO
CREATE OR REPLACE FUNCTION listaTipoDeUsuarios
() RETURNS setof tipo_de_usuario AS 
'select * from TIPO_DE_USUARIO order by TIPUS_SIGLA;'
language 'sql';

-- Fuction to select all USUARIO
CREATE OR REPLACE FUNCTION listaUsuarios
() RETURNS setof usuario AS
'select * from USUARIO order by USU_PNOME;'
LANGUAGE 'sql';

-- Fuction to select all SITUACAO
CREATE OR REPLACE FUNCTION listaSituacoes
() RETURNS setof situacao AS
'select * from SITUACAO order by SIT_ID;'
LANGUAGE 'sql';

-- Fuction to select all RESERVA
CREATE OR REPLACE FUNCTION listaReservas
() RETURNS setof reserva AS
'select * from RESERVA order by RESER_DATA desc;'
LANGUAGE 'sql';

-- End of file.