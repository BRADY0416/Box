package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private JButton registerBtn;
    private LevelFrame levelFrame;
    private UserManager userManager=new UserManager();

    public LoginFrame(int width, int height) {
        this.setTitle("Login Frame");
        this.setLayout(null);
        this.setSize(width, height);
        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 20), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");
        username = FrameUtil.createJTextField(this, new Point(120, 20), 200, 40);
        password = FrameUtil.createJTextField(this, new Point(120, 80), 200, 40);

        registerBtn =FrameUtil.createButton(this, "register", new Point(160, 140), 100, 40);
        submitBtn = FrameUtil.createButton(this, "login", new Point(40, 140), 100, 40);
        resetBtn = FrameUtil.createButton(this, "Reset", new Point(280, 140), 100, 40);

        submitBtn.addActionListener(e -> {
            if(userManager.loginUser(username.getText(), password.getText())) {
                System.out.println("Username = " + username.getText());
                System.out.println("Password = " + password.getText());
                if (this.levelFrame != null) {
                    this.levelFrame.setVisible(true);
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //todo: check login info

        });
        registerBtn.addActionListener(e -> {
            if(userManager.registerUser(username.getText(), password.getText())) {
                System.out.println("Username = " + username.getText());
                System.out.println("Password = " + password.getText());
                if (this.levelFrame != null) {
                    this.levelFrame.setVisible(true);
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //todo: check login info

        });
        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }
}
