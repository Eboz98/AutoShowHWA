drop table if exists cars CASCADE;

create table cars 
(
	`id` integer AUTO_INCREMENT PRIMARY KEY,
	 make varchar(255),
	`colour` varchar(255), 
	`model` varchar(255),
	`category_id` integer
);
