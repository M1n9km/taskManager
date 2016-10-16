drop database taskmanager;
create database taskmanager;

use taskmanager;

create table login
(
id int primary key auto_increment,
psw varchar(100) not null,
role varchar(8) not null,
check (role('admin','user'))
);

insert into login values(null,MD5('123'),'admin');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');
insert into login values(null,MD5('123'),'user');




create table user_
(
id int auto_increment,
username varchar(20),
college varchar(40),
clas varchar(20),
major varchar(40),
mail varchar(40),
direction varchar(40),
constraint id foreign key(id) references login(id),
primary key(id)
);

insert into user_ values (null,'Jruy','数学与信息学院' , '15信管2', '信息管理与信息系统', 'Jury@gmail.com','后端');
insert into user_ values (null,'Kasl','数学与信息学院' , '15软工9', '软件工程', 'Kasl@gmail.com','前端');
insert into user_ values (null,'Hexj','数学与信息学院' , '15计机7', '计算机科学与技术', 'Hexj@gmail.com','移动');
insert into user_ values (null,'Mekax','数学与信息学院' , '15网工8', '网络工程', 'Mekax@gmail.com','交互');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');
insert into user_ values (null,'test','数学与信息学院' , '15test8', 'major', 'test@gmail.com','direction');


create table task
(
tskid int primary key auto_increment ,
tskname varchar(40),
tskstmt varchar(255)
);

insert into task values(null,'任务一','任务一要干什么');
insert into task values(null,'任务二','任务二不知道任务一干什么');
insert into task values(null,'任务三','任务三不知道要怎么办');
insert into task values(null,'任务四','任务四也不知道这是什么啊');

create table usertask
(
id int,
tskid int,
constraint tskid foreign key(tskid) references task(tskid),
constraint id2 foreign key(id) references login(id),
primary key(id,tskid)
);

insert into usertask values(1,1);
insert into usertask values(1,2);
insert into usertask values(1,3);
insert into usertask values(2,1);
insert into usertask values(2,2);
