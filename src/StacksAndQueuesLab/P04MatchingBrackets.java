package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String symbolLine = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < symbolLine.length(); i++) {
            char currentSymbol = symbolLine.charAt(i);
            if (currentSymbol == '(') {
                stack.push(i);
            } else if (currentSymbol == ')') {
                int lastIndex = stack.pop();
                String matching = symbolLine.substring(lastIndex, i + 1);
                System.out.println(matching);
            }
        }
    }
}
