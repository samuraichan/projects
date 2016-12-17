DROP TABLE risk_header IF EXISTS;
DROP TABLE risk_body IF EXISTS;
DROP TABLE endorsement IF EXISTS;
DROP TABLE status IF EXISTS;

CREATE TABLE risk_header 
(
  id INTEGER IDENTITY PRIMARY KEY,
  named_insured VARCHAR(100),
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE risk_body 
(
  id INTEGER IDENTITY PRIMARY KEY,
  risk_header_id INTEGER,
  status_id INTEGER,
  active_flag VARCHAR(1),
  version_number INTEGER
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
  active_flag VARCHAR(1)
);