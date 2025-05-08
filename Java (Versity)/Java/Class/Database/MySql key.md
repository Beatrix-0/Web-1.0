# MySQL Bookstore Database – 7 Key SQL Operations (All-in-One)

```sql
-- 1. Create the database
CREATE DATABASE bookstore;

-- 2. Use the database
USE bookstore;

-- 3. Create tables
CREATE TABLE books (
  book_id VARCHAR(20),
  title VARCHAR(50),
  author_id VARCHAR(20),
  genre VARCHAR(20),
  price DOUBLE
);

CREATE TABLE authors (
  author_id VARCHAR(20),
  author_name VARCHAR(30),
  nationality VARCHAR(50)
);

CREATE TABLE customers (
  customer_id VARCHAR(20),
  customer_name VARCHAR(30),
  email VARCHAR(50),
  phone VARCHAR(11)
);

-- 4. Insert sample data (1 record each as an example)
INSERT INTO books VALUES ('1', 'A Game of Thrones', '1', 'Fantasy', 450.00);
INSERT INTO authors VALUES (1, 'George R. R. Martin', 'American');
INSERT INTO customers VALUES ('1', 'Arya Stark', 'arya@winterfell.com', '01234567890');

-- 5. Update data
UPDATE books SET price = 230 WHERE book_id = '1';
UPDATE customers SET email = 'arya.stark@got.com' WHERE customer_name = 'Arya Stark';
UPDATE authors SET nationality = 'Indian' WHERE author_id = '1';

-- 6. Delete data (example: delete one book by title)
DELETE FROM books WHERE title = 'A Game of Thrones';

-- 7. Retrieve data (example: join authors and books)
SELECT authors.author_name, books.title
FROM books
JOIN authors ON books.author_id = authors.author_id;
