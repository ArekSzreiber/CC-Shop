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

INSERT INTO supplier (id, name)
VALUES (1, 'Mysuko'),
       (2, 'Titan'),
       (3, 'Caltex'),
       (4, 'Itex'),
       (5, 'R-Line'),
       (6, 'Tiger')
ON CONFLICT DO NOTHING;

-- Cars:
INSERT INTO product (id, category_id, supplier_id, title)
VALUES (1, 1, 1, 'Dune Rat'),
       (2, 1, 1, 'Brute'),
       (3, 1, 1, 'Sand Shark'),
       (4, 1, 1, 'Sky Hawk'),
       (5, 1, 1, 'Stunt Monkey'),
       (6, 1, 1, 'Mean Streak'),
       (7, 1, 1, 'Alley Kat'),
       (8, 1, 1, 'Nitro Lightning')
ON CONFLICT DO NOTHING;

-- Suspension:
INSERT INTO product (id, category_id, supplier_id, title, description)
VALUES (9, 2, 4, 'Basic', 'Basic shocks'),
       (10, 2, 4, 'Compact', 'Enhanced ride'),
       (11, 2, 4, 'Absorber', 'Damage reducing travel'),
       (12, 2, 4, 'Absorber Pro', 'Super tough and strong'),
       (13, 2, 4, 'Ultra Shock', 'Max absorption')
ON CONFLICT DO NOTHING;

-- BMS:
INSERT INTO product (id, category_id, supplier_id, title, description)
VALUES (14, 3, 1, 'Maxi-control BMS', 'Maximum brake and handling aids'),
       (15, 3, 1, 'Enhanced BMS', 'Increased performance levels'),
       (16, 3, 1, 'BMS Bypass', 'Increased performance, less aid'),
       (17, 3, 1, 'Mephisto', 'Minimum driving aid'),
       (18, 3, 1, 'Diablo Extreme', 'Maximum control and performance')
ON CONFLICT DO NOTHING;

