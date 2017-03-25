DROP TABLE IF EXISTS phone_number CASCADE;
DROP TABLE IF EXISTS phone_number_m CASCADE;
DROP TABLE IF EXISTS system_revision CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work

CREATE TABLE phone_number 
(
  id SERIAL PRIMARY KEY,
  phone VARCHAR(20),
  type INTEGER,
  created_date date,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE phone_number_m
(
  id SERIAL,
  phone_number_id SERIAL PRIMARY KEY, -- required by hibernate
  phone VARCHAR(20),
  type INTEGER,
  created_date date,
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
