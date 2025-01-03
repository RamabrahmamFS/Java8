package com.java8.streams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example6 {

    public static void main(String[] args) {

        List<Employee> employeeList =  EmployeeList.getEmployeeList();

        //13 : What is the average salary and total salary of the whole organization?

        //For this query, we use Collectors.summarizingDouble() on Employee::getSalary which will return statistics of the employee salary like max, min, average and total.


        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());

        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

        //14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        //For this query, we will be using Collectors.partitioningBy() method which separates input elements based on supplied Predicate.

        Map<Boolean, List<Employee>> partitionEmployeesByAge=
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        System.out.println("Complete Partition Object :: " + partitionEmployeesByAge);

        System.out.println("Employee who are younger than or equal to 25 :: " + partitionEmployeesByAge.get(Boolean.FALSE));

        System.out.println("Employee who are older than 25 :: " + partitionEmployeesByAge.get(Boolean.TRUE));


        //15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?

        Employee oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();

        System.out.println("Name : "+oldestEmployee.getName());

        System.out.println("Age : "+oldestEmployee.getAge());

        System.out.println("Department : "+oldestEmployee.getDepartment());


    }
}
