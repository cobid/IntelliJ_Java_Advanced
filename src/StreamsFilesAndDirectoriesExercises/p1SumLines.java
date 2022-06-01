package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p1SumLines {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            String line = bf.readLine();
            while (line != null) {
                long sum = 0;
                char[] characterArr = line.toCharArray();
                for (int i = 0; i < characterArr.length; i++) {
                    char character = characterArr[i];
                    sum += character;
                }
                System.out.printf("%d%n", sum);
                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
