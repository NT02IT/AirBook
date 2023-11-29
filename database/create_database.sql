CREATE DATABASE AIRBOOK;
GO
USE AIRBOOK;

-- Table structure for table action
GO
CREATE TABLE actions (
    Action_ID varchar(20) NOT NULL,
    Action_name nvarchar(MAX) NOT NULL,
	Info nvarchar(MAX),
	IsDelete bit,
    PRIMARY KEY (Action_ID)
);

-- Table structure for table role
GO
CREATE TABLE roles (
    Role_ID varchar(20) NOT NULL,
    Role_name nvarchar(200) NOT NULL,
	IsDelete bit,
    PRIMARY KEY (Role_ID)
);

-- Table structure for table permission
GO
CREATE TABLE permission (
    Per_ID varchar(20) NOT NULL,
    Role_ID varchar(20) NOT NULL,
	Action_ID varchar(20) NOT NULL,
	Per_access bit NOT NULL,
	Per_create bit NOT NULL,
	Per_view bit NOT NULL,
	Per_edit bit NOT NULL,
	Per_delete bit NOT NULL,
	IsDelete bit,
    PRIMARY KEY (Per_ID),
	FOREIGN KEY(Role_ID) REFERENCES roles(Role_ID),
	FOREIGN KEY(Action_ID) REFERENCES actions(Action_ID)
);

-- Table structure for table user
GO
CREATE TABLE users (
    User_ID varchar(20) NOT NULL,
    Role_ID varchar(20) NOT NULL,
	Username varchar(20) NOT NULL,
	Pwd varchar(MAX) NOT NULL, 
	Real_name nvarchar(50) NOT NULL,
	DoB date NOT NULL, 
	Gender nvarchar(10) NOT NULL,
	Nation nvarchar(20) NOT NULL, 
	User_address nvarchar(100) NOT NULL,
	Phone_number varchar(11) NOT NULL,
	CCCD varchar(12) NOT NULL,
	Email varchar(50) NOT NULL,
	Date_create datetime NOT NULL,
	IsDelete bit,
	PRIMARY KEY (User_ID),
	FOREIGN KEY(Role_ID) REFERENCES roles(Role_ID)
);

-- Table structure for table receivers
GO
CREATE TABLE receivers (
    Receiver_ID varchar(20) NOT NULL,
	Receiver_name nvarchar(50) NOT NULL,
	Gender nvarchar(10) NOT NULL,
	DoB date NOT NULL, 
	Receiver_address nvarchar(100) NOT NULL,
	Nation nvarchar(20) NOT NULL, 
	Phone_number varchar(11) NOT NULL,
	CCCD varchar(12),
	Email varchar(50) NOT NULL,
	User_ID varchar(20) REFERENCES users(User_ID),
	IsDelete bit,
	PRIMARY KEY (Receiver_ID),
);

-- Table structure for table airline
GO
CREATE TABLE airlines (
    Airline_ID varchar(20) NOT NULL,
	Airline_name nvarchar(50) NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Airline_ID)
);

-- Table structure for table more_luggage
GO
CREATE TABLE more_luggage (
    More_luggage_ID varchar(20) NOT NULL,
	Airline_ID varchar(20) NOT NULL,
	Luggage_weight int NOT NULL,
	Price int NOT NULL,
	IsDelete bit,
	PRIMARY KEY (More_luggage_ID),
	FOREIGN KEY (Airline_ID) REFERENCES airlines(Airline_ID)
);

-- Table structure for table plane
GO
CREATE TABLE planes (
    Plane_ID varchar(20) NOT NULL,
	Airline_ID varchar(20) NOT NULL,
	Plane_name nvarchar(50) NOT NULL,
	Seats int NOT NULL,
	Plane_desc nvarchar(100),
	IsDelete bit,
	PRIMARY KEY (Plane_ID),
	FOREIGN KEY (Airline_ID) REFERENCES airlines(Airline_ID)
);

-- Table structure for table ticket_class
GO
CREATE TABLE ticket_classes (
    Ticket_class_ID varchar(20) NOT NULL,
	Plane_ID varchar(20) NOT NULL,
	Class_name nvarchar(50) NOT NULL,
	Seats_quantity int NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Ticket_class_ID),
	FOREIGN KEY (Plane_ID) REFERENCES planes(Plane_ID)
);

