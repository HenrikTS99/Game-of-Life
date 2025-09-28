import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private JButton pauseButton;
    private final Game game;
    private JLabel delayLabel = new JLabel();

    public TopPanel(Game game) {
        this.game = game;
        // Pause button
        createPauseButton();
        // Speed slider
        createDelaySlider(game.getDelay());
    }
     private void createPauseButton() {
         pauseButton = new JButton("Pause");
         pauseButton.addActionListener(this);
         this.add(pauseButton);
     }

     private void createDelaySlider(int currentDelay) {
         JSlider delaySlider = new JSlider(1, 100, currentDelay);
         delaySlider.addChangeListener(e -> {
             int newDelay = delaySlider.getValue();
             game.setDelay(newDelay);
             delayLabel.setText("Delay: " + newDelay + " ms");
         });
         this.add(new JLabel("Speed:"));
         this.add(delaySlider);
         delayLabel.setText("Delay: " + currentDelay + " ms");
         this.add(delayLabel);

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
