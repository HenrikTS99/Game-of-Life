import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
    private final Board board;
    private final int pixelSize = 5;

    public MyPanel(Board board) {
        this.board = board;
        this.setPreferredSize(new Dimension(
                board.getBoardLength() * pixelSize,
                board.getBoardHeight() * pixelSize
        ));
        // Mouse clicks draws
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawAt(e);
            }
        });

        // Mouse dragging drawing
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawAt(e);
            }
        });
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

    private void drawAt(MouseEvent e) {
        int coordX = e.getX() / pixelSize;
        int coordY = e.getY() / pixelSize;
        // Do not draw out of bounds
        if (coordX < 0 || coordY < 0 || coordX >= board.getBoardLength() || coordY >= board.getBoardHeight()) {
            return;
        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            board.setCell(coordX, coordY, true);
        } else if (SwingUtilities.isRightMouseButton(e)){
            board.setCell(coordX, coordY, false);
        }
        repaint();
    }
}
