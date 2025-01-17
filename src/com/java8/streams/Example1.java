package com.java8.streams;

import com.java8.model.Employee;
import com.java8.model.EmployeeList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example1 {

    public static void main(String[] args) {


        // 1 How many male and female employees are there in the organization?

       /* For queries such as above where you need to group the input elements,
        use the Collectors.groupingBy() method.
        In this query, we use Collectors.groupingBy() method which takes two arguments.
        We pass Employee::getGender as first argument which groups the input elements based on gender
        and Collectors.counting() as second argument which counts the number of entries in each group.*/

        List<Employee>   employeeList =  EmployeeList.getEmployeeList();
        Map<String, Long> noOfMaleAndFemaleEmployees =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);

        //{Male=11, Female=6}

        //2 Print the name of all departments in the organization?

        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //3 What is the average age of male and female employees?

        //Use same method as query 1 but pass Collectors.averagingInt(Employee::getAge) instead of Collectors.counting() as the second argument to Collectors.groupingBy().
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        System.out.println(avgAgeOfMaleAndFemaleEmployees);



    }
}
