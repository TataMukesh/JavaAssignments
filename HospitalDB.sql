use hospitaldb;
 
CREATE TABLE DOCTOR_MASTER(
doctor_id varchar(15),
doctor_name varchar(15) not null,
dept varchar(15) not null,
primary key(doctor_id)
);

desc DOCTOR_MASTER;


INSERT INTO DOCTOR_MASTER(doctor_id,doctor_name,dept) 
VALUES ("D0001","Ram","ENT"),
	("D0002","Rajan","ENT"),
	("D0003","Smita","Eye"),
	("D0004","Bhavan","Surgery"),
	("D0005","Sheela","Surgery"),
	("D0006","Nethra","Surgery");


CREATE TABLE ROOM_MASTER(
room_no varchar(15),
room_type varchar(15) not null, 
status varchar(15) not null,
primary key(room_no)
);


INSERT INTO ROOM_MASTER(room_no,room_type,status)
VALUES  ("R0001","AC","occupied"),
		("R0002","Suite","vacant"),
		("R0003","NonAC","vacant"),
		("R0004","NonAC","occupied"),
		("R0005","AC","vacant"),
		("R0006","AC","occupied");


CREATE TABLE PATIENT_MASTER(
pid varchar(15) not null, 
name varchar(15) not null,
age INTEGER not null,
weight INTEGER not null,
gender varchar(10) not null,
address varchar(50) not null,
phoneno varchar(10) not null,
disease varchar(50) not null,
doctorid varchar(5) not null,
primary key(pid),
FOREIGN KEY(doctorid) REFERENCES DOCTOR_MASTER(doctor_id)
);


INSERT INTO PATIENT_MASTER
VALUES  ("P0001","Gita",35,65,"F","Chennai","9867145678","Eye Infection","D0003"),
		("P0002","Ashish",40,70,"M","Delhi","9123456784","Asthma","D0003"),
		("P0003","Radha",25,60,"F","Chennai","9867145678","Pain in heart","D0005"),
		("P0004","Chandra",28,65,"F","Bangalore","9867145678","Astham","D0001"),
		("P0005","Goyal",42,55,"M","Delhi","9867145678","Pain in stomach","D0004");



CREATE TABLE ROOM_ALLOCATION(
room_no varchar(15) , 
pid varchar(15) , 
admission_date DATE not null,
release_date DATE,
primary key(room_no, pid),
FOREIGN KEY(room_no) REFERENCES ROOM_MASTER(room_no),
FOREIGN KEY(pid) REFERENCES PATIENT_MASTER(pid)
);

INSERT INTO ROOM_ALLOCATION
VALUES  ("R0001","P0001","2016-10-16","2016-10-26"),
		("R0002","P0002","2016-11-16","2016-11-26"),
		("R0002","P0003","2016-12-15","2016-12-30"),
		("R0004","P0001","2017-01-15","2017-01-30");


-- Query #1: Display the patients who were admitted in the month of january.
select * from patient_master pm inner join room_allocation ra on pm.pid = ra.pid where month(ra.admission_date) = 1;


-- Query #2: Display the female patient who is not suffering from asthma
select * from patient_master where disease <> "asthma" and gender = "f";


-- Query #3: Count the number of male and female patients.
select count(*) as total from patient_master where gender = "f" or gender = "m";



-- Query #4: Display the patient_id,patient_name, doctor_id, doctor_name, room_no, room_type and admission_date.
select pm.pid, pm.name, dm.doctor_id, dm.doctor_name, ra.room_no, rm.room_type, ra.admission_date 
from patient_master pm inner join doctor_master dm on pm.doctorid = dm.doctor_id inner join room_allocation ra on ra.pid = pm.pid 
inner join room_master rm on ra.room_no = rm.room_no;



-- Query #5: Display the room_no which was never allocated to any patient.
select * from room_master where room_no <> ALL(select room_no from room_allocation);




-- Query #6: Display the room_no, room_type which are allocated more than once.
select ra.room_no, rm.room_type 
from room_allocation ra inner join room_master rm 
on ra.room_no = rm.room_no
group by(ra.room_no) having count(ra.room_no) > 1;