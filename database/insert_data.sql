USE AIRBOOK -- Insert into users
GO
INSERT INTO
    users(User_ID, Role_ID, Username, Pwd, Real_name, DoB, Gender, Nation, User_address, Phone_number, CCCD, Email, Date_create, IsDelete)
VALUES
	('AC00000000', 'ROLE0', 'root', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'Root', '2023-10-05', N'Nam', N'Việt Nam', N'Việt Nam', '0327531105', '000000000000', 'root@airbook.com', '2023-10-05 10:00:00', 0),
	('AC00000001', 'ROLE1', 'mysV', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'Hà Quốc Vĩ', '2002-01-17', N'Nam', N'Việt Nam', N'Việt Nam', '0320410607', '17524729102', 'quocvi1701@gmail.com', '2023-10-05 10:00:00', 0),
	('AC00000002', 'ROLE1', 'lowtee', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'Nguyễn Anh Tuấn', '2002-11-19', N'Nam', N'Việt Nam', N'Việt Nam', '0327531105', '738291648291', 'lowtee.vn@gmail.vn', '2023-10-05 10:00:00', 0),
	('AC55351285', 'ROLE2', 'bossVN', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'GĐ VN', '1985-09-12', N'Nam', N'Việt Nam', N'Việt Nam', '0327531105', '762846592016', 'bossVN@airbook.com', '2023-10-05 10:00:00', 0),
	('AC25716701', 'ROLE3', 'maito', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'Lê Thái Vi', '2002-01-17', N'Nam', N'Việt Nam', N'Việt Nam', '0327531105', '762846592016', 'maito@gmail.com', '2023-10-05 10:00:00', 0),
	('AC26289183', 'ROLE3', 'khachhang', 'z/mGwlDDBsqBfqeAA/IIOwVgDMGd8B0/oq8Vi/uEiuw=', N'Khách hàng', '1985-09-12', N'Nam', N'Việt Nam', N'Việt Nam', '0327531105', '762846592016', 'bossVN@airbook.com', '2023-10-05 10:00:00', 0);    

-- Insert into receivers
GO
INSERT INTO
    receivers(Receiver_ID, Receiver_name, Gender, DoB, Receiver_address, Nation, Phone_number, CCCD, Email, User_ID, IsDelete )
VALUES
	('REC55351285', N'Hà Quốc Vĩ', N'Nam', '2002-01-17', N'Hiệp Bình Chánh, Thủ Đức', N'Việt Nam', '0320410607', '17524729102', 'quocvi1701@gmail.com', 'AC25716701', 0),
	('REC25716701', N'Nguyễn Anh Tuấn', N'Nam', '2002-11-19', N'Hiệp Bình Chánh, Thủ Đức', N'Việt Nam', '0320410607', '17524729102', 'lowtee@gmail.com', 'AC25716701', 0),
	('REC26289183', N'Lê Thái Vi', N'Nam', '2002-01-15', N'Quận 10', N'Việt Nam', '0320410607', '17524729102', 'maito@gmail.com', 'AC26289183', 0);

-- Insert into seats
GO
INSERT INTO
    seats(Seat_ID, Seat_name, Ticket_class_ID, IsDelete)
VALUES
    ('VN-01-A1', 'A1', 'VN-01-BC', 0),
    ('VN-01-A2', 'A2', 'VN-01-BC', 0),
    ('VN-01-B1', 'B1', 'VN-01-PEC', 0),
    ('VN-01-B2', 'B2', 'VN-01-PEC', 0),
    ('VN-01-C1', 'C1', 'VN-01-EC', 0),
    ('VJ-03-A1', 'A1', 'VJ-03-BC', 0),
    ('VJ-03-B1', 'B1', 'VJ-03-EC', 0);

-- Insert into flights
GO
INSERT INTO
    flights(Flight_ID, Flying_from, Flying_to, Hours_fly, Departure_flight, IsDelete )
VALUES
    ('VN1001', 'SGN', 'HAN', 2.15, '2023-9-30 09:00:00', 0 ),
    ('VN1002', 'SGN', 'DAD', 1.20, '2023-9-30 10:30:00', 0 ),
    ('VN1003', 'HAN', 'SGN', 2.15, '2023-9-30 09:30:00', 0 ),
    ('BL6001', 'HAN', 'SGN', 2.15, '2023-9-30 15:30:00', 0 ),
    ('VJ1001', 'HAN', 'SGN', 2.15, '2023-9-30 22:00:00', 0 ),
    ('QH1001', 'HAN', 'SGN', 2.15, '2023-9-30 23:00:00', 0 );

-- Insert into tickets
GO
INSERT INTO
    tickets(Ticket_ID, Flight_ID, Gate_ID, Seat_ID, Import_price, Selling_price, Sold_out, IsDelete )
VALUES
    ('TK0001', 'VN1001', 'SGN-D03', 'VN-01-A1', 1200000, 1500000, 0, 0 ),
    ('TK0002', 'VN1001', 'SGN-D03', 'VN-01-A2', 1200000, 1500000, 0, 0 ),
    ('TK0003', 'VJ1001', 'HAN-D03', 'VJ-03-A1', 900000, 1000000, 0, 0 );

-- Insert into promotions
GO
INSERT INTO
    promotions(Promo_ID, Promo_name, Promo_type, Decreased, Date_start, Date_end, Airline_ID, IsDelete )
VALUES
    ('VN-PR01', 'Summer Sale', 1, 10, '2023-06-01', '2023-08-31', 'VN', 0 ),
    ('VJ-PR02', 'Summer Sale', 2, 200000, '2023-06-01', '2023-08-31', 'VJ', 0 ),
    ('QH-PR03', 'Summer Sale', 1, 10, '2023-06-01', '2023-08-31', 'QH', 0 );

-- Insert into orders
GO
INSERT INTO
    orders(Order_ID, User_ID, Date_order)
VALUES
    ('OD0001', 'AC25716701', '2032-9-29'),
    ('OD0002', 'AC26289183', '2032-9-29');

-- Insert into order_details
GO
INSERT INTO
    order_details(Order_detail_ID, Order_ID, More_luggage_ID, Receiver_ID, Ticket_ID )
VALUES
    ('ODD0001', 'OD0001', 'MLG0001', 'REC55351285', 'TK0001' ),
    ('ODD0002', 'OD0001', 'MLG0001', 'REC55351285', 'TK0003' ),
    ('ODD0003', 'OD0002', 'MLG0002', 'REC25716701', 'TK0002' );