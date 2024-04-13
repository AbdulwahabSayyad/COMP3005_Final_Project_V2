create table members
	(member_id		serial unique not null,
	f_name			varchar(50) not null,
	l_name			varchar(50) not null,
	dob				date not null,
	gender			varchar(10) not null check (gender in ('male','female','other')),
	email			varchar not null unique,
	weight_curr		numeric,
	weight_goal		numeric,
	bodyfat_curr	numeric check (bodyfat_curr >= 0 and bodyfat_curr <= 100),
	bodyfat_goal	numeric check (bodyfat_goal >= 0 and bodyfat_goal <= 100),
	cals_base		int check (cals_base >= 100),
	cals_goal		int check (cals_goal >= 100),
	date_goal		date,
	achievements	text,
	notes			text,
	createdat		timestamp,
	updatedat		timestamp, 
	primary key (member_id)
	);

create table exercises
	(exercise_id 	serial unique not null,
	member_id 		int not null,
	ex_name 		varchar(50) not null,
	ex_type			varchar(10) not null check (ex_type in ('cardio','weights')),
	ex_sets 		int,
	ex_reps 		int,
	pr_curr 		int,
	pr_goal 		int,
	distance 		int,
	time_curr 		int,
	time_goal 		int,
	createdat 		timestamp,
	updatedat 		timestamp,
	primary key (exercise_id),
	foreign key (member_id) references members
		on delete cascade
	);

create table schedules
	(schedule_id serial unique not null,
    mon_start time check (mon_start >= '09:00:00' and mon_start <= '23:00:00'),
    mon_end time check (mon_end >= '09:00:00' and mon_end <= '23:00:00' and mon_end > mon_start),
    tue_start time check (tue_start >= '09:00:00' and tue_start <= '23:00:00'),
    tue_end time check (tue_end >= '09:00:00' and tue_end <= '23:00:00' and tue_end > tue_start),
    wed_start time check (wed_start >= '09:00:00' and wed_start <= '23:00:00'),
    wed_end time check (wed_end >= '09:00:00' and wed_end <= '23:00:00' and wed_end > wed_start),
    thu_start time check (thu_start >= '09:00:00' and thu_start <= '23:00:00'),
    thu_end time check (thu_end >= '09:00:00' and thu_end <= '23:00:00' and thu_end > thu_start),
    fri_start time check (fri_start >= '09:00:00' and fri_start <= '23:00:00'),
    fri_end time check (fri_end >= '09:00:00' and fri_end <= '23:00:00' and fri_end > fri_start),
    sat_start time check (sat_start >= '09:00:00' and sat_start <= '23:00:00'),
    sat_end time check (sat_end >= '09:00:00' and sat_end <= '23:00:00' and sat_end > sat_start),
    sun_start time check (sun_start >= '09:00:00' and sun_start <= '23:00:00'),
    sun_end time check (sun_end >= '09:00:00' and sun_end <= '23:00:00' and sun_end > sun_start),
    createdat timestamp,
    updatedat timestamp,
    primary key (schedule_id)
);

	
create table trainers
	(trainer_id		serial unique not null,
	f_name			varchar(50) not null,
	l_name 			varchar(50) not null,
	dob				date not null,
	gender 			varchar(10) not null check (gender in ('male','female','other')),
	email 			varchar(50) unique not null,
	specialty 		text,
	schedule_id		int not null,
	notes 			text,
	createdat 		timestamp,
	updatedat 		timestamp,
	primary key (trainer_id),
	foreign key (schedule_id) references schedules
		on delete cascade
	);
	
create table staff
	(staff_id 		serial unique not null,
	f_name 			varchar(50) not null,
	l_name 			varchar(50) not null,
	dob 			date,
	gender 			varchar(10) not null check (gender in ('male','female','other')),
	email 			varchar(50) unique not null,
	job_title 		varchar(50) not null check (job_title in ('management', 'maintenance', 'reception')),
	createdat 		timestamp,
	updatedat 		timestamp,
	primary key (staff_id)
	);

