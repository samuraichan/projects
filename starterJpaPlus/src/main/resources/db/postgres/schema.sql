DROP TABLE IF EXISTS phone_number CASCADE;
DROP TABLE IF EXISTS phone_number_m CASCADE;
DROP TABLE IF EXISTS phone_number_owner CASCADE;
DROP TABLE IF EXISTS phone_number_owner_m CASCADE;
DROP TABLE IF EXISTS contact CASCADE;
DROP TABLE IF EXISTS contact_m CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS address_m CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS person_m CASCADE;
DROP TABLE IF EXISTS phone_type CASCADE;
DROP TABLE IF EXISTS phone_type_m CASCADE;
DROP TABLE IF EXISTS phone_value CASCADE;
DROP TABLE IF EXISTS phone_value_m CASCADE;
DROP TABLE IF EXISTS task CASCADE;
DROP TABLE IF EXISTS task_m CASCADE;
DROP TABLE IF EXISTS market_class CASCADE;
DROP TABLE IF EXISTS system_revision CASCADE;

DROP TABLE IF EXISTS quote CASCADE;
DROP TABLE IF EXISTS risk_body CASCADE;
DROP TABLE IF EXISTS risk_header CASCADE;
DROP TABLE IF EXISTS status CASCADE; 

DROP SEQUENCE IF EXISTS hibernate_sequence; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work

CREATE TABLE quote
(
  id SERIAL PRIMARY KEY,
  submission_id integer,
  net_premium NUMERIC(10,2),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_body
(
  id SERIAL PRIMARY KEY,
  risk_id integer,
  status_id SMALLINT,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_header
(
  id SERIAL PRIMARY KEY,
  status_id SMALLINT,
  name VARCHAR(25),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);


CREATE TABLE task
(
  id SERIAL PRIMARY KEY,
  description VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE task_m
(
  task_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  description VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE phone_type
(
  id SERIAL PRIMARY KEY,
  value INTEGER,
  description VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE phone_type_m
(
  phone_type_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  value INTEGER,
  description VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE phone_value
(
  id SERIAL PRIMARY KEY,
  value INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE phone_value_m
(
  phone_value_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  value INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE phone_number 
(
  id SERIAL PRIMARY KEY,
  number VARCHAR(20),
  type INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE phone_number_m
(
  phone_number_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  number VARCHAR(20),
  type INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE phone_number_owner 
(
  id SERIAL PRIMARY KEY,
  owner_id INTEGER,
  phone_number_id INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1) DEFAULT 'N',
  version_number INTEGER
);

CREATE TABLE phone_number_owner_m
(
  phone_number_owner_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  owner_id INTEGER,
  phone_number_id INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE address 
(
  id SERIAL PRIMARY KEY,
  owner_id INTEGER,
  street VARCHAR(50),
  state VARCHAR(50),
  city VARCHAR(50),
  zip VARCHAR(50),
  type INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE address_m
(
  address_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  owner_id INTEGER,
  street VARCHAR(50),
  state VARCHAR(50),
  city VARCHAR(50),
  zip VARCHAR(50),
  type INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE person 
(
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(120),
  my_date timestamp,
  another_created_date timestamp,
  another_update_date timestamp,
  age INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE person_m
(
  person_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  first_name VARCHAR(20),
  last_name VARCHAR(120),
  my_date timestamp,
  another_created_date timestamp,
  another_update_date timestamp,
  age INTEGER,
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE contact
(
  id SERIAL PRIMARY KEY,
  street VARCHAR(20),
  city VARCHAR(20),
  postal_codee VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE contact_m
(
  phone_type_m_id SERIAL PRIMARY KEY, -- required by hibernate
  id SERIAL,
  street VARCHAR(20),
  city VARCHAR(20),
  postal_codee VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE market_class
(
  id SERIAL PRIMARY KEY,
  type_id INTEGER,
  name VARCHAR(20),
  selected VARCHAR(1),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

-- see StarterRevisioinEntity.java (hibernate provides a default REVINFO tale if 
-- @RevisionEntity is not provided by the app
CREATE TABLE system_revision
(
  id INTEGER PRIMARY KEY,
  timestamp BIGINT
);


CREATE SEQUENCE hibernate_sequence START 2000; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work
