package JavaAdvancedExamPreparation.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet petToRemove = this.data.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (petToRemove != null) {
            this.data.remove(petToRemove);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(s -> s.getName().equals(name)).filter(s -> s.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return " The clinic has the following patients:" + System.lineSeparator() +
                this.data.stream().map(pet -> pet.getName() + " " + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }
}
