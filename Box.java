package view.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Box extends JComponent {
    private final int value = 10;
    private int row;
    private int col;

    public Box(int width, int height) {
        this.setSize(width, height);
        this.setLocation(5, 5);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public int getValue() {
        return value;
    }
}