-- Table structure for table seats
GO
CREATE TABLE seats (
    Seat_ID varchar(20) NOT NULL,
	Ticket_class_ID varchar(20) NOT NULL,
	Seat_name nvarchar(10) NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Seat_ID),
	FOREIGN KEY (Ticket_class_ID) REFERENCES ticket_classes(Ticket_class_ID)
);

-- Table structure for table airports
GO
CREATE TABLE airports (
    Airport_ID varchar(20) NOT NULL,
	Airport_name nvarchar(50) NOT NULL,
	Province nvarchar(50) NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Airport_ID)
);

-- Table structure for table airport_gates
GO
CREATE TABLE airport_gates (
    Gate_ID varchar(20) NOT NULL,
	Airport_ID varchar(20) NOT NULL,
	Gate_name nvarchar(50) NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Gate_ID),
	FOREIGN KEY (Airport_ID) REFERENCES airports(Airport_ID)
);

-- Table structure for table flights
GO
CREATE TABLE flights (
    Flight_ID varchar(20) NOT NULL,
	Flying_from varchar(20) NOT NULL,
	Flying_to varchar(20) NOT NULL,
	Hours_fly int NOT NULL, 
	Departure_flight datetime NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Flight_ID),
	FOREIGN KEY (Flying_from) REFERENCES airports(Airport_ID),
	FOREIGN KEY (Flying_to) REFERENCES airports(Airport_ID)
);

-- Table structure for table tickets
GO
CREATE TABLE tickets (
    Ticket_ID varchar(20) NOT NULL,
	Flight_ID varchar(20) NOT NULL,
	Gate_ID varchar(20) NOT NULL,
	Seat_ID varchar(20) NOT NULL,
	Import_price int NOT NULL,
	Selling_price int NOT NULL,
	Sold_out bit NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Ticket_ID),
	FOREIGN KEY (Flight_ID) REFERENCES flights(Flight_ID),
	FOREIGN KEY (Gate_ID) REFERENCES airport_gates(Gate_ID),
	FOREIGN KEY (Seat_ID) REFERENCES seats(Seat_ID)
);

-- Table structure for table promotions
GO
CREATE TABLE promotions (
    Promo_ID varchar(20) NOT NULL,
	Airline_ID varchar(20) NOT NULL,
	Promo_name nvarchar(200) NOT NULL,
	Promo_type int NOT NULL,
	Date_start datetime NOT NULL,
	Date_end datetime NOT NULL,
	Decreased int NOT NULL,
	IsDelete bit,
	PRIMARY KEY (Promo_ID),
	FOREIGN KEY (Airline_ID) REFERENCES airlines(Airline_ID)
);

-- Table structure for table orders
GO
CREATE TABLE orders (
    Order_ID varchar(20) NOT NULL,
	User_ID varchar(20) NOT NULL,	
	Promo_ID varchar(20),
	Date_order datetime NOT NULL,
	PRIMARY KEY (Order_ID),
	FOREIGN KEY (Promo_ID) REFERENCES promotions(Promo_ID),
	FOREIGN KEY (User_ID) REFERENCES users(User_ID),    
);

-- Table structure for table order_details
GO
CREATE TABLE order_details (
    Order_detail_ID varchar(20) NOT NULL,
	Order_ID varchar(20) NOT NULL,
	More_luggage_ID varchar(20),
	Receiver_ID varchar(20),
	Ticket_ID varchar(20) NOT NULL,
	PRIMARY KEY (Order_detail_ID),
	FOREIGN KEY (Order_ID) REFERENCES orders(Order_ID),    
	FOREIGN KEY (More_luggage_ID) REFERENCES more_luggage(More_luggage_ID),    
    FOREIGN KEY (Ticket_ID) REFERENCES tickets(Ticket_ID),
    FOREIGN KEY (Receiver_ID) REFERENCES receivers(Receiver_ID)
);

--
-- UPDATE DATABASE
--

-- Update 2/11/2023 - Nối Promocode vào OrderDetail thay vì Order
ALTER TABLE order_details
ADD Promo_ID varchar(20) REFERENCES promotions(Promo_ID)
GO
ALTER TABLE orders
DROP CONSTRAINT FK__orders__Promo_ID__628FA481
GO
ALTER TABLE orders
DROP COLUMN Promo_ID

