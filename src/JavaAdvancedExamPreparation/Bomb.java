package JavaAdvancedExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;


        for (int row = 0; row < matrixSize; row++) {
            List<Character> charactersList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());
            for (int col = 0; col < charactersList.size(); col++) {
                char currentChar = charactersList.get(col);
                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (currentChar == 'B') {
                    bombCounter++;
                }
                matrix[row][col] = currentChar;

            }

        }
        int foundBombs = 0;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow != matrixSize - 1) {
                        sapperRow++;
                    }
                    break;
                case "right":
                    if (sapperCol != matrixSize - 1) {
                        sapperCol++;
                    }
                    break;
                case "left":
                    if (sapperCol != 0) {
                        sapperCol--;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = '+';
                foundBombs++;
                if (bombCounter == foundBombs) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", bombCounter - foundBombs);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter - foundBombs, sapperRow, sapperCol);


    }
}
