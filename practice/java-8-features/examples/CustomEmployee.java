package practice.streams.custom.employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeDemo {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101,"Ram",201,"active",5000.0));
        employeeList.add(new Employee(102,"Shyam",202,"inactive",4000.0));
        employeeList.add(new Employee(103,"Ramu",202,"active",3000.0));
        employeeList.add(new Employee(104,"Ramesh",204,"active",6000.0));
        employeeList.add(new Employee(105,"Ramika",204,"inactive",7000.0));
        employeeList.add(new Employee(106,"Ramchal",204,"active",5300.0));
        employeeList.add(new Employee(107,"Ramchandra",201,"active",9000.0));

        // WAP to print employee list for a given department : Collectors.groupingBy(Key,Value), Collectors.toList()
        Map<Integer,List<Employee>> empByDeptId =  employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
        empByDeptId.entrySet().forEach(System.out::println);

        // WAP tp print employee count working a department : Collectors.count()
        Map<Integer,Long> empCountByDeptId =  employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
        empCountByDeptId.entrySet().forEach(System.out::println);

        // WAP tp print count of active/inactive employee in a collection : filter()
        long activeEmployees = employeeList.stream().filter(emp -> "active".equalsIgnoreCase(emp.getStatus())).count();
        long inactiveEmployees = employeeList.stream().filter(emp -> "inactive".equalsIgnoreCase(emp.getStatus())).count();
        System.out.println("Active count : "+activeEmployees + " and inactive employee : "+ inactiveEmployees);

        // WAP to print Max/min Employee salary from collection : max/min and Comparator.comparing()
       Optional<Employee> maxSalEmployee = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
       Optional<Employee> minSalEmployee = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
       System.out.println("Max salary employee : "+ maxSalEmployee + "\n" + "Min salary employee : "+ minSalEmployee);

       // WAP to print max salaried employee of each department : Collectors.reducing() and BinaryOperator()
        Map<Integer, Optional<Employee>> maxSalaryEmpDeptWise = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
        ));
        maxSalaryEmpDeptWise.entrySet().forEach(System.out::println);

    }
}
