
-- Insert some Person data
INSERT INTO persons (id, name, email) VALUES (1,'Home Abuser', 'home@foreve.com');
INSERT INTO persons (id, name, email) VALUES (2, 'Always Work', 'loveworking@google.com');
INSERT INTO persons (id, name, email) VALUES (3, 'Hernando Bullet', 'medicine@please.com');

-- Insert some Location data
INSERT INTO locations (id, location_name, address) VALUES (100, 'House', '123 Main St,  USA');
INSERT INTO locations (id, location_name, address) VALUES (200, 'Office', '456 Elm St,  Canada');
INSERT INTO locations (id, location_name, address) VALUES (300, 'Hospital', '789 Oak St,  Mexico');

-- Insert some UserLocation data
INSERT INTO user_locations (id, person_id, location_id, access_level) VALUES (1, 1, 100, 'owner');
INSERT INTO user_locations (id, person_id, location_id, access_level) VALUES (2, 2, 200, 'employee');
INSERT INTO user_locations (id, person_id, location_id, access_level) VALUES (3, 2, 200, 'owner');
INSERT INTO user_locations (id, person_id, location_id, access_level) VALUES (4, 3, 100, 'guest');
INSERT INTO user_locations (id, person_id, location_id, access_level) VALUES (5, 3, 300, 'guest');
