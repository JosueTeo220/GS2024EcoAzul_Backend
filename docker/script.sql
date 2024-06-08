DROP DATABASE IF EXISTS praias_db;

CREATE DATABASE IF NOT EXISTS praias_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE praias_db;

CREATE TABLE IF NOT EXISTS praia (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     nome VARCHAR(255) NOT NULL,
                                     cidade VARCHAR(255) NOT NULL,
                                     estado VARCHAR(255) NOT NULL,
                                     poluida BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS ong (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
                                   area_atuacao VARCHAR(255) NOT NULL,
                                   esta_atuando BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS fakeuser(
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nome VARCHAR(255) NOT NULL,
                                       fakepassword VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS registro (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        nome_pessoa VARCHAR(30) NOT NULL,
                                        cpf VARCHAR(11) NOT NULL ,
                                        data_report DATE NOT NULL,
                                        data_finalizado DATE,
                                        status_pendente BOOLEAN NOT NULL,
                                        descricao VARCHAR(255) NOT NULL,
                                        praia_id BIGINT NOT NULL,
                                        ong_id BIGINT,
                                        FOREIGN KEY (praia_id) REFERENCES praia(id),
                                        FOREIGN KEY (ong_id) REFERENCES ong(id)
);


INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Ipanema', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Leblon', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Leme', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Barra da Tijuca', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Prainha', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Grumari', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Flamengo', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('São Conrado', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Pontal', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Vidigal', 'Rio de Janeiro', 'Rio', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Boa Viagem', 'Recife', 'Pernambuco', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Porto de Galinhas', 'Ipojuca', 'Pernambuco', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Maracaípe', 'Ipojuca', 'Pernambuco', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Piedade', 'Jaboatão dos Guararapes', 'Pernambuco', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Candeias', 'Jaboatão dos Guararapes', 'Pernambuco', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Canoa Quebrada', 'Aracati', 'Ceará', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Jericoacoara', 'Jijoca de Jericoacoara', 'Ceará', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Morro Branco', 'Beberibe', 'Ceará', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Meireles', 'Fortaleza', 'Ceará', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Iracema', 'Fortaleza', 'Ceará', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Boa Vista', 'Vila Velha', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Itapoã', 'Vila Velha', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Itaparica', 'Vila Velha', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Camburi', 'Vitória', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Curva da Jurema', 'Vitória', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Guarapari', 'Guarapari', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Enseada Azul', 'Guarapari', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Setiba', 'Guarapari', 'Espírito Santo', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Praia Grande', 'Arraial do Cabo', 'Rio de Janeiro', false);
INSERT INTO praia (nome, cidade, estado, poluida) VALUES ('Forno', 'Arraial do Cabo', 'Rio de Janeiro', false);


INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Projeto Tamar', 'Conservação marinha', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('SOS Mata Atlântica', 'Preservação ambiental', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Greenpeace Brasil', 'Ativismo ambiental', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Instituto BiomaBrasil', 'Educação ambiental', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Guardians of the Sea', 'Proteção marinha', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Instituto Baleia Jubarte', 'Proteção de baleias', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('EcoSurf', 'Proteção costeira', false);
INSERT INTO ong (nome, area_atuacao, esta_atuando) VALUES ('Associação MarBrasil', 'Pesquisa marinha', false);


INSERT INTO fakeuser(nome, fakepassword) VALUES ('admin', 'admin');
