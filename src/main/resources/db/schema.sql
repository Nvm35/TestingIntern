DROP TABLE persons IF EXISTS;
DROP TABLE locations IF EXISTS;
DROP TABLE user_locations IF EXISTS;

CREATE TABLE persons (
                         id INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL
);

CREATE TABLE locations (
                           id INT PRIMARY KEY,
                           location_name VARCHAR(255) NOT NULL,
                           address VARCHAR(255) NOT NULL
);

CREATE TABLE user_locations (
                                id INT PRIMARY KEY,
                                person_id INT NOT NULL,
                                location_id INT NOT NULL,
                                access_level VARCHAR(255) NOT NULL,
                                FOREIGN KEY (person_id) REFERENCES persons(id),
                                FOREIGN KEY (location_id) REFERENCES locations(id)
);
