## Table Creation

```sql
CREATE TABLE Customers(
	CustomerID INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(100) NOT NULL,
	Email VARCHAR(150) NOT NULL UNIQUE,
	City VARCHAR(100) NOT NULL,
	SignupDate DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE Orders(
	OrderID INT PRIMARY KEY AUTO_INCREMENT,
	CustomerID INT NOT NULL,
	OrderDate DATE NOT NULL DEFAULT CURRENT_DATE,
	TotalAmount DECIMAL(10,2) NOT NULL CHECK(TotalAmount >=0),
	CONSTRAINT fk_orders_customer FOREIGN KEY (CustomerID) 
        REFERENCES Customers(CustomerID) 
        ON DELETE SET NULL
);

CREATE TABLE Products(
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100) NOT NULL,
    Category VARCHAR(50) NOT NULL,
    Price DECIMAL(10,2) NOT NULL CHECK(Price >=0)
);

CREATE TABLE OrderDetails(
    OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL DEFAULT 1 CHECK (Quantity > 0),
    Price DECIMAL(10,2) NOT NULL CHECK(Price >=0),
    CONSTRAINT fk_orderdetails_order FOREIGN KEY (OrderID) 
        REFERENCES Orders(OrderID) 
        ON DELETE SET NULL,
    CONSTRAINT fk_orderdetails_product FOREIGN KEY (ProductID) 
        REFERENCES Products(ProductID) 
        ON DELETE SET NULL
);
```

## Indexing
```sql
CREATE INDEX idx_customers_city ON Customers(City);
CREATE INDEX idx_customers_signupdate ON Customers(SignupDate);

CREATE INDEX idx_orders_totalamount ON Orders(TotalAmount);

CREATE INDEX idx_products_category ON Products(Category);
CREATE INDEX idx_products_productname ON Products(ProductName);

CREATE INDEX idx_orderdetails_price ON OrderDetails(Price);

CREATE INDEX idx_orderdetails_productid_orderid ON OrderDetails(ProductID, OrderID);
CREATE INDEX idx_orders_customerid_totalamount ON Orders(CustomerID, TotalAmount);
```

## Sample Data Insertion

```sql
INSERT INTO Customers (Name, Email, City, SignupDate) VALUES
    ('Alice Johnson', 'alice@example.com', 'New York', '2024-12-15'),
    ('Bob Smith', 'bob@example.com', 'Mumbai', '2025-01-10'),
    ('Charlie Lee', 'charlie@example.com', 'Delhi', '2024-11-05'),
    ('David Kim', 'david@example.com', 'Mumbai', '2023-03-20'),
    ('Eva Green', 'eva@example.com', 'London', '2025-05-01');

INSERT INTO Products (ProductName, Category, Price) VALUES
    ('Laptop', 'Electronics', 95000.00),
    ('Phone', 'Electronics', 30000.00),
    ('Desk', 'Furniture', 12000.00),
    ('Chair', 'Furniture', 8000.00),
    ('Pen', 'Stationery', 10.00),
    ('Notebook', 'Stationery', 50.00);

INSERT INTO Orders (CustomerID, OrderDate, TotalAmount) VALUES
    (1, '2025-04-10', 95000.00),
    (2, '2025-05-15', 40000.00),
    (2, '2025-06-01', 12000.00),
    (3, '2025-05-20', 10010.00),
    (4, '2025-04-01', 10.00);

INSERT INTO OrderDetails (OrderID, ProductID, Quantity, Price) VALUES
    (1, 1, 1, 95000.00), 
    (2, 2, 1, 30000.00),  
    (2, 3, 1, 10000.00),  
    (3, 4, 1, 12000.00),  
    (4, 5, 1, 10.00),     
    (5, 5, 1, 10.00);     
```

## Queries

### Basic Queries
```sql
-- Get the list of all customers.
SELECT CustomerID, Name 
FROM Customers;

-- Find all orders placed in the last 30 days.
SELECT OrderID, CustomerID, OrderDate 
FROM Orders 
WHERE OrderDate >= CURDATE() - INTERVAL 30 DAY;

-- Show product names and their prices.
SELECT ProductName, Price 
FROM Products;

-- Find the total number of products in each category
SELECT COUNT(ProductID), Category
FROM Products
GROUP BY Category;
```

