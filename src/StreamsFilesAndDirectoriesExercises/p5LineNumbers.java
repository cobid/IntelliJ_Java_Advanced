package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class p5LineNumbers {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\cobim\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
             PrintWriter pr = new PrintWriter("C:\\Users\\cobim\\Desktop\\" +
                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt")) {
            String line = bf.readLine();
            List<String> list = new LinkedList<>();
            int count = 0;
            while (line != null) {
                String newLine = String.format("%d. %s", ++count, line);
                list.add(newLine);
                line = bf.readLine();
            }
            for (int i = 0; i < list.size(); i++) {
                pr.println(list.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
