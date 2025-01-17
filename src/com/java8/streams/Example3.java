package com.java8.streams;

import com.java8.model.Employee;
import com.java8.model.EmployeeList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {

        List<Employee> employeeList =  EmployeeList.getEmployeeList();

        //5 : Get the names of all employees who have joined after 2015?

        //For such queries which require filtering of input elements,
        // use Stream.filter() method which filters input elements according to supplied Predicate.

        employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);

        // Get the details of all employees who have joined after 2015?
        employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .forEach(System.out::println);

        //6 : Count the number of employees in each department?
        Map<String, Long> employeeCountByDepartment=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(employeeCountByDepartment);

        //7 : What is the average salary of each department?

        Map<String, Double> avgSalaryOfDepartments=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryOfDepartments);

    }
}
