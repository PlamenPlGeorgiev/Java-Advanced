import java.util.Scanner;

/**
 * Created by admin on 9.6.2016 г..
 */
public class _18_RadioActiveBunnies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] rc = sc.nextLine().split(" ");
        int rows = Integer.parseInt(rc[0]);
        int cols = Integer.parseInt(rc[1]);
        char[][] matrix = new char[rows][cols];
        boolean[][] bunnies = new boolean[rows][cols];
        boolean[][] buffBunnies = new boolean[rows][cols];
        int playerRow = -1;
        int playerCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = line.charAt(j);
                if (line.charAt(j) == 'B') {
                    bunnies[i][j] = true;
                }
                if (line.charAt(j) == 'P') {
                    playerRow = i;
                    playerCol = j;
                    matrix[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < buffBunnies.length; i++) {
            for (int j = 0; j < buffBunnies[0].length; j++) {
                buffBunnies[i][j] = bunnies[i][j];
            }
        }
        boolean isWinner;
        boolean isDead;
        String commands = sc.nextLine();
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'U') {
                isWinner = playerRow == 0;
                playerRow -= isWinner ? 0 : 1;
                BunniesSpread(buffBunnies, bunnies);
                if (isWinner) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    break;
                }
                isDead = bunnies[playerRow][playerCol];
                if (isDead) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    break;
                }
            }
            if (commands.charAt(i) == 'D') {
                isWinner = playerRow == rows - 1;
                playerRow += isWinner ? 0 : 1;
                BunniesSpread(buffBunnies, bunnies);
                if (isWinner) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    break;
                }
                isDead = bunnies[playerRow][playerCol];
                if (isDead) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    break;
                }
            }
            if (commands.charAt(i) == 'L') {
                isWinner = playerCol == 0;
                playerCol -= isWinner ? 0 : 1;
                BunniesSpread(buffBunnies, bunnies);
                if (isWinner) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    break;
                }
                isDead = bunnies[playerRow][playerCol];
                if (isDead) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    break;
                }
            }
            if (commands.charAt(i) == 'R') {
                isWinner = playerCol == cols - 1;
                playerCol += isWinner ? 0 : 1;
                BunniesSpread(buffBunnies, bunnies);
                if (isWinner) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("won: %d %d%n", playerRow, playerCol);
                    break;
                }
                isDead = bunnies[playerRow][playerCol];
                if (isDead) {
                    PrintMatrix(BunniesToMatrix(bunnies, matrix));
                    System.out.printf("dead: %d %d%n", playerRow, playerCol);
                    break;
                }
            }
        }
    }

    static boolean[][] BunniesSpread(boolean[][] buffBunnies, boolean[][] bunnies) {
        for (int i = 0; i < bunnies.length; i++) {
            for (int j = 0; j < bunnies[0].length; j++) {
                if (bunnies[i][j]) {
                    if (i > 0) {
                        buffBunnies[i - 1][j] = true;
                    }
                    if (i < bunnies.length - 1) {
                        buffBunnies[i + 1][j] = true;
                    }
                    if (j > 0) {
                        buffBunnies[i][j - 1] = true;
                    }
                    if (j < bunnies[0].length - 1) {
                        buffBunnies[i][j + 1] = true;
                    }
                }
            }
        }
        for (int i = 0; i < bunnies.length; i++) {
            for (int j = 0; j < bunnies[0].length; j++) {
                if (buffBunnies[i][j]) {
                    bunnies[i][j] = true;
                }
            }
        }
        return bunnies;
    }

    static char[][] BunniesToMatrix(boolean[][] bunnies, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (bunnies[i][j]) {
                    matrix[i][j] = 'B';
                } else {
                    matrix[i][j] = '.';
                }
            }
        }
        return matrix;
    }

    static void PrintMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}