### Filtering and Conditions
```sql
-- Get all customers from the city 'Mumbai'.
SELECT Name, City
FROM Customers
WHERE City = 'Mumbai';

-- Find orders with a total amount greater than ₹5000.
SELECT OrderID, TotalAmount
FROM Orders
WHERE TotalAmount > 5000;

-- List customers who signed up after '2024-01-01'.
SELECT CustomerID, Name, SignupDate
FROM Customers
WHERE SignupDate >= '2024-01-01';
```

### Joins
```sql
-- Show all orders along with the customer's name.
SELECT Orders.OrderId, Customers.Name AS CustomerName
FROM Orders
LEFT JOIN Customers
ON Orders.CustomerID=Customers.CustomerID;

-- List products purchased in each order.
SELECT OD.OrderID, P.ProductName
FROM OrderDetails OD
JOIN Products P
ON OD.ProductID=P.ProductID;

-- Find customers who have never placed an order.
SELECT Customers.Name
FROM Customers
LEFT JOIN Orders 
ON Customers.CustomerID = Orders.CustomerID
WHERE Orders.OrderID IS NULL;
```

### Aggregation and Grouping
```sql
-- Find the total amount spent by each customer.
SELECT C.CustomerID, C.Name, SUM(O.TotalAmount)
FROM Orders O
JOIN Customers C
ON O.CustomerID = C.CustomerID
GROUP BY C.CustomerID,C.Name;

-- Which product has been sold the most (by quantity)?
SELECT P.ProductName, SUM(OD.Quantity) AS TotalQuantity
FROM OrderDetails OD
JOIN Products P
ON P.ProductID = OD.ProductID
GROUP BY P.ProductID,P.ProductName
ORDER BY TotalQuantity DESC
LIMIT 1;

-- Find the average order value for each customer.
SELECT C.Name, AVG(O.TotalAmount)
FROM Orders O
JOIN Customers C
ON O.CustomerID = C.CustomerID
GROUP BY C.CustomerID,C.Name;

-- Total sales amount per product category.
SELECT P.Category, SUM(OD.Price * OD.Quantity) AS TotalSales
FROM OrderDetails OD
JOIN Products P 
ON OD.ProductID = P.ProductID
GROUP BY P.Category;
```

### Subqueries
```sql
-- Find customers who spent more than the average spending.
SELECT C.CustomerID, C.Name
FROM Customers C
JOIN Orders O 
ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID, C.Name
HAVING SUM(O.TotalAmount) > (
    SELECT AVG(TotalAmount) FROM Orders
);

-- List products that have never been ordered.
SELECT ProductID, ProductName
FROM Products
WHERE ProductID NOT IN( 
	SELECT DISTINCT ProductID
    FROM OrderDetails
);

-- Find the most recent order for each customer.
SELECT O.CustomerID, O.OrderDate
FROM Orders O
WHERE O.OrderDate = (
	SELECT MAX(OrderDate)
    FROM Orders O2
    WHERE O2.CustomerID = O.CustomerID
);
```

### Advanced Queries
```sql
-- Rank customers by total spending (highest first).
SELECT C.CustomerID, C.Name, SUM(O.TotalAmount) AS TotalSpent
FROM Customers C
JOIN Orders O 
ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID, C.Name
ORDER BY TotalSpent DESC;

-- Get the top 3 customers based on the number of orders placed.
SELECT C.CustomerID, C.Name, COUNT(O.OrderID) AS NumOrders
FROM Customers C
JOIN Orders O 
ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID, C.Name
ORDER BY NumOrders DESC, C.Name ASC
LIMIT 3;

-- For each product, find how many unique customers have purchased it.
SELECT P.ProductID, P.ProductName, COUNT(DISTINCT O.CustomerID) AS UniqueCustomers
FROM OrderDetails OD
JOIN Orders O 
ON OD.OrderID = O.OrderID
JOIN Products P 
ON OD.ProductID = P.ProductID
GROUP BY P.ProductID, P.ProductName;
```
