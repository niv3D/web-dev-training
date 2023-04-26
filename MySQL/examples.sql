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

select firstName , lastName , officeCode from employees where officeCode in(1,2,3) ORDER by officeCode;


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

select status from orders o group by status;



SELECT 
	o1.orderNumber, o1.status , SUM(o2.quantityOrdered * o2.priceEach)
FROM
	orders o1 
INNER JOIN
	orderdetails o2
USING(orderNumber)
WHERE 
	o1 .status = 'Shipped'
GROUP BY orderNumber;

SELECT 
    orderNumber,
    orderDate,
    orderLineNumber,
    productName,
    quantityOrdered,
    priceEach
FROM
    orders
INNER JOIN
    orderdetails USING (orderNumber)
INNER JOIN
    products USING (productCode)
ORDER BY 
    orderNumber, 
    orderLineNumber;
   
   
CREATE TABLE t1 (
    id INT PRIMARY KEY
);

CREATE TABLE t2 (
    id INT PRIMARY KEY
);

SELECT * from t2;

INSERT INTO t1 VALUES (1),(2),(3);
INSERT INTO t2 VALUES (2),(3),(4);

SELECT 
	id
FROM
	t1
UNION ALL
SELECT
	id
FROM
	t2;
	

SELECT 
	id
FROM
	t1
intersect
SELECT
	id
FROM
	t2;


select
	id
from
	t1
except
select
	id
from 
	t2;


SELECT * from customers;

SELECT 
    CONCAT(firstName, ' ', lastName) as fullname
FROM
    employees 
UNION SELECT 
    CONCAT(contactFirstName, ' ', contactLastName)
FROM
    customers
ORDER BY 
    fullname;
    
 SELECT * from employees;
select * from offices;


SELECT 
    lastName, firstName
FROM
    employees
WHERE
    officeCode IN (
    	SELECT 
            officeCode
        FROM
            offices
        WHERE
            country = 'USA'
       	);
       	
SELECT 
    customerNumber, 
    checkNumber, 
    amount
FROM
    payments
WHERE
    amount IN (SELECT MAX(amount) FROM payments UNION SELECT MIN(amount) from payments);
   

   
   
 set autocommit = 0;

START TRANSACTION;

SELECT 
    @orderNumber := MAX(orderNUmber)+1
FROM
    orders;

INSERT INTO orders(
	orderNumber,
	orderDate,
	requiredDate,
	shippedDate,
	status,
	customerNumber)
VALUES(
	@orderNumber,
	'2005-05-31',
	'2005-06-10',
	'2005-06-11',
	'In Process',
	145
);

SAVEPOINT ins;


INSERT INTO orderdetails(
	orderNumber,
	productCode,
	quantityOrdered,
	priceEach,
	orderLineNumber)
VALUES
	(@orderNumber,'S18_1749', 30, '136', 1),
	(@orderNumber,'S18_2248', 50, '55.09', 2); 

SELECT * from orders ORDER BY orderNumber DESC;

ROLLBACK TO ins;
      
COMMIT;


    
   