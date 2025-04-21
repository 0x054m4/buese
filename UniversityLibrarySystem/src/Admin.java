public class Admin extends User {

    public Admin(int userID) {
        super(userID);
    }
    public Admin(String name, String email, String password, String role, Status status) {
        super(name, email, password, role, status);
    }
    public void generateReport() {
        System.out.println("");
        
    }
}