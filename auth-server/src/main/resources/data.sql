INSERT INTO public.authority (id, name, value) VALUES (1, 'query', 'query');
INSERT INTO public.role (id, name, value) VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO public.role (id, name, value) VALUES (2,  'userAccount', 'ROLE_USER');
INSERT INTO public.user_account (id, email, firstname,  lastname, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES (1,  null,  null, null, 'admin', '$2a$10$TWkFSV9i25IkE8zS6XwNe.yUmCygQnowA0B8VM1rj02pZ524LjD/W', true, true, true, true);
INSERT INTO public.user_account (id, email, firstname,  lastname, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES (2,  null,  null, null, 'userAccount', '$2y$10$1fDQoxb2MEkY9sModlESfuubjbrcwPB7U2b6OYH7ToK9GPAJjDyye', true, true, true, true);
INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (1, 1);
INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (2, 1);
INSERT INTO public.user_account_roles (user_account_id, roles_id) VALUES (1, 1);
INSERT INTO public.user_account_roles (user_account_id, roles_id) VALUES (2, 2);
