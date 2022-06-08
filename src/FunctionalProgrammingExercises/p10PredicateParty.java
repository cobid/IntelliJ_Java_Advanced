package FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];
            String move = inputArr[1];
            String value = inputArr[2];
            switch (command) {
                case "Remove":
                    if (move.equals("StartsWith")) {
                        names.removeIf(name -> name.startsWith(value));
                    } else if (move.equals("EndsWith")) {
                        names.removeIf(name -> name.endsWith(value));
                    }
                    break;
                case "Double":
                    if (move.equals("EndsWith")) {
                        List<String> currentNames = new ArrayList<>();
                        names.stream().filter(name -> name.endsWith(value)).forEach(currentNames::add);
                        names.addAll(currentNames);
                        break;
                    } else if (move.equals("StartsWith")) {
                        List<String> currentNames = new ArrayList<>();
                        names.stream().filter(name -> name.startsWith(value)).forEach(currentNames::add);
                        names.addAll(currentNames);
                        break;

                    } else if (move.equals("Length")) {
                        List<String> currentNames;
                        int nameLength = Integer.parseInt(value);
                        currentNames = names.stream().filter(name -> name.length() == nameLength).collect(Collectors.toList());
                        names.addAll(currentNames);
                        break;
                    }
            }
            input = scanner.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(names.stream().sorted().collect(Collectors.joining(", ")));
            System.out.print(" are going to the party!");
        }
    }

}