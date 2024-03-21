CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    age INTEGER,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name, lastname, email, age) VALUES ('Juan', 'Pérez', 'juan@example.com', 30);
INSERT INTO users (name, lastname, email, age) VALUES ('María', 'García', 'maria@example.com', 25);
INSERT INTO users (name, lastname, email, age) VALUES ('Pedro', 'Martínez', 'pedro@example.com', 35);
INSERT INTO users (name, lastname, email, age) VALUES ('Ana', 'López', 'ana@example.com', 28);
INSERT INTO users (name, lastname, email, age) VALUES ('Luis', 'Rodríguez', 'luis@example.com', 40);
INSERT INTO users (name, lastname, email, age) VALUES ('Laura', 'Sánchez', 'laura@example.com', 22);
INSERT INTO users (name, lastname, email, age) VALUES ('Carlos', 'Gómez', 'carlos@example.com', 33);
INSERT INTO users (name, lastname, email, age) VALUES ('Sofía', 'Díaz', 'sofia@example.com', 27);
INSERT INTO users (name, lastname, email, age) VALUES ('Daniel', 'Fernández', 'daniel@example.com', 29);
INSERT INTO users (name, lastname, email, age) VALUES ('Elena', 'Martínez', 'elena@example.com', 31);

---

CREATE TABLE devices (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    brand VARCHAR(255),
    technology VARCHAR(255),
    _2g_bands VARCHAR(255),
    _3g_bands VARCHAR(255),
    _4g_bands VARCHAR(512)
);

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Samsung Galaxy S9', 'Samsung', 'GSM / HSPA / LTE', '2G', 'Bands 5(850), 8(900), 4(1700/2100), 2(1900), 1(2100)', 'Bands 1(2100), 2(1900), 3(1800), 4(AWS-1), 5(850), 7(2600), 8(900), 12(700 a), 13(700 c), 14(700 PS), 17(700 b), 18(800 Lower), 19(800 Upper), 20(800 DD), 25(1900+), 26(850+), 28(700 APT), 29(700 d), 30(2300 WCS), 66(AWS-3), 71(600)');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Samsung Galaxy S8', 'Samsung', 'GSM / HSPA / LTE', 'Not specified', 'Bands 1(2100), 2(1900), 5(850), 8(900)', 'Bands 1(2100), 2(1900), 3(1800), 4(AWS-1), 5(850), 7(2600), 8(900), 12(700 a), 13(700 c), 17(700 b), 18(800 Lower), 19(800 Upper), 20(800 DD), 25(1900+), 26(850+), 28(700 APT), 29(700 d), 30(2300 WCS), 66(AWS-3)');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Motorola Nexus 6', 'Motorola', 'GSM / HSPA / LTE', 'Quad', 'Bands 6(800), 5(850), 8(900), 4(1700/2100), 2(1900), 1(2100)', 'FDD: Bands 1(2100), 3(1800), 5(850), 7(2600), 8(900), 19(800 Upper), 20(800 DD), 28(700 APT); TDD: Bands 41(2600+)');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('OnePlus 9', 'OnePlus', 'GSM / CDMA / HSPA / LTE / 5G', 'Not specified', 'Bands 1(2100), 2(1900), 4(1700/2100), 5(850), 8(900), 9(1700), 19(800)', 'n1, n2, n3, n5, n7, n8, n20, n25, n28, n38, n40, n41, n48, n66, n71, n77, n78');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Apple iPhone 13', 'Apple', 'GSM / CDMA / HSPA / LTE / 5G', 'Not specified', 'Bands 1(2100), 2(1900), 4(1700/2100), 5(850), 6(800), 8(900)', 'n1, n2, n3, n5, n7, n8, n12, n20, n25, n28, n38, n40, n41, n48, n66, n71, n77, n78, n79, n258, n260, n261');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Apple iPhone 12', 'Apple', 'GSM / CDMA / HSPA / LTE / 5G', 'Not specified', 'Bands 1(2100), 2(1900), 4(1700/2100), 5(850), 8(900)', 'n1, n2, n3, n5, n7, n8, n12, n20, n25, n28, n38, n40, n41, n66, n71, n77, n78, n79, n260, n261');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Apple iPhone 11', 'Apple', 'GSM / HSPA / LTE', 'Not specified', 'Bands 1(2100), 2(1900), 4(1700/2100), 5(850), 8(900)', 'Bands 1(2100), 2(1900), 3(1800), 4(AWS-1), 5(850), 7(2600), 8(900), 12(700 a), 13(700 c), 14(700 PS), 17(700 b), 18(800 Lower), 19(800 Upper), 20(800 DD), 25(1900+), 26(850+), 29(700 d), 30(2300 WCS), 34(2000), 38(2600), 39(1900+), 40(2300), 41(2600+), 42(3500), 46, 48(3600), 66(AWS-3), 71(600)');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('iPhone X', 'Apple', 'GSM / HSPA / LTE', 'Not specified', 'Bands 1(2100), 2(1900), 4(1700/2100), 5(850), 8(900)', 'Bands 1(2100), 2(1900), 3(1800), 4(AWS-1), 5(850), 7(2600), 8(900), 12(700 a), 13(700 c), 17(700 b), 18(800 Lower), 19(800 Upper), 20(800 DD), 25(1900+), 26(850+), 28(700 APT), 29(700 d), 30(2300 WCS), 66(AWS-3)');

INSERT INTO devices (name, brand, technology, _2g_bands, _3g_bands, _4g_bands)
VALUES
('Nokia 3310', 'Nokia', 'GSM', 'Not specified', 'Not applicable', 'Not applicable');

---

CREATE TABLE requirement_type (
    req_type_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO requirement_type (name) VALUES ('BOOKING');
INSERT INTO requirement_type (name) VALUES ('RETURN');

---

--CREATE TABLE requirement (
--    req_id SERIAL PRIMARY KEY,
--    user_id INT,
--    device_id INT,
--    req_type_id INT,
--    availability BOOLEAN,
--    datetime DATE,
--    FOREIGN KEY (user_id) REFERENCES users(user_id),
--    FOREIGN KEY (device_id) REFERENCES devices(device_id),
--    FOREIGN KEY (req_type_id) REFERENCES requirement_type(req_type_id)
--);
--
--INSERT INTO requirement (user_id, device_id, req_type_id, availability, datetime) VALUES (1, 1, 1, true, '2024-03-20');
--INSERT INTO requirement (user_id, device_id, req_type_id, availability, datetime) VALUES (2, 2, 2, false, '2024-03-21');
--INSERT INTO requirement (user_id, device_id, req_type_id, availability, datetime) VALUES (3, 3, 1, true, '2024-03-22');
--INSERT INTO requirement (user_id, device_id, req_type_id, availability, datetime) VALUES (4, 4, 2, false, '2024-03-23');
--INSERT INTO requirement (user_id, device_id, req_type_id, availability, datetime) VALUES (5, 5, 1, true, '2024-03-24');

