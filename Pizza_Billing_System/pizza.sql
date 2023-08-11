create database pizza;
create table admin(id int primary key AUTO_INCREMENT, uname varchar(50),Password(50));
create table cock(id int primary key AUTO_INCREMENT, name varchar(50),cost int,flavour varchar(50));
create table icecream(id int primary key AUTO_INCREMENT,name varchar(50),cost int,flavour varchar(50));
create table orders(id int primary key AUTO_INCREMENT,oid int,uemail varchar(50),pid int,doo date,totalcost int);
create table pizza_types(id int primary key AUTO_INCREMENT,Name varchar(50),Cost int, Size varchar(1));
create table user(uid int primary key AUTO_INCREMENT,	uname varchar(50),	umobile int,	uemail varchar(50),	upassword varchar(50));


insert into admin VALUES(1,'admin','123456');
insert  into admin VALUES(2,'admin','admin');
insert  into cock VALUES(1,'cock_1',100,'Pepsi');
insert  into icecream VALUES(1,'ice_1',100,'gudbud_mango');
insert  into orders VALUES(1,1,'abc@gmail.com',198989,30-04-2023,300);
insert  into pizza_types VALUES(1,'Pizza_1',100,'S');
insert into user values(1,'ABC',7676654809,'abc@gmail.com','Kall@2003');
