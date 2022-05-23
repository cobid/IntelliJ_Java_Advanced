package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p6RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        if (n < 2) {
            System.out.println(1);
            return;
        }
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);
        for (int i = 0; i < n; i++) {
            long n1 = stack.pop();
            long n2 = stack.pop();
            stack.push(n1);
            stack.push(n1 + n2);

        }
        System.out.println(stack.peek());
    }
}
