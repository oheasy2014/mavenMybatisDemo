drop table _user;
use test;
create table _user (
 _id int auto_increment,
 _name varchar(50) default "侯小雨" not null,
 _age int default 0,
 _address varchar(100) default "北京" not null,
 primary key(_id)
 )engine=InnoDB default charset=utf8;