import java.util.Random;
import java.util.Scanner;

public class PennyPitch {
    private Main[][] board;
    private int score;
    private int throwCounter;

    public PennyPitch() {
        // Initialize the game board
        board = new Main[5][5];
        board[0] = new Main[]{new Main(1), new Main(1), new Main(1), new Main(1), new Main(1)};
        board[1] = new Main[]{new Main(1), new Main(2), new Main(2), new Main(2), new Main(1)};
        board[2] = new Main[]{new Main(1), new Main(2), new Main(3), new Main(2), new Main(1)};
        board[3] = new Main[]{new Main(1), new Main(2), new Main(2), new Main(2), new Main(1)};
        board[4] = new Main[]{new Main(1), new Main(1), new Main(1), new Main(1), new Main(1)};
        score = 0;
        throwCounter = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean[][] landed = new boolean[5][5];

        // Display the board
//        printBoard(); // Commented out to avoid printing the board before the first toss

        // Play the game
        while (true) {
            // Generate random row and column for the toss
            int row = random.nextInt(5);
            int col = random.nextInt(5);

            // Add the value of the square to the score
            Main square = board[row][col];
            if (!landed[row][col]) {
                score += square.getValue();
                square.addPenny();
                landed[row][col] = true;
                throwCounter++;
            }

            // Display the updated board
            printBoard();

            // Check if the game is over
            if (throwCounter == 5) {
                break;
            }

            // Wait for the user to press Enter to continue
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }

        // Display the final score
        System.out.println("Game over! Final score: " + score);
    }

    private void printBoard() {
        // Print the board with Ps where the pennies landed
        System.out.println("Score: " + score);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isGameOver(boolean[][] landed) {
        // Check if all squares have a penny on them
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (!landed[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PennyPitch game = new PennyPitch();
        game.play();
    }
}
