package SetsAndMapsAdvancedExercises;

import java.util.*;

public class p3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        while (num-- > 0) {
            String[] elementsToAdd = scanner.nextLine().split(" ");
            for (int i = 0; i < elementsToAdd.length; i++) {
                elements.add(elementsToAdd[i]);
            }
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}

