import java.util.ArrayList;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

/**
 *
 * @author omarh
 */
public class LibrarianController {
    public enum Status {
        ACTIVE, DISABLED
    }
    
    Librarian librarian;
    private int userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private Status status;
    
    // Default constructor
    public LibrarianController() {
        this.userID = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.role = "librarian";
        this.status = Status.ACTIVE;
        this.librarian = new Librarian(this.userID, this.name, this.email, this.password, this.role, this.status);
    }
    
    // Constructor for login credentials
    public LibrarianController(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = "librarian";
        // Other fields will be populated from database if login is successful
    }
    
    // Full parameterized constructor
    public LibrarianController(int userID, String name, String email, String password, Status status) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "librarian";
        this.status = status;
        this.librarian = new Librarian(this.userID, this.name, this.email, this.password, this.role, this.status);
    }
    
    // Method to handle login
    public boolean login() {
        // Implement database authentication logic here
        // For now, return true for testing
        return true;
    }
}
