-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;
-- SWD392.dbo.Account definition

-- Drop table

-- DROP TABLE SWD392.dbo.Account;

CREATE TABLE SWD392.dbo.Account (
	account_id int IDENTITY(0,1) NOT NULL,
	email varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	password varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT Account_PK PRIMARY KEY (account_id)
);


-- SWD392.dbo.Department definition

-- Drop table

-- DROP TABLE SWD392.dbo.Department;

CREATE TABLE SWD392.dbo.Department (
	department_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT Department_PK PRIMARY KEY (department_id)
);


-- SWD392.dbo.Service definition

-- Drop table

-- DROP TABLE SWD392.dbo.Service;

CREATE TABLE SWD392.dbo.Service (
	service_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	price int NOT NULL,
	lastUpdate datetime DEFAULT getdate() NULL,
	unit varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT Service_PK PRIMARY KEY (service_id)
);


-- SWD392.dbo.recordStatus definition

-- Drop table

-- DROP TABLE SWD392.dbo.recordStatus;

CREATE TABLE SWD392.dbo.recordStatus (
	record_status_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT recordStatus_PK PRIMARY KEY (record_status_id)
);


-- SWD392.dbo.Accountant definition

-- Drop table

-- DROP TABLE SWD392.dbo.Accountant;

CREATE TABLE SWD392.dbo.Accountant (
	accountant_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	department_id int NULL,
	account_id int NULL,
	CONSTRAINT Accountant_PK PRIMARY KEY (accountant_id),
	CONSTRAINT Accountant_Account_FK FOREIGN KEY (account_id) REFERENCES SWD392.dbo.Account(account_id),
	CONSTRAINT Accountant_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id)
);


-- SWD392.dbo.Doctor definition

-- Drop table

-- DROP TABLE SWD392.dbo.Doctor;

CREATE TABLE SWD392.dbo.Doctor (
	doctor_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	department_id int NOT NULL,
	account_id int NULL,
	CONSTRAINT Doctor_PK PRIMARY KEY (doctor_id),
	CONSTRAINT Doctor_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id),
	CONSTRAINT Doctor_FK_1 FOREIGN KEY (account_id) REFERENCES SWD392.dbo.Account(account_id)
);


-- SWD392.dbo.Manager definition

-- Drop table

-- DROP TABLE SWD392.dbo.Manager;

CREATE TABLE SWD392.dbo.Manager (
	id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	department_id int NULL,
	account_id int NULL,
	CONSTRAINT Manager_PK PRIMARY KEY (id),
	CONSTRAINT Manager_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id),
	CONSTRAINT Manager_FK_1 FOREIGN KEY (account_id) REFERENCES SWD392.dbo.Account(account_id)
);


-- SWD392.dbo.Medical_Item_Storage definition

-- Drop table

-- DROP TABLE SWD392.dbo.Medical_Item_Storage;

CREATE TABLE SWD392.dbo.Medical_Item_Storage (
	storage_id int IDENTITY(0,1) NOT NULL,
	code varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	department_id int NULL,
	CONSTRAINT Medical_Item_Storage_PK PRIMARY KEY (storage_id),
	CONSTRAINT Medical_Item_Storage_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id)
);


-- SWD392.dbo.Nurse definition

-- Drop table

-- DROP TABLE SWD392.dbo.Nurse;

CREATE TABLE SWD392.dbo.Nurse (
	nurse_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	department_id int NULL,
	account_id int NULL,
	CONSTRAINT Nurse_PK PRIMARY KEY (nurse_id),
	CONSTRAINT Nurse_Account_FK FOREIGN KEY (account_id) REFERENCES SWD392.dbo.Account(account_id),
	CONSTRAINT Nurse_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id)
);


-- SWD392.dbo.Patient definition

-- Drop table

-- DROP TABLE SWD392.dbo.Patient;

CREATE TABLE SWD392.dbo.Patient (
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	social_id varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	address varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	email varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	phone varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	createAt datetime DEFAULT getdate() NULL,
	patient_id int IDENTITY(0,1) NOT NULL,
	account_id int NULL,
	CONSTRAINT Patient_PK PRIMARY KEY (patient_id),
	CONSTRAINT Patient_FK FOREIGN KEY (account_id) REFERENCES SWD392.dbo.Account(account_id)
);


-- SWD392.dbo.Room definition

