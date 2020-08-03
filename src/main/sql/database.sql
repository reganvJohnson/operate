drop table if exists equipment;
create table equipment (
id bigserial not null,
class character varying(10),
description character varying(255),
short character varying(255),
length bigint,
notes character varying(1024));

insert into equipment (class, description, short, length, notes) values ('L', 'Covered Hopper', 'hopper',50,'');
insert into equipment (class, description, short, length, notes) values ('L', 'Plastic Pellet Hopper', 'hopper',55,'');
insert into equipment (class, description, short, length, notes) values ('L', 'Plastic Diffuse Covered Hopper', 'hopper',45,'');
insert into equipment (class, description, short, length, notes) values ('P', 'Baggage', 'baggage',85,'');	