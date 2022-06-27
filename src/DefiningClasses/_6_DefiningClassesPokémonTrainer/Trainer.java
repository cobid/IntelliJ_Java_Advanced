package DefiningClasses._6_DefiningClassesPokémonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //name, a number of badges, and a collection of pokemon
    String name;
    int numberOfBadges;
    List<Pokemon> pokemonsList;


    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonsList = new ArrayList<>();
    }

    public Trainer() {
        this.numberOfBadges = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return this.pokemonsList;
    }

    public void setCollectionOfPokemon(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }


    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, pokemonsList.size());
    }
}
