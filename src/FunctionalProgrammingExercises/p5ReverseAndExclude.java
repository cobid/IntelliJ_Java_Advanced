package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class p5ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Integer num = Integer.parseInt(scanner.nextLine());
        input.removeIf(number -> number % num == 0);
        Collections.reverse(input);
        input.forEach(e -> System.out.printf("%d ", e));

    }
}
