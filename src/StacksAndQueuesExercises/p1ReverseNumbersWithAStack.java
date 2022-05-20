package StacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Scanner;

public class p1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            int element = Integer.parseInt(input[i]);
            stack.push(element);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");

        }
    }
}
