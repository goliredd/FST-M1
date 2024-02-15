REM   Script: Activity5
REM   Activity5

ALTER TABLE Salesman  
ADD grade int;

INSERT ALL   
    INTO Salesman VALUES(5001,'James Hoog','New York',15)  
	INTO Salesman VALUES(5002,'Nail Knite','Paris',13)   
	INTO Salesman VALUES(5005,'Pit Alex','London',11)   
	INTO Salesman VALUES(5006,'McLyon','Paris',14)   
	INTO Salesman VALUES(5007,'Paul Adam','Rome',13)   
	INTO Salesman VALUES(5003,'Lauson Hen','San Jose',12)   
SELECT 1 FROM DUAL;

CREATE TABLE Salesman(  
	salesman_id int, salesman_name varchar2(20), salesman_city varchar2(20), commission int);

SELECT * FROM Salesman;

ALTER TABLE Salesman  
ADD grade int;

SELECT * FROM Salesman;

SELECT * FROM Salesman;

UPDATE Salesman 
SET grade = 100;

SELECT * FROM Salesman;

UPDATE Salesman 
SET grade = 200 
WHERE salesman_city = 'Rome';

UPDATE Salesman 
SET grade = 300 
WHERE salesman_name = 'James Hoog';

UPDATE Salesman 
SET salesman_name = 'Pierre' 
WHERE salesman_name = 'McLyon';

SELECT * FROM Salesman;

