USE AIRBOOK -- Init Database
INSERT INTO
    airline(Airline_ID, Airline_name)
VALUES
    ('QH', 'Bamboo Airways'),
    ('BL', 'Pacific Airlines'),
    ('VJ', 'VietJet Air'),
    ('VN', 'Vietname Airlines'),
    ('VU', 'Vietravel Airlines');

-- Airport
INSERT INTO
    airport(Airport_ID, Airport_name, Province)
VALUES
    (
        'VCA',
        'Can Tho International Airport',
        'Cần Thơ'
    ),
    (
        'DAD',
        'Da Nang International Airport',
        'Đà Nẵng'
    ),
    (
        'HPH',
        'Cai Bi International Airport',
        'Hải Phòng'
    ),
    ('HAN', 'Noi Bai International Airport', 'Hà Nội'),
    (
        'SGN',
        'Tan Son Nhat International Airport',
        'Hồ Chí Minh'
    ),
    ('HUI', 'Phu Bai International Airport', 'Huế'),
    (
        'CXR',
        'Cam Ranh International Airport',
        'Khánh Hòa'
    ),
    (
        'PQC',
        'Phu Quoc International Airport',
        'Kiên Giang'
    ),
    (
        'VDO',
        'Van Don International Airport',
        'Quảng Ninh'
    ),
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

