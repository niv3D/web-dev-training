use classicmodels;
show tables;

SELECT lastName from employees;
select lastname,firstName,jobTitle from employees;
select NOW() ;
select CONCAT('Nived',' ','N') ;

/* dual - dummy table */

select CONCAT(firstName,' ',lastName) as name from employees; 
SELECT 1+1 as sumof;

SELECT 
	contactLastName,
	contactFirstName
from
	customers
order by 
	contactLastName ;
	
SELECT 
	contactLastName,
	contactFirstName
from
	customers
order by 
	contactLastName desc,
	contactFirstName asc;
	

select e.firstName,e.lastName from employees e order by e.lastName; 

select 
	ordernumber,
	orderlinenumber, 
	quantityordered*priceEach as subtotal
from 
	orderdetails
order by
	subtotal desc;

SELECT field('a' ,'z','s','a','h');

select orderNumber , status from orders order by FIELD(status, 'In Process', 'On Hold', 'Cancelled','Resolved','Disputed','Shipped');
       
       
/* null appear first in order by asc */

select firstName , lastName from employees where officeCode in(1,2,3) ORDER by officeCode;


select status from orders;

SELECT  status from orders group by status; 

select orderNumber,sum(quantityOrdered * priceEach) as total from orderdetails group by orderNumber;



CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

SELECT 
	m.member_id, m.name, c.committee_id 
FROM 
	members m 
INNER JOIN
	committees c 
ON
	c.name = m.name;


SELECT 
	m.member_id, m.name, c.committee_id 
FROM 
	members m 
INNER JOIN
	committees c 
USING(name);


SELECT 
	products.productCode, products.productName, plines.textDescription  
FROM 
	products products 
INNER JOIN
	productlines plines
USING(productLine);



SELECT 
	
FROM
	orders o 
INNER JOIN

