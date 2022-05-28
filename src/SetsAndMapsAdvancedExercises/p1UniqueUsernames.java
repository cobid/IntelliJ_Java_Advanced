package SetsAndMapsAdvancedExercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p1UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();
        while (n-- > 0) {
            String input = scanner.nextLine();
            set.add(input);
        }
        for (String s : set) {
            System.out.println(s);

        }


    }
}
