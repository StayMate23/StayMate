create database if not exists stay_mate_demo;
use stay_mate_demo;
create table if not exists partner(
id int auto_increment primary key,
partner_name varchar(100),
address varchar (100),
tel_num varchar(55),
email varchar(55),
company_reg_num int,
tax_num int
);
create table if not exists partner_admin(
id int auto_increment primary key,
name varchar (55),
pos_rank varchar(55),
tel_number varchar(55),
partner_id int,
foreign key (partner_id) references partner(id)
);