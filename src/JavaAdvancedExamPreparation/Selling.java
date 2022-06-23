package JavaAdvancedExamPreparation;

import java.util.*;
import java.util.stream.Collectors;


public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> pillars = new ArrayList<>();
        String[][] matrix = new String[size][size];
        int sRow = 0;
        int sCol = 0;

        for (int row = 0; row < size; row++) {
            List<String> stringsList = Arrays.stream(scanner.nextLine().split(""))
                    .collect(Collectors.toList());
            for (int col = 0; col < stringsList.size(); col++) {
                String currentChar = stringsList.get(col);
                if (currentChar.equals("S")) {
                    sRow = row;
                    sCol = col;
                } else if (currentChar.equals("O")) {
                    List<Integer> pillarPosition = new ArrayList<>();
                    pillarPosition.add(row);
                    pillarPosition.add(col);
                    pillars.add(pillarPosition);

                }
                matrix[row][col] = currentChar;
            }
        }
        int sum = 0;
        while (sum < 50) {
            String command = scanner.nextLine();
            matrix[sRow][sCol] = "-";
            switch (command) {
                case "up":
                    if (sRow != 0) {
                        sRow--;
                    } else {
                        outOfBound(size, sum, matrix);
                        return;
                    }
                    break;
                case "down":
                    if (sRow != size - 1) {
                        sRow++;
                    } else {
                        outOfBound(size, sum, matrix);
                        return;
                    }
                    break;
                case "right":
                    if (sCol != size - 1) {
                        sCol++;
                    } else {
                        outOfBound(size, sum, matrix);
                        return;
                    }
                    break;
                case "left":
                    if (sCol != 0) {
                        sCol--;
                    } else {
                        outOfBound(size, sum, matrix);
                        return;
                    }
                    break;
            }

            if (matrix[sRow][sCol].equals("O")) {
                matrix[sRow][sCol] = "-";
                pillars.remove(0);
                sRow = pillars.get(0).get(0);
                sCol = pillars.get(0).get(1);
                matrix[sRow][sCol] = "S";
            }
            sum = getSum(matrix, sRow, sCol, sum);
            if (!matrix[sRow][sCol].equals("-") && !matrix[sRow][sCol].equals("O")) {
                matrix[sRow][sCol] = "S";
            }

        }
        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + sum);
        printMatrix(size, size, matrix);

    }

    private static void outOfBound(int size, int sum, String[][] matrix){
        System.out.println("Bad news, you are out of the bakery.");
        System.out.println("Money: " + sum);
        printMatrix(size, size, matrix);
    }


    private static int getSum(String[][] matrix, int sapperRow, int sapperCol, int sum) {
        if (!matrix[sapperRow][sapperCol].equals("S") && !matrix[sapperRow][sapperCol].equals("O") && !matrix[sapperRow][sapperCol].equals("-")) {
            int value = Integer.parseInt(matrix[sapperRow][sapperCol]);
            sum += value;
        }
        return sum;
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

}
