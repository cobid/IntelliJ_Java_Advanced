package JavaAdvancedExam.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return this.exercises.remove(exercise);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics(){

        StringBuilder result = new StringBuilder();
        result.append(String.format("Workout type: %s%n", this.type));
        for (Exercise exercise : this.exercises) {
            result.append("Exercise: ");
            result.append(exercise.toString() + System.lineSeparator());
        }
        return result.toString();
    }

}