-- Airport_gates
INSERT INTO
    airport_gates(Airport_gate_ID, Airport_ID, Gate)
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
    ('DAD-D01', 'DAD', 01),
    ('DAD-D02', 'DAD', 02),
    ('DAD-D03', 'DAD', 03),
    ('DAD-D04', 'DAD', 04),
    ('DAD-D05', 'DAD', 05),
    ('DAD-D06', 'DAD', 06),
    ('DAD-D07', 'DAD', 07),
    -- Sân Bay Cai Bi
    ('HPH-D01', 'HPH', 01),
    ('HPH-D02', 'HPH', 02),
    ('HPH-D03', 'HPH', 03),
    ('HPH-D04', 'HPH', 04),
    ('HPH-D05', 'HPH', 05),
    ('HPH-D06', 'HPH', 06),
    ('HPH-D07', 'HPH', 07),
    -- Sân Bay Nội Bài
    ('HAN-D01', 'HAN', 01),
    ('HAN-D02', 'HAN', 02),
    ('HAN-D03', 'HAN', 03),
    ('HAN-D04', 'HAN', 04),
    ('HAN-D05', 'HAN', 05),
    ('HAN-D06', 'HAN', 06),
    ('HAN-D07', 'HAN', 07),
    ('HAN-D08', 'HAN', 08),
    ('HAN-D09', 'HAN', 09),
    ('HAN-D10', 'HAN', 10),
    -- Sân Bay Phú Bài
    ('HUI-D01', 'HUI', 01),
    ('HUI-D02', 'HUI', 02),
    ('HUI-D03', 'HUI', 03),
    ('HUI-D04', 'HUI', 04),
    ('HUI-D05', 'HUI', 05),
    ('HUI-D06', 'HUI', 06),
    ('HUI-D07', 'HUI', 07),
    ('HUI-D08', 'HUI', 08),
    -- Sân bay Cam Ranh
    ('CXR-D01', 'CXR', 01),
    ('CXR-D02', 'CXR', 02),
    ('CXR-D03', 'CXR', 03),
    ('CXR-D04', 'CXR', 04),
    ('CXR-D05', 'CXR', 05),
    ('CXR-D06', 'CXR', 06),
    ('CXR-D07', 'CXR', 07),
    ('CXR-D08', 'CXR', 08),
    -- Sân bay Phú Quốc
    ('PQC-D01', 'PQC', 01),
    ('PQC-D02', 'PQC', 02),
    ('PQC-D03', 'PQC', 03),
    ('PQC-D04', 'PQC', 04),
    ('PQC-D05', 'PQC', 05),
    ('PQC-D06', 'PQC', 06),
    ('PQC-D07', 'PQC', 07),
    ('PQC-D08', 'PQC', 08),
    -- Sân bay Vân Đồn
    ('VDO-D01', 'VDO', 01),
    ('VDO-D02', 'VDO', 02),
    ('VDO-D03', 'VDO', 03),
    ('VDO-D04', 'VDO', 04),
    ('VDO-D05', 'VDO', 05),
    ('VDO-D06', 'VDO', 06),
    ('VDO-D07', 'VDO', 07),
    ('VDO-D08', 'VDO', 08),
    -- Sân bay Vinh
    ('VII-D01', 'VII', 01),
    ('VII-D02', 'VII', 02),
    ('VII-D03', 'VII', 03),
    ('VII-D04', 'VII', 04),
    ('VII-D05', 'VII', 05),
    ('VII-D06', 'VII', 06),
    ('VII-D07', 'VII', 07),
    ('VII-D08', 'VII', 08),
    -- Sân bay Buôn Ma Thuột
    ('BMV-D01', 'BMV', 01),
    ('BMV-D02', 'BMV', 02),
    ('BMV-D03', 'BMV', 03),
    ('BMV-D04', 'BMV', 04),
    ('BMV-D05', 'BMV', 05),
    -- Sân bay Cà Mau
    ('CAH-D01', 'CAH', 01),
    ('CAH-D02', 'CAH', 02),
    ('CAH-D03', 'CAH', 03),
    ('CAH-D04', 'CAH', 04),
    ('CAH-D05', 'CAH', 05),
    -- Sân bay Chu Lai
    ('VCS-D01', 'VCS', 01),
    ('VCS-D02', 'VCS', 02),
    ('VCS-D03', 'VCS', 03),
    ('VCS-D04', 'VCS', 04),
    ('VCS-D05', 'VCS', 05),
    -- Sân bay Co Ong
    ('VCL-D01', 'VCL', 01),
    ('VCL-D02', 'VCL', 02),
    ('VCL-D03', 'VCL', 03),
    ('VCL-D04', 'VCL', 04),
    ('VCL-D05', 'VCL', 05),
    -- Sân bay Liên Khương
    ('DLI-D01', 'DLI', 01),
    ('DLI-D02', 'DLI', 02),
    ('DLI-D03', 'DLI', 03),
    ('DLI-D04', 'DLI', 04),
    ('DLI-D05', 'DLI', 05),
    -- Sân bay Điện Biên
    ('DIN-D01', 'DIN', 01),
    ('DIN-D02', 'DIN', 02),
    ('DIN-D03', 'DIN', 03),
    ('DIN-D04', 'DIN', 04),
    ('DIN-D05', 'DIN', 05),
    -- Sân bay Đồng Hới
    ('VDH-D01', 'VDH', 01),
    ('VDH-D02', 'VDH', 02),
    ('VDH-D03', 'VDH', 03),
    ('VDH-D04', 'VDH', 04),
    ('VDH-D05', 'VDH', 05),
    -- Sân bay Pleiku
    ('PXU-D01', 'PXU', 01),
    ('PXU-D02', 'PXU', 02),
    ('PXU-D03', 'PXU', 03),
    ('PXU-D04', 'PXU', 04),
    ('PXU-D05', 'PXU', 05),
    -- Sân bay Phù Cát
    ('UIH-D01', 'UIH', 01),
    ('UIH-D02', 'UIH', 02),
    ('UIH-D03', 'UIH', 03),
    ('UIH-D04', 'UIH', 04),
    ('UIH-D05', 'UIH', 05),
    -- Sân bay Rạch Giá
    ('VKG-D01', 'VKG', 01),
    ('VKG-D02', 'VKG', 02),
    ('VKG-D03', 'VKG', 03),
    ('VKG-D04', 'VKG', 04),
    ('VKG-D05', 'VKG', 05),
    -- Sân bay Dong Tac
    ('TBB-D01', 'TBB', 01),
    ('TBB-D02', 'TBB', 02),
    ('TBB-D03', 'TBB', 03),
    ('TBB-D04', 'TBB', 04),
    ('TBB-D05', 'TBB', 05),
    -- Sân bay Vũng Tàu
    ('VTG-D01', 'VTG', 01),
    ('VTG-D02', 'VTG', 02),
    ('VTG-D03', 'VTG', 03),
    ('VTG-D04', 'VTG', 04),
    ('VTG-D05', 'VTG', 05),
    -- Sân bay Tho Xuan
    ('THD-D01', 'THD', 01),
    ('THD-D02', 'THD', 02),
    ('THD-D03', 'THD', 03),
    ('THD-D04', 'THD', 04),
    ('THD-D05', 'THD', 05);

-- Flight
INSERT INTO
    flight(
        Flight_ID,
        Flight_from,
        Flight_to,
        Hours_fly,
        Datetime_begin
    )
