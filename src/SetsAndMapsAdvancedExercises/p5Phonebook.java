package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p5Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String phone = data[1];
            phoneBook.put(name, phone);
            input = scanner.nextLine();
        }
        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")) {
            if (phoneBook.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phoneBook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            searchName = scanner.nextLine();
        }

    }
}
