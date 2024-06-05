DROP DATABASE IF EXISTS praias_db;

CREATE DATABASE IF NOT EXISTS praias_db;

USE praias_db;

CREATE TABLE IF NOT EXISTS praia (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(255) NOT NULL,
                                     cidade VARCHAR(255) NOT NULL,
                                     estado VARCHAR(255) NOT NULL,
                                     poluida BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS ong (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
                                   area_atuacao VARCHAR(255) NOT NULL,
                                    esta_atuando BOOLEAN NOT NULL

);

CREATE TABLE IF NOT EXISTS fakeuser(
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    nome VARCHAR(255) NOT NULL,
                                    fakepassword VARCHAR(255) NOT NULL
);

INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Copacabana', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Praia do Futuro', 'Fortaleza', 'Ceará', true);

INSERT INTO ong (nome, area_atuacao,esta_atuando) VALUES ('ONG Limpar Mar', 'Limpeza de praias', true);
INSERT INTO ong (nome, area_atuacao,esta_atuando) VALUES ('Associação Preservar', 'Preservação ambiental',false);

INSERT INTO fakeuser(nome, fakepassword) VALUES ('admin', 'admin')