INSERT INTO users
VALUES (1, 'admin', 'admin', 10, 'admin@gmail.ru', '1234');
INSERT INTO users
VALUES (2, 'user', 'user', 5, 'user@gmail.ru', '1111');

INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');

INSERT INTO users_roles VALUES (1, 1);
INSERT INTO users_roles VALUES (2, 2);