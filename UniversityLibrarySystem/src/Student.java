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
//        this.userID = studentCounter++;
    }
    
    public void setBorrowList(ArrayList<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public ArrayList<Borrow> getBorrowList() {
        return borrowList;
    }
    
    public boolean signUp(String name, String email, String password) {
        String connectionURL = "jdbc:derby://localhost:1527/group51";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO STUDENT (ID, NAME, EMAIL, PASSWORD, STATUS) VALUES (3, 'demo3', 'fsdfsd', 'fsdfds', 1 )"; 
//            String sql = String.format("INSERT INTO STUDENT (ID, NAME, EMAIL, PASSWORD, STATUS)"
//                    + " VALUES (123, '%s', '%s', '%s', 1)", 
//                    name, email, password);
            st.executeUpdate(sql);
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
            return false;
        }
    }    
}