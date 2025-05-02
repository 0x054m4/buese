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
public class AdminController {
    public enum Status {
        ACTIVE, DISABLED
    }
    
    Admin admin;
    private int userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private Status status;
    
    // Default constructor
    public AdminController() {
        this.userID = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.role = "admin";
        this.status = Status.ACTIVE;
        this.admin = new Admin(this.userID, this.name, this.email, this.password, this.role, this.status);
    }
    
    // Constructor for login credentials
    public AdminController(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = "admin";
        // Other fields will be populated from database if login is successful
    }
    
    // Full parameterized constructor
    public AdminController(int userID, String name, String email, String password, Status status) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "admin";
        this.status = status;
        this.admin = new Admin(this.userID, this.name, this.email, this.password, this.role, this.status);
    }
    
    // Method to handle login
    public boolean login() {
        // Implement database authentication logic here
        // For now, return true for testing
        return true;
    }
}
