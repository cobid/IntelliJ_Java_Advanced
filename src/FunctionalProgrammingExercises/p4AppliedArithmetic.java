package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class p4AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersARR = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        UnaryOperator<List<Integer>> add = numbersList -> numbersList.stream().map(element -> element + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbersList -> numbersList.stream().map(element -> element * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbersList -> numbersList.stream().map(element -> element - 1).collect(Collectors.toList());



        String command = scanner.nextLine();


        while (!command.equals("end")) {
            switch (command) {
                case "add" -> numbersARR = add.apply(numbersARR);
                case "multiply" -> numbersARR = multiply.apply(numbersARR);
                case "subtract" -> numbersARR = subtract.apply(numbersARR);
                case "print" -> {
                    numbersARR.forEach(number -> System.out.printf("%d ", number));
                    System.out.println();
                }
            }
            command = scanner.nextLine();

        }
    }
}
