--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-05-06 22:23:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 36239)
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority (
    id bigint NOT NULL,
    name character varying(255),
    value character varying(255)
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 36342)
-- Name: data_file; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.data_file (
    id uuid NOT NULL,
    archived_at timestamp without time zone,
    archived_by character varying(255),
    created_at timestamp without time zone NOT NULL,
    created_by character varying(255) NOT NULL,
    data_file uuid NOT NULL,
    date timestamp without time zone NOT NULL,
    type character varying(255) NOT NULL,
    updated_at timestamp without time zone,
    updated_by character varying(255),
    value character varying(8192) NOT NULL,
    archived_id uuid
);


ALTER TABLE public.data_file OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 36293)
-- Name: field; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.field (
    id uuid NOT NULL,
    category character varying(255),
    key character varying(1024),
    parameters jsonb
);


ALTER TABLE public.field OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 36237)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 26667)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    id uuid NOT NULL,
    icon character varying(255),
    label character varying(255) NOT NULL,
    root boolean NOT NULL,
    sort integer NOT NULL,
    page_id uuid
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 26675)
-- Name: menu_children; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu_children (
    menu_id uuid NOT NULL,
    children_id uuid NOT NULL
);


ALTER TABLE public.menu_children OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 36301)
-- Name: module; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.module (
    id uuid NOT NULL,
    icon character varying(255),
    label character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    sort integer
);


ALTER TABLE public.module OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 25834)
-- Name: module_pages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.module_pages (
    module_id uuid NOT NULL,
    pages_id uuid NOT NULL
);


ALTER TABLE public.module_pages OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 36309)
-- Name: page; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.page (
    id uuid NOT NULL,
    display character varying(255),
    icon character varying(255),
    name character varying(255) NOT NULL,
    schema jsonb,
    sort integer,
    sub_title text,
    title character varying(255),
    module_id uuid
);


ALTER TABLE public.page OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 36317)
-- Name: page_fields; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.page_fields (
    page_id uuid NOT NULL,
    fields character varying(255)
);


ALTER TABLE public.page_fields OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 36247)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255),
    value character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 36255)
-- Name: role_authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_authorities (
    role_id bigint NOT NULL,
    authorities_id bigint NOT NULL
);


ALTER TABLE public.role_authorities OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 36260)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    id bigint NOT NULL,
    account_non_expired boolean NOT NULL,
    account_non_locked boolean NOT NULL,
    credentials_non_expired boolean NOT NULL,
    email character varying(255),
    enabled boolean NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 36268)
-- Name: user_account_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account_roles (
    user_account_id bigint NOT NULL,
    roles_id bigint NOT NULL
);


ALTER TABLE public.user_account_roles OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 36239)
-- Dependencies: 200
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.authority (id, name, value) VALUES (1, 'query', 'query');


--
-- TOC entry 2914 (class 0 OID 36342)
-- Dependencies: 209
-- Data for Name: data_file; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.data_file (id, archived_at, archived_by, created_at, created_by, data_file, date, type, updated_at, updated_by, value, archived_id) VALUES ('15b37039-47f4-4a43-bd48-a88acd793db2', NULL, NULL, '2019-03-25 16:10:50.034', 'System', '77d2f026-0e20-4cc6-9ac4-66c4aa1f214b', '2019-03-25 16:10:50.059', 'prenom', '2019-03-25 16:10:50.034', 'System', 'Jean', NULL);


