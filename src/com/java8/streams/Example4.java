package com.java8.streams;

import com.java8.model.Employee;
import com.java8.model.EmployeeList;

import java.util.Comparator;
import java.util.List;

public class Example4 {

    public static void main(String[] args) {


        List<Employee> employeeList =  EmployeeList.getEmployeeList();

        //8 : Get the details of youngest male employee in the product development department?

        Employee youngestMaleEmployeeInProductDevelopment=
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(Comparator.comparingInt(Employee::getAge)).get();


        System.out.println("Details Of Youngest Male Employee In Product Development");

        System.out.println("----------------------------------------------");

        System.out.println("ID : "+youngestMaleEmployeeInProductDevelopment.getId());

        System.out.println("Name : "+youngestMaleEmployeeInProductDevelopment.getName());

        System.out.println("Age : "+youngestMaleEmployeeInProductDevelopment.getAge());

        System.out.println("Year Of Joinging : "+youngestMaleEmployeeInProductDevelopment.getYearOfJoining());

        System.out.println("Salary : "+youngestMaleEmployeeInProductDevelopment.getSalary());






    }
}
