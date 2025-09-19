import java.util.Arrays;

public class Board {

    private boolean [][] grid = new boolean[10][10];
    private final int boardHeight = grid.length;
    private final int boardLength = grid[0].length;

    public Board() {
        resetBoard();
        grid[5][5] = true;
        grid[5][6] = true;
        grid[6][5] = true;
        grid[6][6] = true;
        System.out.println(getNeighbours(6, 6));
    }

    private void resetBoard() {
       for (boolean[] row : grid) {
           Arrays.fill(row, false);
       }
    }

    public int getNeighbours(int selectedCol, int selectedRow) {
        int count = 0;

        for (int col = -1; col <= 1; col++) {
            for (int row = -1; row <= 1; row++) {
                int currCol = selectedCol + col;
                int currRow = selectedRow + row;

                // Skip itself
                if (col == 0 && row == 0) continue;

                // Skip if out of bounds
                if (currCol < 0 || currCol >= boardLength
                        || currRow < 0 || currRow >= boardHeight) continue;

                if (grid[currRow][currCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBoard() {
        System.out.print("     ");
        for (int col = 1; col <= boardLength; col++) {
            System.out.print(col + "   ");
        }

        System.out.println();
        System.out.println("   " + "|---".repeat(boardLength) + "|");

        for (char row = 0, rowName = 'A'; row < boardHeight; row++, rowName++) {
            // Print row letters
            System.out.print(" " + rowName);

            for (int col = 0; col < boardLength; col++) {
                System.out.print(" | ");
                if (grid[row][col]) {
                    System.out.print('X');
                } else {
                    System.out.print(' ');
                }
            }

            System.out.println(" |");
            System.out.println("   " + "|---".repeat(boardLength) + "|");
        }
    }
}
