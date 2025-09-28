import java.util.Arrays;
import java.util.Random;

public class Board {

    private boolean [][] grid = new boolean[250][500];
    private final int boardHeight = grid.length;
    private final int boardLength = grid[0].length;
    private int updateCount = 0;

    public Board() {
        resetBoard();
        randomizeBoard();
    }

    public void resetBoard() {
       for (boolean[] row : grid) {
           Arrays.fill(row, false);
       }
       updateCount = 0;
    }

    public void randomizeBoard() {
        Random random = new Random();
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardLength; col++) {
                grid[row][col] = random.nextBoolean();
            }
        }
    }

    public void setCell(int x, int y, Boolean bool) {
        grid[y][x] = bool;
    }

    public void updateBoard() {
        int currNeighbours;
        boolean[][] newGrid = clone2DBoolArray(grid);

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardLength; col++) {
                currNeighbours = getNeighbours(row, col);
                // If cell is alive with 2-3 neighbours, it lives on (no need to code this)
                // If cell is alive and has fewer than two neighbours or more than 3 neighbours, it dies
                if ((grid[row][col]) && (currNeighbours < 2 || currNeighbours > 3)) {
                    newGrid[row][col] = false;
                }
                // If cell is dead and has exactly three live neighbours, it becomes alive
                if (!grid[row][col] && currNeighbours == 3) newGrid[row][col] = true;
            }
        }
        grid = newGrid;
        updateCount++;
    }

    // Creates a deep copy of a 2D boolean array
    public static boolean[][] clone2DBoolArray(boolean[][] array) {
        boolean[][] newArray = new boolean[array.length][];
        // Clone each row (inner array)
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i].clone();
        }
        return newArray;
    }

    public boolean[][] getGrid() { return grid; }
    public int getCount() { return updateCount; }

    public int getBoardHeight() { return this.boardHeight; }
    public int getBoardLength() { return this.boardLength; }

    // Returns number of all alive neighbours of specified cell
    public int getNeighbours(int selectedRow, int selectedCol) {
        int count = 0;

        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                int currRow = selectedRow + row;
                int currCol = selectedCol + col;

                // Skip itself
                if (row == 0 && col == 0) continue;

                // Skip if out of bounds
                if (currRow < 0 || currRow >= boardHeight
                    || currCol < 0 || currCol >= boardLength) continue;

                if (grid[currRow][currCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    // For debug. Prints board in terminal, each cell displayed as a number representing total neighbours it has
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
                    System.out.print(getNeighbours(row, col));
                } else {
                    System.out.print(' ');
                }
            }

            System.out.println(" |");
            System.out.println("   " + "|---".repeat(boardLength) + "|");
        }
    }
}
