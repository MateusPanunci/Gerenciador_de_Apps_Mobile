CREATE DATABASE gerenciamento_AppsMobile;

USE gerenciamento_AppsMobile;

CREATE TABLE Apps(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (100) NOT NULL unique,
    tamanho bigint NOT NULL,
	unidade_tamanho NOT NULL,
    descricao TEXT NOT NULL,
    empresa_desenvolvedora VARCHAR(100),
    versao DECIMAL
);

ALTER TABLE apps_mobile ADD CONSTRAINT unique_nome UNIQUE (nome);

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO usuarios (nome, email, senha) VALUES
('Gustavo Naozuka', 'gustavo.naozuka@email.com', 'admin123'),
('Carlos Mendes', 'carlos.mendes@email.com', 'cliente2024'),
('Ana Paula', 'ana.paula@email.com', 'senhaSegura1'),
('João Lima', 'joao.lima@email.com', '12345678'),
('Mariana Rocha', 'mariana.rocha@email.com', 'mari@2025'),
('Mateus Panunci Gonçalves', 'Mateuspanunci@gmail.com', 'opa123');
