REM   Script: Activity3
REM   Activity3

CREATE TABLE Salesman( 
	salesman_id int, salesman_name varchar2(20), salesman_city varchar2(20), commission int);

DESCRIBE Salesman


SELECT * FROM Salesman;

INSERT ALL  
    INTO Salesman VALUES(5001,'James Hoog','New York',15) 
	INTO Salesman VALUES(5002,'Nail Knite','Paris',13)  
	INTO Salesman VALUES(5005,'Pit Alex','London',11)  
	INTO Salesman VALUES(5006,'McLyon','Paris',14)  
	INTO Salesman VALUES(5007,'Paul Adam','Rome',13)  
	INTO Salesman VALUES(5003,'Lauson Hen','San Jose',12)  
SELECT 1 FROM DUAL;

SELECT * FROM Salesman;

SELECT salesman_id, salesman_city FROM Salesman;

SELECT * FROM Salesman 
	WHERE salesman_city = 'Paris';

SELECT * FROM Salesman 
	WHERE salesman_city = 'Paris';

SELECT * FROM Salesman 
	WHERE salesman_city = Paris;

SELECT * FROM Salesman 
	WHERE salesman_city = 'Paris';

SELECT salesman_id, commission FROM Salesman 
	WHERE salesman_name = 'Paul Adam';