VALUES
    (
        "VN1001",
        "SGN",
        "HAN",
        2.15,
        "2023-30-9 09:00:00"
    ),
    (
        "VN1002",
        "SGN",
        "DAD",
        1.20,
        "2023-30-9 10:30:00"
    ),
    (
        "VN1003",
        "HAN",
        "SGN",
        2.15,
        "2023-30-9 90:30:00"
    ),
    (
        "BL6001",
        "HAN",
        "SGN",
        2.15,
        "2023-30-9 15:30:00"
    ),
    (
        "VJ1001",
        "HAN",
        "SGN",
        2.15,
        "2023-30-9 22:00:00"
    ),
    (
        "QH1001",
        "HAN",
        "SGN",
        2.15,
        "2023-30-9 23:00:00"
    );

-- More luggage
INSERT INTO
    more_luggage (
        More_luggage_ID,
        Luggage_weight,
        Luggage_price,
        Airline_ID
    )
VALUES
    ("MLG0001", 5, 382000, "VN"),
    ("MLG0002", 10, 600000, "VN"),
    ("MLG0003", 23, 1200000, "VN"),
    ("MLG0004", 5, 180000, "VJ"),
    ("MLG0005", 10, 300000, "VJ"),
    ("MLG0006", 20, 600000, "VJ"),
    ("MLG0007", 5, 382000, "QH"),
    ("MLG0008", 10, 600000, "QH"),
    ("MLG0009", 23, 1200000, "QH"),
    ("MLG00010", 5, 382000, "BL"),
    ("MLG00011", 10, 382000, "BL"),
    ("MLG00012", 23, 382000, "BL"),
    ("MLG00013", 5, 180000, "VU"),
    ("MLG00014", 10, 300000, "VU"),
    ("MLG00015", 20, 600000, "VU");

-- User type
INSERT INTO
    user_type (User_type_ID, User_type_name)
VALUES
    ("ACT01", "Root"),
    ("ACT02", "Manage"),
    ("ACT03", "Employee"),
    ("ACT04", "User");

-- Users
INSERT INTO
    users(
        User_ID,
        User_type_ID,
        Username,
        Real_name,
        User_DoB,
        User_address,
        User_nationality,
        CCCD,
        Pwd,
        Email,
        PhoneNumber
    )
VALUES
    (
        'AC0001',
        'ACT01',
        'MysV',
        'Hà Quốc Vĩ',
        '2002-01-17',
        '',
        'Vietnam',
        '3120410607',
        '1701',
        0320410607,
        'quocvi1701@gmail.com'
    ),
    (
        'AC1001',
        'ACT02',
        'Maito',
        'Lê Thái Vi',
        '2002-01-17',
        '',
        'Vietnam',
        '3120410606',
        '1701',
        0320410607,
        'quocvi1701@gmail.com'
    ),
    (
        'AC4001',
        'ACT04',
        'TuanCui',
        'Nguyễn Anh Tuấn',
        '2002-01-17',
        '',
        'Vietnam',
        '3120410605',
        '1701',
        0320410607,
        'quocvi1701@gmail.com'
    );

INSERT INTO
    orders(
        Order_ID,
        User_ID,
        Promotion_ID,
        Order_day,
        Ticket_ID,
        Receiver_ID
    )
VALUES
    (
        'OD0001',
        'AC4001',
        '',
        '2032-9-29',
        'TK0001',
        'RC0001'
    ),
    (
        'OD0002',
        'AC4001',
        '',
        '2032-9-29',
        'TK0002',
        'RC0002'
    );

INSERT INTO
    order_details(
        Order_detail_ID,
        More_luggage_ID,
        Order_ID,
        Ticket_class_ID
    )
VALUES
    ("ODD0001", "", "OD0001", "VN-01-BC"),
    ("ODD0002", "", "OD0002", "VN-01-BC");

-- Plane
INSERT INTO
    plane(
        Plane_ID,
        Airline_ID,
        Aircraft_type,
        Plane_seats,
        Plane_desc
    )
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
    (
        'VN-QH-01',
        'QH',
        'BOEING 787-9 Dreamliner',
        294,
        ''
    ),
    (
        'VN-QH-02',
        'QH',
        'AIRBUS A312NEO',
        223,
        ''
    ),
    (
        'VN-QH-03',
        'QH',
        'AIRBUS A312CEO',
        192,
        ''
    ),
    (
        'VN-QH-04',
        'QH',
        'AIRBUS A320CEO',
        170,
        ''
    ),
    (
        'VN-QH-05',
        'QH',
        'AIRBUS A320NEO',
        176,
        ''
    ),
    ('VN-QH-06', 'EMBRAER 190', 98, ''),
    -- Pacific Airlines
    ('VN-BL-01', 'AIRBUS A320-200', 146, ''),
    ('VN-BL-02', 'AIRBUS A320-240', 204, ''),
    -- VU
    ('VN-VU-01', "AIRBUS A321-211", 236, ""),
    ('VN-VU-02', "AIRBUS A321-211", 236, ""),
    ('VN-VU-03', "AIRBUS A321-211", 236, ""),
    ('VN-VU-04', "AIRBUS A319-100", 160, "");

