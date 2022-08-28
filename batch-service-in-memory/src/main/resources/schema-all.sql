DROP TABLE employee IF EXISTS;

CREATE TABLE employee  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    firstname VARCHAR(20),
    place VARCHAR(20),
    team VARCHAR(20)
);