create table rooms
	(room_id 		serial unique not null,
	capacity		int not null,
	room_type		varchar(50) not null check (room_type in ('class','general','conference')),
	notes			text,
	createdat		timestamp,
	updatedat		timestamp,
	primary key (room_id)
	);
	
create table sessions
	(session_id 	serial unique not null,
	member_id 		int not null,
	trainer_id 		int not null,
	session_date 	date not null,
	session_start 	time not null, 
	session_end 	time not null,
	price_per_slot 	money not null,
	notes			text,
	createdat 		timestamp,
	updatedat 		timestamp,
	primary key (session_id),
	foreign key (member_id) references members
	 on delete cascade,
	foreign key (trainer_id) references trainers
	 on delete cascade,
	check (
    	session_end = session_start + interval '30 minutes' OR
    	session_end = session_start + interval '60 minutes' OR
    	session_end = session_start + interval '90 minutes'
    )
	);

create table classes
	(class_id		serial unique not null,
	class_name		varchar(50) not null,
	schedule_id 	int,
	curr_members 	int not null,
	max_members 	int not null,
	price 			money not null,
	notes 			text,
	createdat 		timestamp,
	updatedat 		timestamp,
	primary key (class_id),
	foreign key (schedule_id) references schedules
	 	on delete set null
	);

create table classregs
	(reg_id		serial unique not null,
	member_id	int not null,
	class_id	int not null,
	createdat	timestamp,
	updatedat	timestamp,
	primary key (reg_id),
	foreign key (member_id) references members
		on delete cascade,
	foreign key (class_id) references classes
		on delete cascade
	);

create table bookings
	(booking_id		serial unique not null,
	room_id			int not null,
	class_id		int,
	schedule_id		int,
	createdat		timestamp,
	updatedat		timestamp,
	primary key (booking_id),
	foreign key (room_id) references rooms
		on delete cascade,
	foreign key (class_id) references classes
		on delete cascade,
	foreign key (schedule_id) references schedules
	 	on delete cascade
	);
	
create table equipment
	(equipment_id	serial unique not null,
	equipment_name	varchar(50) not null,
	isFunctioning	bool not null,
	maintenance_last date,
	maintenance_next date,
	assigned_staff	int,
	notes			text,
	createdat		timestamp,
	updatedat		timestamp,
	primary key (equipment_id),
	foreign key (assigned_staff) references staff (staff_id)
		on delete set null
	);

create table payments
	(payment_id		serial unique not null,
	member_id		int not null,
	total			money not null,
	payment_method	varchar(50) check (payment_method in ('debit','credit','cash')),
	payment_date	date not null,
	description		text not null,
	createdat		timestamp,
	updatedat		timestamp,
	primary key (payment_id),
	foreign key (member_id) references members
		on delete set null
	);


-- Trigger function for createdat and updatedat timestamps
create or replace function set_timestamps()
returns trigger as $$
begin
    if TG_OP = 'INSERT' then
        NEW.createdat := current_timestamp;
        NEW.updatedat := current_timestamp;
    elsif TG_OP = 'UPDATE' then
        NEW.updatedat := current_timestamp;
    end if;
    return new;
end;
$$ language plpgsql;

-- create triggers for all tables
create trigger set_timestamps_trigger
before insert or update on members
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on exercises
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on schedules
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on trainers
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on staff
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on sessions
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on rooms
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on classes
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on classregs
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on bookings
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on equipment
for each row
execute procedure set_timestamps();

create trigger set_timestamps_trigger
before insert or update on payments
for each row
execute procedure set_timestamps();

create or replace function create_schedule() returns trigger as $$
declare
    new_schedule_id INT;
begin
    insert into schedules (mon_start, mon_end, tue_start, tue_end, wed_start, wed_end, thu_start, thu_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end) 
    values (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL) 
    returning schedule_id into new_schedule_id;

    NEW.schedule_id := new_schedule_id;
    return NEW;
end;
$$ language plpgsql;

create trigger insert_schedule
before insert on trainers
for each row
execute procedure create_schedule();