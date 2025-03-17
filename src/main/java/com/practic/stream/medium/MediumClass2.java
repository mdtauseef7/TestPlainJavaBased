package com.practic.stream.medium;


import lombok.*;

import java.math.BigDecimal;
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
       // System.out.println(collect3);


        List<Orders> orders = Arrays.asList(new Orders(Arrays.asList(new Item("Pears",200.45, 22),new Item("Mangoes",120.45, 45),new Item("Oranges",145.67, 22),new Item("Mandarins",207.45, 89))),
                new Orders(Arrays.asList(new Item("Pears",200.45, 21),new Item("Mangoes",120.45, 459),new Item("Oranges",345.67, 22),new Item("Mandarins",207.45, 89))));


        Map<String, Double> collect4 = orders.stream().flatMap(orders1 -> orders1.items.stream()).collect(Collectors.groupingBy(Item::getName, Collectors.summingDouble(Item -> Item.price * Item.quantity)));

       // System.out.println(collect4);

        List<EmployeeA> employeesA = Arrays.asList(new EmployeeA("Vikas",new Department("IT"),new BigDecimal(212345.67)),
                new EmployeeA("Ravi",new Department("Commercial"),new BigDecimal(12345.67)),
                new EmployeeA("Rajni",new Department("Procurment"),new BigDecimal(322345.67)),
                new EmployeeA("Sinha",new Department("Commercial"),new BigDecimal(42345.67)));


        Map<String, Double> collect5 = employeesA.stream().filter(emp -> emp.getSalary().doubleValue() > 50000.00)
                .collect(Collectors.groupingBy(EmployeeA::getDepartment, Collectors.averagingDouble(emp -> emp.getSalary().doubleValue())))
                .entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().getName(), entry -> entry.getValue()));


        //System.out.println(collect5);


        String val= "Hello world this is java";

        String collect6 = Arrays.stream(val.split(" ")).map(MediumClass2::reverse).collect(Collectors.joining(" "));
        //System.out.println(collect6);

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(7, 8, 9) );

       // nestedLists.stream().flatMap(list1 -> list1.stream()).distinct().sorted(Comparator.reverseOrder()).map(val1 -> val1*val1).forEach(System.out::println);

        String[] names = {"banana:fruit", "potato:Vegetable", "apple:fruit", "tomato:Vegetable","orange:fruit"};


        Map<String, List<String>> collect7 = Arrays.stream(names) // Convert the array into a stream
                .map(str -> str.split(":")) // Split each string by ":" into an array (food item and category)
                .collect(Collectors.groupingBy(arr -> arr[1],  // Group by the category (second element of the array)
                        Collectors.mapping(arr -> arr[0], Collectors.toList()))); //
        //System.out.println(collect7);


        List<Product> products = Arrays.asList(
                new Product("Laptop", 70000),
                new Product("Mouse", 499),
                new Product("Keyboard", 999),
                new Product("Monitor", 5000));


        List<Product> list1 = products.stream().filter(product -> product.getPrice() < 500).sorted(Comparator.comparing(Product::getName)).toList();
        //System.out.println(list1);

        List<EmployeeB> employeesb = Arrays.asList(
                new EmployeeB("Raj", "IT"),
                new EmployeeB("Priya", "HR"),
                new EmployeeB("Amit", "IT"),
                new EmployeeB("Neha", "Finance"));


        employeesb.stream().collect(Collectors.groupingBy(EmployeeB::getDepartment,Collectors.mapping(EmployeeB::getName,Collectors.toList())));



    }

    public static String reverse(String str){
        if(str == null ||str.isBlank()){
            return str;
        }
        int left=0, right=str.length()-1;
        char[] tempArray = new char[str.length()];
        while (left<=right){
            tempArray[left] = str.charAt(right);
            tempArray[right] =str.charAt(left);
            left++;
            right--;
        }

        return  String.valueOf(tempArray);

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
@Getter
@AllArgsConstructor
class Item {
    String name;
    double price;
    int quantity;
}
@AllArgsConstructor
class Orders {
    List<Item> items;

}
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class EmployeeA {
    private String name;
    private Department department;
    private BigDecimal salary;

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
 class Department {
    private String name;
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}

@AllArgsConstructor
@ToString
@Getter
class EmployeeB {
    private String name;
    private String department;


}


