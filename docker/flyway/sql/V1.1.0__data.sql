INSERT INTO cars(id, name, price) VALUES (1, 'カローラ　クロス', 21780)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (2, 'RAIZE', 16170)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (3, 'ルーミー', 14630)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (4, 'アクア', 19580)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (5, 'ハリアー', 26510)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (6, 'アルファード', 38280)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (7, 'ヤリス2WD', 14960)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (8, 'ヤリス　クロス', 21010)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (9, 'RAV4', 27610)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (10, 'プリウス', 18700)
    ON DUPLICATE KEY UPDATE id = VALUES (id);