--
-- INSERT DATA
--

-- Insert into actions
GO
INSERT INTO
    actions(Action_ID, Action_name, Info, IsDelete)
VALUES
    ('EUC', 'End user account', ' ', 0),
    ('ADM', 'Admin account', ' ', 0),
    ('ROL', 'Role', ' ', 0),
    ('LUG', 'More luggage', ' ', 0),
    ('PRM', 'Promotion program', ' ', 0),
	('FLT', 'Flight', ' ', 0),
	('TIK', 'Ticket', ' ', 0),
	('PLN', 'Plane', ' ', 0),
	('ALN', 'Airline', ' ', 0),
	('APT', 'Airport', ' ', 0),
	('FET', 'Features', ' ', 0);

-- Insert into roles
GO
INSERT INTO
    roles(Role_ID, Role_name, IsDelete)
VALUES
    ('ROLE0', 'Root', 0),
    ('ROLE1', 'Admin', 0),
    ('ROLE2', 'Only read', 0),
    ('ROLE3', 'End user', 0);

-- Insert into permission
GO
INSERT INTO
    permission(Per_ID, Role_ID, Action_ID, Per_access, Per_create, Per_view, Per_edit, Per_delete, IsDelete)
VALUES
    ('ROLE0-EUC', 'ROLE0', 'EUC', '1', '1', '1', '1', '1', 0),
    ('ROLE0-ADM', 'ROLE0', 'ADM', '1', '1', '1', '1', '1', 0),
	('ROLE0-ROL', 'ROLE0', 'ROL', '1', '1', '1', '1', '1', 0),
	('ROLE0-LUG', 'ROLE0', 'LUG', '1', '1', '1', '1', '1', 0),
	('ROLE0-PRM', 'ROLE0', 'PRM', '1', '1', '1', '1', '1', 0),
	('ROLE0-FLT', 'ROLE0', 'FLT', '1', '1', '1', '1', '1', 0),
	('ROLE0-TIK', 'ROLE0', 'TIK', '1', '1', '1', '1', '1', 0),
	('ROLE0-PLN', 'ROLE0', 'PLN', '1', '1', '1', '1', '1', 0),
	('ROLE0-ALN', 'ROLE0', 'ALN', '1', '1', '1', '1', '1', 0),
	('ROLE0-APT', 'ROLE0', 'APT', '1', '1', '1', '1', '1', 0),
	('ROLE0-FET', 'ROLE0', 'FET', '1', '1', '1', '1', '1', 0),
	('ROLE1-EUC', 'ROLE1', 'EUC', '1', '1', '1', '1', '1', 0),
    ('ROLE1-ADM', 'ROLE1', 'ADM', '1', '0', '1', '0', '0', 0),
	('ROLE1-ROL', 'ROLE1', 'ROL', '1', '0', '1', '0', '0', 0),
	('ROLE1-LUG', 'ROLE1', 'LUG', '1', '1', '1', '1', '1', 0),
	('ROLE1-PRM', 'ROLE1', 'PRM', '1', '1', '1', '1', '1', 0),
	('ROLE1-FLT', 'ROLE1', 'FLT', '1', '1', '1', '1', '1', 0),
	('ROLE1-TIK', 'ROLE1', 'TIK', '1', '1', '1', '1', '1', 0),
	('ROLE1-PLN', 'ROLE1', 'PLN', '1', '1', '1', '1', '1', 0),
	('ROLE1-ALN', 'ROLE1', 'ALN', '1', '1', '1', '1', '1', 0),
	('ROLE1-APT', 'ROLE1', 'APT', '1', '1', '1', '1', '1', 0),
	('ROLE1-FET', 'ROLE1', 'FET', '1', '0', '1', '0', '0', 0),
    ('ROLE2-EUC', 'ROLE2', 'EUC', '1', '0', '1', '0', '0', 0),
    ('ROLE2-ADM', 'ROLE2', 'ADM', '1', '0', '1', '0', '0', 0),
	('ROLE2-ROL', 'ROLE2', 'ROL', '1', '0', '1', '0', '0', 0),
	('ROLE2-LUG', 'ROLE2', 'LUG', '1', '0', '1', '0', '0', 0),
	('ROLE2-PRM', 'ROLE2', 'PRM', '1', '0', '1', '0', '0', 0),
	('ROLE2-FLT', 'ROLE2', 'FLT', '1', '0', '1', '0', '0', 0),
	('ROLE2-TIK', 'ROLE2', 'TIK', '1', '0', '1', '0', '0', 0),
	('ROLE2-PLN', 'ROLE2', 'PLN', '1', '0', '1', '0', '0', 0),
	('ROLE2-ALN', 'ROLE2', 'ALN', '1', '0', '1', '0', '0', 0),
	('ROLE2-APT', 'ROLE2', 'APT', '1', '0', '1', '0', '0', 0),
	('ROLE2-FET', 'ROLE2', 'FET', '1', '0', '1', '0', '0', 0),
    ('ROLE3-EUC', 'ROLE3', 'EUC', '1', '0', '0', '1', '1', 0),
    ('ROLE3-ADM', 'ROLE3', 'ADM', '0', '0', '0', '0', '0', 0),
	('ROLE3-ROL', 'ROLE3', 'ROL', '0', '0', '0', '0', '0', 0),
	('ROLE3-LUG', 'ROLE3', 'LUG', '1', '0', '1', '0', '0', 0),
	('ROLE3-PRM', 'ROLE3', 'PRM', '1', '0', '1', '0', '0', 0),
	('ROLE3-FLT', 'ROLE3', 'FLT', '1', '0', '1', '0', '0', 0),
	('ROLE3-TIK', 'ROLE3', 'TIK', '1', '0', '1', '0', '0', 0),
	('ROLE3-PLN', 'ROLE3', 'PLN', '1', '0', '0', '0', '0', 0),
	('ROLE3-ALN', 'ROLE3', 'ALN', '1', '0', '1', '0', '0', 0),
	('ROLE3-APT', 'ROLE3', 'APT', '1', '0', '1', '0', '0', 0),
	('ROLE3-FET', 'ROLE3', 'FET', '0', '0', '0', '0', '0', 0);

