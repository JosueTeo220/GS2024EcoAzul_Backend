CREATE DATABASE IF NOT EXISTS praias_db;
USE praias_db;

CREATE TABLE IF NOT EXISTS praia (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(255) NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    poluida BOOLEAN NOT NULL
    );

CREATE TABLE IF NOT EXISTS ong (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
    area_atuacao VARCHAR(255) NOT NULL
    );
INSERT INTO praia (nome, localizacao, poluida) VALUES ('Copacabana', 'Rio de Janeiro', false);
INSERT INTO praia (nome, localizacao, poluida) VALUES ('Praia do Futuro', 'Fortaleza', true);

INSERT INTO ong (nome, area_atuacao) VALUES ('ONG Limpar Mar', 'Limpeza de praias');
INSERT INTO ong (nome, area_atuacao) VALUES ('Associaçao Preservar', 'Preservaçao ambiental');
