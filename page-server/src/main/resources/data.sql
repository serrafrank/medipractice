INSERT INTO field (id, category, field_key, label, parameters) VALUES ('d356a263-6127-40bc-813d-be0422d79b84', 'htmlelement', 'htmlelement-index', 'index', '{"input":false,"alwaysEnabled":false,"tableView":true,"className":"","label":"index","refreshOnChange":false,"type":"htmlelement","content":"<h2>Bienvenue !<\/h2>","key":"htmlelement-index","attrs":[],"mask":false}');

INSERT INTO page (id, name, schema, sub_title, title, icon) VALUES ('90889339-e314-4a76-bb7f-dfb5593af0a8', 'index', '{"components":[{"field_key":"htmlelement-index"}],"display":"form"}', null, 'Accueil', 'icon-home');


INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', null, 'Navigation', null, 0, true);
INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('2fd962ec-c9c5-40f7-9177-25ba0efea7a5', null, 'Index', 	'index', 	1, false);
INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('ebe18aa1-15e3-4f86-87e5-73a99362c439', null, 'Index 1',	'index', 	2, false);
INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('06253b4a-a5e7-4c55-853f-4f68f07c821d', null, 'Index 2', 'index', 	3, false);
INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be', null, 'Index 3', 'index', 	4, false);
INSERT INTO menu (id, icon, label, page, sort, root) VALUES ('a770f832-cc8e-4afd-a60c-9cc82df1e629', null, 'Index 4', 'index', 	5, false);

INSERT INTO menu_children ( menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104' , '2fd962ec-c9c5-40f7-9177-25ba0efea7a5');
INSERT INTO menu_children ( menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104' , 'ebe18aa1-15e3-4f86-87e5-73a99362c439');
INSERT INTO menu_children ( menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104' , '06253b4a-a5e7-4c55-853f-4f68f07c821d');
INSERT INTO menu_children ( menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104' , 'ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be');
INSERT INTO menu_children ( menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104' , 'a770f832-cc8e-4afd-a60c-9cc82df1e629');
