import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupApp {

    private JFrame frame;
    private JPanel currentPanel;
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField signupUsernameField;
    private JPasswordField signupPasswordField;

    public LoginSignupApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Create login panel
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        JLabel lblLoginUsername = new JLabel("Username:");
        loginPanel.add(lblLoginUsername);
        loginUsernameField = new JTextField();
        loginPanel.add(loginUsernameField);
        JLabel lblLoginPassword = new JLabel("Password:");
        loginPanel.add(lblLoginPassword);
        loginPasswordField = new JPasswordField();
        loginPanel.add(loginPasswordField);
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginPanel.add(btnLogin);
        JButton btnSwitchToSignup = new JButton("Switch to Signup");
        btnSwitchToSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSignupPanel();
            }
        });
        loginPanel.add(btnSwitchToSignup);

        // Create signup panel
        signupPanel = new JPanel();
        signupPanel.setLayout(new GridLayout(3, 2));
        JLabel lblSignupUsername = new JLabel("Username:");
        signupPanel.add(lblSignupUsername);
        signupUsernameField = new JTextField();
        signupPanel.add(signupUsernameField);
        JLabel lblSignupPassword = new JLabel("Password:");
        signupPanel.add(lblSignupPassword);
        signupPasswordField = new JPasswordField();
        signupPanel.add(signupPasswordField);
        JButton btnSignup = new JButton("Signup");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });
        signupPanel.add(btnSignup);
        JButton btnSwitchToLogin = new JButton("Switch to Login");
        btnSwitchToLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginPanel();
            }
        });
        signupPanel.add(btnSwitchToLogin);

        // Initially show login panel
        currentPanel = loginPanel;
        frame.getContentPane().add(currentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void login() {
        String username = loginUsernameField.getText();
        String password = new String(loginPasswordField.getPassword());
        // Add your login logic here
        System.out.println("Login: Username - " + username + ", Password - " + password);
    }

    private void signup() {
        String username = signupUsernameField.getText();
        String password = new String(signupPasswordField.getPassword());
        // Add your signup logic here
        System.out.println("Signup: Username - " + username + ", Password - " + password);
    }

    private void showSignupPanel() {
        frame.getContentPane().remove(currentPanel);
        currentPanel = signupPanel;
        frame.getContentPane().add(currentPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showLoginPanel() {
        frame.getContentPane().remove(currentPanel);
        currentPanel = loginPanel;
        frame.getContentPane().add(currentPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginSignupApp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
