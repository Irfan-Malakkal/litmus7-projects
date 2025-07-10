CREATE DATABASE retailDB;
USE retailDB;

CREATE TABLE products (
 product_id INT PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 category VARCHAR(50) NOT NULL,
 price DOUBLE NOT NULL,
 stock_quantity INT NOT NULL 
);

drop table products;

select * from products;