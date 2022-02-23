DROP TABLE IF EXISTS brands;
CREATE TABLE brands (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO brands VALUES (1, 'Ferrari', 'too cheap');
INSERT INTO brands VALUES (2, 'Lamborghini', 'not fast enough');
INSERT INTO brands VALUES (3, 'Bugatti', 'my car');