package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p7SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stackLastCommand = new ArrayDeque<>();
        ArrayDeque<String> removedText = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "1":
                    stackLastCommand.push(input);
                    addText(commands[1], text);
                    break;
                case "2":
                    stackLastCommand.push(input);
                    int position = Integer.parseInt(commands[1]);
                    int startIndex = text.length() - position;
                    int endIndex = text.length();
                    String elementsForDelete = text.substring(startIndex, endIndex);
                    removedText.push(elementsForDelete);
                    deleteText(text, elementsForDelete);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    printElement(index, text);
                    break;
                case "4":
                    String lastCommand = stackLastCommand.pop();
                    String[] lastArgument = lastCommand.split("\\s+");
                    String lastMove = lastArgument[0];
                    switch (lastMove) {
                        case "1":
                            String elementToDelete = lastArgument[1];
                            deleteText(text, elementToDelete);
                            break;
                        case "2":
                            String elementToAdd = removedText.pop();
                            addText(elementToAdd, text);
                            break;
                    }
                    break;
            }
        }
    }

    private static void deleteText(StringBuilder text, String elementsToDelete) {
        int lastIndex = text.lastIndexOf(elementsToDelete);
        text.delete(lastIndex, text.length());
    }

    private static void addText(String command, StringBuilder text) {
        text.append(command);
    }

    private static void printElement(int index, StringBuilder text) {
        System.out.printf("%s%n", text.charAt(index - 1));
    }
}
