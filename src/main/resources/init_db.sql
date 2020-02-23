CREATE TABLE IF NOT EXISTS category
(
    id   integer NOT NULL,
    name text    NOT NULL
);
INSERT INTO category (id, name)
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
    id   integer NOT NULL,
    name text    NOT NULL
);

INSERT INTO supplier (id, name)
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
    category_id integer NOT NULL,
    supplier_id integer NOT NULL,
    title       text    NOT NULL,
    description text
);
INSERT INTO product (category_id, supplier_id, title)
VALUES (1, 4, 'Dune Rat'),
       (1, 6, 'Brute'),
       (1, 4, 'Sand Shark'),
       (1, 6, 'Sky Hawk'),
       (1, 5, 'Stunt Monkey'),
       (1, 4, 'Mean Streak'),
       (1, 3, 'Alley Kat'),
       (1, 2, 'Nitro Lightning'),
       (1, 3, 'Flying Mantis')
ON CONFLICT DO NOTHING;

-- Suspension:
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (2, 4, 'Basic', 'Basic shocks'),
       (2, 4, 'Compact', 'Enhanced ride'),
       (2, 4, 'Absorber', 'Damage reducing travel'),
       (2, 4, 'Absorber Pro', 'Super tough and strong'),
       (2, 4, 'Ultra Shock', 'Max absorption')
ON CONFLICT DO NOTHING;

-- BMS:
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (3, 1, 'Maxi-control BMS', 'Maximum brake and handling aids'),
       (3, 1, 'Enhanced BMS', 'Increased performance levels'),
       (3, 1, 'BMS Bypass', 'Increased performance, less aid'),
       (3, 1, 'Mephisto', 'Minimum driving aid'),
       (3, 1, 'Diablo Extreme', 'Maximum control and performance')
ON CONFLICT DO NOTHING;

-- Batteries:
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (4, 2, '6V Quadra-Cell', 'Heavy 4 cell battery'),
       (4, 2, '6V Duo Cell', 'Dual cell delivers more charge'),
       (4, 2, '7.2V Powercell Ni-Cad', 'Efficient high capacity cell'),
       (4, 2, '7.2V Powerforce', 'High performance Ni-MH cell'),
       (4, 2, '7.2V Lite-Max', 'Super light, super charged')
ON CONFLICT DO NOTHING;

-- Engines
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (5, 3, '6V Motor', 'Best-value motor'),
       (5, 3, '7.2V Motor', 'Improved 7.2V performance'),
       (5, 3, 'Max-Lite', 'Basic engine'),
       (5, 3, 'Max-Pro', 'Improved performance'),
       (5, 3, 'Nitro-V Extreme', 'High performance nitro-engine')
ON CONFLICT DO NOTHING;

-- Chassis
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (6, 6, 'Impact', 'Base heavy duty chassis'),
       (6, 6, 'Frame-Star', 'Stronger and heavier'),
       (6, 6, 'Hollow-Lite', 'Reinforced chassis'),
       (6, 6, 'Ultra C', 'Strong and light, very desirable'),
       (6, 6, 'Carbon Magna', 'Ultra light and super-strong')
ON CONFLICT DO NOTHING;

-- Brakes
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (7, 4, 'Wheelforce', 'Basic brake system'),
       (7, 4, 'Wheelforce Ultra', 'Enhanced performance'),
       (7, 4, 'Maxim', 'Improved efficiency'),
       (7, 4, 'Brakesure Lite', 'Responsive brake system'),
       (7, 4, 'Brakesure Pro', 'Outstanding brake')
ON CONFLICT DO NOTHING;

-- Gears
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (8, 4, 'Cognito 4-Gear System', 'Basic 2 gear system'),
       (8, 4, 'Five-Star', '3 gear system, improved efficiency'),
       (8, 4, 'Five-Star Pro', '5 gear system'),
       (8, 4, 'Six-Shooted', 'Advanced 6 gear system'),
       (8, 4, 'Velocity', '6 gear racing specification')
ON CONFLICT DO NOTHING;

-- Boost
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (9, 1, 'Stunt Lite', 'Basic stunt boost'),
       (9, 1, 'Stunt Ace', 'Improved launch'),
       (9, 1, 'Maxi-Lift', 'Increased turbo'),
       (9, 1, 'Maxi-Lift Pro', 'Super launch potential'),
       (9, 1, 'Stunt Pro Special Edition', 'Stunt boost extreme')
ON CONFLICT DO NOTHING;

-- Tyres
INSERT INTO product (category_id, supplier_id, title, description)
VALUES (10, 5, 'Dirtbuster', 'Off-road tyres for max grip'),
       (10, 5, 'Maxi-Grip', 'General purpose'),
       (10, 5, 'Aerostunt', 'General purpose, all terrain tyres'),
       (10, 5, 'Vortex', 'Faster, slicker tyres'),
       (10, 5, 'Velocity', 'Racing slicks')
ON CONFLICT DO NOTHING;

-- Drive
INSERT INTO product (category_id, supplier_id, title)
VALUES (11, 6, 'Front Wheel Drive System'),
       (11, 6, 'Rear Wheel Drive System'),
       (11, 6, 'Four Wheel Drive System')
ON CONFLICT DO NOTHING;
