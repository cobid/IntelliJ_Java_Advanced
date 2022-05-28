package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        Set<String> setN = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            setN.add(scanner.nextLine());
        }
        int M = Integer.parseInt(input[1]);
        Set<String> setM = new LinkedHashSet<>();
        for (int i = 0; i < M; i++) {
            setM.add(scanner.nextLine());
        }
        for (String element : setN) {
            if(setM.contains(element)){
                System.out.print(element + " ");
            }

        }




    }
}
