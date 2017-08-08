INSERT INTO contact (id, street, city, postal_codee, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), '1605 NW Ave', 'Copenhagen', '2928-298', 'Y', 1, current_timestamp, current_timestamp);

INSERT INTO contact (id, street, city, postal_codee, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), '2604 18th Street', 'Tokyo', 'TK028-298', 'Y', 1, current_timestamp, current_timestamp);

INSERT INTO person (id, first_name, last_name, active_flag) VALUES (1, 'Yojimbo', 'Hiroshi', 'Y');

INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 1, 'Property', 'Y', 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 2, 'Aggregate', NULL, 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 1, 'Per Bound', 'N', 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 2, 'Per Person', 'Y', 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 3, 'Pillared', 'N', 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 1, 'Reinstatement', NULL, 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 1, 'Stop Loss', 'N', 'Y', 1, current_timestamp, current_timestamp);
INSERT INTO market_class (id, type_id, name, selected, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), 4, 'Variable Risk', 'Y', 'Y', 1, current_timestamp, current_timestamp);

INSERT INTO risk_header VALUES (100, 100, 'Draft One', current_timestamp, current_timestamp, 'Y', 1);
INSERT INTO risk_header VALUES (101, 101, 'In Progress One', current_timestamp, current_timestamp, 'Y', 1);
INSERT INTO risk_header VALUES (102, 104, 'Bound One', current_timestamp, current_timestamp, 'Y', 1);

INSERT INTO risk_body VALUES (500, 100, 1200, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO risk_body VALUES (501, 101, 1201, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO risk_body VALUES (502, 101, 204, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO risk_body VALUES (503, 101, 204, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO risk_body VALUES (504, 102, 1201, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO risk_body VALUES (505, 102, 303, current_timestamp, current_timestamp, 'Y', 0);

INSERT INTO quote VALUES (700, 502, 100.12, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO quote VALUES (701, 502, 1000000.89, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO quote VALUES (702, 502, 320000.99, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO quote VALUES (703, 503, 12000, current_timestamp, current_timestamp, 'Y', 0);
INSERT INTO quote VALUES (704, 505, 1200, current_timestamp, current_timestamp, 'Y', 0);
