package SetsAndMapsAdvancedExercises;

import java.util.*;

public class p7HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] drawsFromTheDeck = input.split(":");
            String name = drawsFromTheDeck[0];
            String[] cards = drawsFromTheDeck[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            for (String card : cards) {
                card = card.trim();
                players.get(name).add(card);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {
            String playerName = player.getKey();
            int totalPoints = calculatePoints(player.getValue());

            System.out.printf("%s: %d%n", playerName, totalPoints);
        }
    }
    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String powerCard = card.substring(0, card.length() - 1);
            String typeCard = String.valueOf(card.charAt(card.length() - 1));
            int power = getPower(powerCard);
            int type = getType(typeCard);
            points += power * type;
        }
        return points;
    }

    private static int getPower(String powerCard){
        switch (powerCard) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(powerCard);
        }
    }

    private static int getType(String typeCard){
        switch (typeCard) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
            default:
                return 0;
        }
    }
}



