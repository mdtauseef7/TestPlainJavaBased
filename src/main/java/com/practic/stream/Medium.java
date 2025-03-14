package com.practic.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Medium {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, Long> collect = words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect1 = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        //collect1.get(Boolean.TRUE).forEach(System.out::print);
        //System.out.println();
        //collect1.get(Boolean.FALSE).forEach(System.out::print);

        List<Integer> numbers1 = Arrays.asList(10, 20, 5, 30, 15);
        //numbers1.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        List<String> words1 = Arrays.asList("apple", "banana", "cherry", "date");
        String collect2 = words1.stream().collect(Collectors.joining(","));
        //System.out.println(collect2);

        //words1.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "aam");
        Map<String, List<String>> collect3 = words2.stream().collect(Collectors.groupingBy(str -> str.substring(0, 1), Collectors.mapping(String::valueOf, Collectors.toList())));
        //System.out.println(collect3);


        List<String> sentenceList = Arrays.asList(
                "This is a short sentence.",
                "Here is another sentence with more words.",
                "This is the longest sentence among them all, with the most words."
        );

        /*sentenceList.stream().collect(Collectors.groupingBy(str -> str.split(" ").length, Collectors.mapping(String::valueOf,Collectors.toList())))
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .ifPresent(System.out::println);*/

        //sentenceList.stream().max(Comparator.comparingInt(str -> str.split(" ").length)).ifPresent(System.out::println);


        List<Product> productList = Arrays.asList(
                new Product("Laptop", "Electronics", 1500),
                new Product("Phone", "Electronics", 800),
                new Product("Shirt", "Clothing", 50),
                new Product("Jacket", "Clothing", 120)
        );

        productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))))
                .forEach((category, product) -> {
                    // System.out.println("Category:: "+category+"^^^^Price: "+product.get().price);
                });

        List<String> listWithNulls = Arrays.asList("apple", null, "banana", null, "cherry");

        // listWithNulls.stream().filter(Objects::nonNull).forEach(System.out::println);

        List<Account> accountList = Arrays.asList(
                new Account("active", 2000),
                new Account("inactive", 500),
                new Account("active", 1500),
                new Account("inactive", 800)
        );

        double active = accountList.stream().filter(A -> A.status.equals("active")).mapToDouble(Account::getPrice).sum();
        //System.out.println(active);

        Map<String, List<Student>> studentsByGrade = new HashMap<>();
        studentsByGrade.put("Grade 10", Arrays.asList(new Student("Alice"), new Student("Bob")));
        studentsByGrade.put("Grade 11", Arrays.asList(new Student("Charlie"), new Student("David")));

        List<String> collect4 = studentsByGrade.values().stream().flatMap(Collection::stream).map(Student::getName).collect(Collectors.toList());
        // System.out.println(collect4);

        List<Integer> integerList = Arrays.asList(5, 3, 8, 6, 2, 7, 4, 1);

        //integerList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);

        int[] arcr1 = {-1, 0, 5, 6, 10};
        int[] arr2 = {1, 2, 3, 7, 9, 11};

        // IntStream.concat(IntStream.of(arcr1),IntStream.of(arr2)).sorted().forEach(System.out::println);

        List<Integer> list1 = List.of(-1, 0, 5, 6, 10);
        List<Integer> list2 = List.of(1, 2, 3, 7, 9, 11);

        List<Integer> collect5 = Stream.of(list1, list2).flatMap(List::stream).collect(Collectors.toList());
        //collect5.forEach(System.out::println);

        List<String> names = List.of("Sachin Tendulkar", "MS Dhoni", "Virat Kohli", "Lionel Messi",
                "Cristiano Ronaldo", "Roger Federer", "Muhammad Ali", "Michael Jordan");

        //names.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        // names.stream().min(Comparator.comparingInt(String::length)).ifPresent(System.out::println);


        int[] arr1 = {1, 4, 5, 7, 2, 3, 11, 18, 25};

        // Arrays.stream(arr1).boxed().collect(Collectors.partitioningBy(a->a%2==0));

        List<Expense> expenses = List.of(
                new Expense("13-09-2024", 60),
                new Expense("13-09-2024", 45),
                new Expense("14-09-2024", 15),
                new Expense("15-09-2024", 100),
                new Expense("15-09-2024", 260),
                new Expense("15-09-2024", 190),
                new Expense("16-09-2024", 900)
        );

        Map<String, Integer> collect6 = expenses.stream().collect(Collectors.groupingBy(Expense::getDate, Collectors.summingInt(Expense::getAmount)));
        //System.out.println(collect6);

        String s = "APJ Abdul Kalam";
        Map<String, Long> collect7 = Stream.of(s.split("")).filter(str -> str != null && !str.isBlank()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //System.out.println(collect7);

        List<Integer> numbers23 = List.of(1, 4, 6, 8, 9, 13);

      //  boolean b = numbers23.stream().anyMatch(Medium::isPrime);

        List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 4, 3, 1, 5, 6);

        List<Integer> collect8 = numbers2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        //System.out.println(collect8);

        List<String> countries = List.of("India", "Russia", "Brazil", "Spain", "Japan", "United State");

        long count = countries.stream().flatMapToInt(String::chars).filter(a -> a == 'a').count();

        //System.out.println(count);

        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("Ajay",35);
        Employee e2 = new Employee("Vijay",5);
        Employee e3 = new Employee("Zack",30);
        Employee e4 = new Employee("David",51);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        List<Employee> employeeList= employees.stream().sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println(employeeList);





    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;

    }
}


class Employee {
    public Employee(String firstName,int age) {
        this.age = age;
        this.firstName = firstName;
    }



    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    String firstName;
    int age;
}

class Expense {
    private String date;
    private int amount;

    public Expense(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}

class Student{
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    String name;

    public Student(String name) {
        this.name = name;
    }
}

class Account{
    String status;

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    double price;
    public Account(String status,double price) {
        this.price = price;
        this.status = status;
    }

}

 class Product{
    public Product(String productName,String category,double price) {
        this.category = category;
        this.price = price;
        this.productName = productName;
    }



    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
    String productName;

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    String category;
    double price;
}