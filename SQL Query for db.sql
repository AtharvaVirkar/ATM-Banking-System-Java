create database bankmanagementsystem;

use bankmanagementsystem;
show databases;

create table signup(
		FORMNO varchar(20) Primary key,
        name varchar(50) not null,
        FNAME varchar(50) not null,
        DOB varchar(10) not null,
        GENDER varchar(6) not null,
        EMAIL varchar(30) not null,
        MARITAL varchar(50) not null,
        ADDRESS varchar(100) not null,
        CITY varchar(50) not null,
        STATE varchar(50) not null,
        PIN varchar(6) not null
        );
        
        show tables;
        
        desc signup;
        ALTER TABLE signup MODIFY DOB varchar(20);
ALTER TABLE SIGNUPTWO ADD PRIMARY KEY (FORMNO);
select * from signuptwo;
delete from signuptwo
where formno = '5986';

CREATE TABLE signuptwo (
    FORMNO VARCHAR(20) NOT NULL,
    RELIGION VARCHAR(50) NOT NULL,
    CATEGORY VARCHAR(50) NOT NULL,
    INCOME VARCHAR(50) NOT NULL,
    EDUCATION VARCHAR(100) NOT NULL,
    OCCUPATION VARCHAR(100) NOT NULL,
    PAN VARCHAR(20) NOT NULL,
    AADHAR VARCHAR(20) NOT NULL,
    SENIORCITIZEN VARCHAR(10) NOT NULL,
    EXISTINGACCOUNT VARCHAR(10) NOT NULL
);
select * from signup;
select * from signuptwo;
delete from signupthree
where pinnumber = 2163;
DELETE FROM SIGNUPTWO 
WHERE FORMNO = '5986' 
LIMIT 1;

CREATE TABLE signupthree (
    FORMNO VARCHAR(20) PRIMARY KEY,
    ACCOUNTTYPE VARCHAR(50) NOT NULL,
    CARDNUMBER VARCHAR(20) NOT NULL UNIQUE,
    PINNUMBER VARCHAR(10) NOT NULL,
    FACILITY VARCHAR(100)
);

create table login( FORMNO varchar(20) , 
					CARDNUMBER varchar(25),
					PIN varchar(10));
select * from login;

DELETE FROM SIGNUPTHREE WHERE PINNUMBER = '2163' LIMIT 1;

ALTER TABLE SIGNUP DROP PRIMARY KEY;
ALTER TABLE SIGNUP MODIFY FORMNO VARCHAR(20);