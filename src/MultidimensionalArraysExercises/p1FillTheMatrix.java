package MultidimensionalArraysExercises;

import java.util.Scanner;

public class p1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];
        switch (pattern) {
            case "A":
                int counter = 1;
                for (int col = 0; col < n; col++) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                }
                break;
            case "B":
                int count = 1;
                for (int col = 0; col < n; col++) {
                    if (col % 2 == 0) {
                        for (int row = 0; row < n; row++) {
                            matrix[row][col] = count;
                            count++;
                        }
                    } else {
                        for (int row = n - 1; row >= 0; row--) {
                            matrix[row][col] = count;
                            count++;
                        }
                    }
                }
                break;
        }
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }

    }

}




