package com.java8interviewprograms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public int getAge() 
    {
        return age;
    }
    public String getGender() 
    {
        return gender;
    }
    public String getDepartment() 
    {
        return department;
    }
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
    public double getSalary() 
    {
        return salary;
    }
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
//        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        
//      Find out the count of male and female employees present in the organization?
        Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(collect);
        
//      Write a program to print the names of all departments in the organization.
        Set<String> collect2 = employeeList.stream().map(e->e.getDepartment())
        		.collect(Collectors.toSet());
        System.out.println(collect2);
        
//      Find the average age of Male and Female Employeeoyees.
     DecimalFormat df = new DecimalFormat("0.00");
       Map<String, Double> collect3 = employeeList.stream()
        		.collect(Collectors.groupingBy(Employee::getGender,Collectors
        				.averagingInt(Employee::getAge)));
       System.out.println(collect3);
       
//      Get the Names of employees who joined after 2015.
       
       Set<String> collect4 = employeeList.stream().filter(x->x.yearOfJoining > 2015)
    		   .map(Employee::getName).collect(Collectors.toSet());
       System.out.println(collect4);
       
//    Count the number of employees in each department.
       Map<String, Long> collect5 = employeeList.stream()
       .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
       System.out.println(collect5);
       
//      Find out the average salary of each department.
       Map<String, Double> collect6 = employeeList.stream()
       .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
       System.out.println(collect6);
       
//     Find out the oldest employee, his/her age and department?
       Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
       System.out.println(max);
       
//     Find out the average and total salary of the organization.
       DoubleSummaryStatistics collect7 = employeeList.stream()
    		   .collect(Collectors.summarizingDouble(Employee::getSalary));
       System.out.println(collect7.getAverage());
       System.out.println(collect7.getSum());
       
//    List down the employees of each department.
      Map<String, List<Employee>> collect8 = employeeList.stream()
      .collect(Collectors.groupingBy(Employee::getDepartment));
      collect8.entrySet().stream()
      .forEach(e->System.out.println(e.getKey() + e.getValue()));
      
//    Find out the highest experienced employees in the organization
      Optional<Employee> min = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
      System.out.println(min);    
      
//   To collect a stream of values and pass to list
      Map<Integer, Set<Employee>> collect9 = employeeList.stream().collect(Collectors.groupingBy(e->e.getAge(),Collectors.toSet()));
      System.out.println("Collect 9 :" + collect9);
      
//		-- To collect a stream of value and pass to TreeMap
      
      
//  	-- To get a age in sorted list and fetch the second largest value 
		List<Integer> ages = employeeList.stream()
				.map(emp -> emp.getAge()).sorted().collect(Collectors.toList());
		
		 ages.stream().skip(1).limit(2).collect(Collectors.toSet()).forEach(x->System.out.println(x));
		 
//		to convert to upper case
		Map<String, List<Employee>> collect10 = employeeList.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.toList())); 
		
		
    }    
 }