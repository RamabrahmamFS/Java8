package com.java8.sort;

import com.java8.model.Employee;
import com.java8.model.EmployeeList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalSort {
    public static void main(String[] args) {
        List<Employee> employeeList =  EmployeeList.getEmployeeList();

       /* List of emp. id, name, salary.
       get name of first 10 employees sorted in ascending order based on salary,
        having salary greater than 10,000/*/

        List<String> ascending = employeeList.stream()
                .filter(e -> e.getSalary() > 10000) // Filter employees with salary > 10,000
                .sorted(Comparator.comparingDouble(Employee::getSalary)) // Sort by salary (ascending)
                .limit(10) // Limit to first 10 employees
                .map(Employee::getName) // Extract employee names
                .toList(); // Collect names into a list


        List<String> descending = employeeList.stream()
                .filter(e -> e.getSalary() > 10000) // Filter employees with salary > 10,000
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Sort by salary (descending)
                .limit(10) // Limit to first 10 employees
                .map(Employee::getName) // Extract employee names
                .toList(); // Collect names into a list

        System.out.println("ascending::: "+ascending);
        System.out.println("descending::: "+descending);


    }
}
