drop table if exists equipment;
create table equipment (
id bigserial not null,
car_class character varying(10),
description character varying(255),
short_description character varying(255),
length bigint,
notes character varying(1024));

insert into equipment (car_class, description, short_description, length, notes) values ('L', 'Covered Hopper', 'hopper',50,'');
insert into equipment (car_class, description, short_description, length, notes) values ('L', 'Plastic Pellet Hopper', 'hopper',55,'');
insert into equipment (car_class, description, short_description, length, notes) values ('L', 'Plastic Diffuse Covered Hopper', 'hopper',45,'');
insert into equipment (car_class, description, short_description, length, notes) values ('P', 'Baggage', 'baggage',85,'');