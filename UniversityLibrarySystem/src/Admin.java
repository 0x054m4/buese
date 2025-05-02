import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author omarh
 */
public class Admin {
    private int userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private AdminController.Status status;
    
    // Constructor
    public Admin(int userID, String name, String email, String password, String role, AdminController.Status status) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }
    
    // Getters and setters
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public AdminController.Status getStatus() {
        return status;
    }
    
    public void setStatus(AdminController.Status status) {
        this.status = status;
    }
    
    public boolean login(){
        try {
            // Create connection using DBManager
            Connection connection = DBManager.openCon();
            
            // Prepare SQL query to check admin credentials
            String query = "SELECT * FROM ADMIN WHERE EMAIL = ? AND PASSWORD = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            // Execute query and check results
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Login successful, update admin info from database
                userID = rs.getInt("ID");
                name = rs.getString("NAME");
                status = AdminController.Status.valueOf(rs.getString("STATUS"));
                
                // Close resources
                rs.close();
                stmt.close();
                DBManager.closeCon(connection);
                return true;
            }
            
            // Close resources
            rs.close();
            stmt.close();
            DBManager.closeCon(connection);
            return false;
            
        } catch (SQLException e) {
            System.out.println("Database error during admin login: " + e.getMessage());
            return false;
        }
    }
}