package DefiningClasses._2_DefiningClassesCompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String nameDepartment;
    private List<Employee> employees;

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
        this.employees = new ArrayList<>();
    }
    public double averageSalary (){
       return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }


    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
