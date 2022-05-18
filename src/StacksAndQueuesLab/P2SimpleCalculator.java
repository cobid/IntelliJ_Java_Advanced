package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P2SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }
        while (stack.size() > 1) {
            int topNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondFromTopNum = Integer.parseInt(stack.pop());
            int result = 0;
            if (operator.equals("+")) {
                result = topNum + secondFromTopNum;
            } else {
                result = topNum - secondFromTopNum;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
