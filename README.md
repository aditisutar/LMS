# LMS
This project is a Library Management System implemented in Java.

Features
Add, update, and delete books
Add, update, and delete users
Borrow and return books
Search for books by ISBN, title, or author
Track available and borrowed books
Log all operations


Entities
Book entity
User entity
Transaction entity


Services
Book service- It  is responsible for managing book-related operations like add/update/delete books, 
              search a book, list of available/borrowed books
User service- It is responsible for managing user-related operations like add/update/delete user.
Transaction service- Handles borrowing/returning of book and maintains a history of transactions.


The code provided follows several SOLID principles
1. Single Responsibility Principle (SRP)
BookService, UserService, and TransactionService each have a single responsibility:

2. Open/Closed Principle (OCP)
By using interfaces (LibraryService, BookService, UserService, TransactionService), the system allows
new functionalities to be added by implementing these interfaces.

4. Liskov Substitution Principle (LSP)
The BookService interface and its implementation BookServiceImpl follow this principle. You can replace BookServiceImpl
with another implementation of BookService without affecting the system's behavior and similarly UserService and
TransactionService

4. Interface Segregation Principle (ISP)
The code defines multiple specific interfaces (BookService, UserService, TransactionService, LibraryService,
SearchFunctionality) rather than one large interface. Each interface has methods relevant to its specific purpose.

6. Dependency Inversion Principle (DIP)
High-level modules (e.g., Book) depend on abstractions (interfaces like BookService, UserService, TransactionService)
rather than concrete implementations.
![Class Diagram](https://github.com/user-attachments/assets/37a13845-890f-4c08-9825-71121cf6e4ff)


