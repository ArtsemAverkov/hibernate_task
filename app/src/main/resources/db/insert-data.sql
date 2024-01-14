INSERT INTO house (uuid, area, country, city, street, number) VALUES
('1a2b3c4d', 120.5, 'USA', 'New York', 'Broadway', '123'),
('5e6f7g8h', 150.2, 'UK', 'London', 'Oxford Street', '456'),
('9i0j1k2l', 200.0, 'France', 'Paris', 'Champs-Élysées', '789'),
('3m4n5o6p', 180.3, 'Germany', 'Berlin', 'Brandenburg Gate', '1011'),
('7q8r9s0t', 100.8, 'Japan', 'Tokyo', 'Ginza', '1213');

INSERT INTO person (uuid, name, surname, sex, passport_series, passport_number, house_id) VALUES
('aaa111', 'John', 'Doe', 'Male', 'AB', '123456', 1),
('bbb222', 'Jane', 'Smith', 'Female', 'CD', '789012', 1),
('ccc333', 'Alice', 'Johnson', 'Female', 'EF', '345678', 2),
('ddd444', 'Bob', 'Brown', 'Male', 'GH', '901234', 3),
('eee555', 'Charlie', 'Williams', 'Male', 'IJ', '567890', 3),
('fff666', 'Emma', 'Davis', 'Female', 'KL', '123789', 4),
('ggg777', 'James', 'Wilson', 'Male', 'MN', '456012', 5),
('hhh888', 'Sophia', 'Moore', 'Female', 'OP', '789123', 5),
('iii999', 'Michael', 'Anderson', 'Male', 'QR', '012345', 5),
('jjj000', 'Olivia', 'Taylor', 'Female', 'ST', '678901', 5);