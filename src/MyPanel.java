import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MyPanel extends JPanel {
    private JPanel [][] pixels;

    public MyPanel(int boardHeight, int boardLength) {
        this.setBackground(Color.blue);
        GridLayout gridlayout = new GridLayout(boardHeight, boardLength);
        this.setLayout(gridlayout);
        this.setPreferredSize(new Dimension(boardLength * 5, boardHeight * 5));
        createPixelArray(boardHeight, boardLength);
    }

    // Fills pixels array with colored 'pixels'/JFrames and adds them to the main panel
    private void createPixelArray(int boardHeight, int boardLength) {
        this.pixels = new JPanel[boardHeight][boardLength];
        // Create pixel frames for each cell, add to main panel and pixels array
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardLength; col++) {
                JPanel pixel = new JPanel(new BorderLayout());
                pixel.setBackground(Color.black);
                this.pixels[row][col] = pixel;
                // Add each pixel to the main panel
                this.add(pixel);
            }
        }
    }

    // TODO: Optimize: draw pixels with paintComponent?
    // Update the color of each pixel/cell and repaint panel
    public void updatePanel(boolean [][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col]) {
                    pixels[row][col].setBackground(Color.white);
                } else {
                    pixels[row][col].setBackground(Color.black);
                }
            }
        }
        this.repaint();
    }
}
