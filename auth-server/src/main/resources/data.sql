INSERT INTO public.authority (id, name, value) VALUES (1, 'query', 'query');
INSERT INTO public.role (id, name, value) VALUES (2, 'admin', 'ROLE_ADMIN');
INSERT INTO public.role (id, name, value) VALUES (3,  'user', 'ROLE_USER');
INSERT INTO public.user_account (id, email, firstname,  lastname, username, password) VALUES (1,  null,  null, null, 'admin', 'admin');
INSERT INTO public.user_account (id, email, firstname,  lastname, username, password) VALUES (2,  null,  null, null, 'user', 'user');
INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (2, 1);
INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (3, 1);
INSERT INTO public.user_account_roles (user_id, roles_id) VALUES (1, 2);
INSERT INTO public.user_account_roles (user_id, roles_id) VALUES (2, 3);