-- Insert into airlines
GO
INSERT INTO
    airlines(Airline_ID, Airline_name, IsDelete)
VALUES
    ('QH', 'Bamboo Airways', 0),
    ('BL', 'Pacific Airlines', 0),
    ('VJ', 'VietJet Air', 0),
    ('VN', 'Vietname Airlines', 0),
    ('VU', 'Vietravel Airlines', 0);

-- Insert into more_luggage
GO
INSERT INTO
	more_luggage(More_luggage_ID, Luggage_weight, Price, Airline_ID, IsDelete)
VALUES
	('MLG0001', 5, 382000, 'VN', 0),
    ('MLG0002', 10, 600000, 'VN', 0),
    ('MLG0003', 23, 1200000, 'VN', 0),
    ('MLG0004', 5, 180000, 'VJ', 0),
    ('MLG0005', 10, 300000, 'VJ', 0),
    ('MLG0006', 20, 600000, 'VJ', 0),
    ('MLG0007', 5, 382000, 'QH', 0),
    ('MLG0008', 10, 600000, 'QH', 0),
    ('MLG0009', 23, 1200000, 'QH', 0),
    ('MLG0010', 5, 382000, 'BL', 0),
    ('MLG0011', 10, 382000, 'BL', 0),
    ('MLG0012', 23, 382000, 'BL', 0),
    ('MLG0013', 5, 180000, 'VU', 0),
    ('MLG0014', 10, 300000, 'VU', 0),
    ('MLG0015', 20, 600000, 'VU', 0);

-- Insert into planes
GO
INSERT INTO
    planes(Plane_ID, Airline_ID, Plane_name, Seats, Plane_desc, IsDelete)
