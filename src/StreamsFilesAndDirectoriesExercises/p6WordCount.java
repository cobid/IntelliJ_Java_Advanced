package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.*;

public class p6WordCount {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("C:\\Users\\cobim\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
             Scanner text = new Scanner(new FileReader("C:\\Users\\cobim\\Desktop\\" +
                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             PrintWriter pw = new PrintWriter("C:\\Users\\cobim\\Desktop\\" +
                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt")) {
            LinkedHashMap<String, Integer> countWords = new LinkedHashMap<>();
            Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> countWords.put(word, 0));

            while (text.hasNext()) {
                String textNext = text.next();

                if (countWords.containsKey(textNext)) {
                    int count = countWords.get(textNext);
                    count++;
                    countWords.put(textNext, count);
                }


            }
            countWords.entrySet().forEach((word -> pw.printf("%s - %d%n", word.getKey(), word.getValue())));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
