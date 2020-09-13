drop table if exists car_class;
create table car_class (
	id bigserial not null,
	classification character varying(255) not null
);


insert into car_class (classification) values
('C - COVERED HOPPER'),
('D - DAMAGE FREE BOXCAR (EQUIPPED BOX)'),
('F - FLATCAR'),
('G - GONDOLA (PLAIN AND EQUIPPED)'),
('H - OPEN TOP HOPPER'),
('I - INSULATED BOX (NON-EQUIPPED)'),
('J - JUNK'),
('L - Special including covered hoppers'),
('M - AUTOVEYORS, MULTI-LEVEL'),
('N - LOAD DIVIDER NON-INSULATED BOX (EQUIPPED)'),
('P - INTERMODAL FLATS, NON-ARTICULATED, SINGLE OR DOUBLE LENGTH'),
('Q - INTERMODAL FLATS, LIGHTWEIGHT, ARTICULATED, AND MULTI-PLATFORM'),
('R - BOXCAR, REFRIGERATED, LOAD DIVIDER'),
('S - STOCK CAR, STOCK USE ONLY'),
('T - TANK CARS'),
('U - CHASSIS/BOGIE'),
('V - VANS (TRAILERS)'),
('W - WOODCHIP CARS, GONDOLA OR HOPPER'),
('X - FOOD BOX, NON-EQUIPPED, FOOD LOADING ONLY'),
('Y - WORK/BUSINESS/PASSENGER EQUIPMENT'),
('Z - WAYCAR (CABOOSE)');


drop table if exists equipment;
create table equipment (
id bigserial not null,
class_id  bigint not null,
era bigint,
description character varying(255) not null,
short_description character varying(255) not null,
aar_code character varying(25),
length bigint not null,
notes character varying(1024));

insert into equipment (class_id, era, description, short_description, aar_code, length, notes) values ((select id from car_class where classification like('L - %')), 1, 'Covered Hopper', 'hopper', 'LH', 50,'some notes');
insert into equipment (class_id, era, description, short_description, aar_code, length, notes) values ((select id from car_class where classification like('L - %')), 1, 'Plastic Pellet Hopper', 'hopper', 'LP',55,'');
insert into equipment (class_id, era, description, short_description, aar_code, length, notes) values ((select id from car_class where classification like('L - %')), 1, 'Plastic Diffuse Covered Hopper', 'hopper', 'LD',45,'');
insert into equipment (class_id, era, description, short_description, aar_code, length, notes) values ((select id from car_class where classification like('P - %')), 1, 'Baggage car', 'baggage', 'B',85,'');

