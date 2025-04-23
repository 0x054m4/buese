import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private Status status;

    public User(int userID) {
        this.userID = userID;
    }

    public User(String name, String email, String password, String role, Status status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        ACTIVE, DISABLED
    }
<<<<<<< HEAD

    public void login() {

    }

    public void signUp() {
        String connectionURL = "jdbc:derby://localhost:1527/group51";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO STUDENT (ID, NAME) VALUES (gggg, 'demo3')";
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");

        }
    }
=======
>>>>>>> 98c0990f957ee17449e9f10fec4fcc625212f356
}