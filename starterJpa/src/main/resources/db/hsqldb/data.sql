INSERT INTO risk_header VALUES (1, 'one', 100, 'Y', 1);
INSERT INTO risk_header VALUES (2, 'two', 101, 'Y', 1);
INSERT INTO risk_header VALUES (3, 'three', 104, 'Y', 1);
INSERT INTO risk_header VALUES (4, 'four', 104, 'Y', 1);
INSERT INTO risk_header VALUES (5, 'five', 104, 'Y', 1);

INSERT INTO risk_body VALUES (6, 1, 1201, 'Y', 1);
INSERT INTO risk_body VALUES (7, 1, 204, 'Y', 1);
INSERT INTO risk_body VALUES (8, 1, 204, 'Y', 1);

INSERT INTO status VALUES (100, 'draft', 'risk draft', 'Y', 1);
INSERT INTO status VALUES (101, 'inprogress', 'risk in-progress', 'Y', 1);
INSERT INTO status VALUES (104, 'completed', 'risk completed', 'Y', 1);
INSERT INTO status VALUES (1201, 'original', 'original submission', 'Y', 1);
INSERT INTO status VALUES (1200, 'draft', 'draft submission', 'Y', 1);
INSERT INTO status VALUES (204, 'quote', 'needs quote', 'Y', 1);

INSERT INTO book VALUES (1, 'The Passage', 'Justin Cronin', '0345504976');
INSERT INTO book VALUES (2, 'Wool', 'Hugh Howey', '1476733953');
INSERT INTO book VALUES (3, 'Red Rising', 'Pierce Brown', '034553980X');