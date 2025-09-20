import java.util.Timer;
import java.util.TimerTask;

public class Game {

    Board board = new Board();

    public void run() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            int counter = 20;
            @Override
            public void run() {
                if (counter > 0) {
                    board.printBoard();
                    board.updateBoard();
                    counter--;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1300, 400);
    }
}
