/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lucas
 * Created: 09/06/2020
 */

CREATE TABLE ADMINUSERS (
    Username varchar(50) NOT NULL PRIMARY KEY,
    Password varchar (50)
);

CREATE TABLE CUSTOMERS (
    CusEmail varchar(50) NOT NULL PRIMARY KEY,
    CusName varchar (50),
    CusPassword varchar (20),
    CusPhone varchar (13),
    CusType varchar (10)
);

CREATE TABLE "PRODUCTS"
(    
   "PRODUCT_ID" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "NAME" VARCHAR(50),     
   "DETAIL" VARCHAR(100),
   "TYPE" VARCHAR(50),
   "PRICE" DOUBLE,  
   "QUANTITY" INTEGER   
);

CREATE TABLE STAFF (
    StaffEmail varchar(50) NOT NULL PRIMARY KEY,
    StaffName varchar (50),
    StaffPassword varchar (20),
    StaffPhone varchar (13),
    StaffPos varchar (50)
);

CREATE TABLE TIMELOG (
    LoginTime varchar (50) NOT NULL PRIMARY KEY,
    UserEmail varchar(50)
);

INSERT INTO ADMINUSERS (USERNAME, PASSWORD)
VALUES
('admin', 'admin');

INSERT INTO PRODUCTS (NAME, DETAIL, TYPE, PRICE, QUANTITY)
VALUES
('BMP180 Barometer', 'Reads air pressure, temperature and altitude', 'Temperature sensor', 5.0, 10),
('Moisture Sensor', 'Analogue humidity sensor', 'Temperature sensor', 4.5, 10),
('PIR Motion Sensor', 'Senses movement', 'Motion Sensor', 2.0, 10),
('HC-SR04 ultrasonic sensor', 'Ultrasonic sensor', 'Motion Sensor', 3.0, 10),
('GPS NEO-6M Module', 'GPS Receiver', 'Navigation Module', 10.0, 10),
('MPU-6050 Gyroscope', 'Detects rotation on the three axes', 'Navigation Module', 3.5, 10),
('HMC5883L/GY-271 Compass', 'Digital compass', 'Navigation Module', 4.5, 10),
('433 MHz Set', 'Radio transmitter and receiver', 'Raspberry Pi Sensor', 2.0, 10),
('Radio controlled outlet', 'Wireless sockets', 'Raspberry Pi Sensor', 10.0, 10),
('Bluetooth Adapter', 'USB Bluetooth adapter', 'Raspberry Pi Sensor', 7.0, 10),
('Servo Motor', 'Individually controlled motor', 'Motor', 2.0, 10),
('MCP3008 Analog-to-digital converter', 'Required for analog module on Raspberry Pi', 'Analogous Raspberry Pi Sensor', 5.0, 10),
('Joystick', '2-axis joystick', 'Analogous Raspberry Pi Sensor', 4.0, 10),
('Potentiometer', 'Rotatable resistor', 'Analogous Raspberry Pi Sensor', 3.0, 10),
('Raindrop Sensor', 'Rainwater sensor determines whether it is raining', 'Analogous Raspberry Pi Sensor', 2.0, 10),
('Official 7inch Touchscreen', 'Raspberry Pi official touch screen display', 'Display', 65.0, 1),
('3.2inch Touchscreen', 'Raspberry Pi small touch screen display', 'Display', 10.0, 10),
('HD44780 Display', 'Pure character display', 'Display', 4.5, 10),
('Water Flowmeter', 'Measures rate of water flowing through tube', 'Raspberry Pi Sensor', 10.0, 10),
('Optical Fingerprint Sensor', 'Reads fingerprints', 'Raspberry Pi Sensor', 30.0, 10);

