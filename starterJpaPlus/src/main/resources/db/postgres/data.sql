INSERT INTO contact (id, street, city, postal_codee, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), '1605 NW Ave', 'Copenhagen', '2928-298', 'Y', 1, current_timestamp, current_timestamp);

INSERT INTO contact (id, street, city, postal_codee, active_flag, version_number, created_date, updated_date) VALUES (nextval ('hibernate_sequence'), '2604 18th Street', 'Tokyo', 'TK028-298', 'Y', 1, current_timestamp, current_timestamp);

INSERT INTO person (id, first_name, last_name, active_flag) VALUES (1, 'Yojimbo', 'Hiroshi', 'Y');