-- Drop table

-- DROP TABLE SWD392.dbo.Room;

CREATE TABLE SWD392.dbo.Room (
	room_id int IDENTITY(0,1) NOT NULL,
	roomCode varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	department_id int NOT NULL,
	CONSTRAINT Room_PK PRIMARY KEY (room_id),
	CONSTRAINT Room_FK FOREIGN KEY (department_id) REFERENCES SWD392.dbo.Department(department_id)
);


-- SWD392.dbo.Bed definition

-- Drop table

-- DROP TABLE SWD392.dbo.Bed;

CREATE TABLE SWD392.dbo.Bed (
	bed_id int IDENTITY(0,1) NOT NULL,
	room_id int NOT NULL,
	is_empty bit DEFAULT 1 NOT NULL,
	CONSTRAINT Bed_PK PRIMARY KEY (bed_id),
	CONSTRAINT Bed_FK FOREIGN KEY (room_id) REFERENCES SWD392.dbo.Room(room_id)
);


-- SWD392.dbo.Medical_Item definition

-- Drop table

-- DROP TABLE SWD392.dbo.Medical_Item;

CREATE TABLE SWD392.dbo.Medical_Item (
	medical_item_id int IDENTITY(0,1) NOT NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[image] varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	provider varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	storage_id int NULL,
	quantity int NULL,
	CONSTRAINT Medical_Item_PK PRIMARY KEY (medical_item_id),
	CONSTRAINT Medical_Item_FK FOREIGN KEY (storage_id) REFERENCES SWD392.dbo.Medical_Item_Storage(storage_id)
);


-- SWD392.dbo.Patient_record definition

-- Drop table

-- DROP TABLE SWD392.dbo.Patient_record;

CREATE TABLE SWD392.dbo.Patient_record (
	record_id int IDENTITY(0,1) NOT NULL,
	record_status_id int NOT NULL,
	patient_id int NOT NULL,
	createdAt datetime DEFAULT getdate() NULL,
	lastUpdate datetime NULL,
	bed_id int NULL,
	doctor_id int NULL,
	CONSTRAINT Patient_record_PK PRIMARY KEY (record_id),
	CONSTRAINT Patient_record_FK_1 FOREIGN KEY (patient_id) REFERENCES SWD392.dbo.Patient(patient_id),
	CONSTRAINT Patient_record_FK_2 FOREIGN KEY (record_status_id) REFERENCES SWD392.dbo.recordStatus(record_status_id),
	CONSTRAINT Patient_record_FK_3 FOREIGN KEY (bed_id) REFERENCES SWD392.dbo.Bed(bed_id),
	CONSTRAINT Patient_record_FK_4 FOREIGN KEY (doctor_id) REFERENCES SWD392.dbo.Doctor(doctor_id)
);


-- SWD392.dbo.Treatment_Plan definition

-- Drop table

-- DROP TABLE SWD392.dbo.Treatment_Plan;

CREATE TABLE SWD392.dbo.Treatment_Plan (
	record_id int NOT NULL,
	service_id int NOT NULL,
	create_date datetime DEFAULT getdate() NULL,
	is_done bit DEFAULT 0 NULL,
	last_update datetime NULL,
	quantity int NULL,
	CONSTRAINT Treatment_Plan_FK FOREIGN KEY (record_id) REFERENCES SWD392.dbo.Patient_record(record_id),
	CONSTRAINT Treatment_Plan_FK_1 FOREIGN KEY (service_id) REFERENCES SWD392.dbo.Service(service_id)
);


-- SWD392.dbo.Nurse_Record definition

-- Drop table

-- DROP TABLE SWD392.dbo.Nurse_Record;

CREATE TABLE SWD392.dbo.Nurse_Record (
	nurse_record_id int IDENTITY(0,1) NOT NULL,
	record_id int NULL,
	nurse_id int NULL,
	blood_pressure float NULL,
	heart_rate float NULL,
	CONSTRAINT Nurse_Record_PK PRIMARY KEY (nurse_record_id),
	CONSTRAINT Nurse_Record_FK FOREIGN KEY (record_id) REFERENCES SWD392.dbo.Patient_record(record_id),
	CONSTRAINT Nurse_Record_FK_1 FOREIGN KEY (nurse_id) REFERENCES SWD392.dbo.Nurse(nurse_id)
);