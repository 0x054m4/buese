import java.util.ArrayList;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

public class Student extends User{
    private static int studentCounter = 0;
    private ArrayList<Borrow> borrowList;

    public Student(int userID) {
        super(userID);
        this.borrowList = new ArrayList<Borrow>();
        studentCounter++;
    } 
 
    public Student(String name, String email, String password, String role, Status status, ArrayList<Borrow> borrowList) {
        super(name, email, password, role, status);
        this.borrowList = borrowList;
        studentCounter++;
    }
    
    public void setBorrowList(ArrayList<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public ArrayList<Borrow> getBorrowList() {
        return borrowList;
    }
    
    public void signUp() {
        String connectionURL = "jdbc:derby://localhost:1527/group51";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO STUDENT (ID, NAME, EMAIL, PASSWORD) VALUES (studentCounter, )";
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");

        }
    }
    
}