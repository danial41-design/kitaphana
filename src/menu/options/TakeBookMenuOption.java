package menu.options;

import menu.MenuOption;
import controllers.BookController;
import java.util.Scanner;

public class TakeBookMenuOption implements MenuOption {
    private BookController bookController;

    public TakeBookMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to take: ");
        String title = scanner.nextLine();
        bookController.takeBook(title); 
    }

    @Override
    public String getDescription() {
        return "Take a book";
    }
}
