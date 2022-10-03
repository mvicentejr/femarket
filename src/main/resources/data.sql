INSERT INTO CATEGORIA VALUES(1, 'Bebidas');
INSERT INTO CATEGORIA VALUES(2, 'Limpeza');
INSERT INTO CATEGORIA VALUES(3, 'Padaria');

INSERT INTO PRODUTO VALUES(1, 'Água Mineral 1L', 10, 2.30, 1);
INSERT INTO PRODUTO VALUES(2, 'Sabão em pó', 6, 5.00, 2);
INSERT INTO PRODUTO VALUES(3, 'Água Sanitária', 7, 7.60, 2);
INSERT INTO PRODUTO VALUES(4, 'Bisnaguinha', 7, 10.00, 3);
INSERT INTO PRODUTO VALUES(5, 'Bolo de Fubá', 3, 7.20, 3);
INSERT INTO PRODUTO VALUES(6, 'Pão Francês', 10, 14.00, 3);

INSERT INTO Endereco_Entrega (id_endereco, cliente, rua, numero) VALUES (1, 'Maria', 'R.Belmont', 350);

INSERT INTO Venda (id_venda, valor_total, data_venda, id_endereco) VALUES(1, 17.60, '2020-11-10', 1);
INSERT INTO Venda (id_venda, valor_total, data_venda, id_endereco) VALUES(2, 2.60, '2020-11-10', null);

INSERT INTO Produto_Vendido (id_venda, id_produto) VALUES(1, 2);
INSERT INTO Produto_Vendido (id_venda, id_produto) VALUES(1, 2);
INSERT INTO Produto_Vendido (id_venda, id_produto) VALUES(1, 3);
INSERT INTO Produto_Vendido (id_venda, id_produto) VALUES(2, 1);
INSERT INTO Produto_Vendido (id_venda, id_produto) VALUES(2, 1);