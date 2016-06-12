import java.util.Scanner;

/**
 * Created by admin on 3.6.2016 г..
 */
public class _15_RubiksMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        int commandsCount = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[rows][cols];
        int[][] matrixShuffled = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = i * cols + j + 1;
                matrixShuffled[i][j] = i * cols + j + 1;
            }
        }
        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int rowOrCol = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int moves = Integer.parseInt(tokens[2]);
            MatrixShuffle(matrixShuffled, rowOrCol, direction, moves);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == matrixShuffled[i][j]) {
                    System.out.println("No swap required");
                } else {
                    int row = 0;
                    int col = 0;
                    int temp = matrix[i][j];
                    int buff = matrixShuffled[i][j];
                    for (int k = 0; k < rows; k++) {
                        for (int l = 0; l < cols; l++) {
                            if (matrixShuffled[i][j] == matrix[k][l]) {
                                matrixShuffled[i][j] = matrix[k][l];
                            }
                            if (matrixShuffled[k][l] == temp) {
                                matrixShuffled[k][l] = buff;
                                row = k;
                                col = l;
                            }
                        }
                    }
                    System.out.printf("Swap (%d, %d) with (%d, %d)%n", i, j, row, col);
                }
            }
        }
    }

    static int[][] MatrixShuffle(int[][] matrix, int rowOrCol, String directon, int moves) {
        if (directon.equals("left")) {
            int row = rowOrCol;
            moves %= matrix[0].length;
            for (int i = 0; i < moves; i++) {
                int temp = matrix[row][0];
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[row][j - 1] = matrix[row][j];
                }
                matrix[row][matrix[0].length - 1] = temp;
            }
        } else if (directon.equals("right")) {
            int row = rowOrCol;
            moves %= matrix[0].length;
            for (int i = 0; i < moves; i++) {
                int temp = matrix[row][matrix[0].length - 1];
                for (int j = matrix[0].length - 1; j > 0; j--) {
                    matrix[row][j] = matrix[row][j - 1];
                }
                matrix[row][0] = temp;
            }
        } else if (directon.equals("up")) {
            int col = rowOrCol;
            moves %= matrix.length;
            for (int i = 0; i < moves; i++) {
                int temp = matrix[0][col];
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j - 1][col] = matrix[j][col];
                }
                matrix[matrix.length - 1][col] = temp;
            }
        } else if (directon.equals("down")) {
            int col = rowOrCol;
            moves %= matrix.length;
            for (int i = 0; i < moves; i++) {
                int temp = matrix[matrix[0].length - 1][col];
                for (int j = matrix.length - 1; j > 0; j--) {
                    matrix[j][col] = matrix[j - 1][col];
                }
                matrix[0][col] = temp;
            }
        }
        return matrix;
    }
}
