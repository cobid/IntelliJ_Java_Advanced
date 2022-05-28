package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p7Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputMatrixData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = inputMatrixData[0];
        int cols = inputMatrixData[1];

        List<List<Integer>> matrix = new ArrayList<>();

        readMatrix(rows, cols, matrix);

        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            String[] data = line.split(" ");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row) {
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            line = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void readMatrix(int rows, int cols, List<List<Integer>> matrix) {
        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}

