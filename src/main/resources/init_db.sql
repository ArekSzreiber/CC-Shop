TRUNCATE TABLE category RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS category
(
    category_id integer NOT NULL,
    name        text    NOT NULL
);
INSERT INTO category (category_id, name)
VALUES (1, 'Cars'),
       (2, 'Suspension'),
       (3, 'BMS'),
       (4, 'Batteries'),
       (5, 'Engines'),
       (6, 'Chassis'),
       (7, 'Brakes'),
       (8, 'Gears'),
       (9, 'Boost'),
       (10, 'Tyres'),
       (11, 'Drive'),
       (12, 'Chains'),
       (13, 'Cassettes'),
       (14, 'Wheels'),
       (15, 'Tubes'),
       (16, 'Derailleur Gears');


TRUNCATE TABLE supplier RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS supplier
(
    supplier_id integer NOT NULL,
    name        text    NOT NULL
);
INSERT INTO supplier (supplier_id, name)
VALUES (1, 'Mysuko'),
       (2, 'Titan'),
       (3, 'Caltech'),
       (4, 'Itex'),
       (5, 'R-Line'),
       (6, 'TGR');


TRUNCATE TABLE product RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS product
(
    product_id  SERIAL PRIMARY KEY,
    category_id integer NOT NULL,
    supplier_id integer NOT NULL,
    title       text    NOT NULL,
    price       money   NOT NULL,
    image_url   text,
    description text
);
-- Cars:
INSERT INTO product (category_id, supplier_id, title, price, image_url)
VALUES (1, 4, 'Dune Rat', 1250, NULL),
       (1, 6, 'Brute', 3600, NULL),
       (1, 4, 'Sand Shark', 1400, 'http://studio408.pl/authors/skot/021.jpg'),
       (1, 6, 'Sky Hawk', 2500, 'http://studio408.pl/authors/skot/018.jpg'),
       (1, 5, 'Stunt Monkey', 2300, NULL),
       (1, 4, 'Mean Streak', 2800, 'http://studio408.pl/authors/skot/024.jpg'),
       (1, 3, 'Alley Kat', 3100, NULL),
       (1, 2, 'Nitro Lightning', 4400, NULL),
       (1, 3, 'Flying Mantis', 5500, NULL);

INSERT INTO product (category_id, supplier_id, title, description, price)
-- Tyres
VALUES (10, 5, 'Dirtbuster', 'Off-road tyres for max grip', 300),
       (10, 5, 'Maxi-Grip', 'General purpose', 250),
       (10, 5, 'Aerostunt', 'General purpose, all terrain tyres', 220),
       (10, 5, 'Vortex', 'Faster, slicker tyres', 280),
       (10, 5, 'Velocity', 'Racing slicks', 400);
INSERT INTO product (category_id, supplier_id, title, price)
VALUES (10, 5, 'Road Fighter', 600),
       (10, 5, 'Mountain Crawler', 300),
       (10, 5, 'Mountain Chamois', 400),
       (10, 5, 'Forest Mouse', 200),
       (10, 5, 'Sand Shrew', 230),
       (10, 5, 'Sand Rat', 280),
-- Drive
       (11, 6, 'Front Wheel Drive System', 500),
       (11, 6, 'Rear Wheel Drive System', 800),
       (11, 6, 'Four Wheel Drive System', 1700),
-- Chains
       (12, 1, 'Steel Worm', 50),
       (12, 1, 'Chrome Worm', 70),
       (12, 1, 'Steel Night Crawler', 70),
       (12, 1, 'Chrome Night Crawler', 120),
-- Cassettes
       (13, 6, 'Starfish', 45),
       (13, 1, 'Staryu', 50),
       (13, 1, 'Starmie', 70),
       (13, 1, 'Sun Staryu', 200),
       (13, 1, 'Sun Starmie', 280),
-- Wheels
       (14, 4, 'Swift', 50),
       (14, 4, 'Sparrow', 60),
       (14, 3, 'Martin', 120),
       (14, 3, 'Swallow', 260),
       (14, 4, 'TRE Swift', 500),
       (14, 4, 'TRE Sparrow', 650),
-- Tubes
       (15, 5, 'Standard 26"', 10),
       (15, 5, 'Pro 26', 15),
       (15, 5, 'Standard 27.5"', 11),
       (15, 5, 'Pro 27.5"', 16),
       (15, 5, 'Standard 29"', 12),
       (15, 5, 'Pro 29"', 20),
-- Derailleur
       (16, 3, 'Albatross', 25),
       (16, 3, 'Owl', 30),
       (16, 3, 'Hawk', 90),
       (16, 3, 'Kite', 150),
       (16, 3, 'Eagle', 300);

TRUNCATE TABLE property_type RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS property_type
(
    property_type_id integer NOT NULL,
    name             text    NOT NULL
);
INSERT INTO property_type (property_type_id, name)
VALUES (1, 'color'),
       (2, 'diameter'),
       (3, 'number of cells'),
       (4, 'number of derailleur gears'),
       (5, 'number of teeth'),
       (6, 'surface');

TRUNCATE TABLE property_value RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS property_value
(
    property_value_id integer NOT NULL,
    property_type_id  integer REFERENCES property_type (property_type_id),
    value             text    NOT NULL
);
INSERT INTO property_value (property_value_id, property_type_id, value)
VALUES (1, 1, 'green'),
       (2, 1, 'grey'),
       (3, 1, 'navy'),
       (4, 1, 'orange'),
       (5, 1, 'purple'),
       (6, 1, 'white'),
       (7, 2, '26'),
       (8, 2, '27.5'),
       (9, 2, '29'),
       (9, 3, '110'),
       (9, 3, '114'),
       (9, 3, '116'),
       (9, 4, '7'),
       (9, 4, '8'),
       (9, 4, '9'),
       (9, 4, '10'),
       (9, 4, '11'),
       (9, 4, '12'),
       (9, 5, '32'),
       (9, 5, '36'),
       (9, 5, '42'),
       (9, 5, '44'),
       (9, 6, 'hardpack'),
       (9, 6, 'loose'),
       (9, 6, 'mud'),
       (9, 6, 'road');


TRUNCATE TABLE category_property_type RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS category_property_type
(
    category_id      int REFERENCES category (category_id),
    property_type_id int REFERENCES property_type (property_type_id),
    PRIMARY KEY (category_id, property_type_id)
);
INSERT INTO category_property_type(category_id, property_type_id)
VALUES (10, 1),
       (10, 2),
       (10, 6),
       (12, 3),
       (12, 4),
       (13, 4),
       (14, 1),
       (14, 2),
       (14, 4),
       (15, 2),
       (16, 4);


TRUNCATE TABLE product_property_value RESTART IDENTITY CASCADE;
CREATE TABLE IF NOT EXISTS product_property_value
(
    product_id        int REFERENCES product (product_id),
    property_value_id int REFERENCES property_value (property_value_id),
    PRIMARY KEY (product_id, property_value_id)
);