VALUES
    ('VN-VN-01', 'VN', 'BOEING B787', 274, '', 0),
    ('VN-VN-02', 'VN', 'AIRBUS A330', 269, '', 0),
    ('VN-VN-03', 'VN', 'AIRBUS A350', 305, '', 0),
    ('VN-VN-04', 'VN', 'AIRBUS A321', 184, '', 0),
    -- Vietjet
    ('VN-VJ-01', 'VJ', 'AIRBUS A330', 300, '', 0),
    ('VN-VJ-02', 'VJ', 'AIRBUS A321', 232, '', 0),
    ('VN-VJ-03', 'VJ', 'AIRBUS A320', 188, '', 0),
    ('VN-VJ-04', 'VJ', 'BOEING 737 MAX', 212, '', 0),
    -- Bamboo
    ('VN-QH-01', 'QH', 'BOEING 787-9 Dreamliner', 294, '', 0),
    ('VN-QH-02', 'QH', 'AIRBUS A312NEO', 223, '', 0),
    ('VN-QH-03', 'QH', 'AIRBUS A312CEO', 192, '', 0),
    ('VN-QH-04', 'QH', 'AIRBUS A320CEO', 170, '', 0),
    ('VN-QH-05', 'QH', 'AIRBUS A320NEO', 176, '', 0),
    ('VN-QH-06', 'QH', 'EMBRAER 190', 98, '', 0),
    -- Pacific Airlines
    ('VN-BL-01', 'BL','AIRBUS A320-200', 146, '', 0),
    ('VN-BL-02', 'BL','AIRBUS A320-240', 204, '', 0),
    -- VU
    ('VN-VU-01', 'VU', 'AIRBUS A321-211', 236, '', 0),
    ('VN-VU-02', 'VU', 'AIRBUS A321-211', 236, '', 0),
    ('VN-VU-03', 'VU', 'AIRBUS A321-211', 236, '', 0),
    ('VN-VU-04', 'VU', 'AIRBUS A319-100', 160, '', 0);

-- Insert into ticket_classes
GO
INSERT INTO
    ticket_classes(Ticket_class_ID, Class_name, Seats_quantity, Plane_ID, IsDelete)
VALUES
    -- VN
    ('VN-01-BC', 'Business Class', 28, 'VN-VN-01', 0),
    ('VN-01-PEC', 'Premium Economy Class', 35, 'VN-VN-01', 0),
    ('VN-01-EC', 'Economy Class', 211, 'VN-VN-01', 0),
    ('VN-02-BC', 'Business Class', 18, 'VN-VN-02', 0),
    ('VN-02-EC', 'Economy Class', 251, 'VN-VN-02', 0),
    ('VN-03-BC', 'Business Class', 29, 'VN-VN-03', 0),
    ('VN-03-PEC', 'Premium Economy Class', 45, 'VN-VN-03', 0),
    ('VN-03-EC', 'Economy Class', 231, 'VN-VN-03', 0),
    ('VN-04-BC', 'Business Class', 16, 'VN-VN-04', 0),
    ('VN-04-EC', 'Economy Class', 162, 'VN-VN-04', 0),
    -- VJ
    ('VJ-01-BC', 'SkyBoss Class', 24, 'VN-VJ-01', 0),
    ('VJ-01-EC', 'Economy Class', 276, 'VN-VJ-01', 0),
    ('VJ-02-BC', 'SkyBoss Class', 12, 'VN-VJ-02', 0),
    ('VJ-02-EC', 'Economy Class', 220, 'VN-VJ-02', 0),
    ('VJ-03-BC', 'SkyBoss Class', 8, 'VN-VJ-03', 0),
    ('VJ-03-EC', 'Economy Class', 180, 'VN-VJ-03', 0),
    ('VJ-04-BC', 'SkyBoss Class', 12, 'VN-VJ-04', 0),
    ('VJ-04-EC', 'Economy Class', 200, 'VN-VJ-04', 0),
    -- QH
    ('QH-01-BC', 'Business Class', 26, 'VN-QH-01', 0),
    ('QH-01-EC', 'Economy Class', 268, 'VN-QH-01', 0),
    ('QH-02-BC', 'Business Class', 8, 'VN-QH-02', 0),
    ('QH-02-EC', 'Economy Class', 215, 'VN-QH-02', 0),
    ('QH-03-BC', 'Business Class', 8, 'VN-QH-03', 0),
    ('QH-03-EC', 'Economy Class', 184, 'VN-QH-03', 0),
    ('QH-04-BC', 'Business Class', 8, 'VN-QH-04', 0),
    ('QH-04-EC', 'Economy Class', 162, 'VN-QH-04', 0),
    ('QH-05-BC', 'Business Class', 8, 'VN-QH-05', 0),
    ('QH-05-EC', 'Economy Class', 168, 'VN-QH-05', 0),
    ('QH-06-BC', 'Business Class', 6, 'VN-QH-06', 0),
    ('QH-06-EC', 'Economy Class', 92, 'VN-QH-06', 0),
    -- BL
    ('BL-01-BC', 'Business Class', 8, 'VN-BL-01', 0),
    ('BL-01-EC', 'Economy Class', 138, 'VN-BL-01', 0),
    ('BL-02-BC', 'Business Class', 16, 'VN-BL-02', 0),
    ('BL-02-EC', 'Economy Class', 188, 'VN-BL-02', 0),
    -- VU;
    ('VU-01-BC', 'Business Class', 16, 'VN-VU-01', 0),
    ('VU-01-EC', 'Economy Class', 220, 'VN-VU-01', 0),
    ('VU-02-BC', 'Business Class', 16, 'VN-VU-02', 0),
    ('VU-02-EC', 'Economy Class', 220, 'VN-VU-02', 0),
    ('VU-03-BC', 'Business Class', 16, 'VN-VU-03', 0),
    ('VU-03-EC', 'Economy Class', 220, 'VN-VU-03', 0),
    ('VU-04-BC', 'Business Class', 8, 'VN-VU-04', 0),
    ('VU-04-EC', 'Economy Class', 160, 'VN-VU-04', 0);

