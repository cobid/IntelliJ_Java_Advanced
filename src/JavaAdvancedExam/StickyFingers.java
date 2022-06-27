package JavaAdvancedExam;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] commands = scanner.nextLine().split(",");
        int startRow = 0;
        int startCol = 0;
        int pocket = 0;

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'D') {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int previousRow = startRow;
            int previousCol = startCol;
            switch (command) {
                case "up":
                    startRow--;
                    break;
                case "down":
                    startRow++;
                    break;
                case "right":
                    startCol++;
                    break;
                case "left":
                    startCol--;
                    break;
            }
            if (startRow < 0 || startRow >= matrix.length || startCol < 0 || startCol >= matrix.length) {
                startRow = previousRow;
                startCol = previousCol;
                System.out.println("You cannot leave the town, there is police outside!");
            }
            if (matrix[startRow][startCol] == '$') {
                int stolenMoney = startCol * startRow;
                pocket += stolenMoney;
                matrix[previousRow][previousCol] = '+';
                matrix[startRow][startCol] = 'D';
                System.out.println(String.format("You successfully stole %d$.", stolenMoney));
            } else if (matrix[startRow][startCol] == 'P') {

                matrix[startRow][startCol] = '#';
                System.out.println(String.format("You got caught with %d$, and you are going to jail.", pocket));
                return;
            } else if (matrix[startRow][startCol] == '+') {
                matrix[previousRow][previousCol] = '+';
                matrix[startRow][startCol] = 'D';
            }
        }
        System.out.println(String.format("Your last theft has finished successfully with %d$ in your pocket.", pocket));
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

