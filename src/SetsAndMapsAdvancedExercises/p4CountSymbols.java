package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                int count = map.get(symbol);
                count++;
                map.put(symbol, count);
            }

        }
        for (var characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + ": " + characterIntegerEntry.getValue() + " time/s");
        }

    }
}
