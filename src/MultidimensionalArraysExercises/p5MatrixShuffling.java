package MultidimensionalArraysExercises;

import java.util.Scanner;


public class p5MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row] = inputRow;
            }
        }
        String[] commandInput = scanner.nextLine().split("\\s+");
        while (!commandInput[0].equals("END")) {
            if(commandInput.length != 5){
                System.out.println("Invalid input!");
                commandInput = scanner.nextLine().split("\\s+");
                continue;
            } else {
                String command = commandInput[0];
                if (!command.equals("swap")) {
                    System.out.println("Invalid input!");
                    commandInput = scanner.nextLine().split("\\s+");
                    continue;
                }
                int firstRow = Integer.parseInt(commandInput[1]);
                int firstCol = Integer.parseInt(commandInput[2]);
                int secondRow = Integer.parseInt(commandInput[3]);
                int secondCol = Integer.parseInt(commandInput[4]);
                if (firstRow >= 0 && firstRow <= rows - 1 && firstCol >= 0 && firstCol <= cols - 1
                        && secondRow >= 0 && secondRow <= rows - 1 && secondCol >= 0 && secondCol <= cols - 1) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;
                } else {
                    System.out.println("Invalid input!");
                    commandInput = scanner.nextLine().split("\\s+");
                    continue;
                }
                printMatrix(rows, cols, matrix);
                commandInput = scanner.nextLine().split("\\s+");
            }
        }
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
