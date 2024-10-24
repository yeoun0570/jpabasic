create database jpabegin CHARACTER SET utf8mb4;

CREATE USER 'userjpa'@'localhost' IDENTIFIED BY '1234';
CREATE USER 'userjpa'@'%' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON jpabegin.* TO 'userjpa'@'localhost';
GRANT ALL PRIVILEGES ON jpabegin.* TO 'userjpa'@'%';
