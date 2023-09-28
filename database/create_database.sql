CREATE DATABASE AIRBOOK;

GO
    USE AIRBOOK;

-- Table structure for table airline
CREATE TABLE airline (
    Airline_ID nvarchar(20) NOT NULL,
    Airline_name nvarchar(50) NOT NULL,
    PRIMARY KEY (Airline_ID)
);

-- Table structure for table airport
CREATE TABLE airport (
    Airport_ID nvarchar(20) NOT NULL,
    Airport_name nvarchar(50) NOT NULL,
    Province nvarchar(40) NOT NULL,
    PRIMARY KEY (Airport_ID)
);

-- Table structure for table airport_gates
CREATE TABLE airport_gates (
    Airport_gate_ID nvarchar(20) NOT NULL,
    Airport_ID nvarchar(20) NOT NULL,
    Gate nvarchar(4) NOT NULL,
    PRIMARY KEY (Airport_gate_ID),
    FOREIGN KEY (Airport_ID) REFERENCES airport (Airport_ID)
);

-- Table structure for table flight
CREATE TABLE flight (
    Flight_ID nvarchar(20) NOT NULL,
    Flight_from nvarchar(20) NOT NULL,
    Flight_to nvarchar(20) NOT NULL,
    Hours_fly int NOT NULL,
    Datetime_begin datetime NOT NULL,
    PRIMARY KEY (Flight_ID),
    FOREIGN KEY (Flight_from) REFERENCES airport (Airport_ID),
    FOREIGN KEY (Flight_to) REFERENCES airport (Airport_ID)
);

-- Table structure for table more_luggage
CREATE TABLE more_luggage (
    More_luggage_ID nvarchar(20) NOT NULL,
    Luggage_weight int NOT NULL,
    Luggage_price int NOT NULL,
    PRIMARY KEY (More_luggage_ID)
);

CREATE TABLE user_type(
    User_type_ID nvarchar(20) NOT NULL,
    User_type_name nvarchar(20) NOT NULL,
    PRIMARY KEY (User_type_ID)
);

-- Table structure for table user
CREATE TABLE users (
    User_ID nvarchar(20) NOT NULL,
    User_type_ID nvarchar(20) NOT NULL,
    Username nvarchar(50) NOT NULL,
    Real_name nvarchar(50) NOT NULL,
    User_DoB datetime NOT NULL,
    User_nationality nvarchar(40) NOT NULL,
    User_address nvarchar(100),
    CCCD varchar(20) NOT NULL,
    Pwd varchar(20) NOT NULL,
    PhoneNumber nvarchar(20) NOT NULL,
    Email nvarchar(50) NOT NULL,
    PRIMARY KEY (User_ID),
    FOREIGN KEY (User_type_ID) REFERENCES user_type (User_type_ID)
);

-- Table structure for table order_table
CREATE TABLE orders (
    Order_ID nvarchar(20) NOT NULL,
    User_ID nvarchar(20) NOT NULL,
    Promotion_ID nvarchar(20) NOT NULL,
    Order_day datetime NOT NULL,
    Ticket_ID nvarchar(20) NOT NULL,
    Receiver_ID nvarchar(20) NOT NULL,
    PRIMARY KEY (Order_ID),
    FOREIGN KEY (User_ID) REFERENCES users (User_ID),
    FOREIGN KEY (Promotion_ID) REFERENCES promotion (Promotion_ID),
    FOREIGN KEY (Ticket_ID) REFERENCES ticket (Ticket_ID),
    FOREIGN KEY (Receiver_ID) REFERENCES receiver (Receiver_ID)
);

-- Table structure for table order_details
CREATE TABLE order_details (
    Order_detail_ID nvarchar(20) NOT NULL,
    More_luggage_ID nvarchar(20) NOT NULL,
    Order_ID nvarchar(20) NOT NULL,
    Ticket_class_ID nvarchar(20) NOT NULL,
    PRIMARY KEY (Order_detail_ID),
    FOREIGN KEY (More_luggage_ID) REFERENCES more_luggage (More_luggage_ID),
    FOREIGN KEY (Order_ID) REFERENCES orders (Order_ID),
    FOREIGN KEY (Ticket_class_ID) REFERENCES ticket_class (Ticket_class_ID)
);

-- Table structure for table plane
CREATE TABLE plane (
    Plane_ID nvarchar(20) NOT NULL,
    Airline_ID nvarchar(20) NOT NULL,
    Aircraft_type nvarchar(30) NOT NULL,
    Plane_seats int NOT NULL,
    PRIMARY KEY (Plane_ID),
    FOREIGN KEY (Airline_ID) REFERENCES airline (Airline_ID)
);

-- Table structure for table promotion
CREATE TABLE promotion (
    Promotion_ID nvarchar(20) NOT NULL,
    Promotion_name nvarchar(100) NOT NULL,
    Promotion_type nvarchar(30) NOT NULL,
    Decreased int NOT NULL,
    Date_start datetime NOT NULL,
    Date_end datetime NOT NULL,
    Airline_ID nvarchar(20) NOT NULL,
    PRIMARY KEY (Promotion_ID),
    FOREIGN KEY (Airline_ID) REFERENCES airline(Airline_ID)
);

-- Table structure for table receiver
CREATE TABLE receiver (
    Receiver_ID nvarchar(20) NOT NULL,
    Receiver_name nvarchar(50) NOT NULL,
    Receiver_gender nvarchar(5) NOT NULL,
    Receiver_phone nvarchar(20) NOT NULL,
    Receiver_address nvarchar(100),
    Receiver_DoB datetime NOT NULL,
    Receiver_CCCD nvarchar(20) NOT NULL,
    Receiver_email nvarchar(30),
    PRIMARY KEY (Receiver_ID)
);

CREATE TABLE seats(
    Seat_ID nvarchar(20) NOT NULL,
    Plane_ID nvarchar(20) NOT NULL,
    Ticket_class_ID nvarchar(20) NOT NULL,
    PRIMARY KEY (Seat_ID),
    FOREIGN KEY (Plane_ID) REFERENCES plane (Plane_ID),
    FOREIGN KEY (Ticket_class_ID) REFERENCES ticket_class (Ticket_class_ID)
);

-- Table structure for table ticket
CREATE TABLE ticket (
    Ticket_ID nvarchar(20) NOT NULL,
    Flight_ID nvarchar(20) NOT NULL,
    Airport_gate_ID nvarchar(20) NOT NULL,
    Ticket_price int NOT NULL,
    Plane_ID nvarchar(20) NOT NULL,
    Seat_ID nvarchar(20) NOT NULL,
    Sold_out int NOT NULL,
    PRIMARY KEY (Ticket_ID),
    FOREIGN KEY (Flight_ID) REFERENCES flight (Flight_ID),
    FOREIGN KEY (Plane_ID) REFERENCES plane (Plane_ID),
    FOREIGN KEY (Seat_ID) REFERENCES seats(Seat_ID)
);

-- Table structure for table ticket_details
CREATE TABLE ticket_class (
    Ticket_class_ID nvarchar(20) NOT NULL,
    Ticket_class_name nvarchar(20) NOT NULL,
    Maximum_seats int NOT NULL,
    PRIMARY KEY (Ticket_class_ID)
);