import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTypeSelector extends JFrame {

    public LoginTypeSelector() {
        setTitle("Select Login Type");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);

        // Title Label
        JLabel titleLabel = new JLabel("Choose Login Type", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(40, 40, 40));
        
        // Create buttons
        JButton studentButton = createStyledButton("Student");
        JButton librarianButton = createStyledButton("Librarian");

        // Add action listeners
        studentButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Student Login selected");
            // new StudentLoginFrame();
        });

        librarianButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Librarian Login selected");
            // new LibrarianLoginFrame();
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 20, 20));
        buttonPanel.setOpaque(false);
        buttonPanel.add(studentButton);
        buttonPanel.add(librarianButton);

        // Main Layout
        setLayout(new BorderLayout(20, 20));
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        getContentPane().setBackground(new Color(245, 245, 245)); // Light background

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 20));
        button.setBackground(new Color(70, 130, 180)); // Steel Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static void main(String[] args) {
        // Use system look and feel for a better style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(LoginTypeSelector::new);
    }
}
