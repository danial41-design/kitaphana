package menu.options;

import menu.MenuOption;
import controllers.BookController;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBookMenuOption implements MenuOption {
    private BookController bookController;

    public DeleteBookMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to delete: ");
        String title = scanner.nextLine();

        try {
            // Проверка, существует ли книга в базе
            if (bookController.isBookAvailable(title)) {
                bookController.deleteBook(title);  // Если книга существует, то удаляем
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("This book does not exist in the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error while interacting with the database: " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Delete a book";
    }
}
