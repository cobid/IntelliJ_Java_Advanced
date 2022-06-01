package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class p4CountCharacterTypes {
    public static void main(String[] args) {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        try (FileReader fl = new FileReader("C:\\Users\\cobim\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
             PrintWriter pr = new PrintWriter("C:\\Users\\cobim\\Desktop\\" +
                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt")) {
            int symbol = fl.read();
            while (symbol >= 0) {
                char asChar = (char) symbol;
                if (asChar == 'a' || asChar == 'o' || asChar == 'u' || asChar == 'e' || asChar == 'i') {
                    vowels++;
                } else if (asChar == '!' || asChar == ',' || asChar == '.' || asChar == '?') {
                    punctuation++;
                }else if(!Character.isWhitespace(asChar) ){
                    consonants++;
                }
                symbol = fl.read();
            }
            pr.printf("Vowels: %d%n", vowels);
            pr.printf("Consonants: %d%n", consonants);
            pr.printf("Punctuation: %d%n", punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;


    }
}
