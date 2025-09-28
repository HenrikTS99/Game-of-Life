import javax.swing.*;
import java.awt.*;

public class MyFrame {

    private JFrame frame;

    public MyFrame(MyPanel panel, TopPanel topPanel){
        this.frame = new JFrame();
        this.frame.setTitle("Game of Life");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        // Menu bar
        this.frame.add(topPanel, BorderLayout.NORTH);

        // Cell display
        this.frame.add(panel, BorderLayout.CENTER);
        this.frame.pack(); // Adjust frame size to fit panel
        this.frame.setLocationRelativeTo(null); // Center

        this.frame.setVisible(true);
    }
}
