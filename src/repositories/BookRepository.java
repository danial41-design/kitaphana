import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private IDB db;

    public BookRepository(IDB db) {
        this.db = db;
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM librarydb ORDER BY id ASC";
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("quantity")
                ));
            }
        }
        return books;
    }

    // Добавление новой книги
    public void addNewBook(String title, String author, int year, int quantity) throws SQLException {
        String query = "INSERT INTO librarydb (title, author, year, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, year);
            pstmt.setInt(4, quantity);
            pstmt.executeUpdate();
        }
    }

    public void deleteBook(String bookTitle) throws SQLException {
        String query = "DELETE FROM librarydb WHERE title = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookTitle);
            pstmt.executeUpdate();
        }
    }

    public void takeBook(String bookTitle) throws SQLException {
        String query = "UPDATE librarydb SET quantity = quantity - 1 WHERE title = ? AND quantity > 0";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookTitle);
            pstmt.executeUpdate();
        }
    }

    public void returnBook(String bookTitle) throws SQLException {
        String query = "UPDATE librarydb SET quantity = quantity + 1 WHERE title = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookTitle);
            pstmt.executeUpdate();
        }
    }
}

