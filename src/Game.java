import java.util.Timer;
import java.util.TimerTask;

public class Game {

    Board board = new Board();

    public void run() {

        MyPanel myPanel = new MyPanel(board.getBoardHeight(), board.getBoardLength());
        MyFrame myFrame = new MyFrame(myPanel);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = 200000;
            @Override
            public void run() {
                if (counter > 0) {
                    // board.printBoard();
                    board.updateBoard();
                    myPanel.updatePanel(board.getGrid());
                    counter--;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 100);
    }
}
