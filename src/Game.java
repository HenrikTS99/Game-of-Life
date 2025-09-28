import javax.swing.Timer;

public class Game {
    private final Board board;
    private final MyPanel myPanel;
    private final TopPanel topPanel;
    private final Timer timer;
    private int delay = 100;

    public Game() {
        this.board = new Board();
        myPanel = new MyPanel(board);

        timer = new Timer(delay, e -> {
            nextFrame();
        });
        topPanel = new TopPanel(this);
    }

    public void run() {
        new MyFrame(myPanel, topPanel);
        timer.start();
    }

    public void setDelay(int newDelay) {
        this.delay = newDelay;
        timer.setDelay(newDelay);
    }

    public void nextFrame() {
        board.updateBoard();
        topPanel.updateCountLabel(board.getCount());
        myPanel.repaint();
    }

    public void clearBoard() {
        board.resetBoard();
        myPanel.repaint();
    }

    public void randomizeBoard() {
        board.randomizeBoard();
        myPanel.repaint();
    }

    public void pause() { timer.stop(); }
    public void resume() { timer.start(); }
    public boolean isRunning() { return timer.isRunning(); }
    public int getDelay() { return delay; }
}
