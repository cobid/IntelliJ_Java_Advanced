package StreamsFilesAndDirectoriesExercises;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class p8GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\cobim\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int size = 0;
        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    files.offer(nestedFile);
                } else {
                    size += nestedFile.length();
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
