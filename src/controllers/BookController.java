package controllers;

import models.Book;
import repositories.BookRepository;
import repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public BookController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void searchBooks(String title, String author, String category) {
        try {
            List<Book> books = bookRepository.searchBooks(title, author, category);
            if (books.isEmpty()) {
                System.out.println("No books found.");
            } else {
                books.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Error while searching for books: " + e.getMessage());
        }
    }

    // Метод для фильтрации книг по статусу
    public void filterBooksByStatus(String status) {
        try {
            List<Book> books = bookRepository.filterBooksByStatus(status);
            if (books.isEmpty()) {
                System.out.println("No books with status: " + status);
            } else {
                books.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Error while filtering books: " + e.getMessage());
        }
    }

    public void addNewBook(String title, String author, int year, int quantity) throws SQLException {
        bookRepository.addNewBook(title, author, year, quantity);
    }

    public void deleteBook(String title) throws SQLException {
        bookRepository.deleteBook(title);
    }

    public void showAllBooks() {
        try {
            List<Book> books = bookRepository.getAllBooks();
            if (books.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching books: " + e.getMessage());
        }
    }

    public void takeBook(String name, String surname, String bookTitle) throws SQLException {
        // Проверяем, есть ли книга в базе
        if (!bookRepository.isBookAvailable(bookTitle)) {
            System.out.println("This book is not available.");
            return;
        }

        // Здесь вызываем метод для добавления книги пользователю
        // Предположим, что у нас уже есть метод для обновления поля bookTitle в таблице users
        addUserBook(name, surname, bookTitle);

        // Уменьшаем количество книги в базе на 1
        bookRepository.takeBook(bookTitle);

        System.out.println("Book taken successfully!");
    }

    private void addUserBook(String name, String surname, String bookTitle) throws SQLException {
        // Здесь вызовем метод в репозитории, чтобы обновить bookTitle у пользователя
        // Пример:
        // userRepository.addBookToUser(name, surname, bookTitle);
    }

    public void returnBook(String name, String surname, String bookTitle) throws SQLException {
        // Проверка, существует ли пользователь
        if (!userRepository.userExists(name, surname)) {
            System.out.println("User not found.");
            return;
        }

        // Проверка, есть ли у пользователя эта книга
        String existingBook = userRepository.getBookTitleByUser(name, surname);
        if (existingBook == null || !existingBook.equals(bookTitle)) {
            System.out.println("This user does not have this book.");
            return;
        }

        // Очищаем booktitle у пользователя
        userRepository.deleteBookTitle(name, surname);
        bookRepository.returnBook(bookTitle);
        System.out.println("Book successfully returned!");
    }

    // Метод для проверки доступности книги
    public boolean isBookAvailable(String bookTitle) throws SQLException {
        return bookRepository.isBookAvailable(bookTitle);
    }
}