INSERT INTO CUSTOMERS (CUSEMAIL, CUSNAME, CUSPASSWORD, CUSPHONE, CUSTYPE)
VALUES
('john.smith@test.com', 'John Smith', 'test1', '0123456789', 'individual'),
('jack.king@test.com', 'Jack King', 'test2', '0568744698', 'company'),
('george.ahn@test.com', 'George Ahn', 'test3', '0123457789', 'individual'),
('helen.li@test.com', 'Helen Li', 'test4', '1123458832', 'individual'),
('amos.kim@test.com', 'Amos Kim', 'test5', '2226556789', 'individual'),
('rex.ars@test.com', 'John Smith', 'test6', '4123456789', 'company'),
('bobby.jones@test.com', 'Bobby Jones', 'test7', '3223456789', 'individual'),
('mark.fritz@test.com', 'Mark Fritz', 'test8', '4133456789', 'individual'),
('karen.rodriguez@test.com', 'Karen Rodriguez', 'test9', '6163456789', 'individual'),
('wayne.rodriguez@test.com', 'Wayne Rodriguez', 'test10', '3323456789', 'individual'),
('cynthia.smith@test.com', 'Cynthia Smith', 'test11', '8823456789', 'company'),
('jay.newcomb@test.com', 'Jay Newcomb', 'test12', '9923456789', 'individual'),
('dora.moore@test.com', 'Dora Moore', 'test13', '0129956789', 'individual'),
('deborah.baker@test.com', 'Deborah Baker', 'test14', '0123666789', 'company'),
('susan.adkins@test.com', 'Susan Adkins', 'test15', '0123336789', 'individual'),
('joseph.schaffer@test.com', 'Joseph Schaffer', 'test16', '0423456799', 'individual'),
('james.ford@test.com', 'James Ford', 'test17', '0123423789', 'individual'),
('monica.bates@test.com', 'Monica Bates', 'test18', '0123444789', 'company'),
('mitchel.devito@test.com', 'Mitchel Devito', 'test19', '0100456789', 'individual'),
('bobby.vanhook@test.com', 'Bobby Vanhook', 'test20', '0122356789', 'company');

INSERT INTO STAFF (STAFFEMAIL, STAFFNAME, STAFFPASSWORD, STAFFPHONE, STAFFPOS)
VALUES
('test@iotbay.com', 'Mary Jane', 'test1', '0123456789', 'product manager'),
('chelsea.glasper@test.com', 'chelsea glasper', 'test2', '0568744338', 'sales associate'),
('georgia.brooks@test.com', 'Georgia Brooks', 'test3', '0192834589', 'customer service representative'),
('samuel.haguland@test.com', 'Samuel Hagland', 'test4', '1123456632', 'store manager'),
('russel.ramos@test.com', 'Russel Ramos', 'test5', '2226588789', 'sales associate'),
('jimmy.beats@test.com', 'Jimmy Beats', 'test6', '4123446789', 'sales associate'),
('greg.jones@test.com', 'Greg Jones', 'test7', '3223776789', 'sales associate'),
('mark.mcree@test.com', 'Mark Mcree', 'test8', '4133456789', 'customer service representative'),
('daniel.higgins@test.com', 'Daniel Higgens', 'test9', '6613456789', 'customer service representative'),
('bruce.anderson@test.com', 'Bruce Anderson', 'test10', '3323456789', 'product inspector'),
('guy.briggs@test.com', 'Guy Briggs', 'test11', '8823456789', 'product inspector'),
('phillip.mcgee@test.com', 'Phillip Mcgee', 'test12', '9923456789', 'sales associate'),
('martin.howell@test.com', 'Martin Howell', 'test13', '0129966789', 'delivery driver'),
('alice.green@test.com', 'Alice Green', 'test14', '01236651289', 'delivery driver'),
('jeremy.jones@test.com', 'Jeremy Jones', 'test15', '6623336789', 'sales associate'),
('joseph.schaffer@test.com', 'Joseph Schaffer', 'test16', '0423456799', 'general manager'),
('avdol.ford@test.com', 'Avdol Ford', 'test17', '0123463789', 'customer service representative'),
('gill.bates@test.com', 'Gill Bates', 'test18', '0123444789', 'company'),
('donald.devito@test.com', 'Donald Devito', 'test19', '0100456789', 'customer service representative'),
('danny.lynkins@test.com', 'Danny Lynkins', 'test20', '0122341789', 'delivery driver');