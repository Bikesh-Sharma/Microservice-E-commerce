package com.ecom.util;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindHighestSalaryDepartmentWise {
    public static void main(String[] args) {

        //find top 3 highest paid employee
        // in each department sorted by salary desc

        List<Employee> list = List.of(new Employee(1,"Bikesh","HR",9000.0),
                new Employee(1,"Rakesh","Java",5000.0),
                new Employee(2,"Umesh","IT",8000.0),
                new Employee(3,"Umesh","HR",9000.0),
                new Employee(4,"Umesh","IT",5000.0));
                new Employee(5,"Umesh","JAVA",4000.0);

        Map<String, List<Employee>> result = list.stream().collect(Collectors.groupingBy(Employee::getDepartment
                , Collectors.collectingAndThen(Collectors.toList(),
                        emp -> emp.stream().sorted(Comparator.comparing(
                                        Employee::getSalary
                                ).reversed())
                                .limit(3).toList()
                )
        ));
//        System.out.println(result);

        Employee employee = list.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow();
//        System.out.println(employee);

        Map<String, List<Employee>> result1 = list.stream().collect(Collectors.groupingBy
                (Employee::getDepartment, Collectors.toList()));
//        System.out.println(result1);




        Map<String, Optional<Employee>> result2 =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        ));

//        System.out.println(result2);


        Predicate<Employee> isIT = e -> e.getDepartment().equalsIgnoreCase("IT");

//        list.stream()
//                .filter(isIT)
//                .max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(System.out::println);

        Employee employee1 = list.stream().filter(isIT).max(Comparator.comparing(Employee::getSalary)).orElseThrow();

        System.out.println(employee1);
    }
}
