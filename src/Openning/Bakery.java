package Openning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void add( Employee employee){
        this.employees.add(employee);
    }

    public boolean remove(String employeeName){
        if(this.employees.stream().anyMatch(e -> e.getName().equals(employeeName))) {
            this.employees.stream().filter(e -> !e.getName().equals(employeeName));
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList())
                .get(this.employees.size() -1);
    }

    public Employee getEmployee(String employeeName){
        return this.employees.stream()
                .filter(e->e.getName().equals(employeeName))
                .collect(Collectors.toList())
                .get(0);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        return "Employees working at Bakery Barny:\n" +
        this.employees.stream().map(Employee:: toString).collect(Collectors.joining(System.lineSeparator()));
    }

}
