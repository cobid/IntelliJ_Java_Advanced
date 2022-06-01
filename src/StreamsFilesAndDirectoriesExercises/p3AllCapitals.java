package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class p3AllCapitals {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\cobim\\Desktop" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"))) {
            bf.lines().forEach(line -> pw.println(line.toUpperCase()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
