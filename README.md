Library data management

### Project Overview
Library data management is a library management application developed in Java. It allows users to register, log in, browse available books, borrow books, and manage their profiles. The application interacts with a PostgreSQL database to store and retrieve information about users and books.

### Key Features
1. User Management
   - User registration with name, surname, email, password, and phone number.
   - Secure login authentication.
   - Password change functionality.
   - Profile update options (name, surname, phone number).
   - User deletion.

2. Book Management
   - View all books and available books in the library.
   - Ability to borrow books.
   - Automatic status update of books after borrowing.

3. Security
   - Password hashing for security.
   - Email uniqueness check to prevent duplicate registrations.
   - Validation of phone numbers.

### Project Structure
kitaphana/
├── src/
│    ├── Main.java
│    ├── models/
│    │   ├── User.java
│    │   ├── Book.java
│    ├── Interfaces/
│    │   ├── IUserService.java
│    ├── Implementation/
│    │   ├── UserService.java
│    ├── Repository/
│    │   ├── UserRepository.java
│    │   ├── BookRepository.java
│    ├── Controller/
│    │   ├── UserController.java
├── README.md

### Technologies Used
- Java (core logic and OOP).
- JDBC (Java Database Connectivity) for database interaction.
- PostgreSQL as the relational database.

### How to Run the Project
1. Make sure you have Java and PostgreSQL installed.
2. Create a database and configure the connection in the configuration file.
3. Compile and run the project using the following commands:
     javac src/Main.java
   java src/Main
   
