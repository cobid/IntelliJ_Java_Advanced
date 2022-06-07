package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p8CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Comparator<Integer> comparator;
        comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.sort(input, comparator);
        System.out.println(Arrays.stream(input)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        //Arrays.stream(input).forEach(number-> System.out.print(number + " "));
    }
}