-- Promotion
INSERT INTO
    promotion(
        Promotion_ID,
        Promotion_name,
        Promotion_type,
        Decreased,
        Date_start,
        Date_end,
        Airline_ID
    )
VALUES
    (
        'VN-PT01',
        'Summer Sale',
        'percent',
        10,
        '2023-06-01',
        '2023-08-31',
        "VN"
    ),
    (
        'VJ-PT01',
        'Summer Sale',
        'money',
        200000,
        '2023-06-01',
        '2023-08-31',
        "VJ"
    ),
    (
        'QH-PT01',
        'Summer Sale',
        'percent',
        10,
        '2023-06-01',
        '2023-08-31',
        "QH"
    );

-- Receiver
INSERT INTO
    receiver (
        Receiver_ID,
        Receiver_name,
        Receiver_gender,
        Receiver_nationality,
        Receiver_phone,
        Receiver_address,
        Receiver_DoB,
        Receiver_CCCD,
        Receiver_email
    )
VALUES
    (
        'REC0001',
        'Hà Quốc Vĩ',
        'Male',
        'Vietnam',
        0320410607,
        '',
        '2002-01-17',
        '3120410607',
        'quocvi1701@gmail.com'
    ) (
        'REC0002',
        'Nguyễn Anh Tuấn',
        'Female',
        'Vietnam',
        0320410607,
        '',
        '2002-01-17',
        '3120410607',
        'quocvi1701@gmail.com'
    ),
    (
        'REC0003',
        'Hà Quốc Vĩ',
        'Male',
        'Vietnam',
        0320410607,
        '',
        '2002-01-17',
        '3120410607',
        'quocvi1701@gmail.com'
    );

INSERT INTO
    seats(Seat_ID, Plane_ID, Ticket_class_ID)
VALUES
    ("VN-01-A1", "VN-VN-01", "VN-01-BC"),
    ("VN-01-A2", "VN-VN-01", "VN-01-BC"),
    ("VN-01-B1", "VN-VN-01", "VN-01-PEC"),
    ("VN-01-B2", "VN-VN-01", "VN-01-PEC"),
    ("VN-01-C1", "VN-VN-01", "VN-01-EC"),
    ("VJ-03-A1", "VN-VJ-03", "VJ-03-BC"),
    ("VJ-03-B1", "VN-VJ-03", "VJ-03-EC");

INSERT INTO
    ticket(
        Ticket_ID,
        Flight_ID,
        Airport_gate_ID,
        Ticket_price,
        Plane_ID,
        Seat_ID,
        Sold_out
    )
VALUES
    (
        'TK0001',
        'VN1001',
        'SGN-D03',
        1200000,
        'VN-VN-01',
        'VN-01-A1'
    ),
    (
        'TK0002',
        'VN1001',
        'SGN-D03',
        1200000,
        'VN-VN-01',
        'VN-01-A2'
    ),
    (
        'TK0003',
        'VJ1001',
        'HAN-D03',
        900000,
        'VN-VJ-03',
        'VJ-03-A1',
        0
    );

INSERT INTO
    ticket_class (
        Ticket_class_ID,
        Ticket_class_name,
        Maximum_seats,
        Plane_ID
    )
VALUES
    -- VN
    ('VN-01-BC', 'Business Class', 28, 'VN-VN-01'),
    (
        'VN-01-PEC',
        'Premium Economy Class',
        35,
        'VN-VN-01'
    ),
    ('VN-01-EC', 'Economy Class', 211, 'VN-VN-01'),
    ('VN-02-BC', 'Business Class', 18, 'VN-VN-02'),
    ('VN-02-EC', 'Economy Class', 251, 'VN-VN-02'),
    ('VN-03-BC', 'Business Class', 29, 'VN-VN-03'),
    (
        'VN-03-PEC',
        'Premium Economy Class',
        45,
        'VN-VN-03'
    ),
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