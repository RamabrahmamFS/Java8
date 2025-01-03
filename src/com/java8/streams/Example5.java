package com.java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Example5 {

    public static void main(String[] args) {


        //9 : Who has the most working experience in the organization?
        List<Employee> employeeList =  EmployeeList.getEmployeeList();

        Employee seniorMostEmployee =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();

// OR

        //Employee seniorMostEmployee = employeeList.stream().min(Comparator.comparingDouble(Employee::getYearOfJoining)).get();

        System.out.println("Senior Most Employee Details :");

        System.out.println("----------------------------");

        System.out.println("ID : "+seniorMostEmployee.getId());

        System.out.println("Name : "+seniorMostEmployee.getName());

        System.out.println("Age : "+seniorMostEmployee.getAge());

        System.out.println("Gender : "+seniorMostEmployee.getGender());

        System.out.println("Age : "+seniorMostEmployee.getDepartment());

        System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());

        System.out.println("Salary : "+seniorMostEmployee.getSalary());


        //10 : How many male and female employees are there in the sales and marketing team?

        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
                employeeList.stream()
                        .filter(e -> e.getDepartment()=="Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeesInSalesMarketing);

        //.11 : What is the average salary of male and female employees?

        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryOfMaleAndFemaleEmployees);


        //12 : List down the names of all employees in each department?

        Map<String, List<Employee>> employeeListByDepartment=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entrySet)
        {
            System.out.println("--------------------------------------");

            System.out.println("Employees In "+entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }

    }
}
