package MultidimensionalArraysExercises;

import java.util.Scanner;

public class p3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[num][num];

        for (int row = 0; row < num; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < num; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        int firstDiagonalSum = 0;
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (row == col) {
                    firstDiagonalSum += matrix[row][col];
                }
            }
        }
        int secondDiagonalSum = 0;
        for (int row = 0; row < num; row++) {
            secondDiagonalSum+=matrix[row][num - row - 1];
        }
        int sum  = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(sum);
    }
}