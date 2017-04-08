DROP TABLE IF EXISTS phone_number CASCADE;
DROP TABLE IF EXISTS phone_number_m CASCADE;
DROP TABLE IF EXISTS phone_number_owner CASCADE;
DROP TABLE IF EXISTS phone_number_owner_m CASCADE;
DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS address_m CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS person_m CASCADE;
DROP TABLE IF EXISTS phone_type CASCADE;
DROP TABLE IF EXISTS phone_type_m CASCADE;
DROP TABLE IF EXISTS phone_value CASCADE;
DROP TABLE IF EXISTS phone_value_m CASCADE;
DROP TABLE IF EXISTS system_revision CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work

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
  last_name VARCHAR(20),
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
  last_name VARCHAR(20),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

-- see StarterRevisioinEntity.java (hibernate provides a default REVINFO tale if 
-- @RevisionEntity is not provided by the app
CREATE TABLE system_revision
(
  id INTEGER PRIMARY KEY,
  timestamp BIGINT
);


CREATE SEQUENCE hibernate_sequence START 2000; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work
