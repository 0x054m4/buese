
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
 
 
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

