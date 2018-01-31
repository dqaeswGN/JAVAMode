create database chapter3;

use chapter3;

create table t_role (
id int(12) auto_increment,
role_name varchar(60) not null,
note varchar(256) null,
primary key(id)
);

insert into t_role(role_name, note) values('hello world1', '123');
insert into t_role(role_name, note) values('hello world2', '123');
insert into t_role(role_name, note) values('hello world3', '123');
insert into t_role(role_name, note) values('hello world4', '123');
insert into t_role(role_name, note) values('hello world5', '123');
