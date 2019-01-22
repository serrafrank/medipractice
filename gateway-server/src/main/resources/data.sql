INSERT INTO SERVER (id, name) VALUES (1, 'zuul');
INSERT INTO SERVER (id, name) VALUES (2, 'products');

INSERT INTO USER VALUES (1, '$2a$10$VfnpmiA5eeMcNkzpqAIoFOV8ADSPx6zQj2UJZBydaAteYlYXB02by', 'brunno');
INSERT INTO USER VALUES (2, '$2a$10$VfnpmiA5eeMcNkzpqAIoFOV8ADSPx6zQj2UJZBydaAteYlYXB02by', 'test');

INSERT INTO RESOURCE (id, path, method, server_id) VALUES (1, 'servers', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (2, 'servers', 'POST', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (3, 'servers/*', 'PUT', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (4, 'servers/*', 'DELETE', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (5, 'servers/*', 'GET', 1);

INSERT INTO RESOURCE (id, path, method, server_id) VALUES (6, 'users', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (7, 'users', 'POST', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (8, 'users/*', 'PUT', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (9, 'users/*', 'DELETE', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (10, 'users/*', 'GET', 1);

INSERT INTO RESOURCE (id, path, method, server_id) VALUES (11, 'authorities', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (12, 'authorities', 'POST', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (13, 'authorities/*', 'PUT', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (14, 'authorities/*', 'DELETE', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (15, 'authorities/*', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (16, 'authorities/user/*', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (17, 'authorities/services', 'GET', 1);

INSERT INTO RESOURCE (id, path, method, server_id) VALUES (18, 'resources/', 'GET', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (19, 'resources/', 'POST', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (20, 'resources/*', 'PUT', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (21, 'resources/*', 'DELETE', 1);
INSERT INTO RESOURCE (id, path, method, server_id) VALUES (22, 'resources/*', 'GET', 1);

INSERT INTO RESOURCE (id, path, method, server_id) VALUES (23, 'test', 'GET', 2);

INSERT INTO AUTHORITY (resource_id, user_id) VALUES (1, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (2, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (3, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (4, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (5, 1);

INSERT INTO AUTHORITY (resource_id, user_id) VALUES (6, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (7, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (8, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (9, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (10, 1);

INSERT INTO AUTHORITY (resource_id, user_id) VALUES (11, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (12, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (13, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (14, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (15, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (16, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (17, 1);

INSERT INTO AUTHORITY (resource_id, user_id) VALUES (18, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (19, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (20, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (21, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (22, 1);
INSERT INTO AUTHORITY (resource_id, user_id) VALUES (23, 1);

INSERT INTO AUTHORITY (resource_id, user_id) VALUES (17, 2);