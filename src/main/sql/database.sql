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



drop table if exists module;
create table module (
   id bigserial not null,
   full_name character varying(1024),
   short_name character varying(20),
   owner character varying(255),
   size character varying(50),
   passing_siding cHaracter varying(100),
   description  character varying(1024),
   notes character varying(1024)
);
insert into module (full_name, short_name, owner, size, passing_siding, description, notes) values('Tyvan Derrick No. 9', 'Tyvan 9', 'Regan Johnson', '24x48 inches', '0', 'two track mainline each with a backwards siding', 'PITA backwards sidings. sigh');
insert into module (full_name, short_name, owner, size, passing_siding, description, notes) values('Credit river bridge', 'Credit_bridge', 'Regan Johnson', '24x48 inches', '0', 'two track mainline with bridge over the Credit River', 'in reality, this is single track');

   drop table if exists consignee;
   create table consignee (
      id bigserial not null,
      module_id bigint not null,
      name character varying(100)
   );

insert into consignee(module_id, name) values((select id from module where short_name='Tyvan 9'),       'oil derrick');
insert into consignee(module_id, name) values((select id from module where short_name='Tyvan 9'),       'country store');
insert into consignee(module_id, name) values((select id from module where short_name='Credit_bridge'), 'team track');

   drop table if exists zone;
   create table zone (
      id bigserial not null,
      consignee_id bigint not null,
      zone_id bigint,
      name character varying(100) not null,
      length bigint not null,
      faces character not null,
      yard_interchange_staging boolean,
      active boolean
   );

insert into zone(consignee_id, zone_id, name, length, faces, yard_interchange_staging, active) values((select id from consignee where name='oil derrick'), 1, 'oil derrick', 50, 'a', false, true);
insert into zone(consignee_id, zone_id, name, length, faces, yard_interchange_staging, active) values((select id from consignee where name='country store'), 2, 'country store', 50, 'b', false, true);

insert into zone(consignee_id, zone_id, name, length, faces, yard_interchange_staging, active) values((select id from consignee where name='team track'), 1, 'team track', 75, 'a', false, true);