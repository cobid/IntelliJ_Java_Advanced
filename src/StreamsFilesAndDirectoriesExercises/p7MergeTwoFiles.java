package StreamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class p7MergeTwoFiles {
    public static void main(String[] args) {
        Path firstText = Paths.get("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondText = Paths.get("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path appendText = Paths.get("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        try {
            List<String> firstInput = Files.readAllLines(firstText);
            List<String> secondInput = Files.readAllLines(secondText);
            Files.write(appendText,firstInput, StandardOpenOption.APPEND);
            Files.write(appendText,secondInput, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
