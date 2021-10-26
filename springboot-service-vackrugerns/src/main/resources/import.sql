INSERT INTO vaccine(id_vaccine, name) VALUES(1, 'Sputnik');
INSERT INTO vaccine(id_vaccine, name) VALUES(2, 'Astrazeneca');
INSERT INTO vaccine(id_vaccine, name) VALUES(3, 'Pfizer');
INSERT INTO vaccine(id_vaccine, name) VALUES(4, 'Jhonson&Jhonson');

INSERT INTO Rol (id_rol, name, description) VALUES (1, 'ADMIN', 'Admin');
INSERT INTO Rol (id_rol, name, description) VALUES (2, 'USER', 'User');
INSERT INTO Rol (id_rol, name, description) VALUES (3, 'DBA', 'DataBase administrator');

INSERT INTO users(id_user, doc_number, names, last_name, email, user_name, password, state_vaccine, state) values (1, '123456', 'pepito', 'perez', 'daniel.10510@gmail.com', 'pepe', '$2a$10$ckkkD0Avl/eJnH6GvsyxcOkbcPmzrXGRH54J0sk0VP/X0RW2fHqeq', 0, 1);