--
-- TOC entry 2910 (class 0 OID 36293)
-- Dependencies: 205
-- Data for Name: field; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.field (id, category, key, parameters) VALUES ('3a5be2fa-a10c-4d60-b4ba-9fa947ff1c29', 'checkbox', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme', '{"key": "checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme", "mask": false, "type": "checkbox", "input": true, "label": "Grossesse arrivée à terme", "reorder": false, "shortcut": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": false, "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('4960c4e6-a78a-4f45-9c28-a3a017fe59d7', 'checkbox', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme2', '{"key": "checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme2", "mask": false, "type": "checkbox", "input": true, "label": "Grossesse arrivée à terme", "reorder": false, "shortcut": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": false, "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('779953ca-a4e0-49a4-b816-6607f057184a', 'checkbox', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme3', '{"key": "checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme3", "mask": false, "type": "checkbox", "input": true, "label": "Grossesse arrivée à terme", "reorder": false, "shortcut": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": false, "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('3055fae4-7ca9-4bc9-8e60-7a038bd3c2df', 'checkbox', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme5', '{"key": "checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme5", "mask": false, "type": "checkbox", "input": true, "label": "Grossesse arrivée à terme", "reorder": false, "shortcut": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": false, "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('cbe5f190-b881-4852-a73b-019d8f273bfa', 'datetime', 'datetime_date_de_debut_datededebutgrossesse', '{"key": "datetime_date_de_debut_datededebutgrossesse", "mask": false, "type": "datetime", "input": true, "label": "Date de début", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": false, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('970323b5-ad54-445f-a189-950441086912', 'datetime', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant', '{"key": "datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant", "mask": false, "type": "datetime", "input": true, "label": "Date de début de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('e1d66afa-e8e8-4121-8bc8-60530389bd18', 'datetime', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant2', '{"key": "datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant2", "mask": false, "type": "datetime", "input": true, "label": "Date de début de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('a90f9424-8855-41bb-80f5-fbed89d8f014', 'datetime', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant3', '{"key": "datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant3", "mask": false, "type": "datetime", "input": true, "label": "Date de début de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ae0eb790-c052-41b6-9661-03e9456f31ff', 'datetime', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant4', '{"key": "datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant4", "mask": false, "type": "datetime", "input": true, "label": "Date de début de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('686f44f5-848c-4f89-8ff0-40efa699556b', 'number', 'number_%baso_baso', '{"key": "number_%baso_baso", "mask": false, "type": "number", "input": true, "label": "%BASO", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d309e4fb-fefb-4855-a4cd-845910332277', 'datetime', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant5', '{"key": "datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant5", "mask": false, "type": "datetime", "input": true, "label": "Date de début de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('462507eb-9068-4629-bd9c-43a46df2309f', 'datetime', 'datetime_date_de_fin_datedefingrossesse', '{"key": "datetime_date_de_fin_datedefingrossesse", "mask": false, "type": "datetime", "input": true, "label": "Date de fin", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('e5ff04f7-dcb9-4e42-b02a-afcca27be53a', 'datetime', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant', '{"key": "datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant", "mask": false, "type": "datetime", "input": true, "label": "Date de fin de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": null, "minDate": null, "language": "en", "time_24hr": false, "allowInput": true, "enableTime": false, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9c5013ae-d709-47c3-880e-64a0c406fe79', 'datetime', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant2', '{"key": "datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant2", "mask": false, "type": "datetime", "input": true, "label": "Date de fin de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ce38d00c-dfa7-4c37-9029-09abd709047c', 'datetime', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant3', '{"key": "datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant3", "mask": false, "type": "datetime", "input": true, "label": "Date de fin de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ac061012-d56b-479b-a01c-b885eff06c49', 'datetime', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant4', '{"key": "datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant4", "mask": false, "type": "datetime", "input": true, "label": "Date de fin de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('dcd8dd95-3135-401a-82a4-853bf8a5fd9d', 'datetime', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant5', '{"key": "datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant5", "mask": false, "type": "datetime", "input": true, "label": "Date de fin de grossesse", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('300daf8e-4e3c-4008-86a1-4aa33c8b108c', 'number', 'number_%baso_number_%baso_baso', '{"key": "number_%baso_number_%baso_baso", "mask": false, "type": "number", "input": true, "label": "%BASO", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('58971768-72c3-4707-8ae1-c93987c7a4a0', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant', '{"key": "datetime_date_de_naissance_datedenaissanceenfant", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": null, "minDate": null, "language": "en", "time_24hr": false, "allowInput": true, "enableTime": false, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ffafc1b6-75f7-4974-be35-31964d762833', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant2', '{"key": "datetime_date_de_naissance_datedenaissanceenfant2", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('1dde7694-1c64-49fe-a742-fbb349815b13', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant3', '{"key": "datetime_date_de_naissance_datedenaissanceenfant3", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('8ef32683-3381-4976-86df-bf2953cbc673', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant4', '{"key": "datetime_date_de_naissance_datedenaissanceenfant4", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('faa5428d-8295-4aee-9b86-213f1818b0d2', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant5', '{"key": "datetime_date_de_naissance_datedenaissanceenfant5", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('806cf7b6-007a-4d7d-896a-fc5399620ff5', 'datetime', 'datetime_date_de_naissance_datedenaissanceenfant6', '{"key": "datetime_date_de_naissance_datedenaissanceenfant6", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('7d745e41-ccb6-48f1-a1c1-1a3e600ee246', 'email', 'email_email_principal_emailprincipalperso', '{"key": "email_email_principal_emailprincipalperso", "type": "email", "input": true, "label": "Email principal", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c9d0fa75-4639-4efc-b671-33fd33f92f93', 'email', 'email_email_professionnel_emailprofessionnel', '{"key": "email_email_professionnel_emailprofessionnel", "type": "email", "input": true, "label": "Email professionnel", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('348e0ca5-4904-4cc4-8c48-b2dffe7c6d68', 'email', 'email_email_secondaire_emailsecondaireperso', '{"key": "email_email_secondaire_emailsecondaireperso", "type": "email", "input": true, "label": "Email secondaire", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ed5b7db4-bf6d-4b97-b1db-4959071c5643', 'number', 'number_%eos_eos', '{"key": "number_%eos_eos", "mask": false, "type": "number", "input": true, "label": "%EOS", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('7a7a0784-7de1-40d3-97b9-6c685668ed4f', 'number', 'number_%eos_number_%eos_eos', '{"key": "number_%eos_number_%eos_eos", "mask": false, "type": "number", "input": true, "label": "%EOS", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('02f17420-108f-42e0-a8dd-b73c7e046af8', 'number', 'number_%lym_lym', '{"key": "number_%lym_lym", "mask": false, "type": "number", "input": true, "label": "%LYM", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ba7dd379-b110-40d8-b254-05b34c330365', 'number', 'number_%lym_number_%lym_lym', '{"key": "number_%lym_number_%lym_lym", "mask": false, "type": "number", "input": true, "label": "%LYM", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('4114c60e-28f1-4d8b-bcb2-ef5ada97ca59', 'number', 'number_%mono_mono', '{"key": "number_%mono_mono", "mask": false, "type": "number", "input": true, "label": "%MONO", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('65380b9f-00c6-4124-8287-2aed4bb286fd', 'number', 'number_%mono_number_%mono_mono', '{"key": "number_%mono_number_%mono_mono", "mask": false, "type": "number", "input": true, "label": "%MONO", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('523fa656-0c53-4f72-8251-33bd1b26530f', 'number', 'number_%neu_neu', '{"key": "number_%neu_neu", "mask": false, "type": "number", "input": true, "label": "%NEU", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('2c5afbbb-379f-4431-987a-a0c20d4e7f5e', 'number', 'number_%neu_number_%neu_neu', '{"key": "number_%neu_number_%neu_neu", "mask": false, "type": "number", "input": true, "label": "%NEU", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('10144575-a6ad-4625-baf0-16f260cba799', 'number', 'number_%retic_number_%retic_retic', '{"key": "number_%retic_number_%retic_retic", "mask": false, "type": "number", "input": true, "label": "%RETIC", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c9dcbd1f-4761-44b9-907a-57b4f7e0c9e0', 'number', 'number_%retic_retic', '{"key": "number_%retic_retic", "mask": false, "type": "number", "input": true, "label": "%RETIC", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('950f707a-adb7-42f2-9e92-c59c4389d6f9', 'number', 'number_bun/crea_buncrea', '{"key": "number_bun/crea_buncrea", "mask": false, "type": "number", "input": true, "label": "BUN/CREA", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5ff79798-5aac-4d8b-936c-4f0fd9a2a72d', 'number', 'number_ca_ca', '{"key": "number_ca_ca", "mask": false, "type": "number", "input": true, "label": "Ca", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d5abf491-a8e2-4324-b375-a5c1ac5d8bbb', 'number', 'number_ccmh_ccmh', '{"key": "number_ccmh_ccmh", "mask": false, "type": "number", "input": true, "label": "CCMH", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('0ff12f88-a941-4bb0-9206-72b81618ed4b', 'number', 'number_ccmh_number_ccmh_ccmh', '{"key": "number_ccmh_number_ccmh_ccmh", "mask": false, "type": "number", "input": true, "label": "CCMH", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('332217a5-ae6e-4239-8f3b-99fb6857bdf3', 'number', 'number_cl_cl', '{"key": "number_cl_cl", "mask": false, "type": "number", "input": true, "label": "Cl", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('2af12e3e-ac6a-4a71-909b-b89f4e441ac3', 'number', 'number_creatinine_creatinine', '{"key": "number_creatinine_creatinine", "mask": false, "type": "number", "input": true, "label": "Créatinine", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('673eb5b1-6668-4909-b2d8-21ef28c6c45f', 'number', 'number_gb_gb', '{"key": "number_gb_gb", "mask": false, "type": "number", "input": true, "label": "GB", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('2eea5159-0c40-478f-9e69-8e3a5ec08fda', 'number', 'number_gb_number_gb_gb', '{"key": "number_gb_number_gb_gb", "mask": false, "type": "number", "input": true, "label": "GB", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('86ec7207-b582-4d00-acda-26759819c61d', 'number', 'number_gr_gr', '{"key": "number_gr_gr", "mask": false, "type": "number", "input": true, "label": "GR", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('3d9d968e-2450-4de4-b99e-c82b9d9630b1', 'number', 'number_gr_number_gr_gr', '{"key": "number_gr_number_gr_gr", "mask": false, "type": "number", "input": true, "label": "GR", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('15c3df4b-419f-447c-963c-20d2ef1d04ca', 'number', 'number_hct_hct', '{"key": "number_hct_hct", "mask": false, "type": "number", "input": true, "label": "HCT", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c8e72ed0-7ccb-4777-9330-a7547a4f0b81', 'number', 'number_hct_number_hct_hct', '{"key": "number_hct_number_hct_hct", "mask": false, "type": "number", "input": true, "label": "HCT", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('45dc740f-66c2-4950-a404-4c0cb7d657bb', 'number', 'number_hgb_hgb', '{"key": "number_hgb_hgb", "mask": false, "type": "number", "input": true, "label": "HGB", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d0f69ee6-e90d-40f2-99fa-4ff6f55bec17', 'number', 'number_hgb_number_hgb_hgb', '{"key": "number_hgb_number_hgb_hgb", "mask": false, "type": "number", "input": true, "label": "HGB", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('2b9005ca-6535-42ba-a291-2ff456470d1a', 'number', 'number_idr_idr', '{"key": "number_idr_idr", "mask": false, "type": "number", "input": true, "label": "IDR", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('8704a112-9842-4a67-8363-a9ba3d3f351a', 'number', 'number_idr_number_idr_idr', '{"key": "number_idr_number_idr_idr", "mask": false, "type": "number", "input": true, "label": "IDR", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('34295aae-e4b3-4aac-88a4-f7bd5615dcaf', 'number', 'number_k_k', '{"key": "number_k_k", "mask": false, "type": "number", "input": true, "label": "K", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('85498bdc-80d8-48e5-b906-59d88455a135', 'number', 'number_na/k_nak', '{"key": "number_na/k_nak", "mask": false, "type": "number", "input": true, "label": "Na/K", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('08bf60e0-b7ec-4dcd-996f-ed464e3d3f95', 'number', 'number_na_na', '{"key": "number_na_na", "mask": false, "type": "number", "input": true, "label": "Na", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('a3872056-6a16-421a-bdea-1e64c19f21f8', 'number', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance', '{"key": "number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance", "mask": false, "type": "number", "input": true, "label": "Périmètre crânien à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('33560e27-3901-4ec8-8877-9c9894f79472', 'number', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance2', '{"key": "number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance2", "mask": false, "type": "number", "input": true, "label": "Périmètre crânien à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9a455420-f23e-4c8c-93c1-320b6a8ad60f', 'number', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance3', '{"key": "number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance3", "mask": false, "type": "number", "input": true, "label": "Périmètre crânien à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ad925a00-40c1-46ef-ac80-ca8e837c030b', 'number', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance4', '{"key": "number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance4", "mask": false, "type": "number", "input": true, "label": "Périmètre crânien à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('e3fbfa35-d629-471a-8ce4-951b07116677', 'number', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance5', '{"key": "number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance5", "mask": false, "type": "number", "input": true, "label": "Périmètre crânien à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('095b84a9-bef9-43de-82a2-909738ea529d', 'number', 'number_phos_phos', '{"key": "number_phos_phos", "mask": false, "type": "number", "input": true, "label": "PHOS", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('528eb28c-9c34-4ec1-b2d8-06aedb1e754b', 'number', 'number_poids_a_la_naissance_poidsalanaissance', '{"key": "number_poids_a_la_naissance_poidsalanaissance", "mask": false, "type": "number", "input": true, "label": "Poids à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('3ba92627-399e-401c-970a-3197d56ec731', 'number', 'number_poids_a_la_naissance_poidsalanaissance2', '{"key": "number_poids_a_la_naissance_poidsalanaissance2", "mask": false, "type": "number", "input": true, "label": "Poids à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('f12dce71-afe7-4847-9b13-998f3efb7149', 'number', 'number_poids_a_la_naissance_poidsalanaissance3', '{"key": "number_poids_a_la_naissance_poidsalanaissance3", "mask": false, "type": "number", "input": true, "label": "Poids à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('a14406d6-7b7b-4cd5-a129-71eb6cb0f4d6', 'number', 'number_poids_a_la_naissance_poidsalanaissance4', '{"key": "number_poids_a_la_naissance_poidsalanaissance4", "mask": false, "type": "number", "input": true, "label": "Poids à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c31e4b22-adbc-4477-bfcc-5c20276011ea', 'number', 'number_poids_a_la_naissance_poidsalanaissance5', '{"key": "number_poids_a_la_naissance_poidsalanaissance5", "mask": false, "type": "number", "input": true, "label": "Poids à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('b1b82a01-e8d9-4a4f-88b0-76dad0fde5d7', 'number', 'number_retic_number_retic_retic2', '{"key": "number_retic_number_retic_retic2", "mask": false, "type": "number", "input": true, "label": "RETIC", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('75cd9cdf-ce13-4131-a615-fd82cf5bd883', 'number', 'number_retic_retic2', '{"key": "number_retic_retic2", "mask": false, "type": "number", "input": true, "label": "RETIC", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('af738810-e484-47b4-9acb-ba6ab37454ed', 'number', 'number_taille_a_la_naissance_taillealanaissance', '{"key": "number_taille_a_la_naissance_taillealanaissance", "mask": false, "type": "number", "input": true, "label": "Taille à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('7d6dae7d-c823-4ea7-9f0b-5bb7a1407de1', 'number', 'number_taille_a_la_naissance_taillealanaissance2', '{"key": "number_taille_a_la_naissance_taillealanaissance2", "mask": false, "type": "number", "input": true, "label": "Taille à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('641d8d6c-ff35-4c06-8e98-8057e1cc701c', 'number', 'number_taille_a_la_naissance_taillealanaissance3', '{"key": "number_taille_a_la_naissance_taillealanaissance3", "mask": false, "type": "number", "input": true, "label": "Taille à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('25ebfa43-1e8f-4b83-9ca2-8951a99a791c', 'number', 'number_taille_a_la_naissance_taillealanaissance4', '{"key": "number_taille_a_la_naissance_taillealanaissance4", "mask": false, "type": "number", "input": true, "label": "Taille à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('daa3563c-9f21-4800-af05-9300d4ae3064', 'number', 'number_taille_a_la_naissance_taillealanaissance5', '{"key": "number_taille_a_la_naissance_taillealanaissance5", "mask": false, "type": "number", "input": true, "label": "Taille à la naissance", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d250832c-b8f1-4967-a5b1-05c5c357881d', 'number', 'number_tcmh_number_tcmh_tcmh', '{"key": "number_tcmh_number_tcmh_tcmh", "mask": false, "type": "number", "input": true, "label": "TCMH", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('982e1102-1a0f-4d9e-979d-75a3be3aac59', 'number', 'number_tcmh_tcmh', '{"key": "number_tcmh_tcmh", "mask": false, "type": "number", "input": true, "label": "TCMH", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('51db47e1-5ece-42dc-bc9a-05fc0fa26a99', 'number', 'number_uree_uree', '{"key": "number_uree_uree", "mask": false, "type": "number", "input": true, "label": "Urée", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('298325c9-3552-4934-afa7-d76a49a8702d', 'number', 'number_vgm_number_vgm_vgm', '{"key": "number_vgm_number_vgm_vgm", "mask": false, "type": "number", "input": true, "label": "VGM", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('28f3d6a2-a126-4070-977b-8cf3decae557', 'number', 'number_vgm_vgm', '{"key": "number_vgm_vgm", "mask": false, "type": "number", "input": true, "label": "VGM", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('39c42402-129b-463e-931d-2a814c64a0c3', 'phoneNumber', 'phonenumber_numero_de_telephone_numerodetelephoneconjoint', '{"key": "phonenumber_numero_de_telephone_numerodetelephoneconjoint", "mask": false, "type": "phoneNumber", "input": true, "label": "Numéro de téléphone", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "99 99 99 99 99", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d5af7a19-4ffb-4df3-be15-c9b90f9b385a', 'phoneNumber', 'phonenumber_telephone_fixe_telephonefixeperso', '{"key": "phonenumber_telephone_fixe_telephonefixeperso", "type": "phoneNumber", "input": true, "label": "Téléphone fixe", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "inputMask": "99 99 99 99 99", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('0216e6a7-12a4-4aed-bef0-2198a303fd07', 'phoneNumber', 'phonenumber_telephone_portable_telephoneportableperso', '{"key": "phonenumber_telephone_portable_telephoneportableperso", "type": "phoneNumber", "input": true, "label": "Téléphone portable", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "inputMask": "99 99 99 99 99", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('86f5331c-e328-4f52-a2b0-beb131642a1e', 'phoneNumber', 'phonenumber_telephone_professionnel__telephoneprofessionnel', '{"key": "phonenumber_telephone_professionnel__telephoneprofessionnel", "type": "phoneNumber", "input": true, "label": "Téléphone professionnel ", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "inputMask": "99 99 99 99 99", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('f959e58f-a9b0-4224-8e58-36c64bec73ca', 'select', 'select_genre_genre', '{"key": "select_genre_genre", "data": {"values": [{"label": "Masculin", "value": "masculin", "shortcut": null}, {"label": "Feminin", "value": "feminin", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Genre", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('b74ab37b-0f5e-48ed-894c-4ff7fbf9fc86', 'select', 'select_genre_genreconjoint', '{"key": "select_genre_genreconjoint", "data": {"values": [{"label": "Monsieur", "value": "monsieur", "shortcut": null}, {"label": "Madame", "value": "madame", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Genre", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('76c33a8c-8bb3-4fb7-94fc-424ef04aa0b0', 'textarea', 'textarea_allergies__allergies', '{"key": "textarea_allergies__allergies", "mask": false, "type": "textarea", "input": true, "label": "Allergies ", "editor": "ckeditor", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 5, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('95e5e201-5517-41b8-9706-38eed2e4cf9d', 'number', 'number_quantites_d_unites_d_alcool_moyennes_consommees_par_jour_quantitesdalcoolmoyennesparjour', '{"key": "number_quantites_d_unites_d_alcool_moyennes_consommees_par_jour_quantitesdalcoolmoyennesparjour", "mask": false, "type": "number", "input": true, "label": "Quantités d''unités d''alcool moyennes consommées par jour", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9833906c-3339-40b0-ac88-f23eb5030cdb', 'selectboxes', 'selectboxes_type_de_stupefiants_consommes_typedestupefiantsconsommes', '{"key": "selectboxes_type_de_stupefiants_consommes_typedestupefiantsconsommes", "mask": false, "type": "selectboxes", "input": true, "label": "Type de stupéfiants consommés", "inline": false, "values": [{"label": "Cannabis", "value": "cannabis", "shortcut": ""}, {"label": "Psilocybine", "value": "psilocybine", "shortcut": ""}, {"label": "Méthadone", "value": "methadone", "shortcut": ""}, {"label": "Héroïne", "value": "heroine", "shortcut": ""}, {"label": "Cocaïne", "value": "cocaine", "shortcut": ""}], "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": {"cocaine": false, "heroine": false, "cannabis": false, "methadone": false, "psilocybine": false}, "alwaysEnabled": false, "customConditional": "", "optionsLabelPosition": "right"}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c00da455-1816-4fa5-afb8-d089f71c0f8d', 'textarea', 'textarea_commentaire_commentaire', '{"key": "textarea_commentaire_commentaire", "mask": false, "type": "textarea", "input": true, "label": "Commentaire", "editor": "", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 3, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('522bf903-607c-4e6b-aa39-079d6dac241d', 'textarea', 'textarea_commentaire_commentaire2', '{"key": "textarea_commentaire_commentaire2", "mask": false, "type": "textarea", "input": true, "label": "Commentaire", "editor": "", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 3, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('620f94e4-4ada-43b1-bc67-5d76db12d537', 'textarea', 'textarea_commentaire_commentaire3', '{"key": "textarea_commentaire_commentaire3", "mask": false, "type": "textarea", "input": true, "label": "Commentaire", "editor": "", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 3, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('dba7e710-7864-4136-8b0b-935397caefbc', 'textarea', 'textarea_commentaire_commentaire4', '{"key": "textarea_commentaire_commentaire4", "mask": false, "type": "textarea", "input": true, "label": "Commentaire", "editor": "", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 3, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('fde807ab-53cc-426c-a676-8862db183737', 'textarea', 'textarea_commentaire_commentaire5', '{"key": "textarea_commentaire_commentaire5", "mask": false, "type": "textarea", "input": true, "label": "Commentaire", "editor": "", "widget": {"mode": null, "type": null, "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 3, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('8f5e5018-b6b7-4e69-b5ab-1c14055040e1', 'textfield', 'textfield_adresse_adresseconjoint', '{"key": "textfield_adresse_adresseconjoint", "type": "textfield", "input": true, "label": "Adresse", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5051a34e-223a-4963-b9d2-6286253547a8', 'textfield', 'textfield_activite_processionnelle_activiteprocessionnelle', '{"key": "textfield_activite_processionnelle_activiteprocessionnelle", "type": "textfield", "input": true, "label": "Activité professionnelle", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('7ef00c8c-e114-42e3-a64f-15785fd849f6', 'textfield', 'textfield_code_postal_codepostaladresseperso', '{"key": "textfield_code_postal_codepostaladresseperso", "type": "textfield", "input": true, "label": "Code Postal", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5d30ce35-65cf-4948-a209-eb076626c6ed', 'textfield', 'textfield_entreprise_entreprise', '{"key": "textfield_entreprise_entreprise", "type": "textfield", "input": true, "label": "Entreprise", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c27b3f10-8875-452d-89f0-e5ac636adba8', 'textfield', 'textfield_lieu_de_naissance_lieudenaissance', '{"key": "textfield_lieu_de_naissance_lieudenaissance", "type": "textfield", "input": true, "label": "Lieu de naissance", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('bc206e4e-a3bb-47ad-a7f3-9adfca23e214', 'textfield', 'textfield_nom_de_naissance_nomdenaissance', '{"key": "textfield_nom_de_naissance_nomdenaissance", "type": "textfield", "input": true, "label": "Nom de naissance", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('c7594b35-896a-41b8-b556-daf6aa566f40', 'textfield', 'textfield_nom_nomconjoint', '{"key": "textfield_nom_nomconjoint", "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('fab46ffe-a07f-4575-96d1-19540094861a', 'textfield', 'textfield_nom_nomenfant', '{"key": "textfield_nom_nomenfant", "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('632af5aa-b3a8-4361-b1f6-b7be66b0b807', 'textfield', 'textfield_nom_textfield_nom_nomconjoint', '{"key": "textfield_nom_textfield_nom_nomconjoint", "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5ef9a444-81c9-4149-a36e-409ce9621a9e', 'textfield', 'textfield_nom_textfield_nom_nomenfant', '{"key": "textfield_nom_textfield_nom_nomenfant", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('e29faacd-7a24-43a7-8520-44018e77110f', 'textfield', 'textfield_nom_textfield_nom_nomenfant2', '{"key": "textfield_nom_textfield_nom_nomenfant2", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('6e484939-f9ff-4563-85e8-59f8c496602d', 'button', 'button_submit_submit2', '{"key": "button_submit_submit2", "url": "", "mask": false, "type": "button", "event": "", "input": true, "label": "Submit", "theme": "primary", "custom": "", "reorder": false, "shortcut": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": false, "alwaysEnabled": false, "showValidations": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('4b259e29-11c3-43d4-a0d5-f2e1bed00a8b', 'textfield', 'textfield_nom_textfield_nom_nomenfant3', '{"key": "textfield_nom_textfield_nom_nomenfant3", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('6aba0da1-7b2d-4a8a-8950-3971f2bf6ed5', 'textfield', 'textfield_nom_textfield_nom_nomenfant4', '{"key": "textfield_nom_textfield_nom_nomenfant4", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('a36c1498-b066-4a36-a3d3-a784ea7fef8a', 'textfield', 'textfield_nom_textfield_nom_nomenfant5', '{"key": "textfield_nom_textfield_nom_nomenfant5", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('1999c1e9-b3a4-42e4-b92e-99f14a35cff1', 'textfield', 'textfield_nom_textfield_nom_nomenfant6', '{"key": "textfield_nom_textfield_nom_nomenfant6", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('491ebe92-4acf-4ccc-9dc0-2b9820ab99aa', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomconjoint', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomconjoint", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('0e81b19f-cb97-4068-950e-e39f1420c663', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('b95e833f-fcdf-48d9-85cb-b9acb2c16825', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant2', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant2", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('f741c31c-f0d7-4684-b8a5-05c25b1d781d', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant3', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant3", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('fe6b8a4c-37f3-4b37-8b41-1639b42962a2', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant4', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant4", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d56e54e0-69e2-43ea-a676-228bccc19219', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant5', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant5", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('df81347d-4080-44d6-8176-89b753f126e5', 'textfield', 'textfield_nom_textfield_nom_textfield_nom_nomenfant6', '{"key": "textfield_nom_textfield_nom_textfield_nom_nomenfant6", "mask": false, "type": "textfield", "input": true, "label": "Nom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('886f7c78-0328-4179-8b2d-2f1de7f9a880', 'textfield', 'textfield_nom_usuel_nomusuel', '{"key": "textfield_nom_usuel_nomusuel", "type": "textfield", "input": true, "label": "Nom usuel", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('aac25a58-b0e9-4482-ad7b-8e04844c8c9b', 'textfield', 'textfield_numero_numeroadresseperso', '{"key": "textfield_numero_numeroadresseperso", "type": "textfield", "input": true, "label": "Numero", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5972ca9e-2bbf-4c97-8e3b-6ee3f116817d', 'textfield', 'textfield_prenom_prenom', '{"key": "textfield_prenom_prenom", "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('60247c06-b943-4151-83b8-9248b0cab69d', 'textfield', 'textfield_prenom_prenomconjoint', '{"key": "textfield_prenom_prenomconjoint", "type": "textfield", "input": true, "label": "Prenom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('dc59d344-72bb-4b61-8ec1-581c875c50ce', 'textfield', 'textfield_prenom_prenomenfant', '{"key": "textfield_prenom_prenomenfant", "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('e16fb22d-4fdc-46da-a30c-0bc4c8c0a98e', 'textfield', 'textfield_prenom_prenomenfant2', '{"key": "textfield_prenom_prenomenfant2", "mask": false, "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('61587d8a-a348-4232-a4ae-32821ed3e6d8', 'textfield', 'textfield_prenom_prenomenfant3', '{"key": "textfield_prenom_prenomenfant3", "mask": false, "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('a5e22882-41ef-4c8a-83d0-31e3dc00881b', 'textfield', 'textfield_prenom_prenomenfant4', '{"key": "textfield_prenom_prenomenfant4", "mask": false, "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5aeb0af3-33ca-4aab-95b9-3beeec392560', 'textfield', 'textfield_prenom_prenomenfant5', '{"key": "textfield_prenom_prenomenfant5", "mask": false, "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('f827cb61-3ca2-497e-8ec2-65baee8c7ba0', 'textfield', 'textfield_prenom_prenomenfant6', '{"key": "textfield_prenom_prenomenfant6", "mask": false, "type": "textfield", "input": true, "label": "Prénom", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('d7f3dfd3-ab40-4e11-b1be-88bc36b2a313', 'textfield', 'textfield_rue_rueadresseperso', '{"key": "textfield_rue_rueadresseperso", "type": "textfield", "input": true, "label": "Rue", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('bc93e656-97d7-4de8-9b61-f2a7b09b3ae4', 'textfield', 'textfield_ville_villeadresseperso', '{"key": "textfield_ville_villeadresseperso", "type": "textfield", "input": true, "label": "Ville", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('fe5b19fa-6726-4cc7-ad62-e0518697dc51', 'textfield', 'textfield_numero_de_securite_sociale_numerodesecuritesociale', '{"key": "textfield_numero_de_securite_sociale_numerodesecuritesociale", "type": "textfield", "input": true, "label": "Numéro de Sécurité Sociale", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "inputMask": "999999999999999", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('6884a958-ee69-4878-b87e-a832e37678cb', 'datetime', 'datetime_date_de_naissance_datedenaissance', '{"key": "datetime_date_de_naissance_datedenaissance", "mask": false, "type": "datetime", "input": true, "label": "Date de naissance", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('061a2672-deed-428a-a756-cc5e588ee721', 'datetime', 'datetime_date_de_deces_datededeces', '{"key": "datetime_date_de_deces_datededeces", "mask": false, "type": "datetime", "input": true, "label": "Date de décès", "format": "dd/MM/yyyy", "suffix": true, "widget": {"mode": "single", "type": "calendar", "format": "dd/MM/yyyy", "maxDate": "", "minDate": "", "language": "en", "time_24hr": false, "allowInput": true, "enableTime": true, "noCalendar": false, "defaultDate": "", "hourIncrement": 1, "minuteIncrement": 1, "displayInTimezone": "viewer", "useLocaleSettings": false}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "datePicker": {"maxDate": "", "minDate": ""}, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('3c128c70-3748-47e0-ba33-3c34a0fa23ee', 'textfield', 'textfield_autre_autre', '{"key": "textfield_autre_autre", "mask": false, "type": "textfield", "input": true, "label": "Autre", "widget": {"mode": null, "type": "", "format": "yyyy-MM-dd hh:mm a", "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": false, "inputMask": "", "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('2ed6a35f-0271-4326-bc7b-4af9a31726f0', 'select', 'select_diabete_diabete', '{"key": "select_diabete_diabete", "data": {"values": [{"label": "Non", "value": "non", "shortcut": null}, {"label": "Type I", "value": "typeI", "shortcut": null}, {"label": "Type II", "value": "typeIi", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Diabète", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9ef73877-8e05-49f7-a206-f436f68ca540', 'select', 'select_type_de_travail_activitephysique', '{"key": "select_type_de_travail_activitephysique", "data": {"values": [{"label": "Travail sédentaire ", "value": "travailSedentaire", "shortcut": null}, {"label": "Travail léger : marche, petite manutention (moins de 10 kg)", "value": "travailLegerMarchePetiteManutentionMoinsDe10Kg", "shortcut": null}, {"label": "Travail moyen : manutention d’objets assez lourds (entre 10 kg et 25 kg)", "value": "travailMoyenManutentionDobjetsAssezLourdsEntre10KgEt25Kg", "shortcut": null}, {"label": "Travaux de force : manutention lourde (25 kg et plus)", "value": "travauxDeForceManutentionLourde25KgEtPlus", "shortcut": null}, {"label": "N’a jamais travaillé", "value": "naJamaisTravaille", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Type de travail", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9ce10ae6-8227-40c4-9bff-d2cd9013f96c', 'select', 'select_activite_sportive_activitesportive', '{"key": "select_activite_sportive_activitesportive", "data": {"values": [{"label": "Néant", "value": "neant", "shortcut": null}, {"label": "Marche à pied / Vélo, moins de 15 minutes par trajet", "value": "marcheAPiedVeloMoinsDe15MinutesParTrajet", "shortcut": null}, {"label": "Marche à pied / Vélo, 15 minutes et plus par trajet", "value": "marcheAPiedVelo15MinutesEtPlusParTrajet", "shortcut": null}, {"label": "Activité sportive,  moins de 2 heures par semaine", "value": "activiteSportiveMoinsDe2HeuresParSemaine", "shortcut": null}, {"label": "Activité sportive,  2 heures et plus par semaine", "value": "activiteSportive2HeuresEtPlusParSemaine", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Activité sportive", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('5a08ad52-e8df-421f-be41-4c5456cdfd2b', 'number', 'number_nombre_d_annees_de_tabagisme_nombredanneesdetabagisme', '{"key": "number_nombre_d_annees_de_tabagisme_nombredanneesdetabagisme", "mask": false, "type": "number", "input": true, "label": "Nombre d''années de tabagisme", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('9305bedd-082d-4b5f-a268-79e42ddf1639', 'number', 'number_quantites_de_cigarettes_moyennes_fumees_par_jour_quantitesdecigarettesmoyennesfumeesparjour', '{"key": "number_quantites_de_cigarettes_moyennes_fumees_par_jour_quantitesdecigarettesmoyennesfumeesparjour", "mask": false, "type": "number", "input": true, "label": "Quantités de cigarettes moyennes fumées par jour", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('cc07e289-fffd-4ba7-b7a6-bdf85764961e', 'number', 'number_nombre_d_annees_de_consommation_nombredanneesdalcoolisme', '{"key": "number_nombre_d_annees_de_consommation_nombredanneesdalcoolisme", "mask": false, "type": "number", "input": true, "label": "Nombre d''années de consommation", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "hideLabel": false, "refreshOn": "", "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('653afd44-0f7d-4641-85aa-3d5861798ba9', 'number', 'number_poids_poids', '{"key": "number_poids_poids", "mask": false, "type": "number", "input": true, "label": "Poids", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('6e97d3c4-caeb-45e8-9b60-3f8063f19ce3', 'textarea', 'textarea_antecedents_medicaux_antecedentsmedicaux', '{"key": "textarea_antecedents_medicaux_antecedentsmedicaux", "type": "textarea", "input": true, "label": "Antécédents médicaux", "editor": "ckeditor", "nbrRows": 5, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('6b1b79e6-1368-46eb-ac2f-224fb6c59299', 'textarea', 'textarea_antecedents_chirurgicaux_antecedentschirurgicaux', '{"key": "textarea_antecedents_chirurgicaux_antecedentschirurgicaux", "type": "textarea", "input": true, "label": "Antécédents chirurgicaux", "editor": "ckeditor", "nbrRows": 5, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ac201457-2b40-40c1-8b19-43a28c25d797', 'number', 'number_taille_taille', '{"key": "number_taille_taille", "mask": false, "type": "number", "input": true, "label": "Taille", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('4afa15d1-697f-4e54-bd5b-e451263da781', 'number', 'number_rythme_cardiaque_rythmecardiaque', '{"key": "number_rythme_cardiaque_rythmecardiaque", "mask": false, "type": "number", "input": true, "label": "Rythme cardiaque", "reorder": false, "validate": {"json": "", "customMessage": ""}, "delimiter": false, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "requireDecimal": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('de394d70-7b31-4c05-85a6-7163208b5f4b', 'textfield', 'textfield_tension_arterielle_tensionarterielle', '{"key": "textfield_tension_arterielle_tensionarterielle", "type": "textfield", "input": true, "label": "Tension artérielle", "widget": {"mode": null, "type": "", "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "customConditional": "", "allowMultipleMasks": false}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('ebc9543d-0773-4a15-9a1c-1b2a0557744c', 'select', 'select_groupe_sanguin_groupesanguin', '{"key": "select_groupe_sanguin_groupesanguin", "data": {"values": [{"label": "A+", "value": "a+", "shortcut": null}, {"label": "A-", "value": "a-", "shortcut": null}, {"label": "B+", "value": "b+", "shortcut": null}, {"label": "B-", "value": "b-", "shortcut": null}, {"label": "AB+", "value": "ab+", "shortcut": null}, {"label": "AB-", "value": "ab-", "shortcut": null}, {"label": "O+", "value": "o+", "shortcut": null}, {"label": "O-", "value": "o-", "shortcut": null}]}, "mask": false, "sort": "", "type": "select", "input": true, "label": "Groupe sanguin", "reorder": false, "validate": {"json": "", "customMessage": ""}, "encrypted": false, "tableView": true, "conditional": {"json": "", "show": null, "when": ""}, "defaultValue": "", "alwaysEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('8ee4a314-fc9c-44b8-92d5-f7e56dcbb9d5', 'textarea', 'textarea_allergies_allergies', '{"key": "textarea_allergies_allergies", "type": "textarea", "input": true, "label": "Allèrgies", "widget": {"mode": null, "type": null, "format": null, "maxDate": null, "minDate": null, "language": null, "time_24hr": null, "allowInput": null, "enableTime": null, "noCalendar": null, "defaultDate": null, "hourIncrement": null, "minuteIncrement": null, "displayInTimezone": null, "useLocaleSettings": null}, "nbrRows": 5, "reorder": false, "wysiwyg": "", "validate": {"json": "", "customMessage": ""}, "encrypted": false, "hideLabel": true, "tableView": true, "uploadDir": "", "uploadUrl": "", "conditional": {"json": "", "show": null, "when": ""}, "inputFormat": "plain", "defaultValue": "", "alwaysEnabled": false, "showCharCount": false, "showWordCount": false, "uploadOptions": "", "isUploadEnabled": false, "customConditional": ""}');
INSERT INTO public.field (id, category, key, parameters) VALUES ('20abb85c-22c3-4c84-bbbf-8b8181acf11e', 'button', 'button_submit_submit', '{"key": "submit", "type": "button", "input": true, "label": "Submit", "theme": "primary", "validate": {"json": null, "customMessage": null}, "tableView": true, "conditional": {"json": null, "show": null, "when": null}, "disableOnInvalid": true}');


--
-- TOC entry 2902 (class 0 OID 26667)
-- Dependencies: 197
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', NULL, 'Navigation', true, 0, NULL);
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('2fd962ec-c9c5-40f7-9177-25ba0efea7a5', NULL, 'Accueil', false, 1, '90889339-e314-4a76-bb7f-dfb5593af0a8');
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('2e7031a1-d55a-4087-864c-e32fd804f29e', NULL, 'Administratif', false, 2, NULL);
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', NULL, 'Médical', false, 3, NULL);
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('ebe18aa1-15e3-4f86-87e5-73a99362c439', NULL, 'Identité', false, 4, '90889339-e314-4a76-bb7f-dfb5593af0a8');
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('06253b4a-a5e7-4c55-853f-4f68f07c821d', NULL, 'Adresse personnelle', false, 5, '90889339-e314-4a76-bb7f-dfb5593af0a8');
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('a770f832-cc8e-4afd-a60c-9cc82df1e629', NULL, 'Antécédants', false, 6, '90889339-e314-4a76-bb7f-dfb5593af0a8');
INSERT INTO public.menu (id, icon, label, root, sort, page_id) VALUES ('ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be', NULL, 'Grossesses', false, 7, '90889339-e314-4a76-bb7f-dfb5593af0a8');


--
-- TOC entry 2903 (class 0 OID 26675)
-- Dependencies: 198
-- Data for Name: menu_children; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu_children (menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', '2fd962ec-c9c5-40f7-9177-25ba0efea7a5');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', '2e7031a1-d55a-4087-864c-e32fd804f29e');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('e8ae63e9-a45d-4302-8e86-ade0012b8104', 'fb1a207a-0ef8-4534-9cc5-c50ebf98f175');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('2e7031a1-d55a-4087-864c-e32fd804f29e', 'ebe18aa1-15e3-4f86-87e5-73a99362c439');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('2e7031a1-d55a-4087-864c-e32fd804f29e', '06253b4a-a5e7-4c55-853f-4f68f07c821d');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', 'ace60f7d-d5f8-4a1a-8f46-afb6b3ff80be');
INSERT INTO public.menu_children (menu_id, children_id) VALUES ('fb1a207a-0ef8-4534-9cc5-c50ebf98f175', 'a770f832-cc8e-4afd-a60c-9cc82df1e629');


--
-- TOC entry 2911 (class 0 OID 36301)
-- Dependencies: 206
-- Data for Name: module; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.module (id, icon, label, name, sort) VALUES ('747fbf5f-0840-47db-9dc9-46c88d08378f', NULL, 'Administratif', 'admin', 1);
INSERT INTO public.module (id, icon, label, name, sort) VALUES ('0e172969-1841-48f1-a353-d27ccd4642c6', NULL, 'Medical', 'medical', 2);


--
-- TOC entry 2901 (class 0 OID 25834)
-- Dependencies: 196
-- Data for Name: module_pages; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2912 (class 0 OID 36309)
-- Dependencies: 207
-- Data for Name: page; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('76263802-d131-480d-8770-ae81045224b9', NULL, NULL, 'addressPerso', '{"display": null, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 2, "offset": 0, "tableView": true, "components": [{"internalKey": "textfield_numero_numeroadresseperso"}, {"internalKey": "textfield_code_postal_codepostaladresseperso"}], "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 10, "offset": 0, "tableView": true, "components": [{"internalKey": "textfield_rue_rueadresseperso"}, {"internalKey": "textfield_ville_villeadresseperso"}], "hideOnChildrenHidden": false}], "reorder": false, "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 2, NULL, 'Adresse personnelle', '747fbf5f-0840-47db-9dc9-46c88d08378f');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', NULL, NULL, 'divers', '{"display": null, "components": [{"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Conjoint", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"internalKey": "select_genre_genreconjoint"}, {"internalKey": "textfield_nom_textfield_nom_nomconjoint"}, {"internalKey": "textfield_prenom_prenomconjoint"}, {"internalKey": "textfield_adresse_adresseconjoint"}, {"internalKey": "phonenumber_numero_de_telephone_numerodetelephoneconjoint"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 1", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 2", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant2"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant2"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant2"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 3", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant3"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant3"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant3"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 4", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant4"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant4"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant4"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 5", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant5"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant5"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant5"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panelEnfant", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "info", "title": "Enfant 6", "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "components": [{"key": "columns", "mask": false, "type": "columns", "input": false, "label": "Columns", "columns": [{"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_nom_textfield_nom_textfield_nom_nomenfant6"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "textfield_prenom_prenomenfant6"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}, {"key": "", "pull": 0, "push": 0, "type": "column", "input": true, "label": "", "width": 4, "offset": 0, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": true, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissanceenfant6"}], "conditional": {"json": null, "show": null, "when": null}, "hideOnChildrenHidden": false}], "reorder": false, "validate": {"json": null, "customMessage": null}, "hideLabel": false, "refreshOn": "", "tableView": false, "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": "", "hideOnChildrenHidden": false}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 6, NULL, 'Entourage Familial', '747fbf5f-0840-47db-9dc9-46c88d08378f');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', NULL, NULL, 'contact', '{"display": null, "components": [{"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Téléphone", "reorder": false, "tableView": false, "components": [{"internalKey": "phonenumber_telephone_fixe_telephonefixeperso"}, {"internalKey": "phonenumber_telephone_portable_telephoneportableperso"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Internet", "reorder": false, "tableView": false, "components": [{"internalKey": "email_email_principal_emailprincipalperso"}, {"internalKey": "email_email_secondaire_emailsecondaireperso"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit2"}]}', 4, NULL, 'Contact', '747fbf5f-0840-47db-9dc9-46c88d08378f');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('bbda452e-1d70-43a5-ac81-59563c3356a4', NULL, NULL, 'atcd', '{"display": null, "components": [{"internalKey": "textarea_antecedents_medicaux_antecedentsmedicaux"}, {"internalKey": "textarea_antecedents_chirurgicaux_antecedentschirurgicaux"}, {"internalKey": "textarea_allergies__allergies"}, {"internalKey": "button_submit_submit"}]}', 11, NULL, 'Antécédents et synthèses', '0e172969-1841-48f1-a353-d27ccd4642c6');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('4bd6b18b-ee2f-4924-9c2b-a72efc13c956', NULL, NULL, 'catAtcdStruc', '{"display": null, "components": [{"internalKey": "textarea_antecedents_medicaux_antecedentsmedicaux"}, {"internalKey": "textarea_antecedents_chirurgicaux_antecedentschirurgicaux"}, {"internalKey": "button_submit_submit"}]}', 15, NULL, 'Antécédents', '0e172969-1841-48f1-a353-d27ccd4642c6');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', NULL, NULL, 'activity', '{"display": null, "components": [{"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Profession", "reorder": false, "tableView": false, "components": [{"internalKey": "textfield_activite_processionnelle_activiteprocessionnelle"}, {"internalKey": "textfield_entreprise_entreprise"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Contact", "reorder": false, "tableView": false, "components": [{"internalKey": "phonenumber_telephone_professionnel__telephoneprofessionnel"}, {"internalKey": "email_email_professionnel_emailprofessionnel"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 5, NULL, 'Activité', '747fbf5f-0840-47db-9dc9-46c88d08378f');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', NULL, NULL, 'dataBio', '{"display": null, "components": [{"key": "bilanBiologique", "mask": false, "type": "tabs", "input": false, "label": "Bilan biologique", "reorder": false, "tableView": true, "components": [{"key": "formuleSanguine", "label": "Formule sanguine", "components": [{"internalKey": "number_gr_number_gr_gr"}, {"internalKey": "number_hct_number_hct_hct"}, {"internalKey": "number_hgb_number_hgb_hgb"}, {"internalKey": "number_vgm_number_vgm_vgm"}, {"internalKey": "number_tcmh_number_tcmh_tcmh"}, {"internalKey": "number_ccmh_number_ccmh_ccmh"}, {"internalKey": "number_idr_number_idr_idr"}, {"internalKey": "number_%retic_number_%retic_retic"}, {"internalKey": "number_retic_number_retic_retic2"}, {"internalKey": "number_gb_number_gb_gb"}, {"internalKey": "number_%neu_number_%neu_neu"}, {"internalKey": "number_%lym_number_%lym_lym"}, {"internalKey": "number_%mono_number_%mono_mono"}, {"internalKey": "number_%eos_number_%eos_eos"}, {"internalKey": "number_%baso_number_%baso_baso"}]}, {"key": "bilanRenal", "label": "Bilan rénal", "components": [{"internalKey": "number_uree_uree"}, {"internalKey": "number_creatinine_creatinine"}, {"internalKey": "number_bun/crea_buncrea"}]}, {"key": "electrolytes", "label": "Électrolytes", "components": [{"internalKey": "number_phos_phos"}, {"internalKey": "number_na_na"}, {"internalKey": "number_ca_ca"}, {"internalKey": "number_k_k"}, {"internalKey": "number_na/k_nak"}, {"internalKey": "number_cl_cl"}]}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 13, NULL, 'Bilan biologique', '0e172969-1841-48f1-a353-d27ccd4642c6');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', NULL, NULL, 'grossesse', '{"display": null, "components": []}', 17, NULL, 'Grossesse', '0e172969-1841-48f1-a353-d27ccd4642c6');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', NULL, NULL, 'identity', '{"display": null, "components": [{"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Identité", "reorder": false, "tableView": false, "components": [{"internalKey": "select_genre_genre"}, {"internalKey": "textfield_nom_usuel_nomusuel"}, {"internalKey": "textfield_nom_de_naissance_nomdenaissance"}, {"internalKey": "textfield_prenom_prenom"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Naissance", "reorder": false, "tableView": false, "components": [{"internalKey": "datetime_date_de_naissance_datedenaissance"}, {"internalKey": "textfield_lieu_de_naissance_lieudenaissance"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "warning", "title": "Décès", "reorder": false, "tableView": false, "components": [{"internalKey": "datetime_date_de_deces_datededeces"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 1, NULL, 'Etat civil', '747fbf5f-0840-47db-9dc9-46c88d08378f');
INSERT INTO public.page (id, display, icon, name, schema, sort, sub_title, title, module_id) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', NULL, NULL, 'dataCliniques', '{"display": null, "components": [{"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Mensurations", "reorder": false, "validate": {"json": null, "customMessage": null}, "tableView": false, "components": [{"internalKey": "number_taille_taille"}, {"internalKey": "number_poids_poids"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Données biologiques", "reorder": false, "validate": {"json": null, "customMessage": null}, "tableView": false, "components": [{"internalKey": "number_rythme_cardiaque_rythmecardiaque"}, {"internalKey": "textfield_tension_arterielle_tensionarterielle"}, {"internalKey": "select_groupe_sanguin_groupesanguin"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"key": "panel", "mask": false, "type": "panel", "input": false, "label": "Panel", "theme": "primary", "title": "Allergies", "reorder": false, "validate": {"json": null, "customMessage": null}, "tableView": false, "components": [{"internalKey": "textarea_allergies_allergies"}], "conditional": {"json": "", "show": null, "when": ""}, "alwaysEnabled": false, "customConditional": ""}, {"internalKey": "button_submit_submit"}]}', 10, NULL, 'Données cliniques', '0e172969-1841-48f1-a353-d27ccd4642c6');


--
-- TOC entry 2913 (class 0 OID 36317)
-- Dependencies: 208
-- Data for Name: page_fields; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.page_fields (page_id, fields) VALUES ('bbda452e-1d70-43a5-ac81-59563c3356a4', 'textarea_antecedents_medicaux_antecedentsmedicaux');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bbda452e-1d70-43a5-ac81-59563c3356a4', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bbda452e-1d70-43a5-ac81-59563c3356a4', 'textarea_antecedents_chirurgicaux_antecedentschirurgicaux');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bbda452e-1d70-43a5-ac81-59563c3356a4', 'textarea_allergies__allergies');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_poids_a_la_naissance_poidsalanaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_fin_de_grossesse_datedefindegrossesseenfant');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'textarea_commentaire_commentaire');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'checkbox_grossesse_arrivee_a_terme_grossessearriveeaterme');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'textarea_commentaire_commentaire2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'textarea_commentaire_commentaire3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'textarea_commentaire_commentaire4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'textarea_commentaire_commentaire5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_taille_a_la_naissance_taillealanaissance5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_taille_a_la_naissance_taillealanaissance4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_taille_a_la_naissance_taillealanaissance3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_taille_a_la_naissance_taillealanaissance2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('76263802-d131-480d-8770-ae81045224b9', 'textfield_code_postal_codepostaladresseperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('76263802-d131-480d-8770-ae81045224b9', 'textfield_rue_rueadresseperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('76263802-d131-480d-8770-ae81045224b9', 'textfield_ville_villeadresseperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('76263802-d131-480d-8770-ae81045224b9', 'textfield_numero_numeroadresseperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('76263802-d131-480d-8770-ae81045224b9', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_poids_a_la_naissance_poidsalanaissance2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_poids_a_la_naissance_poidsalanaissance3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_poids_a_la_naissance_poidsalanaissance4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_poids_a_la_naissance_poidsalanaissance5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_taille_a_la_naissance_taillealanaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'number_perimetre_cranien_a_la_naissance_perimetrecranienalanaissance5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomconjoint');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'select_genre_genreconjoint');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_adresse_adresseconjoint');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_nomconjoint');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant6');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'phonenumber_numero_de_telephone_numerodetelephoneconjoint');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant6');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'datetime_date_de_naissance_datedenaissanceenfant');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant6');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_prenom_prenomenfant');
INSERT INTO public.page_fields (page_id, fields) VALUES ('d1e056c5-c472-45c6-9dd8-7bfb288ee119', 'textfield_nom_textfield_nom_textfield_nom_nomenfant');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_ca_ca');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_k_k');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_vgm_number_vgm_vgm');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_hgb_number_hgb_hgb');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_gr_number_gr_gr');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_retic_number_retic_retic2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_na_na');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_phos_phos');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_idr_number_idr_idr');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_hct_number_hct_hct');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_na/k_nak');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%baso_number_%baso_baso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%lym_number_%lym_lym');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%mono_number_%mono_mono');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_uree_uree');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_bun/crea_buncrea');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_ccmh_number_ccmh_ccmh');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%neu_number_%neu_neu');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%eos_number_%eos_eos');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_creatinine_creatinine');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_cl_cl');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_%retic_number_%retic_retic');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_tcmh_number_tcmh_tcmh');
INSERT INTO public.page_fields (page_id, fields) VALUES ('35619d34-1bf2-450e-baf4-e36bdb60347a', 'number_gb_number_gb_gb');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant3');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant4');
INSERT INTO public.page_fields (page_id, fields) VALUES ('ac85201a-0537-4dd1-acd7-e33e2b254dce', 'datetime_date_de_debut_de_grossesse_datededebutdegrossesseenfant5');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'select_genre_genre');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'datetime_date_de_naissance_datedenaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'textfield_nom_de_naissance_nomdenaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'textfield_prenom_prenom');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'textfield_lieu_de_naissance_lieudenaissance');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'datetime_date_de_deces_datededeces');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'textfield_numero_de_securite_sociale_numerodesecuritesociale');
INSERT INTO public.page_fields (page_id, fields) VALUES ('bdee8afd-bac0-4a32-8217-27e710c055c2', 'textfield_nom_usuel_nomusuel');
INSERT INTO public.page_fields (page_id, fields) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', 'phonenumber_telephone_fixe_telephonefixeperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', 'button_submit_submit2');
INSERT INTO public.page_fields (page_id, fields) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', 'phonenumber_telephone_portable_telephoneportableperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', 'email_email_principal_emailprincipalperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('1e2f6224-6e40-4fc5-ad34-bbd64a2ca945', 'email_email_secondaire_emailsecondaireperso');
INSERT INTO public.page_fields (page_id, fields) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', 'textfield_activite_processionnelle_activiteprocessionnelle');
INSERT INTO public.page_fields (page_id, fields) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', 'textfield_entreprise_entreprise');
INSERT INTO public.page_fields (page_id, fields) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', 'phonenumber_telephone_professionnel__telephoneprofessionnel');
INSERT INTO public.page_fields (page_id, fields) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', 'email_email_professionnel_emailprofessionnel');
INSERT INTO public.page_fields (page_id, fields) VALUES ('528886af-18ca-4313-9c47-6f2fc55b181b', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'textarea_allergies_allergies');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'number_rythme_cardiaque_rythmecardiaque');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'textfield_tension_arterielle_tensionarterielle');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'number_poids_poids');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'select_groupe_sanguin_groupesanguin');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('0d3e6b3f-20ed-4b0d-8c82-77306d7094c6', 'number_taille_taille');
INSERT INTO public.page_fields (page_id, fields) VALUES ('4bd6b18b-ee2f-4924-9c2b-a72efc13c956', 'textarea_antecedents_medicaux_antecedentsmedicaux');
INSERT INTO public.page_fields (page_id, fields) VALUES ('4bd6b18b-ee2f-4924-9c2b-a72efc13c956', 'button_submit_submit');
INSERT INTO public.page_fields (page_id, fields) VALUES ('4bd6b18b-ee2f-4924-9c2b-a72efc13c956', 'textarea_antecedents_chirurgicaux_antecedentschirurgicaux');


--
-- TOC entry 2906 (class 0 OID 36247)
-- Dependencies: 201
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (id, name, value) VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO public.role (id, name, value) VALUES (2, 'userAccount', 'ROLE_USER');


--
-- TOC entry 2907 (class 0 OID 36255)
-- Dependencies: 202
-- Data for Name: role_authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (1, 1);
INSERT INTO public.role_authorities (role_id, authorities_id) VALUES (2, 1);


--
-- TOC entry 2908 (class 0 OID 36260)
-- Dependencies: 203
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (id, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, username) VALUES (1, true, true, true, 'dbeck@medipractice.org', true, 'damien', 'beck', '$2a$10$TWkFSV9i25IkE8zS6XwNe.yUmCygQnowA0B8VM1rj02pZ524LjD/W', 'admin');
INSERT INTO public.user_account (id, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, username) VALUES (2, true, true, true, 'user@localhost', true, 'user', 'user', '$2y$10$1fDQoxb2MEkY9sModlESfuubjbrcwPB7U2b6OYH7ToK9GPAJjDyye', 'user');


--
-- TOC entry 2909 (class 0 OID 36268)
-- Dependencies: 204
-- Data for Name: user_account_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account_roles (user_account_id, roles_id) VALUES (1, 1);
INSERT INTO public.user_account_roles (user_account_id, roles_id) VALUES (2, 2);


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 199
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 2748 (class 2606 OID 36246)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- TOC entry 2770 (class 2606 OID 36349)
-- Name: data_file data_file_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_file
    ADD CONSTRAINT data_file_pkey PRIMARY KEY (id);


--
-- TOC entry 2758 (class 2606 OID 36300)
-- Name: field field_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.field
    ADD CONSTRAINT field_pkey PRIMARY KEY (id);


--
-- TOC entry 2744 (class 2606 OID 26674)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- TOC entry 2762 (class 2606 OID 36308)
-- Name: module module_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT module_pkey PRIMARY KEY (id);


--
-- TOC entry 2768 (class 2606 OID 36316)
-- Name: page page_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.page
    ADD CONSTRAINT page_pkey PRIMARY KEY (id);


--
-- TOC entry 2752 (class 2606 OID 36259)
-- Name: role_authorities role_authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT role_authorities_pkey PRIMARY KEY (role_id, authorities_id);


--
-- TOC entry 2750 (class 2606 OID 36254)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2764 (class 2606 OID 36323)
-- Name: module uk_448gl6t8oobfwuxv9v5ux5cs9; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT uk_448gl6t8oobfwuxv9v5ux5cs9 UNIQUE (label);


--
-- TOC entry 2742 (class 2606 OID 25852)
-- Name: module_pages uk_4tn5g4vtrj35redeb7l8vjv5e; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module_pages
    ADD CONSTRAINT uk_4tn5g4vtrj35redeb7l8vjv5e UNIQUE (pages_id);


--
-- TOC entry 2766 (class 2606 OID 36325)
-- Name: module uk_f73dsvaor0f4cycvldyt2idf1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT uk_f73dsvaor0f4cycvldyt2idf1 UNIQUE (name);


--
-- TOC entry 2746 (class 2606 OID 26697)
-- Name: menu_children uk_q1pl8glqjacwss40dwkbv1gm3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu_children
    ADD CONSTRAINT uk_q1pl8glqjacwss40dwkbv1gm3 UNIQUE (children_id);


--
-- TOC entry 2760 (class 2606 OID 36321)
-- Name: field uk_rqewo8kyj1u7jerytwtgc58xg; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.field
    ADD CONSTRAINT uk_rqewo8kyj1u7jerytwtgc58xg UNIQUE (key);


--
-- TOC entry 2754 (class 2606 OID 36267)
-- Name: user_account user_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pkey PRIMARY KEY (id);


--
-- TOC entry 2756 (class 2606 OID 36272)
-- Name: user_account_roles user_account_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_roles
    ADD CONSTRAINT user_account_roles_pkey PRIMARY KEY (user_account_id, roles_id);


--
-- TOC entry 2773 (class 2606 OID 36273)
-- Name: role_authorities fk4cy1svku5asbuvksc7ap47iyi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT fk4cy1svku5asbuvksc7ap47iyi FOREIGN KEY (authorities_id) REFERENCES public.authority(id);


--
-- TOC entry 2777 (class 2606 OID 36326)
-- Name: page fk4oaif8jsf3uf29oga817wv75h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.page
    ADD CONSTRAINT fk4oaif8jsf3uf29oga817wv75h FOREIGN KEY (module_id) REFERENCES public.module(id);


--
-- TOC entry 2779 (class 2606 OID 36350)
-- Name: data_file fk5qhx57l6nhmw91i4yrm1ihhce; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.data_file
    ADD CONSTRAINT fk5qhx57l6nhmw91i4yrm1ihhce FOREIGN KEY (archived_id) REFERENCES public.data_file(id);


--
-- TOC entry 2774 (class 2606 OID 36278)
-- Name: role_authorities fk8dv2uo3imjpm4dmk7pge9v2vo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT fk8dv2uo3imjpm4dmk7pge9v2vo FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2778 (class 2606 OID 36331)
-- Name: page_fields fkf8nupokybnrcfrmcxh6a2lk2n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.page_fields
    ADD CONSTRAINT fkf8nupokybnrcfrmcxh6a2lk2n FOREIGN KEY (page_id) REFERENCES public.page(id);


--
-- TOC entry 2775 (class 2606 OID 36283)
-- Name: user_account_roles fkhgw1hs27q8latvqis3h4u9hh0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_roles
    ADD CONSTRAINT fkhgw1hs27q8latvqis3h4u9hh0 FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- TOC entry 2771 (class 2606 OID 26707)
-- Name: menu_children fkjf9yuiqqns5nxysdfo8ds2o69; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu_children
    ADD CONSTRAINT fkjf9yuiqqns5nxysdfo8ds2o69 FOREIGN KEY (children_id) REFERENCES public.menu(id);


--
-- TOC entry 2772 (class 2606 OID 26712)
-- Name: menu_children fko7qt9jnvmjrhlsuse3eyaienw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu_children
    ADD CONSTRAINT fko7qt9jnvmjrhlsuse3eyaienw FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 2776 (class 2606 OID 36288)
-- Name: user_account_roles fkpacca51k3kkqoqs0nbmyugdt2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_roles
    ADD CONSTRAINT fkpacca51k3kkqoqs0nbmyugdt2 FOREIGN KEY (user_account_id) REFERENCES public.user_account(id);


-- Completed on 2019-05-06 22:23:30

--
-- PostgreSQL database dump complete
--

