package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoPowder::push);

        Map<String, Double> cookedChocolad = new TreeMap<>();
        cookedChocolad.put("Milk Chocolate", 0.0);
        cookedChocolad.put("Dark Chocolate", 0.0);
        cookedChocolad.put("Baking Chocolate", 0.0);

        while (!milk.isEmpty() && !cacaoPowder.isEmpty()) {
            Double lastMilk = milk.peek();
            Double lastCocoaPowder = cacaoPowder.peek();
            Double exactPercent = 100.0 * (lastCocoaPowder / (lastMilk + lastCocoaPowder));
            String chocolate;
            double newValue = 0.0;
            if (exactPercent == 30) {
                makeChocolad(milk, cacaoPowder, cookedChocolad, "Milk Chocolate");
            } else if (exactPercent == 50) {
                makeChocolad(milk, cacaoPowder, cookedChocolad, "Dark Chocolate");
            } else if (exactPercent == 100) {
                makeChocolad(milk, cacaoPowder, cookedChocolad, "Baking Chocolate");
            } else {
                cacaoPowder.poll();
                milk.offer(lastMilk + 10);
                milk.pop();
            }

        }
        boolean allChocolateAreCooked = cookedChocolad.entrySet().stream().allMatch(e -> e.getValue() > 0);
        if (allChocolateAreCooked) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (var chocolate : cookedChocolad.entrySet()) {
            if (chocolate.getValue() != 0) {
                System.out.printf("# %s --> %.0f%n", chocolate.getKey(), chocolate.getValue());
            }
        }
    }

    private static void makeChocolad(ArrayDeque<Double> milk, ArrayDeque<Double> cacaoPowder, Map<String, Double> cookedChocolad, String s) {
        String chocolate;
        double newValue;
        chocolate = s;
        newValue = cookedChocolad.get(chocolate) + 1;
        cookedChocolad.put(chocolate, newValue);
        cacaoPowder.poll();
        milk.pop();
    }
}
