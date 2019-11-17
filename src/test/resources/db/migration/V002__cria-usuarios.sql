-- insere um administrador com senha admin
INSERT INTO user (id, username, password) VALUES (1, 'admin', '$2a$10$Bda8NPv7pFMGKv/LK1qJIuNvzz72h/G4rGeyVP/SaPDbiLrvzgVu2');

-- insere um usuario com senha 132456
INSERT INTO user (id, username, password) VALUES (2, 'usuario1', '$2a$10$Bda8NPv7pFMGKv/LK1qJIuNvzz72h/G4rGeyVP/SaPDbiLrvzgVu2');


INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (1, 4);
INSERT INTO user_roles (USER_ID, ROLE_ID) VALUES (2, 5);