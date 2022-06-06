package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class p3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> getMin = (int[] intArray) -> {
            int minValue = Integer.MAX_VALUE;
            for (int i : intArray) {
                if (i < minValue) {
                    minValue = i;

                }
            }
            return minValue;
        };
        System.out.println(getMin.apply(inputArray));
    }

}
