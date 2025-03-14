package com.practic.stream.medium;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MediumClass2 {
    public static <Order> void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 75000)
        );

        //employees.stream().filter(employee -> employee.getSalary() >50000).forEach(System.out::println);

        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "kiwi");

        //strings.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        List<String> strings1 = Arrays.asList("apple", "banana", "orange","grape", "melon");

        long count = strings1.stream().flatMapToInt(String::chars).filter(value -> value == 'a').count();
        //System.out.println(count);

        List<String> list = Arrays.asList("Wood","Box","Camera","Apple", "Mango");

        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Function.identity(), String::length));

        //System.out.println(collect);

        List<String> list2 = Arrays.asList("Wood","Box","Camera","Apple", "Mango");

        Map<String, Integer> collect1 = list2.stream().max(Comparator.comparingInt(String::length)).stream().collect(Collectors.toMap(Str -> Str, String::length));
        //System.out.println(collect1);

        //list2.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        String name = "BANANA";
        Map<String, Long> collect2 = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(collect2);

        int arr1[] = {1, 3, 2, 1, 4, 1, 3, 3, 3};

        Optional<Integer> i = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey);
        //System.out.println(i.get());

        String input = "javastreams";

        Optional<String> first = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() > 1).findFirst().map(Map.Entry::getKey);


        //System.out.println(first.get());

        List<Person> people = Arrays.asList(
                new Person("Alice", "Bethany", "Smith", Gender.FEMALE),
                new Person("Bob", "Charles", "Doe", Gender.MALE),
                new Person("Carol", "Diane", "White", Gender.FEMALE),
                new Person("Eve", "Francis", "Brown", Gender.OTHERS)
        );

        List<String> collect3 = people.stream().filter(person -> Gender.FEMALE.equals(person.getGender())).map(Person::getMiddleName)
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect3);


    }
}
@ToString
@Getter
@AllArgsConstructor
class Person{
    String firstName;
    String middleName;
    String lastName;
    Enum Gender;
}

enum Gender{
    MALE,FEMALE,OTHERS;
}

@ToString
class Employee {
    String name;
    double salary;
    public double getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }


    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


}
