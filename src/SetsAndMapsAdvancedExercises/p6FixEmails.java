package SetsAndMapsAdvancedExercises;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p6FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        Map<String, String> emailBook = new LinkedHashMap<>();
        while (!inputName.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".com") && !email.contains(".uk")) {
                emailBook.put(inputName, email);
            }
            inputName = scanner.nextLine();
        }
        for (Map.Entry<String, String> email : emailBook.entrySet()) {
            System.out.printf("%s -> %s%n", email.getKey(), email.getValue());
        }
    }
}
