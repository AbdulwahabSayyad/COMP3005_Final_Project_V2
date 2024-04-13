INSERT INTO members (f_name, l_name, dob, gender, email, weight_curr, weight_goal, bodyfat_curr, bodyfat_goal, cals_base, cals_goal, date_goal, achievements, notes)
VALUES 
('John', 'Doe', '1980-01-01', 'male', 'john.doe@example.com', 80, 75, 20, 15, 2000, 1800, '2024-12-31', 'Achievement 1', 'Note 1'),
('Jane', 'Doe', '1985-02-02', 'female', 'jane.doe@example.com', 65, 60, 25, 20, 1800, 1600, '2024-11-30', 'Achievement 2', 'Note 2'),
('Morgan', 'Stanley', '1999-03-03', 'other', 'morgan.stanley@example.com', 99, 55, 25, 20, 2000, 1600, '2024-09-30', 'Achievement 3', 'Note 3'),
('Philys', 'Dunton', '2000-04-05', 'female', 'philys.dunton@example.com', 75, 40.5, 25, 20, 2500, 1600, '2024-08-30', 'Achievement 4', 'Note 4'),
('Michael', 'Scott', '1985-06-02', 'male', 'michael.scott@example.com', 47.7, 60, 25, 20, 1600, 3000, '2024-06-30', 'Achievement 5', 'Note 5');

INSERT INTO exercises (member_id, ex_name, ex_type, ex_sets, ex_reps, pr_curr, pr_goal, distance, time_curr, time_goal)
VALUES 
(1, 'Bench Press', 'weights', 3, 10, 100, 120, NULL, NULL, NULL),
(2, 'Squats', 'weights', 4, 12, 140, 160, NULL, NULL, NULL),
(3, 'Deadlift', 'weights', 3, 8, 180, 200, NULL, NULL, NULL),
(4, 'Running', 'cardio', NULL, NULL, NULL, NULL, 5, 30, 25),
(5, 'Cycling', 'cardio', NULL, NULL, NULL, NULL, 10, 60, 50),
(1, 'Burpees', 'cardio', NULL, NULL, NULL, NULL, 50, 60, 30),
(2, 'Lat pulls', 'weights', 3, 10, 120, 150, NULL, NULL, NULL);

INSERT INTO trainers (f_name, l_name, dob, gender, email, specialty, notes)
VALUES 
('Mister', 'Miyagi', '1980-01-01', 'male', 'mister.miyagi@example.com', 'Fitness', 'Experienced trainer'),
('Anne', 'Hathaway', '1985-02-02', 'female', 'anne.hathaway@example.com', 'Yoga', 'Certified yoga instructor'),
('Geralt', 'Rivia', '1990-03-03', 'male', 'geralt.rivia@example.com', 'Pilates', 'Pilates grand witcher');

INSERT INTO staff (f_name, l_name, dob, gender, email, job_title)
VALUES 
('Lebron', 'James', '1980-01-01', 'male', 'lebron.james@example.com', 'management'),
('Mo', 'Salah', '1985-02-02', 'male', 'mo.salah@example.com', 'maintenance'),
('Nicki', 'Minaj', '1990-03-03', 'female', 'nicki.minaj@example.com', 'reception');

INSERT INTO rooms (capacity, room_type, notes)
VALUES 
(50, 'class', 'room with pilates mats'),
(50, 'class', 'big room'),
(20, 'conference', 'Conference room with large table and teleconferencing equipment');

INSERT INTO sessions (member_id, trainer_id, session_date, session_start, session_end, price_per_slot, notes)
VALUES 
(1, 1, '2024-04-15', '10:00:00', '10:30:00', 50.00, 'First session note'),
(2, 2, '2024-04-16', '14:00:00', '15:00:00', 60.00, 'Second session note');

INSERT INTO classes (class_name, curr_members, max_members, price, notes)
VALUES 
('Yoga Class', 10, 20, 30.00, 'Yoga class for beginners'),
('Pilates Class', 5, 15, 40.00, 'Pilates class for intermediate level'),
('Fitness Class', 8, 25, 50.00, 'Fitness class for advanced level');

INSERT INTO classregs (member_id, class_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

INSERT INTO bookings (room_id, class_id, schedule_id)
VALUES 
(1, 1, 1),
(2, 2, 2),
(3, NULL, 3);

INSERT INTO equipment (equipment_name, isFunctioning, maintenance_last, maintenance_next, assigned_staff, notes)
VALUES 
('Treadmill', true, '2024-01-01', '2024-07-01', 1, 'Treadmill in good condition'),
('Yoga Mats', true, '2024-02-01', '2024-08-01', 2, 'Yoga mats replaced recently'),
('Dumbbells', false, '2024-03-01', '2024-09-01', 3, 'Some dumbbells need replacement');

INSERT INTO payments (member_id, total, payment_method, payment_date, description)
VALUES 
(1, 30.00, 'debit', '2024-04-01', 'Payment for Yoga Class'),
(2, 40.00, 'credit', '2024-04-02', 'Payment for Pilates Class'),
(3, 50.00, 'cash', '2024-04-03', 'Payment for Fitness Class');

