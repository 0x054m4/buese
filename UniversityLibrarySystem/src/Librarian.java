public class Librarian extends User {
    public Librarian(int userID) {
        super(userID);
    }
    public Librarian(String name, String email, String password, String role, Status status) {
        super(name, email, password, role, status);
    }
}
