package GUIExample;

import Model.Card;
import Model.Dealer;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private JLabel userLabel;
    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JButton button;

    private String onlyPassword = "password";

    private class PasswordButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String username = userField.getText();
            char[] password = passwordField.getPassword();

            if (new String(password).equals(onlyPassword)) {

                Dealer dealer = new Dealer();
                Player player = new Player(username, password.toString(), 1000);
                setVisible(false);
                ShuffleFrame shuffleFrame = new ShuffleFrame(dealer, player);
                shuffleFrame.run();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password", "Invalid username or password",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public LoginPanel() {

        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(300, 150));

        userLabel = new JLabel("Username");
        userField = new JTextField("");
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(99);

        button = new JButton("Login");
        button.addActionListener(new PasswordButtonListener());

        setLayout(new GridLayout(3, 2));
        add(userLabel);
        add(userField);
        add(passwordLabel);
        add(passwordField);

        add(button);

    }

    public void paintComponent(Graphics g) {
    }

}
