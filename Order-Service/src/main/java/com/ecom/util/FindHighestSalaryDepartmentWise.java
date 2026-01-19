package com.ecom.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindHighestSalaryDepartmentWise {
    public static void main(String[] args) {

        //find top 3 highest paid employee
        // in each department sorted by salary desc

        List<Employee> list = List.of(new Employee(1,"Bikesh","HR",9000.0),
                new Employee(2,"Rakesh","Java",5000.0),
                new Employee(3,"Umesh","IT",8000.0),
                new Employee(3,"Umesh","HR",9000.0),
                new Employee(3,"Umesh","IT",5000.0));
                new Employee(3,"Umesh","JAVA",4000.0);

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
        System.out.println(employee);
    }
}
