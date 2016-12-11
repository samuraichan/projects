DROP TABLE risk_header IF EXISTS;
DROP TABLE risk_body IF EXISTS;
DROP TABLE endorsement IF EXISTS;
DROP TABLE status IF EXISTS;

CREATE TABLE risk_header 
(
  risk_header_id INTEGER IDENTITY PRIMARY KEY,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_body 
(
  risk_body_id INTEGER IDENTITY PRIMARY KEY,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE endorsement 
(
  endorsement_id INTEGER IDENTITY PRIMARY KEY,
  risk_body_id INTEGER,
  grouping_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE status 
(
  status_id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(25),
  description VARCHAR(50),
  active_flag VARCHAR(1)
);