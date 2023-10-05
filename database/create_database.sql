CREATE DATABASE AIRBOOK;
GO
USE AIRBOOK;

-- Table structure for table action
GO
CREATE TABLE actions (
    Action_ID varchar(20) NOT NULL,
    Action_name nvarchar(50) NOT NULL,
	Info nvarchar(200),
    PRIMARY KEY (Action_ID)
);

-- Table structure for table role
GO
CREATE TABLE roles (
    Role_ID varchar(20) NOT NULL,
    Role_name nvarchar(50) NOT NULL,
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
	Pwd varchar(20) NOT NULL, 
	Real_name nvarchar(50) NOT NULL,
	DoB date NOT NULL, 
	Gender nvarchar(10) NOT NULL,
	Nation nvarchar(20) NOT NULL, 
	User_address nvarchar(50) NOT NULL,
	Phone_number varchar(11) NOT NULL,
	CCCD varchar(12) NOT NULL,
	Email varchar(50) NOT NULL,
	Date_create datetime NOT NULL,
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
	Receiver_address nvarchar(50) NOT NULL,
	Nation nvarchar(20) NOT NULL, 
	Phone_number varchar(11) NOT NULL,
	CCCD varchar(12),
	Email varchar(50) NOT NULL,
	PRIMARY KEY (Receiver_ID),
);

-- Table structure for table airline
GO
CREATE TABLE airlines (
    Airline_ID varchar(20) NOT NULL,
	Airline_name nvarchar(50) NOT NULL,
	PRIMARY KEY (Airline_ID)
);

-- Table structure for table more_luggage
GO
CREATE TABLE more_luggage (
    More_luggage_ID varchar(20) NOT NULL,
	Airline_ID varchar(20) NOT NULL,
	Luggage_weight int NOT NULL,
	Price int NOT NULL,
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
	PRIMARY KEY (Ticket_class_ID),
	FOREIGN KEY (Plane_ID) REFERENCES planes(Plane_ID)
);

-- Table structure for table seats
GO
CREATE TABLE seats (
    Seat_ID varchar(20) NOT NULL,
	Ticket_class_ID varchar(20) NOT NULL,
	Seat_name nvarchar(10) NOT NULL,
	PRIMARY KEY (Seat_ID),
	FOREIGN KEY (Ticket_class_ID) REFERENCES ticket_classes(Ticket_class_ID)
);

-- Table structure for table airports
GO
CREATE TABLE airports (
    Airport_ID varchar(20) NOT NULL,
	Airport_name nvarchar(50) NOT NULL,
	Province nvarchar(50) NOT NULL,
	PRIMARY KEY (Airport_ID)
);

