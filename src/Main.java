//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        MyPanel myPanel = new MyPanel();
        MyFrame myFrame = new MyFrame(myPanel);
        Board board = new Board();
        board.printBoard();

    }
}