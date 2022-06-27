package JavaAdvancedExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> cookedFood = new TreeMap<>();
        cookedFood.put("Bread", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pastry", 0);
        cookedFood.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int lastIngredients = ingredients.pop();
            int sum = liquids.poll() + lastIngredients;
            String food;
            switch (sum) {
                case 25:
                    food = "Bread";
                    break;
                case 50:
                    food = "Cake";
                    break;
                case 75:
                    food = "Pastry";

                    break;
                case 100:
                    food = "Fruit Pie";
                    break;
                default:
                    food = null;

            }

            if (food != null) {
                cookedFood.putIfAbsent(food, 0);
                int newValue = cookedFood.get(food) + 1;
                cookedFood.put(food, newValue);
            } else {
                ingredients.push(lastIngredients + 3);
            }

        }
        boolean allFoodsAreCooked = cookedFood.entrySet().stream().allMatch(e -> e.getValue() > 0);
        if(allFoodsAreCooked){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String ingredientsLeft = ingredients.isEmpty() ? "none" : ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + ingredientsLeft);


        cookedFood.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

    }

}
