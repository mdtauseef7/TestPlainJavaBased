package com.practic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MediumQuestions {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        //persons.stream().mapToDouble(Person::getAge).average().ifPresent(System.out::println);

        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        //transactions.stream().collect(Collectors.groupingBy(Transaction::getDate,Collectors.summarizingDouble(Transaction::getAmount)));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

        collect.get(Boolean.TRUE).stream().forEach(System.out::print);
        System.out.println();
        collect.get(Boolean.FALSE).stream().forEach(System.out::print);

    }
}

class Transaction{
    public Transaction(String date,double amount) {
        this.amount = amount;
        this.date = date;
    }

    String date;

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    double amount;



}

class Person{
    String name;
    double age;
    public String getName() {
        return name;
    }
    public double getAge() {
        return age;
    }
    public Person(String name,double age) {
        this.age = age;
        this.name = name;
    }


}
