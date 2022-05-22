package StacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] commands = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int command = commands[0];
            switch (command) {
                case 1:
                    int number = commands[1];
                    stack.push(number);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.printf("%s%n", Collections.max(stack));
                    break;
            }

        }
    }
}
