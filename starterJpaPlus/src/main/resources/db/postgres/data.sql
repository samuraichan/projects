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


