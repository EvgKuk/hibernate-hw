CREATE TABLE consumers_products (consumer_id integer REFERENCES consumers (id), product_id integer REFERENCES products (id));
INSERT INTO products (id, "name", price) VALUES (1, 'кофе', 150 )
INSERT INTO products (id, "name", price) VALUES (2, 'молоко', 50 )
INSERT INTO products (id, "name", price) VALUES (3, 'сахар', 70 )
INSERT INTO products (id, "name", price) VALUES (4, 'круассан', 100 )
SELECT * FROM products
insert into consumers("id","name") values (1, 'Андрей')
insert into consumers("id","name") values (2, 'Валерий')
insert into consumers("id","name") values (3, 'Мария')
SELECT * FROM consumers