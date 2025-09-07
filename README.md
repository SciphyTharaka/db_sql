# Record Database Management

A simple Java project to manage records in a MySQL database using
JDBC.  
It supports basic **CRUD operations**: Create, Read, Update, and Delete.

## Features

-   Add new records  
-   View all records  
-   Update record details  
-   Delete records  

## Requirements

-   Java 8 or higher  
-   MySQL installed  
-   MySQL JDBC driver (mysql-connector-java)  

## Database Setup

```sql
CREATE DATABASE db_students;

USE db_students;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100)
);
