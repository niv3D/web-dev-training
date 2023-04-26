CREATE TABLE StudentDetails(
	sid int primary key,
	name varchar(50),
	feepaid date,
	dob	date,
	street varchar(100),
	town varchar(50),
	pin int(5)
);

CREATE INDEX student_indx ON StudentDetails (name);

CREATE TABLE TeacherDetails(
	tid int primary key,
	name varchar(50),
	street varchar(100),
	town varchar(50),
	pin	int(5)
);

CREATE TABLE Courses(
	cid varchar(5) primary key,
	name varchar(50),
	tid int,
	FOREIGN KEY (tid)
	REFERENCES TeacherDetails(tid)
);

CREATE TABLE Subjects(
	subid varchar(5) primary key,
	name varchar(50),
	cid varchar(5),
	FOREIGN KEY (cid)
	REFERENCES Courses(cid)
);

CREATE TABLE Marks(
	sid int, FOREIGN KEY (sid) REFERENCES StudentDetails(sid) ON DELETE CASCADE,
	subid varchar(5), FOREIGN KEY (subid) REFERENCES Subjects(subid),
	marks int
);

select * from Marks;

DELETE from StudentDetails where sid = 3;


INSERT INTO TeacherDetails VALUES
	(2,'Charles Xavior','47 March Way','Glebe',56100),
	(3,'Sarah Francis', null ,null, null),
	(4,'Shane Cobson','105 Mist Road','Faulkner',56410);

INSERT INTO Courses VALUES
	('ECS', 'Economics',1),
	('CS', 'Computer Science',2),
	('MEDC', 'Medicine',3),
	('DS', 'Dentistry',4);

INSERT INTO Subjects VALUES
	('ECS1', 'Economics 1','ECS'),
	('BIO1', 'Biology 1','MEDC'),
	('BISI', 'Business Intro','ECS'),
	('PG2', 'Programming 2','CS'),
	('BIO2', 'Biology 2','MEDC');

INSERT INTO StudentDetails VALUES
	(3,'Susan Johnson','2001-02-03','1991-1-13','21 Arrow Street','South Boston',56128);

INSERT INTO Marks VALUES 
	(3,'BIO2',92);

CREATE TABLE EnrolledSubjects(
	sid int primary key , FOREIGN KEY (sid) REFERENCES StudentDetails(sid) ON DELETE CASCADE,
	sub1 varchar(5), FOREIGN KEY (sub1) REFERENCES Subjects(subid),
	sub2 varchar(5), FOREIGN KEY (sub2) REFERENCES Subjects(subid),
	sub3 varchar(5), FOREIGN KEY (sub2) REFERENCES Subjects(subid),
	sub4 varchar(5), FOREIGN KEY (sub2) REFERENCES Subjects(subid)
);

INSERT INTO EnrolledSubjects VALUES
	(1,'ECS1','BIO1',null,null),
	(2,'BIO1','BISI','PG2',null),
	(3,'BIO2',null,null,null),
	(4,null,null,null,null)
;

/* ACTIVITY 7 */
SELECT sid , name
FROM StudentDetails
WHERE sid NOT IN (SELECT sid FROM Marks);

/* ACTIVITY 8 */
SELECT sd.name, sub.name , mk.marks
FROM StudentDetails sd
INNER JOIN Marks mk USING(sid)
INNER JOIN Subjects sub USING (subid)
WHERE mk.marks > 90 AND (YEAR(sd.feepaid) = '2001' OR YEAR(sd.feepaid) = '2000');

/* ACTIVITY 9 */
SELECT  sid , sd.name , mark.total_marks 
FROM (
		SELECT sid , SUM(marks) as total_marks
		FROM Marks 
		GROUP BY sid
) as mark
INNER JOIN StudentDetails sd USING (sid)
WHERE YEAR(sd.feepaid) = '2001' 
ORDER BY total_marks ASC LIMIT 1;


SELECT * from marks;