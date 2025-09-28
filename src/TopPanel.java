import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private final JButton pauseButton;
    private final JButton nextFrameButton;
    private final JButton clearButton;
    private final JButton randomizeButton;
    private final Game game;
    private final JLabel delayLabel = new JLabel();

    public TopPanel(Game game) {
        this.game = game;
        // Create and add buttons and sliders
        nextFrameButton = createButton("Next Frame");
        pauseButton = createButton("Pause");
        nextFrameButton.setVisible(false);
        createDelaySlider(game.getDelay());
        clearButton = createButton("Clear");
        randomizeButton = createButton("Randomize");

    }

    private JButton createButton(String name) {
        JButton button = new JButton(name);
        button.addActionListener(this);
        this.add(button);
        return button;
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
