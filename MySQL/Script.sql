SELECT DATABASE();
SHOW TABLES;
CREATE TABLE pet (name varchar(20), owner varchar(20), species varchar(20), sex char(1), birth date, death date);
show tables;
describe pet;

set GLOBAL local_infile = 1;

load data local infile 'pet.txt' into table pet lines terminated by '\r';

/* pet.txt
 * Whistler        Gwen    bird    \N      1997-12-09      \N
 */

insert into pet values('Puffball','Diane','hamster','f','1999-03-30',NULL);

insert into pet (name,owner) values ('jack','amanda');
select * from pet;
select * FROM pet;
UPDATE pet set birth = '2000-03-11' where name = 'Puffball';

insert into pet values
('Fluffy','Harold','cat','f','1993-02-04',NULL),
('Claws','Gwen','cat','m','1994-03-17',NULL),
('Buffy','Harold','dog','f','1989-05-13',NULL);

delete from pet where name = 'fluffy';

insert into pet values
('Fluffy','Harold','cat','f','1993-02-04',NULL);

select * from pet where birth >= '1990-1-1' and birth <= '2000-1-1';

select name,birth from pet where species = 'dog' and sex = 'f';

select DISTINCT owner from pet;

SELECT * from Pet;

select DISTINCT owner from pet;

SELECT name,birth from pet order by birth DESC ;

select name, TIMESTAMPDIFF(YEAR ,birth,CURDATE()) as age from pet;

select sex,COUNT(name)  from pet group by sex;