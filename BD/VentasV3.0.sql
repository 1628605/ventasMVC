DROP DATABASE VENTAS;
CREATE DATABASE VENTAS;
USE VENTAS;

create table empresa (
ruc_empresa varchar(45) not null primary key,
  rs_empresa varchar(45),
  dir_empresa varchar(45),
  email_empresa varchar(45)
);

INSERT INTO empresa (rs_empresa, ruc_empresa, dir_empresa, email_empresa) VALUES
('SALE TIC', '20508689404', 'Av. Alfonso Bernal Montoya 1020', 'ventas@saletic.pe');

create table producto (
  idproducto int auto_increment not null primary key,
  nom_producto varchar(100),
  desc_producto varchar(200),
  preciov_producto double ,
  stock_producto int
);

INSERT INTO producto (idproducto,nom_producto,desc_producto,preciov_producto,stock_producto) value (00001,'DISCO DURO','500GB',150.0,10);

create table orden(
  idorden int auto_increment not null primary key,
  idcliente int,/*PK*/
  fecha_orden date,
  detalle_orden varchar(100)
);

create table detalle_orden (
  item int not null primary key,
  idorden int,/*PK*/
  idproducto int,/*PK*/
  cantidad double,
  preciov double,
  subtotal double
);

create table factura (
  idfactura int auto_increment not null primary key,
  idpersonal int,/*PK*/
  idorden int,/*PK*/
  fecha_factura date,
  igv double,
  total double
);

create table cliente (
  idcliente int auto_increment not null primary key,
  nom_cliente varchar(45),
  dni_cliente int,
  dir_cliente varchar(45),
  razon_social varchar(45),
  ruc_cliente varchar(45),
  email_cliente varchar(45)
);

INSERT INTO cliente nom_cliente,dni_cliente,dir_cliente,razon_social,ruc_cliente,email_cliente values ?,?,?,?,?,?;
UPDATE cliente set nom_cliente=?,dni_cliente=?,dir_cliente=?,razon_social=?,ruc_cliente=?,email_cliente=? where idcliente=?;
create table personal (
  idpersonal int auto_increment not null primary key,
  nom_personal varchar(50) NOT NULL,
  ape_personal varchar(50) NOT NULL,
  cargo_personal varchar(30) NOT NULL,
  clave_personal varchar(20) NOT NULL
);
SELECT idpersonal,nom_personal,ape_personal,cargo_personal,clave_personal FROM personal
INSERT INTO personal idpersonal,nom_personal,ape_personal,cargo_personal,clave_personal values ?,?,?,?,?;
UPDATE personal set nom_personal=?,ape_personal=?,cargo_personal=?,clave_personal=? where idpersonal=?;
ALTER TABLE orden
  add constraint cliente_fk foreign key (idcliente) references cliente(idcliente);
  
ALTER TABLE detalle_orden
  add constraint orden_detalle_fk foreign key (idorden) references orden(idorden),
  add constraint producto_fk foreign key (idproducto) references producto(idproducto);

  
ALTER TABLE factura
  add constraint orden_factura_fk foreign key (idorden) references orden(idorden),
  add constraint personal_fk foreign key (idpersonal) references personal(idpersonal);


drop table cliente;
drop table producto;
drop table orden_detalle;
drop table factura;
drop table personal;
drop table empresa;