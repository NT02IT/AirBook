USE master;
GO
DROP DATABASE AIRBOOK;

GO
CREATE DATABASE AIRBOOK;

GO
USE AIRBOOK;

-- Table structure for table action
GO
CREATE TABLE actions (
    Action_ID varchar(20) NOT NULL,
    Action_name nvarchar(50) NOT NULL,
	Info nvarchar(50),
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
	Allowed int NOT NULL,
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

-- Table structure for table more_luggage
GO
CREATE TABLE more_luggage (
    More_luggage_ID varchar(20) NOT NULL,
	Luggage_weight int NOT NULL,
	Price int NOT NULL
	PRIMARY KEY (More_luggage_ID),
);

-- Table structure for table airline
GO
CREATE TABLE airlines (
    Airline_ID varchar(20) NOT NULL,
	Airline_name nvarchar(50) NOT NULL,
	PRIMARY KEY (Airline_ID),
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
	Provine nvarchar(50) NOT NULL,
	PRIMARY KEY (Airport_ID),
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
	FOREIGN KEY (Flying_to) REFERENCES airports(Airport_ID),
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