import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {


    public MyPanel(int boardHeight, int boardLength) {
        this.setBackground(Color.blue);
        GridLayout gridlayout = new GridLayout(boardHeight, boardLength);
        this.setLayout(gridlayout);
    }

    //TODO: improve how panel is updated/drawn
    public void updatePanel(boolean [][] grid) {
        this.removeAll();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                JPanel square = new JPanel( new BorderLayout());
                if (grid[row][col]) {
                    square.setBackground(Color.white);
                } else {
                    square.setBackground(Color.black);
                }
                this.add(square);
            }
        }
        this.revalidate();
        this.repaint();
    }
}
