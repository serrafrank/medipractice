INSERT INTO field (id, category, parameters)
VALUES ('d356a263-6127-40bc-813d-be0422d79b84', 'index',
        '{"input":false,"alwaysEnabled":false,"tableView":true,"className":"","label":"index","refreshOnChange":false,"type":"htmlelement","content":"<h2>Bienvenue !<\/h2>","key":"d356a263-6127-40bc-813d-be0422d79b84","attrs":[],"mask":false}');


INSERT into module (id, label, name)
VALUES ('43828d5b-75f8-4281-ae1b-e370329846e2', 'General', 'homepage'),
        ('0e172969-1841-48f1-a353-d27ccd4642c6', 'Administratif', 'admin'),
        ('747fbf5f-0840-47db-9dc9-46c88d08378f', 'Medical', 'medical');


INSERT INTO page (id, module_id, name, schema, sub_title, title, icon)
VALUES ('90889339-e314-4a76-bb7f-dfb5593af0a8', '43828d5b-75f8-4281-ae1b-e370329846e2', 'index',
        '{"components":[{"key":"d356a263-6127-40bc-813d-be0422d79b84"}],"display":"form"}', null, 'Accueil', 'icon-home');


INSERT INTO menu (id, icon, label, page_id, sort, root)
VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', null, 'Navigation',  null,  0, true),

       ('2fd962ec-c9c5-40f7-9177-25ba0efea7a5', null, 'Accueil', '90889339-e314-4a76-bb7f-dfb5593af0a8', 1, false),
       ('2e7031a1-d55a-4087-864c-e32fd804f29e', null, 'Administratif', null,  2, false),
       ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', null, 'Médical', null,  3, false),



        ('ebe18aa1-15e3-4f86-87e5-73a99362c439', null, 'Identité', '90889339-e314-4a76-bb7f-dfb5593af0a8', 4, false),
        ('06253b4a-a5e7-4c55-853f-4f68f07c821d', null, 'Adresse personnelle',  '90889339-e314-4a76-bb7f-dfb5593af0a8', 5, false),

        ('a770f832-cc8e-4afd-a60c-9cc82df1e629', null, 'Antécédants', '90889339-e314-4a76-bb7f-dfb5593af0a8', 6, false),
        ('ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be', null, 'Grossesses', '90889339-e314-4a76-bb7f-dfb5593af0a8', 7, false);

INSERT INTO menu_children (menu_id, children_id)
VALUES  ('e8ae63e9-a45d-4302-8e86-ade0012b8104', '2fd962ec-c9c5-40f7-9177-25ba0efea7a5'),
        ('e8ae63e9-a45d-4302-8e86-ade0012b8104', '2e7031a1-d55a-4087-864c-e32fd804f29e'),
        ('e8ae63e9-a45d-4302-8e86-ade0012b8104', 'fb1a207a-0ef8-4534-9cc5-c50ebf98f175'),

        ('2e7031a1-d55a-4087-864c-e32fd804f29e', 'ebe18aa1-15e3-4f86-87e5-73a99362c439'),
        ('2e7031a1-d55a-4087-864c-e32fd804f29e', '06253b4a-a5e7-4c55-853f-4f68f07c821d'),

        ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', 'ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be'),
        ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', 'a770f832-cc8e-4afd-a60c-9cc82df1e629');
