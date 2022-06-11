package _1_DefiningClassesOpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<NameBook> nameBooks = new ArrayList<>();
        while (num-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            NameBook namebook = new NameBook();
            namebook.setName(name);
            namebook.setAge(age);
            nameBooks.add(namebook);
        }
        nameBooks.stream().filter(name -> name.getAge() > 30)
                .sorted(Comparator.comparing(NameBook::getName))
                .forEach(name -> System.out.println(name.toString()));

    }
}
