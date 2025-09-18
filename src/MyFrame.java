import javax.swing.*;
import java.awt.*;

public class MyFrame {

    private JFrame frame;

    public MyFrame(MyPanel panel){
        this.frame = new JFrame();
        this.frame.setTitle("Game of Life");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setSize(500, 500);
        this.frame.setLocationRelativeTo(null);
        this.frame.getContentPane().setBackground(Color.black);

        this.frame.add(panel);

        this.frame.setVisible(true);
    }
}
