import java.util.ArrayList;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

public class Student extends User{
    private ArrayList<Borrow> borrowList;

    public Student(int userID) {
        super(userID);
        this.borrowList = new ArrayList<Borrow>();
    } 
 
    public Student(String name, String email, String password, String role, UserStatus.Status status, ArrayList<Borrow> borrowList) {
        super(name, email, password, role, status);
        this.borrowList = borrowList;
    }

    public boolean login(){
        String q = "SELECT * FROM STUDENT WHERE EMAIL = '" + this.getEmail() + "' AND PASSWORD = '" + this.getPassword() + "'";
        final ResultSet res = DBManager.query(q);
        if(res != null) {
            try {
                if (res.next()) {
                    this.setUserID(res.getInt("ID"));
                    this.setName(res.getString("NAME"));
                    this.setEmail(res.getString("EMAIL"));
                    this.setPassword(res.getString("PASSWORD"));
                    this.setStatus(UserStatus.Status.valueOf(res.getString("STATUS")));
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return false;
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
            String currID = "SELECT ID FROM STUDENT ORDER BY DESC FETCH FIRST 1 ROWS ONLY";
            ResultSet rs = st.executeQuery(currID);
            int nextID = Integer.parseInt(currID);
            String sql = String.format("INSERT INTO STUDENT (ID, NAME, EMAIL, PASSWORD, STATUS)"
                    + " VALUES ('%d', '%s', '%s', '%s', TRUE)", 
                    nextID, name, email, password);
            st.executeUpdate(sql);
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connect failed ! " + ex.getMessage());
            return false;
        }
    }    
}