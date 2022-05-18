package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentUrl = " ";
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!arrayDeque.isEmpty()) {
                    currentUrl = arrayDeque.pop();
                }else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentUrl.equals(" ")) {
                    arrayDeque.push(currentUrl);
                }
                currentUrl = input;
            }
            System.out.println(currentUrl);
            input = scanner.nextLine();
        }
    }
}

