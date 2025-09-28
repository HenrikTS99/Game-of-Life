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
         double minLog = Math.log(1);
         double maxLog = Math.log(1001);

         // Map currentDelay to 0–1 logarithmic scale
         double normalizedStartValue = (Math.log(currentDelay) - minLog) / (maxLog - minLog);
         // Map to slider range 1–100
         int sliderStartValue = (int) Math.round(normalizedStartValue * 100);

         JSlider delaySlider = new JSlider(1, 100, sliderStartValue);
         delaySlider.addChangeListener(e -> {
             int sliderValue = delaySlider.getValue();
             double normalizedSliderValue = (double) sliderValue / 100.00; // normalize to 0-1
             int logValue = (int) Math.exp(minLog + normalizedSliderValue * maxLog);
             game.setDelay(logValue);
             delayLabel.setText("Delay: " + logValue + " ms");
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
