DROP TABLE risk_header IF EXISTS;
DROP TABLE risk_body IF EXISTS;
DROP TABLE endorsement IF EXISTS;
DROP TABLE status IF EXISTS;
DROP TABLE risk_header_m IF EXISTS;
DROP TABLE risk_body_m IF EXISTS;
DROP TABLE quote_m IF EXISTS;
DROP TABLE quote IF EXISTS;
DROP TABLE system_revision IF EXISTS;

CREATE TABLE risk_header 
(
  id INTEGER IDENTITY PRIMARY KEY,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_header_m
(
  risk_header_id INTEGER IDENTITY PRIMARY KEY, -- required by hibernate
  id INTEGER,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype TINYINT -- required by hibernate
);

CREATE TABLE risk_body 
(
  id INTEGER IDENTITY PRIMARY KEY,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

ALTER TABLE risk_body ADD CONSTRAINT fk_risk_header FOREIGN KEY (risk_header_id) REFERENCES risk_header (id);

CREATE TABLE risk_body_m
(
  risk_body_id INTEGER IDENTITY PRIMARY KEY, -- required by hibernate
  id INTEGER,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype TINYINT -- required by hibernate
);

CREATE TABLE quote 
(
  id INTEGER IDENTITY PRIMARY KEY,
  risk_body_id INTEGER,
  net_premium DECIMAL,
  active_flag VARCHAR(1),
  version_number INTEGER
);

ALTER TABLE quote ADD CONSTRAINT fk_risk_body FOREIGN KEY (risk_body_id) REFERENCES risk_body (id);

CREATE TABLE quote_m
(
  mirror_id INTEGER IDENTITY PRIMARY KEY,
  id INTEGER,
  risk_body_id INTEGER,
  net_premium DECIMAL,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype TINYINT -- required by hibernate
);


CREATE TABLE endorsement 
(
  id INTEGER IDENTITY PRIMARY KEY,
  risk_body_id INTEGER,
  grouping_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE status 
(
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(25),
  description VARCHAR(50),
  active_flag VARCHAR(1),
  version_number INTEGER
);


-- see StarterRevisioinEntity.java (hibernate provides a default REVINFO tale if 
-- @RevisionEntity is not provided by the app
CREATE TABLE system_revision
(
  id INTEGER IDENTITY PRIMARY KEY,
  timestamp BIGINT
);

--CREATE SEQUENCE HIBERNATE_SEQUENCE AS INTEGER--
--START WITH 1 INCREMENT BY 1;
