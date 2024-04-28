package GUIExample;

import Controller.GameController;
import View.GUIView;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginPanel panel = new LoginPanel();

        add(panel);
        pack();
        setVisible(true);
    }
}
