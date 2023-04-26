create database exercise;
show databases;

use exercise;

show tables;

create table Student (id int primary key,FirstName varchar(20),LastName varchar(20),Gender char(1),email varchar(20),yearOfBirth date);

describe Student;

ALTER table Student add YearOfAdmission date;

alter table Student change column yearOfBirth DateOfBirth date;


insert into Student values
	(1,'Jaimy','Simon','F','jaimysimon@gmail.com','2000-10-11','2019-7-1'),
	(2,'Nived','N','M','nivedn@gmail.com','2000-3-11','2019-7-1'),
	(3,'Gayathri','M','F','gayathri@gmail.com','2001-7-9','2019-7-1'),
	(4,'Ihsanul','Haque','M','ihsan@gmail.com','2000-6-4','2018-7-1'),
	(5,'Leo','Anil','M','leoanil@gmail.com','2000-10-20','2019-7-1'),
	(6,'Rohit','Biju','M','rohit@gmail.com','2000-7-20','2020-7-1'),
	(7,'Kiran','Das','M','kirandas@gmail.com','2002-4-20','2021-7-1'),
	(8,'Kiran','Christopher','M','kiranc@gmail.com','2000-11-20','2019-7-1'),
	(9,'Parthan','Das','M','parthan@gmail.com','2000-4-19','2019-7-1'),
	(10,'Leo','Anil','M','leoanil1@gmail.com','2002-10-20','2021-7-1');
	

select * from Student ;

alter table Student add Branch varchar(20), add Std int; 

select count(*) from Student where YEAR(DateOfBirth) = 2000;

select yearOfAdmission , gender ,count(*) from Student group by yearOfAdmission,gender;


select 
	t1.FirstName, 
	t1.LastName 
from 
	Student as t1, 
	Student as t2 
where 
	t1.id != t2.id and (t1.firstname = t2.firstname or t1.lastname = t2.lastname)
order BY
 firstname;

select CONCAT(FirstName,' ', LastName) as name from Student order by dateofbirth LIMIT 10;


SELECT
	
from 
	Student
GROUP BY
	yearofadmission;

CREATE TABLE MarksObtained (
	id int, FOREIGN KEY (id) REFERENCES Student(id),
	subject varchar(20),
	marks int
);

INSERT INTO MarksObtained VALUES
(4,'Chemistry',96)
;



SELECT 
	st.FirstName, mk.subject, mk.marks
FROM 
	Student as st
INNER JOIN 
	MarksObtained as mk
USING(id)
WHERE 
	mk.marks > 90 AND YEAR(st.YearOfAdmission) = '2019';

/* ACTIVITY 4 */
SELECT 
	st.FirstName, mark.subject , mark.marks
FROM 
	(SELECT * FROM MarksObtained WHERE marks > 90) as mark, student as st
WHERE 
	st.id = mark.id AND YEAR(st.yearOfAdmission) = '2019';
	

SELECT * from MarksObtained;