-- Insert into airports
GO
INSERT INTO
    airports(Airport_ID, Airport_name, Province, IsDelete)
VALUES
    ('VCA', 'Can Tho International Airport', N'Cần Thơ', 0),
    ('DAD', 'Da Nang International Airport', N'Đà Nẵng', 0),
    ('HPH', 'Cai Bi International Airport', N'Hải Phòng', 0),
    ('HAN', 'Noi Bai International Airport', N'Hà Nội', 0),
    ('SGN', 'Tan Son Nhat International Airport', N'Hồ Chí Minh', 0),
    ('HUI', 'Phu Bai International Airport', N'Huế', 0),
    ('CXR', 'Cam Ranh International Airport', N'Khánh Hòa', 0),
    ('PQC', 'Phu Quoc International Airport', N'Kiên Giang', 0),
    ('VDO', 'Van Don International Airport', N'Quảng Ninh', 0),
    ('VII', 'Vinh International Airport', N'Nghệ An', 0),
    ('BMV', 'Buon Ma Thuot Airport', N'Đắk Lắk', 0),
    ('CAH', 'Ca Mau Airport', N'Cà Mau', 0),
    ('VCS', 'Chu Lai Airport', N'Quảng Nam', 0),
    ('VCL', 'Co Ong Airport', N'Bà Rịa - Vũng Tàu', 0),
    ('DLI', 'Lien Khuong Airport', N'Đà Lạt', 0),
    ('DIN', 'Dien Bien Phu Airport', N'Điện Biên', 0),
    ('VDH', 'Dong Hoi Airport', N'Quảng Bình', 0),
    ('PXU', 'Pleiku Airport', N'Gia Lai', 0),
    ('UIH', 'Phu Cat Airport', N'Bình Định', 0),
    ('VKG', 'Rach Gia Airport', N'Kiên Giang', 0),
    ('TBB', 'Dong Tac Airport', N'Phú Yên', 0),
    ('VTG', 'Vung Tau Airport', N'Bà Rịa - Vũng Tàu', 0),
    ('THD', 'Tho Xuan Airport', N'Thanh Hóa', 0);

-- Insert into airport_gates
GO
INSERT INTO
    airport_gates(Gate_ID, Airport_ID, Gate_name, IsDelete)
