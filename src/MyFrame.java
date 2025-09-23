import javax.swing.*;
import java.awt.*;

public class MyFrame {

    private JFrame frame;

    public MyFrame(MyPanel panel){
        this.frame = new JFrame();
        this.frame.setTitle("Game of Life");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null); // Center
        this.frame.getContentPane().setBackground(Color.black);

        this.frame.add(panel);
        this.frame.pack(); // Adjust frame size to fit panel
        this.frame.setVisible(true);
    }
}
