-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-18 23:52:03.524

-- enum
CREATE TYPE horario AS ENUM
(
    'M1 (07h30 - 08h20)',
    'M2 (08h20 - 09h10)',
    'M3 (09h10 - 10h00)',
    'M4 (10h20 - 11h10)',
    'M5 (11h10 - 12h00)',
    'M6 (12h00 - 12h50)',
    'T1 (13h00 - 13h50)',
    'T2 (13h50 - 14h40)',
    'T3 (14h40 - 15h30)',
    'T4 (15h50 - 16h40)',
    'T5 (16h40 - 17h30)',
    'T6 (17h50 - 18h40)',
    'N1 (18h40 - 19h30)',
    'N2 (19h30 - 20h20)',
    'N3 (20h20 - 21h10)',
    'N4 (21h20 - 22h10)',
    'N5 (22h10 - 23h00)'
);
-- end of enum

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

-- Table: departamento
CREATE TABLE departamento
(
    DEP_ID SERIAL NOT NULL,
    DEP_NOME varchar(150) NOT NULL,
    DEP_SIGLA varchar(10) NOT NULL,
    DEP_ATIVO boolean DEFAULT TRUE NOT NULL,
    CONSTRAINT departamento_pk PRIMARY KEY (DEP_ID)
);

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

-- Table: situacao
CREATE TABLE situacao
(
    SIT_ID SERIAL NOT NULL,
    SIT_NOME varchar(50) NOT NULL,
    SIT_MENSAGEM varchar(100) NOT NULL,
    CONSTRAINT situacao_pk PRIMARY KEY (SIT_ID)
);

-- Table: tipo_de_sala
CREATE TABLE tipo_de_sala
(
    TIPSAL_ID SERIAL NOT NULL,
    TIPSAL_NOME varchar(50) NOT NULL,
    CONSTRAINT tipo_de_sala_pk PRIMARY KEY (TIPSAL_ID)
);

-- Table: tipo_de_usuario
CREATE TABLE tipo_de_usuario
(
    TIPUS_ID SERIAL NOT NULL,
    TIPUS_SIGLA varchar(20) NOT NULL,
    TIPUS_NOME varchar(30) NOT NULL,
    CONSTRAINT tipo_de_usuario_pk PRIMARY KEY (TIPUS_ID)
);

-- Table: usuario
CREATE TABLE usuario
(
    USU_ID SERIAL NOT NULL,
    USU_PNOME varchar(100) NOT NULL,
    USU_UNOME varchar(100) NOT NULL,
    USU_EMAIL varchar(30) NOT NULL,
    USU_SENHA varchar(200) NOT NULL UNIQUE,
    USU_ATIVO boolean NOT NULL DEFAULT TRUE,
    DEP_ID int NOT NULL,
    TIPUS_ID int NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (USU_ID)
);

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