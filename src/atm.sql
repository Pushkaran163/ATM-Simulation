CREATE DATABASE atm;

USE atm;

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    pin VARCHAR(4) NOT NULL,
    balance DOUBLE NOT NULL
);