-- Table structure for table airport_gates
GO
CREATE TABLE airport_gates (
    Gate_ID varchar(20) NOT NULL,
	Airport_ID varchar(20) NOT NULL,
	Gate_name nvarchar(50) NOT NULL,
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
	Price int NOT NULL,
	Sold_out bit NOT NULL,
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
-- INSERT DATA
--

-- Insert into actions
GO
INSERT INTO
    actions(Action_ID, Action_name, Info)
VALUES
    ('AT1', 'End user account', ' '),
    ('AT2', 'Admin account', ' '),
    ('AT3', 'Role', ' '),
    ('AT4', 'More luggage', ' '),
    ('AT5', 'Promotion program', ' '),
	('AT6', 'Flight', ' '),
	('AT7', 'Ticket', ' '),
	('AT8', 'Plane', ' '),
	('AT9', 'Airline', ' '),
	('AT10', 'Airport', ' ');

-- Insert into roles
GO
INSERT INTO
    roles(Role_ID, Role_name)
VALUES
    ('ROLE1', 'Root'),
    ('ROLE2', 'Admin'),
    ('ROLE3', 'Only read'),
    ('ROLE4', 'End user');

-- Insert into permission
GO
INSERT INTO
    permission(Per_ID, Role_ID, Action_ID, Per_access, Per_create, Per_view, Per_edit, Per_delete)
VALUES
    ('ROLE1-AT1', 'ROLE1', 'AT1', '1', '1', '1', '1', '1'),
    ('ROLE1-AT2', 'ROLE1', 'AT2', '1', '1', '1', '1', '1'),
	('ROLE1-AT3', 'ROLE1', 'AT3', '1', '1', '1', '1', '1'),
	('ROLE1-AT4', 'ROLE1', 'AT4', '1', '1', '1', '1', '1'),
	('ROLE1-AT5', 'ROLE1', 'AT5', '1', '1', '1', '1', '1'),
	('ROLE1-AT6', 'ROLE1', 'AT6', '1', '1', '1', '1', '1'),
	('ROLE1-AT7', 'ROLE1', 'AT7', '1', '1', '1', '1', '1'),
	('ROLE1-AT8', 'ROLE1', 'AT8', '1', '1', '1', '1', '1'),
	('ROLE1-AT9', 'ROLE1', 'AT9', '1', '1', '1', '1', '1'),
	('ROLE1-AT10', 'ROLE1', 'AT10', '1', '1', '1', '1', '1'),
	('ROLE2-AT1', 'ROLE2', 'AT1', '1', '1', '1', '1', '1'),
    ('ROLE2-AT2', 'ROLE2', 'AT2', '1', '0', '1', '0', '0'),
	('ROLE2-AT3', 'ROLE2', 'AT3', '1', '0', '1', '0', '0'),
	('ROLE2-AT4', 'ROLE2', 'AT4', '1', '1', '1', '1', '1'),
	('ROLE2-AT5', 'ROLE2', 'AT5', '1', '1', '1', '1', '1'),
	('ROLE2-AT6', 'ROLE2', 'AT6', '1', '1', '1', '1', '1'),
	('ROLE2-AT7', 'ROLE2', 'AT7', '1', '1', '1', '1', '1'),
	('ROLE2-AT8', 'ROLE2', 'AT8', '1', '1', '1', '1', '1'),
	('ROLE2-AT9', 'ROLE2', 'AT9', '1', '1', '1', '1', '1'),
	('ROLE2-AT10', 'ROLE2', 'AT10', '1', '1', '1', '1', '1'),
    ('ROLE3-AT1', 'ROLE3', 'AT1', '1', '0', '1', '0', '0'),
    ('ROLE3-AT2', 'ROLE3', 'AT2', '1', '0', '1', '0', '0'),
	('ROLE3-AT3', 'ROLE3', 'AT3', '1', '0', '1', '0', '0'),
	('ROLE3-AT4', 'ROLE3', 'AT4', '1', '0', '1', '0', '0'),
	('ROLE3-AT5', 'ROLE3', 'AT5', '1', '0', '1', '0', '0'),
	('ROLE3-AT6', 'ROLE3', 'AT6', '1', '0', '1', '0', '0'),
	('ROLE3-AT7', 'ROLE3', 'AT7', '1', '0', '1', '0', '0'),
	('ROLE3-AT8', 'ROLE3', 'AT8', '1', '0', '1', '0', '0'),
	('ROLE3-AT9', 'ROLE3', 'AT9', '1', '0', '1', '0', '0'),
	('ROLE3-AT10', 'ROLE3', 'AT10', '1', '0', '1', '0', '0'),
    ('ROLE4-AT1', 'ROLE4', 'AT1', '1', '0', '0', '1', '1'),
    ('ROLE4-AT2', 'ROLE4', 'AT2', '0', '0', '0', '0', '0'),
	('ROLE4-AT3', 'ROLE4', 'AT3', '0', '0', '0', '0', '0'),
	('ROLE4-AT4', 'ROLE4', 'AT4', '1', '0', '1', '0', '0'),
	('ROLE4-AT5', 'ROLE4', 'AT5', '1', '0', '1', '0', '0'),
	('ROLE4-AT6', 'ROLE4', 'AT6', '1', '0', '1', '0', '0'),
	('ROLE4-AT7', 'ROLE4', 'AT7', '1', '0', '1', '0', '0'),
	('ROLE4-AT8', 'ROLE4', 'AT8', '1', '0', '0', '0', '0'),
	('ROLE4-AT9', 'ROLE4', 'AT9', '1', '0', '1', '0', '0'),
	('ROLE4-AT10', 'ROLE4', 'AT10', '1', '0', '1', '0', '0');

-- Insert into airlines
GO
INSERT INTO
    airlines(Airline_ID, Airline_name)
VALUES
    ('QH', 'Bamboo Airways'),
    ('BL', 'Pacific Airlines'),
    ('VJ', 'VietJet Air'),
    ('VN', 'Vietname Airlines'),
    ('VU', 'Vietravel Airlines');

-- Insert into more_luggage
GO
INSERT INTO
	more_luggage(More_luggage_ID, Luggage_weight, Price, Airline_ID)
VALUES
	('MLG0001', 5, 382000, 'VN'),
    ('MLG0002', 10, 600000, 'VN'),
    ('MLG0003', 23, 1200000, 'VN'),
    ('MLG0004', 5, 180000, 'VJ'),
    ('MLG0005', 10, 300000, 'VJ'),
    ('MLG0006', 20, 600000, 'VJ'),
    ('MLG0007', 5, 382000, 'QH'),
    ('MLG0008', 10, 600000, 'QH'),
    ('MLG0009', 23, 1200000, 'QH'),
    ('MLG0010', 5, 382000, 'BL'),
    ('MLG0011', 10, 382000, 'BL'),
    ('MLG0012', 23, 382000, 'BL'),
    ('MLG0013', 5, 180000, 'VU'),
    ('MLG0014', 10, 300000, 'VU'),
    ('MLG0015', 20, 600000, 'VU');

-- Insert into planes
GO
INSERT INTO
    planes(Plane_ID, Airline_ID, Plane_name, Seats, Plane_desc)
VALUES
    ('VN-VN-01', 'VN', 'BOEING B787', 274, ''),
    ('VN-VN-02', 'VN', 'AIRBUS A330', 269, ''),
    ('VN-VN-03', 'VN', 'AIRBUS A350', 305, ''),
    ('VN-VN-04', 'VN', 'AIRBUS A321', 184, ''),
    -- Vietjet
    ('VN-VJ-01', 'VJ', 'AIRBUS A330', 300, ''),
    ('VN-VJ-02', 'VJ', 'AIRBUS A321', 232, ''),
    ('VN-VJ-03', 'VJ', 'AIRBUS A320', 188, ''),
    ('VN-VJ-04', 'VJ', 'BOEING 737 MAX', 212, ''),
    -- Bamboo
    ('VN-QH-01', 'QH', 'BOEING 787-9 Dreamliner', 294, ''),
    ('VN-QH-02', 'QH', 'AIRBUS A312NEO', 223, ''),
    ('VN-QH-03', 'QH', 'AIRBUS A312CEO', 192, ''),
    ('VN-QH-04', 'QH', 'AIRBUS A320CEO', 170, ''),
    ('VN-QH-05', 'QH', 'AIRBUS A320NEO', 176, ''),
    ('VN-QH-06', 'QH', 'EMBRAER 190', 98, ''),
    -- Pacific Airlines
    ('VN-BL-01', 'BL','AIRBUS A320-200', 146, ''),
    ('VN-BL-02', 'BL','AIRBUS A320-240', 204, ''),
    -- VU
    ('VN-VU-01', 'VU', 'AIRBUS A321-211', 236, ''),
    ('VN-VU-02', 'VU', 'AIRBUS A321-211', 236, ''),
    ('VN-VU-03', 'VU', 'AIRBUS A321-211', 236, ''),
    ('VN-VU-04', 'VU', 'AIRBUS A319-100', 160, '');

-- Insert into ticket_classes
GO
INSERT INTO
    ticket_classes(Ticket_class_ID, Class_name, Seats_quantity, Plane_ID)
VALUES
    -- VN
    ('VN-01-BC', 'Business Class', 28, 'VN-VN-01'),
    ('VN-01-PEC', 'Premium Economy Class', 35, 'VN-VN-01'),
    ('VN-01-EC', 'Economy Class', 211, 'VN-VN-01'),
    ('VN-02-BC', 'Business Class', 18, 'VN-VN-02'),
    ('VN-02-EC', 'Economy Class', 251, 'VN-VN-02'),
    ('VN-03-BC', 'Business Class', 29, 'VN-VN-03'),
    ('VN-03-PEC', 'Premium Economy Class', 45, 'VN-VN-03'),
    ('VN-03-EC', 'Economy Class', 231, 'VN-VN-03'),
    ('VN-04-BC', 'Business Class', 16, 'VN-VN-04'),
    ('VN-04-EC', 'Economy Class', 162, 'VN-VN-04'),
    -- VJ
    ('VJ-01-BC', 'SkyBoss Class', 24, 'VN-VJ-01'),
    ('VJ-01-EC', 'Economy Class', 276, 'VN-VJ-01'),
    ('VJ-02-BC', 'SkyBoss Class', 12, 'VN-VJ-02'),
    ('VJ-02-EC', 'Economy Class', 220, 'VN-VJ-02'),
    ('VJ-03-BC', 'SkyBoss Class', 8, 'VN-VJ-03'),
    ('VJ-03-EC', 'Economy Class', 180, 'VN-VJ-03'),
    ('VJ-04-BC', 'SkyBoss Class', 12, 'VN-VJ-04'),
    ('VJ-04-EC', 'Economy Class', 200, 'VN-VJ-04'),
    -- QH
    ('QH-01-BC', 'Business Class', 26, 'VN-QH-01'),
    ('QH-01-EC', 'Economy Class', 268, 'VN-QH-01'),
    ('QH-02-BC', 'Business Class', 8, 'VN-QH-02'),
    ('QH-02-EC', 'Economy Class', 215, 'VN-QH-02'),
    ('QH-03-BC', 'Business Class', 8, 'VN-QH-03'),
    ('QH-03-EC', 'Economy Class', 184, 'VN-QH-03'),
    ('QH-04-BC', 'Business Class', 8, 'VN-QH-04'),
    ('QH-04-EC', 'Economy Class', 162, 'VN-QH-04'),
    ('QH-05-BC', 'Business Class', 8, 'VN-QH-05'),
    ('QH-05-EC', 'Economy Class', 168, 'VN-QH-05'),
    ('QH-06-BC', 'Business Class', 6, 'VN-QH-06'),
    ('QH-06-EC', 'Economy Class', 92, 'VN-QH-06'),
    -- BL
    ('BL-01-BC', 'Business Class', 8, 'VN-BL-01'),
    ('BL-01-EC', 'Economy Class', 138, 'VN-BL-01'),
    ('BL-02-BC', 'Business Class', 16, 'VN-BL-02'),
    ('BL-02-EC', 'Economy Class', 188, 'VN-BL-02'),
    -- VU;
    ('VU-01-BC', 'Business Class', 16, 'VN-VU-01'),
    ('VU-01-EC', 'Economy Class', 220, 'VN-VU-01'),
    ('VU-02-BC', 'Business Class', 16, 'VN-VU-02'),
    ('VU-02-EC', 'Economy Class', 220, 'VN-VU-02'),
    ('VU-03-BC', 'Business Class', 16, 'VN-VU-03'),
    ('VU-03-EC', 'Economy Class', 220, 'VN-VU-03'),
    ('VU-04-BC', 'Business Class', 8, 'VN-VU-04'),
    ('VU-04-EC', 'Economy Class', 160, 'VN-VU-04');

-- Insert into airports
GO
INSERT INTO
    airports(Airport_ID, Airport_name, Province)
VALUES
    ('VCA', 'Can Tho International Airport', 'Cần Thơ'),
    ('DAD', 'Da Nang International Airport', 'Đà Nẵng'),
    ('HPH', 'Cai Bi International Airport', 'Hải Phòng'),
    ('HAN', 'Noi Bai International Airport', 'Hà Nội'),
    ('SGN', 'Tan Son Nhat International Airport', 'Hồ Chí Minh'),
    ('HUI', 'Phu Bai International Airport', 'Huế'),
    ('CXR', 'Cam Ranh International Airport', 'Khánh Hòa'),
    ('PQC', 'Phu Quoc International Airport', 'Kiên Giang'),
    ('VDO', 'Van Don International Airport', 'Quảng Ninh'),
    ('VII', 'Vinh International Airport', 'Nghệ An'),
    ('BMV', 'Buon Ma Thuot Airport', 'Đắk Lắk'),
    ('CAH', 'Ca Mau Airport', 'Cà Mau'),
    ('VCS', 'Chu Lai Airport', 'Quảng Nam'),
    ('VCL', 'Co Ong Airport', 'Bà Rịa - Vũng Tàu'),
    ('DLI', 'Lien Khuong Airport', 'Đà Lạt'),
    ('DIN', 'Dien Bien Phu Airport', 'Điện Biên'),
    ('VDH', 'Dong Hoi Airport', 'Quảng Bình'),
    ('PXU', 'Pleiku Airport', 'Gia Lai'),
    ('UIH', 'Phu Cat Airport', 'Bình Định'),
    ('VKG', 'Rach Gia Airport', 'Kiên Giang'),
    ('TBB', 'Dong Tac Airport', 'Phú Yên'),
    ('VTG', 'Vung Tau Airport', 'Bà Rịa - Vũng Tàu'),
    ('THD', 'Tho Xuan Airport', 'Thanh Hóa');

-- Insert into airport_gates
GO
INSERT INTO
    airport_gates(Gate_ID, Airport_ID, Gate_name)
VALUES
    -- Sân bay Tân Sơn Nhất
    ('SGN-D01', 'SGN', '01'),
    ('SGN-D02', 'SGN', '02'),
    ('SGN-D03', 'SGN', '03'),
    ('SGN-D04', 'SGN', '04'),
    ('SGN-D05', 'SGN', '05'),
    ('SGN-D06', 'SGN', '06'),
    ('SGN-D07', 'SGN', '07'),
    ('SGN-D08', 'SGN', '08'),
    ('SGN-D09', 'SGN', '09'),
    ('SGN-D10', 'SGN', '10'),
    -- Sân bay Cần Thơ
    ('VCA-D01', 'VCA', '01'),
    ('VCA-D02', 'VCA', '02'),
    ('VCA-D03', 'VCA', '03'),
    ('VCA-D04', 'VCA', '04'),
    ('VCA-D05', 'VCA', '05'),
    ('VCA-D06', 'VCA', '06'),
    ('VCA-D07', 'VCA', '07'),
    -- Sân Bay Đà Nẵng
    ('DAD-D01', 'DAD', '01'),
    ('DAD-D02', 'DAD', '02'),
    ('DAD-D03', 'DAD', '03'),
    ('DAD-D04', 'DAD', '04'),
    ('DAD-D05', 'DAD', '05'),
    ('DAD-D06', 'DAD', '06'),
    ('DAD-D07', 'DAD', '07'),
    -- Sân Bay Cai Bi
    ('HPH-D01', 'HPH', '01'),
    ('HPH-D02', 'HPH', '02'),
    ('HPH-D03', 'HPH', '03'),
    ('HPH-D04', 'HPH', '04'),
    ('HPH-D05', 'HPH', '05'),
    ('HPH-D06', 'HPH', '06'),
    ('HPH-D07', 'HPH', '07'),
    -- Sân Bay Nội Bài
    ('HAN-D01', 'HAN', '01'),
    ('HAN-D02', 'HAN', '02'),
    ('HAN-D03', 'HAN', '03'),
    ('HAN-D04', 'HAN', '04'),
    ('HAN-D05', 'HAN', '05'),
    ('HAN-D06', 'HAN', '06'),
    ('HAN-D07', 'HAN', '07'),
    ('HAN-D08', 'HAN', '08'),
    ('HAN-D09', 'HAN', '09'),
    ('HAN-D10', 'HAN', '10'),
    -- Sân Bay Phú Bài
    ('HUI-D01', 'HUI', '01'),
    ('HUI-D02', 'HUI', '02'),
    ('HUI-D03', 'HUI', '03'),
    ('HUI-D04', 'HUI', '04'),
    ('HUI-D05', 'HUI', '05'),
    ('HUI-D06', 'HUI', '06'),
    ('HUI-D07', 'HUI', '07'),
    ('HUI-D08', 'HUI', '08'),
    -- Sân bay Cam Ranh
    ('CXR-D01', 'CXR', '01'),
    ('CXR-D02', 'CXR', '02'),
    ('CXR-D03', 'CXR', '03'),
    ('CXR-D04', 'CXR', '04'),
    ('CXR-D05', 'CXR', '05'),
    ('CXR-D06', 'CXR', '06'),
    ('CXR-D07', 'CXR', '07'),
    ('CXR-D08', 'CXR', '08'),
    -- Sân bay Phú Quốc
    ('PQC-D01', 'PQC', '01'),
    ('PQC-D02', 'PQC', '02'),
    ('PQC-D03', 'PQC', '03'),
    ('PQC-D04', 'PQC', '04'),
    ('PQC-D05', 'PQC', '05'),
    ('PQC-D06', 'PQC', '06'),
    ('PQC-D07', 'PQC', '07'),
    ('PQC-D08', 'PQC', '08'),
    -- Sân bay Vân Đồn
    ('VDO-D01', 'VDO', '01'),
    ('VDO-D02', 'VDO', '02'),
    ('VDO-D03', 'VDO', '03'),
    ('VDO-D04', 'VDO', '04'),
    ('VDO-D05', 'VDO', '05'),
    ('VDO-D06', 'VDO', '06'),
    ('VDO-D07', 'VDO', '07'),
    ('VDO-D08', 'VDO', '08'),
    -- Sân bay Vinh
    ('VII-D01', 'VII', '01'),
    ('VII-D02', 'VII', '02'),
    ('VII-D03', 'VII', '03'),
    ('VII-D04', 'VII', '04'),
    ('VII-D05', 'VII', '05'),
    ('VII-D06', 'VII', '06'),
    ('VII-D07', 'VII', '07'),
    ('VII-D08', 'VII', '08'),
    -- Sân bay Buôn Ma Thuột
    ('BMV-D01', 'BMV', '01'),
    ('BMV-D02', 'BMV', '02'),
    ('BMV-D03', 'BMV', '03'),
    ('BMV-D04', 'BMV', '04'),
    ('BMV-D05', 'BMV', '05'),
    -- Sân bay Cà Mau
    ('CAH-D01', 'CAH', '01'),
    ('CAH-D02', 'CAH', '02'),
    ('CAH-D03', 'CAH', '03'),
    ('CAH-D04', 'CAH', '04'),
    ('CAH-D05', 'CAH', '05'),
    -- Sân bay Chu Lai
    ('VCS-D01', 'VCS', '01'),
    ('VCS-D02', 'VCS', '02'),
    ('VCS-D03', 'VCS', '03'),
    ('VCS-D04', 'VCS', '04'),
    ('VCS-D05', 'VCS', '05'),
    -- Sân bay Co Ong
    ('VCL-D01', 'VCL', '01'),
    ('VCL-D02', 'VCL', '02'),
    ('VCL-D03', 'VCL', '03'),
    ('VCL-D04', 'VCL', '04'),
    ('VCL-D05', 'VCL', '05'),
    -- Sân bay Liên Khương
    ('DLI-D01', 'DLI', '01'),
    ('DLI-D02', 'DLI', '02'),
    ('DLI-D03', 'DLI', '03'),
    ('DLI-D04', 'DLI', '04'),
    ('DLI-D05', 'DLI', '05'),
    -- Sân bay Điện Biên
    ('DIN-D01', 'DIN', '01'),
    ('DIN-D02', 'DIN', '02'),
    ('DIN-D03', 'DIN', '03'),
    ('DIN-D04', 'DIN', '04'),
    ('DIN-D05', 'DIN', '05'),
    -- Sân bay Đồng Hới
    ('VDH-D01', 'VDH', '01'),
    ('VDH-D02', 'VDH', '02'),
    ('VDH-D03', 'VDH', '03'),
    ('VDH-D04', 'VDH', '04'),
    ('VDH-D05', 'VDH', '05'),
    -- Sân bay Pleiku
    ('PXU-D01', 'PXU', '01'),
    ('PXU-D02', 'PXU', '02'),
    ('PXU-D03', 'PXU', '03'),
    ('PXU-D04', 'PXU', '04'),
    ('PXU-D05', 'PXU', '05'),
    -- Sân bay Phù Cát
    ('UIH-D01', 'UIH', '01'),
    ('UIH-D02', 'UIH', '02'),
    ('UIH-D03', 'UIH', '03'),
    ('UIH-D04', 'UIH', '04'),
    ('UIH-D05', 'UIH', '05'),
    -- Sân bay Rạch Giá
    ('VKG-D01', 'VKG', '01'),
    ('VKG-D02', 'VKG', '02'),
    ('VKG-D03', 'VKG', '03'),
    ('VKG-D04', 'VKG', '04'),
    ('VKG-D05', 'VKG', '05'),
    -- Sân bay Dong Tac
    ('TBB-D01', 'TBB', '01'),
    ('TBB-D02', 'TBB', '02'),
    ('TBB-D03', 'TBB', '03'),
    ('TBB-D04', 'TBB', '04'),
    ('TBB-D05', 'TBB', '05'),
    -- Sân bay Vũng Tàu
    ('VTG-D01', 'VTG', '01'),
    ('VTG-D02', 'VTG', '02'),
    ('VTG-D03', 'VTG', '03'),
    ('VTG-D04', 'VTG', '04'),
    ('VTG-D05', 'VTG', '05'),
    -- Sân bay Tho Xuan
    ('THD-D01', 'THD', '01'),
    ('THD-D02', 'THD', '02'),
    ('THD-D03', 'THD', '03'),
    ('THD-D04', 'THD', '04'),
    ('THD-D05', 'THD', '05');

