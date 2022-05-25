package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;


public class p2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).
                toArray();
        int cols = input[0];
        int rows = input[1];
        String[][] matrix = new String[cols][rows];
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                char first = (char) ('a' + col);
                char second = (char) (first + row);
                matrix[col][row] = String.valueOf(first) + second + first;
            }
        }
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }


    }
}
