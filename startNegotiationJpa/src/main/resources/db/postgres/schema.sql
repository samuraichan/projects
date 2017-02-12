DROP TABLE IF EXISTS risk_header CASCADE;
DROP TABLE IF EXISTS risk_body CASCADE;
DROP TABLE IF EXISTS endorsement CASCADE;
DROP TABLE IF EXISTS status CASCADE;
DROP TABLE IF EXISTS risk_header_m CASCADE;
DROP TABLE IF EXISTS risk_body_m CASCADE;
DROP TABLE IF EXISTS quote_m CASCADE;
DROP TABLE IF EXISTS quote CASCADE;
DROP TABLE IF EXISTS system_revision CASCADE;
DROP SEQUENCE IF EXISTS hibernate_sequence; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work

CREATE TABLE risk_header 
(
  id SERIAL PRIMARY KEY,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_header_m
(
  risk_header_id SERIAL PRIMARY KEY, -- required by hibernate
  id INTEGER,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE risk_body 
(
  id SERIAL PRIMARY KEY,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

ALTER TABLE risk_body ADD CONSTRAINT fk_risk_header FOREIGN KEY (risk_header_id) REFERENCES risk_header (id);

CREATE TABLE risk_body_m
(
  risk_body_id SERIAL PRIMARY KEY, -- required by hibernate
  id INTEGER,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE quote 
(
  id SERIAL PRIMARY KEY,
  risk_body_id INTEGER,
  net_premium DECIMAL,
  active_flag VARCHAR(1),
  version_number INTEGER
);

ALTER TABLE quote ADD CONSTRAINT fk_risk_body FOREIGN KEY (risk_body_id) REFERENCES risk_body (id);

CREATE TABLE quote_m
(
  mirror_id SERIAL PRIMARY KEY,
  id INTEGER,
  risk_body_id INTEGER,
  net_premium DECIMAL,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);


CREATE TABLE endorsement 
(
  id SERIAL PRIMARY KEY,
  risk_body_id INTEGER,
  grouping_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE status 
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(25),
  description VARCHAR(50),
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
