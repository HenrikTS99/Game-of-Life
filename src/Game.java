import javax.swing.Timer;

public class Game {
    private final Board board;
    private final MyPanel myPanel;
    private final TopPanel topPanel;
    private final Timer timer;
    private int delay = 10;

    public Game() {
        this.board = new Board();
        myPanel = new MyPanel(board);

        timer = new Timer(delay, e -> {
            board.updateBoard();
            myPanel.repaint();
        });

        topPanel = new TopPanel(this);
    }

    public void run() {
        MyFrame myFrame = new MyFrame(myPanel, topPanel);
        timer.start();
    }

    public void pause() { timer.stop(); }
    public void resume() { timer.start(); }
    public boolean isRunning() { return timer.isRunning(); }
}
