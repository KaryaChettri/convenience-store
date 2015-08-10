# convenience-store
1. Configure database. Run this script
DROP DATABASE IF EXISTS scheduler;
CREATE DATABASE scheduler;
GRANT ALL ON scheduler.* to 'naresh'@'localhost' identified by 'shrestha';
commit;
flush privileges;
use scheduler;
CREATE TABLE employee (
   id INT PRIMARY KEY AUTO_INCREMENT,
   first_name VARCHAR(45) DEFAULT NULL,
   last_name VARCHAR(45) DEFAULT NULL,
   job_title VARCHAR(45)  DEFAULT NULL,
   schedule_time varchar(45) DEFAULT NULL,
   address VARCHAR (45) DEFAULT NULL,
   phone VARCHAR (45) DEFAULT NULL
);

CREATE TABLE schedule (
	id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT default NULL,
    start_time varchar(10) default null,
    end_time varchar(10) default null,
    scheduled_date date,
    
	FOREIGN KEY (employee_id) REFERENCES employee (id)
);

2. Copy mysql connector jar over to tomcat lib folder
From <Your .m2>/repository/mysql/mysql-connector-java/5.1.6
To <Your tomcat installation>/lib
