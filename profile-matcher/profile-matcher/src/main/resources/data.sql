-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS client;

CREATE TABLE client (
                      id INT PRIMARY KEY,
                      name VARCHAR(250) NOT NULL
);

INSERT INTO client (ID, name) VALUES (1, 'Andrei');