package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class p2KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Consumer consumer;
        names.forEach(name-> System.out.printf("Sir %s%n", name));
    }
}
