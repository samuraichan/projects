INSERT INTO risk_header VALUES (1, 'one', 100, 'Y', 1);
INSERT INTO risk_header_m VALUES (1, 1, 'one', 100, 'Y', 1, null, null);
INSERT INTO risk_header VALUES (2, 'two', 101, 'Y', 1);
INSERT INTO risk_header VALUES (3, 'three', 104, 'Y', 1);
INSERT INTO risk_header VALUES (4, 'four', 104, 'Y', 1);
INSERT INTO risk_header VALUES (5, 'five', 104, 'Y', 1);

INSERT INTO risk_body VALUES (6, 1, 1201, 'Y', 1);
INSERT INTO risk_body_m VALUES (1, 6, 1, 1201, 'Y', 1, null, null);
INSERT INTO risk_body VALUES (7, 1, 204, 'Y', 1);
INSERT INTO risk_body_m VALUES (2, 6, 1, 1201, 'Y', 1, null, null);
INSERT INTO risk_body VALUES (8, 1, 204, 'Y', 1);
INSERT INTO risk_body_m VALUES (3, 6, 1, 1201, 'Y', 1, null, null);

INSERT INTO status VALUES (100, 'draft', 'risk draft', 'Y', 1);
INSERT INTO status VALUES (101, 'inprogress', 'risk in-progress', 'Y', 1);
INSERT INTO status VALUES (104, 'completed', 'risk completed', 'Y', 1);
INSERT INTO status VALUES (1201, 'original', 'original submission', 'Y', 1);
INSERT INTO status VALUES (1200, 'draft', 'draft submission', 'Y', 1);
INSERT INTO status VALUES (204, 'quote', 'needs quote', 'Y', 1);
INSERT INTO status VALUES (205, 'quoted', 'assumer quoted', 'Y', 1);
