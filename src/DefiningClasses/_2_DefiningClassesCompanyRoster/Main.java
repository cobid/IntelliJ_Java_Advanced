package DefiningClasses._2_DefiningClassesCompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> employees = new ArrayList<>();
        Map<String, Department> map = new HashMap<>();


        while (num-- > 0) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            Employee employee = null;
            switch (employeeData.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);


                    break;
                case 5:
                    if (employeeData[4].matches("\\d+")) {
                        int age = Integer.parseInt(employeeData[4]);
                        employee = new Employee(name, salary, position, department, age);

                    } else {
                        String email = employeeData[4];
                        employee = new Employee(name, salary, position, department, email);

                    }
                    break;
                case 6:
                    String email = employeeData[4];
                    int age = Integer.parseInt(employeeData[5]);
                    employee = new Employee(name, salary, position, department, email, age);

                    break;
            }
            map.putIfAbsent(department, new Department(department));
            map.get(department).getEmployees().add(employee);

        }
        Department name = map.entrySet().stream().max(Comparator.comparingDouble(e -> e.getValue().averageSalary())).get().getValue();
        System.out.printf("Highest Average Salary: %s%n", name.getNameDepartment());
        name.getEmployees().stream()
                .sorted((e1,e2)  ->Double.compare( e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}

