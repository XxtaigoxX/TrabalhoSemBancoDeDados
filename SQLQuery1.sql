create database trabalho
use trabalho
go
CREATE TABLE Categoria (
    id INT PRIMARY KEY IDENTITY,
    nome NVARCHAR(100) NOT NULL
);

CREATE TABLE Produto (
    id INT PRIMARY KEY IDENTITY,
    nome NVARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
);

CREATE TABLE Cliente (
    id INT PRIMARY KEY IDENTITY,
    nome NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL
);

CREATE TABLE Venda (
    id INT PRIMARY KEY IDENTITY,
    data DATE NOT NULL,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE ItemVenda (
    id INT PRIMARY KEY IDENTITY,
    venda_id INT,
    produto_id INT,
    quantidade INT,
    preco DECIMAL(10, 2),
    FOREIGN KEY (venda_id) REFERENCES Venda(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);	