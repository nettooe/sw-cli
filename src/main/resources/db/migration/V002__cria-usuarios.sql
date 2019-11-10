-- insere um administrador com senha admin
INSERT INTO user (id, username, password) VALUES (1, 'admin', '$2a$10$VSWQWBg.PMiBzvePfqqas.ufY366fz0ak8TTm7VDwkNTkoZv/X30S');
-- insere um usuario com senha 132456
INSERT INTO user (id, username, password) VALUES (2, 'usuario1', '$2a$10$JxpCg.RzXMqkun0JOZnfjuQvl9EXrpWZe42h.bulT1S9npEeM.Os2');


INSERT INTO user_roles (user_id, role_id) VALUES (1, 4);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 5);