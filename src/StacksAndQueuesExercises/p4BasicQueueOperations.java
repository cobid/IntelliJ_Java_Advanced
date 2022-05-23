package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p4BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int elementToPush = Integer.parseInt(input[0]);
        int elementToPop = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);
        String[] elements = scanner.nextLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementToPush; i++) {
            stack.offer(Integer.parseInt(elements[i]));
        }
        for (int i = 0; i < elementToPop; i++) {
            stack.poll();
        }
        if(stack.contains(elementToSearch)){
            System.out.print("true");
        }else if (stack.isEmpty()){
            System.out.print("0");
        }else {
            System.out.print(Collections.min(stack));
        }
    }
}
