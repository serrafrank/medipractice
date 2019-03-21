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
