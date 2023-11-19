INSERT INTO tb_list (name) VALUES ('Frutas');
INSERT INTO tb_list (name) VALUES ('Frutas2');

INSERT INTO tb_product (name, price, img_Url, short_Description) VALUES ('Laranja', 5, 'www.imglaranja.com', 'Laranja inteira');
INSERT INTO tb_product (name, price, img_Url, short_Description) VALUES ('Maçã', 7, 'www.imgmaca.com', 'Maçã argentina');
INSERT INTO tb_product (name, price, img_Url, short_Description) VALUES ('Banana', 10, 'www.imgbanana.com', 'Penca de banana');
INSERT INTO tb_product (name, price, img_Url, short_Description) VALUES ('Uva', 12, 'www.imguva.com', 'Uva sem semente');
INSERT INTO tb_product (name, price, img_Url, short_Description) VALUES ('Melancia', 8, 'www.imgmelancia.com', 'Melancia sem caroço');

INSERT INTO tb_belonging (list_id, product_id, position) VALUES (1, 1, 0)
INSERT INTO tb_belonging (list_id, product_id, position) VALUES (1, 2, 1)

INSERT INTO tb_belonging (list_id, product_id, position) VALUES (2, 3, 0)
INSERT INTO tb_belonging (list_id, product_id, position) VALUES (2, 4, 1)