VALUES
    -- Sân bay Tân Sơn Nhất
    ('SGN-D01', 'SGN', '01', 0),
    ('SGN-D02', 'SGN', '02', 0),
    ('SGN-D03', 'SGN', '03', 0),
    ('SGN-D04', 'SGN', '04', 0),
    ('SGN-D05', 'SGN', '05', 0),
    ('SGN-D06', 'SGN', '06', 0),
    ('SGN-D07', 'SGN', '07', 0),
    ('SGN-D08', 'SGN', '08', 0),
    ('SGN-D09', 'SGN', '09', 0),
    ('SGN-D10', 'SGN', '10', 0),
    -- Sân bay Cần Thơ
    ('VCA-D01', 'VCA', '01', 0),
    ('VCA-D02', 'VCA', '02', 0),
    ('VCA-D03', 'VCA', '03', 0),
    ('VCA-D04', 'VCA', '04', 0),
    ('VCA-D05', 'VCA', '05', 0),
    ('VCA-D06', 'VCA', '06', 0),
    ('VCA-D07', 'VCA', '07', 0),
    -- Sân Bay Đà Nẵng
    ('DAD-D01', 'DAD', '01', 0),
    ('DAD-D02', 'DAD', '02', 0),
    ('DAD-D03', 'DAD', '03', 0),
    ('DAD-D04', 'DAD', '04', 0),
    ('DAD-D05', 'DAD', '05', 0),
    ('DAD-D06', 'DAD', '06', 0),
    ('DAD-D07', 'DAD', '07', 0),
    -- Sân Bay Cai Bi
    ('HPH-D01', 'HPH', '01', 0),
    ('HPH-D02', 'HPH', '02', 0),
    ('HPH-D03', 'HPH', '03', 0),
    ('HPH-D04', 'HPH', '04', 0),
    ('HPH-D05', 'HPH', '05', 0),
    ('HPH-D06', 'HPH', '06', 0),
    ('HPH-D07', 'HPH', '07', 0),
    -- Sân Bay Nội Bài
    ('HAN-D01', 'HAN', '01', 0),
    ('HAN-D02', 'HAN', '02', 0),
    ('HAN-D03', 'HAN', '03', 0),
    ('HAN-D04', 'HAN', '04', 0),
    ('HAN-D05', 'HAN', '05', 0),
    ('HAN-D06', 'HAN', '06', 0),
    ('HAN-D07', 'HAN', '07', 0),
    ('HAN-D08', 'HAN', '08', 0),
    ('HAN-D09', 'HAN', '09', 0),
    ('HAN-D10', 'HAN', '10', 0),
    -- Sân Bay Phú Bài
    ('HUI-D01', 'HUI', '01', 0),
    ('HUI-D02', 'HUI', '02', 0),
    ('HUI-D03', 'HUI', '03', 0),
    ('HUI-D04', 'HUI', '04', 0),
    ('HUI-D05', 'HUI', '05', 0),
    ('HUI-D06', 'HUI', '06', 0),
    ('HUI-D07', 'HUI', '07', 0),
    ('HUI-D08', 'HUI', '08', 0),
    -- Sân bay Cam Ranh
    ('CXR-D01', 'CXR', '01', 0),
    ('CXR-D02', 'CXR', '02', 0),
    ('CXR-D03', 'CXR', '03', 0),
    ('CXR-D04', 'CXR', '04', 0),
    ('CXR-D05', 'CXR', '05', 0),
    ('CXR-D06', 'CXR', '06', 0),
    ('CXR-D07', 'CXR', '07', 0),
    ('CXR-D08', 'CXR', '08', 0),
    -- Sân bay Phú Quốc
    ('PQC-D01', 'PQC', '01', 0),
    ('PQC-D02', 'PQC', '02', 0),
    ('PQC-D03', 'PQC', '03', 0),
    ('PQC-D04', 'PQC', '04', 0),
    ('PQC-D05', 'PQC', '05', 0),
    ('PQC-D06', 'PQC', '06', 0),
    ('PQC-D07', 'PQC', '07', 0),
    ('PQC-D08', 'PQC', '08', 0),
    -- Sân bay Vân Đồn
    ('VDO-D01', 'VDO', '01', 0),
    ('VDO-D02', 'VDO', '02', 0),
    ('VDO-D03', 'VDO', '03', 0),
    ('VDO-D04', 'VDO', '04', 0),
    ('VDO-D05', 'VDO', '05', 0),
    ('VDO-D06', 'VDO', '06', 0),
    ('VDO-D07', 'VDO', '07', 0),
    ('VDO-D08', 'VDO', '08', 0),
    -- Sân bay Vinh
    ('VII-D01', 'VII', '01', 0),
    ('VII-D02', 'VII', '02', 0),
    ('VII-D03', 'VII', '03', 0),
    ('VII-D04', 'VII', '04', 0),
    ('VII-D05', 'VII', '05', 0),
    ('VII-D06', 'VII', '06', 0),
    ('VII-D07', 'VII', '07', 0),
    ('VII-D08', 'VII', '08', 0),
    -- Sân bay Buôn Ma Thuột
    ('BMV-D01', 'BMV', '01', 0),
    ('BMV-D02', 'BMV', '02', 0),
    ('BMV-D03', 'BMV', '03', 0),
    ('BMV-D04', 'BMV', '04', 0),
    ('BMV-D05', 'BMV', '05', 0),
    -- Sân bay Cà Mau
    ('CAH-D01', 'CAH', '01', 0),
    ('CAH-D02', 'CAH', '02', 0),
    ('CAH-D03', 'CAH', '03', 0),
    ('CAH-D04', 'CAH', '04', 0),
    ('CAH-D05', 'CAH', '05', 0),
    -- Sân bay Chu Lai
    ('VCS-D01', 'VCS', '01', 0),
    ('VCS-D02', 'VCS', '02', 0),
    ('VCS-D03', 'VCS', '03', 0),
    ('VCS-D04', 'VCS', '04', 0),
    ('VCS-D05', 'VCS', '05', 0),
    -- Sân bay Co Ong
    ('VCL-D01', 'VCL', '01', 0),
    ('VCL-D02', 'VCL', '02', 0),
    ('VCL-D03', 'VCL', '03', 0),
    ('VCL-D04', 'VCL', '04', 0),
    ('VCL-D05', 'VCL', '05', 0),
    -- Sân bay Liên Khương
    ('DLI-D01', 'DLI', '01', 0),
    ('DLI-D02', 'DLI', '02', 0),
    ('DLI-D03', 'DLI', '03', 0),
    ('DLI-D04', 'DLI', '04', 0),
    ('DLI-D05', 'DLI', '05', 0),
    -- Sân bay Điện Biên
    ('DIN-D01', 'DIN', '01', 0),
    ('DIN-D02', 'DIN', '02', 0),
    ('DIN-D03', 'DIN', '03', 0),
    ('DIN-D04', 'DIN', '04', 0),
    ('DIN-D05', 'DIN', '05', 0),
    -- Sân bay Đồng Hới
    ('VDH-D01', 'VDH', '01', 0),
    ('VDH-D02', 'VDH', '02', 0),
    ('VDH-D03', 'VDH', '03', 0),
    ('VDH-D04', 'VDH', '04', 0),
    ('VDH-D05', 'VDH', '05', 0),
    -- Sân bay Pleiku
    ('PXU-D01', 'PXU', '01', 0),
    ('PXU-D02', 'PXU', '02', 0),
    ('PXU-D03', 'PXU', '03', 0),
    ('PXU-D04', 'PXU', '04', 0),
    ('PXU-D05', 'PXU', '05', 0),
    -- Sân bay Phù Cát
    ('UIH-D01', 'UIH', '01', 0),
    ('UIH-D02', 'UIH', '02', 0),
    ('UIH-D03', 'UIH', '03', 0),
    ('UIH-D04', 'UIH', '04', 0),
    ('UIH-D05', 'UIH', '05', 0),
    -- Sân bay Rạch Giá
    ('VKG-D01', 'VKG', '01', 0),
    ('VKG-D02', 'VKG', '02', 0),
    ('VKG-D03', 'VKG', '03', 0),
    ('VKG-D04', 'VKG', '04', 0),
    ('VKG-D05', 'VKG', '05', 0),
    -- Sân bay Dong Tac
    ('TBB-D01', 'TBB', '01', 0),
    ('TBB-D02', 'TBB', '02', 0),
    ('TBB-D03', 'TBB', '03', 0),
    ('TBB-D04', 'TBB', '04', 0),
    ('TBB-D05', 'TBB', '05', 0),
    -- Sân bay Vũng Tàu
    ('VTG-D01', 'VTG', '01', 0),
    ('VTG-D02', 'VTG', '02', 0),
    ('VTG-D03', 'VTG', '03', 0),
    ('VTG-D04', 'VTG', '04', 0),
    ('VTG-D05', 'VTG', '05', 0),
    -- Sân bay Tho Xuan
    ('THD-D01', 'THD', '01', 0),
    ('THD-D02', 'THD', '02', 0),
    ('THD-D03', 'THD', '03', 0),
    ('THD-D04', 'THD', '04', 0),
    ('THD-D05', 'THD', '05', 0);

