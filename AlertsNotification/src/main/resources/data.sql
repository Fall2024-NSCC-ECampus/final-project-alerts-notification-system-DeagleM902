-- Sample data for FireStation
INSERT INTO fire_station (station_number, station_address) VALUES (1, '101 Firehouse Way');
INSERT INTO fire_station (station_number, station_address) VALUES (2, '202 Rescue Lane');

-- Sample data for Household
INSERT INTO household (address,fire_station_id) VALUES ('123 Elm Street', 1);
INSERT INTO household (address,fire_station_id) VALUES ('456 Oak Street', 1);
INSERT INTO household (address,fire_station_id) VALUES ('789 Pine Street', 2);

-- Sample data for Person
INSERT INTO residents (first_name, last_name, address, city, phone_number, email, age, household_id)
VALUES ('John', 'Doe', '123 Elm Street', 'Halifax', '902-1234', 'john.doe@example.com', 35, 1);

INSERT INTO residents (first_name, last_name, address, city, phone_number, email, age, household_id)
VALUES ('Jane', 'Smith', '456 Oak Street', 'Halifax', '902-5678', 'jane.smith@example.com', 30, 2);

INSERT INTO residents (first_name, last_name, address, city, phone_number, email, age, household_id)
VALUES ('Child', 'Smith', '456 Oak Street', 'Halifax', '902-5678', 'child.smith@example.com', 9, 2);

-- Sample data for Medications
INSERT INTO person_medications (person_id, medication) VALUES (1, 'aspirin:100mg');
INSERT INTO person_medications (person_id, medication) VALUES (1, 'ibuprofen:200mg');
INSERT INTO person_medications (person_id, medication) VALUES (2, 'acetaminophen:500mg');
INSERT INTO person_medications (person_id, medication) VALUES (3, 'children_vitamin:10mg');

-- Sample data for Allergies
INSERT INTO person_allergies (person_id, allergy) VALUES (1, 'pollen');
INSERT INTO person_allergies (person_id, allergy) VALUES (3, 'dust');
