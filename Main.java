import view.level.LevelFrame;
import view.login.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(400,300);
            loginFrame.setVisible(true);
            LevelFrame levelFrame = new LevelFrame(500,200);
            levelFrame.setVisible(false);
            loginFrame.setLevelFrame(levelFrame);
        });
    }
}
