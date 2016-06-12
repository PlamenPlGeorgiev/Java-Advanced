import java.util.Scanner;

/**
 * Created by admin on 3.6.2016 г..
 */
public class _16_TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        char[] snake = sc.nextLine().toCharArray();
        char[][] matrix = new char[rows][cols];
        int counter = 0;
        Boolean isGoingLeft = true;
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (isGoingLeft) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    matrix[i][j] = snake[counter % snake.length];
                    counter++;
                }
            } else {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = snake[counter % snake.length];
                    counter++;
                }
            }
            isGoingLeft = !isGoingLeft;
        }
        String[] tokens = sc.nextLine().split(" ");
        int impactRow = Integer.parseInt(tokens[0]);
        int impactCol = Integer.parseInt(tokens[1]);
        int radius = Integer.parseInt(tokens[2]);
        IsInCircle(matrix, radius, impactRow, impactCol);
        GravityCheck(matrix);
        PrintMatrix(matrix);
    }

    static void PrintMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static char[][] IsInCircle(char[][] matrix, int radius, int impactRow, int impactCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((i - impactRow) * (i - impactRow) + (j - impactCol) * (j - impactCol) <= radius * radius) {
                    matrix[i][j] = ' ';
                }
            }
        }
        return matrix;
    }

    static char[][] GravityCheck(char[][] matrix) {
        while (true) {
            int counter = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length - 1; j++) {
                    if (matrix[j + 1][i] == ' '&&matrix[j][i]!=' ') {
                        char temp = matrix[j][i];
                        matrix[j][i] = ' ';
                        matrix[j + 1][i] = temp;
                        counter++;
                    }
                }
            }
            if (counter == 0) {
                break;
            }
        }
        return matrix;
    }
}
