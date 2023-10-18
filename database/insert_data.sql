USE AIRBOOK

-- Insert into users
GO
INSERT INTO
    users(User_ID, Role_ID, Username, Pwd, Real_name, DoB, Gender, Nation, User_address, Phone_number, CCCD, Email, Date_create)
VALUES
	('AC00000000', 'ROLE0', 'root', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'Root', '2023-10-05', 'Nam', 'Việt Nam', 'Việt Nam', '0327531105', '000000000000', 'root@airbook.com', '2023-10-05 10:00:00'),
	('AC00000001', 'ROLE1', 'mysV', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'Hà Quốc Vĩ', '2002-01-17', 'Nam', 'Việt Nam', 'Việt Nam', '0320410607', '17524729102', 'quocvi1701@gmail.com', '2023-10-05 10:00:00'),
	('AC00000002', 'ROLE1', 'lowtee', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'Nguyễn Anh Tuấn', '2002-11-19', 'Nam', 'Việt Nam', 'Việt Nam', '0327531105', '738291648291', 'lowtee.vn@gmail.vn', '2023-10-05 10:00:00'),
	('AC55351285', 'ROLE2', 'bossVN', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'GĐ VN', '1985-09-12', 'Nam', 'Việt Nam', 'Việt Nam', '0327531105', '762846592016', 'bossVN@airbook.com', '2023-10-05 10:00:00'),
	('AC25716701', 'ROLE3', 'maito', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'Lê Thái Vi', '2002-01-17', 'Nam', 'Việt Nam', 'Việt Nam', '0327531105', '762846592016', 'maito@gmail.com', '2023-10-05 10:00:00'),
	('AC26289183', 'ROLE3', 'khachhang', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', 'Khách hàng', '1985-09-12', 'Nam', 'Việt Nam', 'Việt Nam', '0327531105', '762846592016', 'bossVN@airbook.com', '2023-10-05 10:00:00');    

-- Insert into receivers
GO
INSERT INTO
    receivers(Receiver_ID, Receiver_name, Gender, DoB, Receiver_address, Nation, Phone_number, CCCD, Email, User_ID)
VALUES
	('REC55351285', 'Hà Quốc Vĩ', 'Nam', '2002-01-17', 'Hiệp Bình Chánh, Thủ Đức', 'Việt Nam', '0320410607', '17524729102', 'quocvi1701@gmail.com', 'AC0100'),
	('REC25716701', 'Nguyễn Anh Tuấn', 'Nam', '2002-11-19', 'Hiệp Bình Chánh, Thủ Đức', 'Việt Nam', '0320410607', '17524729102', 'lowtee@gmail.com', 'AC0101'),
	('REC26289183', 'Lê Thái Vi', 'Nam', '2002-01-15', 'Quận 10', 'Việt Nam', '0320410607', '17524729102', 'maito@gmail.com', 'AC0100');

-- Insert into seats
GO
INSERT INTO
    seats(Seat_ID, Seat_name, Ticket_class_ID)
VALUES
    ('VN-01-A1', 'A1', 'VN-01-BC'),
    ('VN-01-A2', 'A2', 'VN-01-BC'),
    ('VN-01-B1', 'B1', 'VN-01-PEC'),
    ('VN-01-B2', 'B2', 'VN-01-PEC'),
    ('VN-01-C1', 'C1', 'VN-01-EC'),
    ('VJ-03-A1', 'A1', 'VJ-03-BC'),
    ('VJ-03-B1', 'B1', 'VJ-03-EC');

-- Insert into flights
GO
INSERT INTO
    flights(Flight_ID, Flying_from, Flying_to, Hours_fly, Departure_flight)
VALUES
    ('VN1001', 'SGN', 'HAN', 2.15, '2023-9-30 09:00:00'),
    ('VN1002', 'SGN', 'DAD', 1.20, '2023-9-30 10:30:00'),
    ('VN1003', 'HAN', 'SGN', 2.15, '2023-9-30 09:30:00'),
    ('BL6001', 'HAN', 'SGN', 2.15, '2023-9-30 15:30:00'),
    ('VJ1001', 'HAN', 'SGN', 2.15, '2023-9-30 22:00:00'),
    ('QH1001', 'HAN', 'SGN', 2.15, '2023-9-30 23:00:00');

-- Insert into tickets
GO
INSERT INTO
    tickets(Ticket_ID, Flight_ID, Gate_ID, Price, Seat_ID, Sold_out)
VALUES
    ('TK0001', 'VN1001', 'SGN-D03', 1200000, 'VN-01-A1', 0),
    ('TK0002', 'VN1001', 'SGN-D03', 1200000, 'VN-01-A2', 0),
    ('TK0003', 'VJ1001', 'HAN-D03', 900000, 'VJ-03-A1', 0);

-- Insert into promotions
GO
INSERT INTO
    promotions(Promo_ID, Promo_name, Promo_type, Decreased, Date_start, Date_end, Airline_ID)
VALUES
    ('VN-PR01', 'Summer Sale', 1, 10, '2023-06-01', '2023-08-31', 'VN'),
    ('VJ-PR02', 'Summer Sale', 2, 200000, '2023-06-01', '2023-08-31', 'VJ'),
    ('QH-PR03', 'Summer Sale', 1, 10, '2023-06-01', '2023-08-31', 'QH');

-- Insert into orders
GO
INSERT INTO
    orders(Order_ID, User_ID, Date_order)
VALUES
    ('OD0001', 'AC25716701', '2032-9-29'),
    ('OD0002', 'AC26289183', '2032-9-29');
GO
INSERT INTO
    orders(Order_ID, User_ID, Promo_ID, Date_order)
VALUES
    ('OD0003', 'AC26289183', 'VN-PR01', '2032-9-30'),
    ('OD0004', 'AC25716701', 'VJ-PR02', '2032-9-30');

-- Insert into order_details
GO
INSERT INTO
    order_details(Order_detail_ID, Order_ID, More_luggage_ID, Receiver_ID, Ticket_ID)
VALUES
    ('ODD0001', 'OD0001', 'MLG0001', 'REC55351285', 'TK0001'),
	('ODD0002', 'OD0001', 'MLG0001', 'REC55351285', 'TK0003'),
    ('ODD0003', 'OD0002', 'MLG0002', 'REC25716701', 'TK0002');