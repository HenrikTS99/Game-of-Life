import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private JButton pauseButton;
    private JButton nextFrameButton;
    private JButton clearButton;
    private JButton randomizeButton;
    private final Game game;
    private JLabel delayLabel = new JLabel();

    public TopPanel(Game game) {
        this.game = game;
        // Create and add buttons and sliders
        createPauseButton();
        createNextFrameButton();
        createDelaySlider(game.getDelay());
        createClearButton();
        createRandomizeButton();

    }
     private void createPauseButton() {
         pauseButton = new JButton("Pause");
         pauseButton.addActionListener(this);
         this.add(pauseButton);
     }

     private void createClearButton() {
         clearButton = new JButton("Clear");
         clearButton.addActionListener(this);
         this.add(clearButton);
     }
     private void createRandomizeButton() {
         randomizeButton = new JButton("Randomize");
         randomizeButton.addActionListener(this);
         this.add(randomizeButton);
     }
     private void createNextFrameButton() {
        nextFrameButton = new JButton("Next Frame");
        nextFrameButton.addActionListener(this);
        nextFrameButton.setVisible(false);
        this.add(nextFrameButton);
     }

     private void createDelaySlider(int currentDelay) {
         double minLog = Math.log(1); // min delay
         double maxLog = Math.log(1001); // max delay

         double normalizedStartValue = (Math.log(currentDelay) - minLog) / (maxLog - minLog); // normalize to 0-1
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
         // Add text labels and slider
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
                nextFrameButton.setVisible(true);
                pauseButton.setText("Resume");
            } else {
                game.resume();
                nextFrameButton.setVisible(false);
                pauseButton.setText("Pause");
            }
        }
        if (e.getSource()==nextFrameButton) {
            game.nextFrame();
        }
        if (e.getSource()==clearButton) {
            game.clearBoard();
        }
        if (e.getSource()==randomizeButton) {
            game.randomizeBoard();
        }
    }
}
