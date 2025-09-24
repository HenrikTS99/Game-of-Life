import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MyPanel extends JPanel {
    private final Board board;
    private int pixelSize = 2;

    public MyPanel(Board board) {
        this.board = board;
        this.setPreferredSize(new Dimension(
                board.getBoardLength() * pixelSize,
                board.getBoardHeight() * pixelSize
        ));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean[][] grid = board.getGrid();
        for (int row = 0; row < board.getBoardHeight(); row++) {
            for (int col = 0; col < board.getBoardLength(); col++) {
                g.setColor(grid[row][col] ? Color.WHITE : Color.BLACK);
                g.fillRect(col * pixelSize, row * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
