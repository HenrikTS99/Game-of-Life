import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private final JButton pauseButton;
    private final Game game;

    public TopPanel(Game game) {
        this.game = game;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.pauseButton = new JButton("Pause");
        pauseButton.addActionListener(this);
        this.add(pauseButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==pauseButton) {
            if (game.isRunning()) {
                game.pause();
                pauseButton.setText("Resume");
            } else {
                game.resume();
                pauseButton.setText("Pause");
            }
        }
    }
}
