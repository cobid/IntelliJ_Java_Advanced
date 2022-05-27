package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p6StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        String input = scanner.nextLine();
        int maxWordLength = Integer.MIN_VALUE;
        List<String> wordList = new ArrayList<>();

        maxWordLength = getLength(scanner, input, maxWordLength, wordList);
        int rows = wordList.size();
        int cols = maxWordLength;
        char[][] matrix = new char[rows][cols];

        fillMatrix(wordList, rows, cols, matrix);
        String[] angleInput = rotation.split("[()]");
            String angleForRotation = angleInput[1];
            int angle = Integer.parseInt(angleForRotation);
            angle = angle % 360;

            switch (angle) {
                case 0:
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case 90:
                    for (int col = 0; col < cols; col++) {
                        for (int row = rows - 1; row >= 0; row--) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case 180:
                    for (int row = rows - 1; row >= 0; row--) {
                        for (int col = cols - 1; col >= 0; col--) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case 270:
                    for (int col = cols-1; col >=0; col--) {
                        for (int row = 0; row < rows; row++) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;

            }


    }

    private static int getLength(Scanner scanner, String input, int maxWordLength, List<String> wordList) {
        while (!input.equals("END")) {
            int currentLength = input.length();
            if (currentLength > maxWordLength) {
                maxWordLength = currentLength;
            }
            wordList.add(input);
            input = scanner.nextLine();
        }
        return maxWordLength;
    }

    private static void fillMatrix(List<String> wordList, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String currentRow = wordList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentRow.length()) {
                    char currentChar = currentRow.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}

