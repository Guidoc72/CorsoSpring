CREATE TABLE IF NOT EXISTS contacts
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name 	varchar(100) NOT NULL,
	last_name 	varchar(100) NOT NULL,
	phone 		varchar(100) NOT NULL,
	email 		varchar(100) DEFAULT NULL
);

