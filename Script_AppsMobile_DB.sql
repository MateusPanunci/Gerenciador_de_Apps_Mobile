CREATE DATABASE gerenciamento_AppsMobile;

USE gerenciamento_AppsMobile;

CREATE TABLE Apps(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (100) NOT NULL unique,
    tamanho bigint NOT NULL,
    descricao TEXT NOT NULL,
    empresa_desenvolvedora VARCHAR(100),
    versao DECIMAL
);

ALTER TABLE apps_mobile ADD CONSTRAINT unique_nome UNIQUE (nome);

