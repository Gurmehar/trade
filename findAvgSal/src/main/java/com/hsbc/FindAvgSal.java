package com.hsbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FindAvgSal {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Employee> employees = new ArrayList<>();

			employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer",  Double.valueOf (10000)));
			employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", Double.valueOf(12000)));
			employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", Double.valueOf(14000)));
			employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", Double.valueOf(15000)));
			employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", Double.valueOf(16000)));
			employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", Double.valueOf(12000)));
			employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", Double.valueOf(12000)));
			employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", Double.valueOf(16000)));
			employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", Double.valueOf(20000)));
			employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", Double.valueOf(14000)));

      new FindAvgSal().findAverageSalary(employees);


    }

    public void findAverageSalary(List<Employee> employees){

			employees.parallelStream()
				.collect(Collectors.groupingBy(Employee::getByOfficeAndDesignation))
				.entrySet().parallelStream().forEach(e -> {

					OptionalDouble average = e.getValue().parallelStream()
						.mapToDouble(Employee::getSalary).average();
					System.out.println(	e.getKey()+" "+average.getAsDouble());

				});

			
		}


}