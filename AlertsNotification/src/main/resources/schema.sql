CREATE TABLE fire_station (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_number INT NOT NULL,
    station_address VARCHAR(255) NOT NULL
);

CREATE TABLE household (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each household
    address VARCHAR(255) NOT NULL,        -- Address of the household
    fire_station_id BIGINT NOT NULL,      -- Foreign key to fire_station table
    FOREIGN KEY (fire_station_id) REFERENCES fire_station(id)
);

CREATE TABLE residents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    city VARCHAR(50),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    age INT,
    household_id BIGINT,
    FOREIGN KEY (household_id) REFERENCES household(id)
);


CREATE TABLE person_medications (
    person_id BIGINT NOT NULL,
    medication VARCHAR(255) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES residents(id)
);

CREATE TABLE person_allergies (
    person_id BIGINT NOT NULL,
    allergy VARCHAR(255) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES residents(id)
);