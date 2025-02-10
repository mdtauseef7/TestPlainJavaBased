package com.practic.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        List<String> cityNames = Arrays.asList("blr","hyd","del","mum");

        List<String> capCityName = cityNames.stream().map(String::toUpperCase).collect(Collectors.toList());
        
        //System.out.println(capCityName);

        List<String> smallCities = Arrays.asList("pat","katihar","mysore","bhagalpur");

        List<String> allCitiesName = Stream.of(cityNames, smallCities).flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.toList());

        //System.out.println(allCitiesName);


        List<Integer>  numList = Arrays.asList(6,7,32,4,3,2,4,3,6,7,2);

       // List<Integer> distinctNumList = numList.stream().distinct().collect(Collectors.toList());

        //System.out.println(distinctNumList);

       // List<String> reversedOrder = cityNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //System.out.println(reversedOrder);

        //cityNames.stream().map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());

        //List<Integer> firstThreeEle = numList.stream().limit(3).collect(Collectors.toList());

        //System.out.println(firstThreeEle);

        //List<Integer> skipTwoEle = numList.stream().skip(2).collect(Collectors.toList());

        //System.out.println(skipTwoEle);

        Optional<Integer> multiResult = numList.stream().reduce((integer, integer2) -> integer * integer2);

        //System.out.println(multiResult.get());

        boolean b = numList.stream().allMatch(value -> value > -1);
        //System.out.println(b);

        boolean b1 = numList.stream().anyMatch(integer -> integer > 2890);
        //System.out.println(b1);

       // String[] cityNamesArr = cityNames.stream().toArray(String[]::new);


        String commaSeparatedStr = cityNames.stream().map(s -> s.concat(",")).collect(Collectors.joining());
        System.out.println(commaSeparatedStr);


        List<People> peopleList = Arrays.asList(new People("Ram","Blr"),
                new People("Sohan","Hyd"),
                new People("Shyam","Blr"),
                new People("Rama","Blr"),
                new People("Tauseef","Hyd"),
                new People("Sohain","Blr"));

        Map<String, List<People>> collect =
                peopleList.stream().collect(Collectors.groupingBy(People::getCity));

        //System.out.println(collect);

        String str = "Tauseef";

        Map<String, Long> collect2 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //System.out.println(collect2);


    }
}

class People {

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    String name;
    String city;

    public People(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
