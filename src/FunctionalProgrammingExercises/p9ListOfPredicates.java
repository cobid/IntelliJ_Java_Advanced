package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p9ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.parseInt(scanner.nextLine());
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Predicate<Integer> divisible = number -> {
            for (Integer integer : input) {
                if (number % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        dividedNumbers(num, divisible);
    }


    private static void dividedNumbers(Integer num, Predicate<Integer> divisible) {
        for (int i = 1; i <= num; i++) {
            if (divisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
