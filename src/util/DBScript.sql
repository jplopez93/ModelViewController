/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  JUAN PABLO
 * Created: 13 sept 2021
 */

create schema EcoRuedasLtda;
use EcoRuedasLtda;

create table Clientes(
alias varchar(45) not null primary key,
nombre varchar(45),
apellidos varchar(45),
fecha_nto date,
contrasena int,
email varchar(100),
celular bigint
);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('lucky','Pedro','Perez','2000-05-09','12345678','lucky@ecoruedas.com',3114445566);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('malopez','Maria','Lopez','2000-05-09',23456789,'malopez@ecoruedas.com',3223334455);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('diva','Ana','Diaz','2000-05-09',34567890,'diva@ecoruedas.com',3334445566);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('dreamer','Luis','Rojas','2000-05-09',45678901,'dreamer@ecoruedas.com',3445556677);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('ninja','Andres','Cruz','2000-05-09',56789012,'ninja@ecoruedas.com',3556667788);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('neon','Nelson','Ruiz','2000-05-09',67890123,'neon@ecoruedas.com',3667778899);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('rose','Claudia','Mendez','2000-05-09',78901234,'rose@ecoruedas.com',3778889900);
insert into Clientes(alias,nombre,apellidos,fecha_nto,contrasena,email,celular) values('green','Jorge','Rodriguez','2000-05-09',89012345,'green@ecoruedas.com',3123456789);

create table bicicletas(
idbicicletas int primary key,
nombre varchar(50),
precio int,
anio_const int
);
insert into bicicletas (idbicicletas,nombre,precio,anio_const)values(1,'Cannondale',1200000,2020);
insert into bicicletas (idbicicletas,nombre,precio,anio_const)values(2,'Trek',1450000,2019);
insert into bicicletas (idbicicletas,nombre,precio,anio_const)values(3,'Yeti',2000000,2020);
insert into bicicletas (idbicicletas,nombre,precio,anio_const)values(4,'Fuji',950000,2021);
insert into bicicletas (idbicicletas,nombre,precio,anio_const)values(5,'Bmc',1950000,2018);

create table proveedor (
prov_id  int primary key,
prov_nombre  varchar(20),
prov_direccion varchar(45),
prov_telefono  varchar(11)
);
insert into proveedor values (101, "Auteco","calle 7 No. 45-17", "05713224459");
insert into proveedor values (102, "Hitachi", "calle 19 No. 108-26", "05714223344");
insert into proveedor values (103, "Bosch", "carrera 68 No. 26-45", "05715678798");
insert into proveedor values (104, "Teco", "calle 77 No. 68-33", "05712213243");
insert into proveedor values (105, "General Electric", "calle 29 No. 26-12", "05717239919");

create table motocicletas_electricas(
idmotocicleta int primary key,
nom_fab varchar(50),
precio int,
autonomia int,
proveedor int,
foreign key (proveedor) references proveedor(prov_id)
);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(1,'Starker',4200000,18,101);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(2,'Lucky Lion',5600000,14,102);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(3,'Be Electric',4600000,26,101);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(4,'Aima',8000000,36,103);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(5,'Mec de Colombia',5900000,20,104);
insert into motocicletas_electricas (idmotocicleta,nom_fab,precio,autonomia,proveedor) values(6,'Atom Electric',4500000,12,105);

create table intencion_compra(
idintencion_compra int primary key,
fecha_intencion timestamp,
cliente varchar(45),
bicicletaid int null,
motocicletaid int null,
foreign key (cliente) references Clientes(alias),
foreign key (bicicletaid) references bicicletas(idbicicletas),
foreign key(motocicletaid) references motocicletas_electricas(idmotocicleta)
);
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(1,'lucky',1,'2017-10-25 20:00:00');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(2,'lucky',2,'2019-03-15 18:30:00');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(3,'lucky',1,'2019-05-20 20:30:00');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(4,'malopez',1,'2018-05-20 20:30:00');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(5,'malopez',1,'2020-01-20 20:30:00');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(6,'diva',3,'2019-05-20 20:30:00');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(7,'diva',4,'2018-06-22 21:30:00');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(8,'diva',2,'2020-03-17 15:30:20');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(9,'dreamer',2,'2020-03-17 15:30:20');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(10,'dreamer',1,'2020-04-10 18:30:20');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(11,'ninja',4,'2020-02-17 20:30:20');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(12,'ninja',1,'2020-02-20 16:30:20');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(13,'ninja',5,'2020-03-27 18:30:20');
insert into intencion_compra(idintencion_compra,cliente,motocicletaid,fecha_intencion) values(14,'rose',6,'2020-03-20 21:30:20');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(15,'green',3,'2020-01-10 17:30:20');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(16,'green',2,'2020-02-15 20:30:20');
insert into intencion_compra(idintencion_compra,cliente,bicicletaid,fecha_intencion) values(17,'green',5,'2020-03-17 18:30:20');

update bicicletas set anio_const = 2017 where nombre = 'Cannondale';
update clientes set celular = 3115678432 where alias = 'ninja';
delete from intencion_compra where cliente = 'green' and bicicletaid = 2;