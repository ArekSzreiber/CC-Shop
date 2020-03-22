TRUNCATE TABLE category, supplier, product RESTART IDENTITY CASCADE;
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
       (11, 'Drive')
ON CONFLICT DO NOTHING;

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
       (6, 'TGR')
ON CONFLICT DO NOTHING;

-- Cars:
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


INSERT INTO product (category_id, supplier_id, title, price, image_url)
VALUES (1, 4, 'Dune Rat', 1250, NULL),
       (1, 6, 'Brute', 3600, NULL),
       (1, 4, 'Sand Shark', 1400, 'http://studio408.pl/authors/skot/021.jpg'),
       (1, 6, 'Sky Hawk', 2500, 'http://studio408.pl/authors/skot/018.jpg'),
       (1, 5, 'Stunt Monkey', 2300, NULL),
       (1, 4, 'Mean Streak', 2800, 'http://studio408.pl/authors/skot/024.jpg'),
       (1, 3, 'Alley Kat', 3100, NULL),
       (1, 2, 'Nitro Lightning', 4400, NULL),
       (1, 3, 'Flying Mantis', 5500, NULL)
ON CONFLICT DO NOTHING;

-- Suspension:
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (2, 4, 'Basic', 'Basic shocks', 200),
       (2, 4, 'Compact', 'Enhanced ride', 550),
       (2, 4, 'Absorber', 'Damage reducing travel', 950),
       (2, 4, 'Absorber Pro', 'Super tough and strong', 1550),
       (2, 4, 'Ultra Shock', 'Max absorption', 2000)
ON CONFLICT DO NOTHING;

-- BMS:
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (3, 1, 'Maxi-control BMS', 'Maximum brake and handling aids', 300),
       (3, 1, 'Enhanced BMS', 'Increased performance levels', 400),
       (3, 1, 'BMS Bypass', 'Increased performance, less aid', 500),
       (3, 1, 'Mephisto', 'Minimum driving aid', 1000),
       (3, 1, 'Diablo Extreme', 'Maximum control and performance', 3000)
ON CONFLICT DO NOTHING;

-- Batteries:
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (4, 2, '6V Quadra-Cell', 'Heavy 4 cell battery', 100),
       (4, 2, '6V Duo Cell', 'Dual cell delivers more charge', 150),
       (4, 2, '7.2V Powercell Ni-Cad', 'Efficient high capacity cell', 400),
       (4, 2, '7.2V Powerforce', 'High performance Ni-MH cell', 600),
       (4, 2, '7.2V Lite-Max', 'Super light, super charged', 1700)
ON CONFLICT DO NOTHING;

-- Engines
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (5, 3, '6V Motor', 'Best-value motor', 50),
       (5, 3, '7.2V Motor', 'Improved 7.2V performance', 120),
       (5, 3, 'Max-Lite', 'Basic engine', 800),
       (5, 3, 'Max-Pro', 'Improved performance', 1200),
       (5, 3, 'Nitro-V Extreme', 'High performance nitro-engine', 1800)
ON CONFLICT DO NOTHING;

-- Chassis
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (6, 6, 'Impact', 'Base heavy duty chassis', 70),
       (6, 6, 'Frame-Star', 'Stronger and heavier', 120),
       (6, 6, 'Hollow-Lite', 'Reinforced chassis', 230),
       (6, 6, 'Ultra C', 'Strong and light, very desirable', 400),
       (6, 6, 'Carbon Magna', 'Ultra light and super-strong', 1000)
ON CONFLICT DO NOTHING;

-- Brakes
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (7, 4, 'Wheelforce', 'Basic brake system', 40),
       (7, 4, 'Wheelforce Ultra', 'Enhanced performance', 120),
       (7, 4, 'Maxim', 'Improved efficiency', 180),
       (7, 4, 'Brakesure Lite', 'Responsive brake system', 500),
       (7, 4, 'Brakesure Pro', 'Outstanding brake', 1500)
ON CONFLICT DO NOTHING;

-- Gears
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (8, 4, 'Cognito 4-Gear System', 'Basic 2 gear system', 250),
       (8, 4, 'Five-Star', '3 gear system, improved efficiency', 350),
       (8, 4, 'Five-Star Pro', '5 gear system', 600),
       (8, 4, 'Six-Shooted', 'Advanced 6 gear system', 900),
       (8, 4, 'Velocity', '6 gear racing specification', 1600)
ON CONFLICT DO NOTHING;

-- Boost
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (9, 1, 'Stunt Lite', 'Basic stunt boost', 200),
       (9, 1, 'Stunt Ace', 'Improved launch', 300),
       (9, 1, 'Maxi-Lift', 'Increased turbo', 450),
       (9, 1, 'Maxi-Lift Pro', 'Super launch potential', 550),
       (9, 1, 'Stunt Pro Special Edition', 'Stunt boost extreme', 950)
ON CONFLICT DO NOTHING;

-- Tyres
INSERT INTO product (category_id, supplier_id, title, description, price)
VALUES (10, 5, 'Dirtbuster', 'Off-road tyres for max grip', 300),
       (10, 5, 'Maxi-Grip', 'General purpose', 250),
       (10, 5, 'Aerostunt', 'General purpose, all terrain tyres', 220),
       (10, 5, 'Vortex', 'Faster, slicker tyres', 280),
       (10, 5, 'Velocity', 'Racing slicks', 400)
ON CONFLICT DO NOTHING;

-- Drive
INSERT INTO product (category_id, supplier_id, title, price)
VALUES (11, 6, 'Front Wheel Drive System', 500),
       (11, 6, 'Rear Wheel Drive System', 800),
       (11, 6, 'Four Wheel Drive System', 1700)
ON CONFLICT DO NOTHING;
