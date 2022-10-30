CREATE TABLE cliente (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
nome varchar(100)
);

CREATE TABLE produto (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
descricao varchar(100),
preco NUMERIC(20,2)
);

CREATE TABLE pedido (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
cliente_id INTEGER REFERENCES cliente (id),
data_pedido TIMESTAMP,
total NUMERIC(20,2)
);

CREATE TABLE item_pedido (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
pedido_id INTEGER REFERENCES pedido (id),
produto_id INTEGER REFERENCES produto (id),
quantidade INTEGER
);