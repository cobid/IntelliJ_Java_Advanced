package DefiningClasses._6_DefiningClassesPokémonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainerList = new ArrayList<>();
        Pokemon pokemon;

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] inputData = input.split("\\s+");
            //{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);
            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainerList.stream().noneMatch(tr -> Objects.equals(tr.getName(), trainerName))) {
                Trainer trainer = new Trainer(trainerName);
                trainerList.add(trainer);
                trainer.getCollectionOfPokemon().add(pokemon);
            } else {
                trainerList.stream().filter(tr -> Objects.equals(tr.getName(), trainerName))
                        .collect(Collectors.toList()).get(0)
                        .getCollectionOfPokemon().add(pokemon);
            }

            input = scanner.nextLine();
        }

        String inputCommands = scanner.nextLine();
        while (!inputCommands.equals("End")) {
            for (Trainer trainer : trainerList) {
                String finalInputCommands = inputCommands;
                if (trainer.getCollectionOfPokemon().size() > 0) {
                    if (trainer.getCollectionOfPokemon().stream().anyMatch(pok -> pok.getElement().equals(finalInputCommands))) {
                        trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                    } else {
                        for (Pokemon item : trainer.getCollectionOfPokemon()) {
                            item.setHealth(item.getHealth() - 10);
                        }
                        trainer.setCollectionOfPokemon(trainer.getCollectionOfPokemon()
                                .stream().filter(e -> e.getHealth() > 0)
                                .collect(Collectors.toList()));
                    }
                }
            }
            inputCommands = scanner.nextLine();
        }
        for (Trainer trainer : trainerList.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getNumberOfBadges(), e1.getNumberOfBadges()))
                .collect(Collectors.toList())) {
            System.out.println(trainer.toString());
        }
    }
}
