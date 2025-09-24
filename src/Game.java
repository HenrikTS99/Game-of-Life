import java.util.Timer;
import java.util.TimerTask;

public class Game {

    Board board = new Board();

    public void run() {

        MyPanel myPanel = new MyPanel(board);
        MyFrame myFrame = new MyFrame(myPanel);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                board.updateBoard();
                myPanel.repaint();
            }
        };
        timer.scheduleAtFixedRate(task, 2000, 1);
    }
}
