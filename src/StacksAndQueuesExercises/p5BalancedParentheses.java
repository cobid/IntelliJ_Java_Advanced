package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p5BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isValid = true;
        ArrayDeque<Character> openingParentheses = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentParentheses = input.charAt(i);
            if (currentParentheses == '(' || currentParentheses == '[' || currentParentheses == '{') {
                openingParentheses.push(currentParentheses);
            } else {
                if (openingParentheses.isEmpty()) {
                    isValid = false;
                    break;
                }
                char lastParentheses = openingParentheses.pop();
                if (currentParentheses == ')' && lastParentheses != '(') {
                    isValid = false;
                    break;
                } else if (currentParentheses == ']' && lastParentheses != '[') {
                    isValid = false;
                    break;
                } else if (currentParentheses == '}' && lastParentheses != '{') {
                    isValid = false;
                    break;
                }
            }
        }
        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
