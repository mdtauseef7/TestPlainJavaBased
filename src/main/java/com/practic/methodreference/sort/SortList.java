package com.practic.methodreference.sort;

import com.practic.methodreference.Student;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortList {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Welcome", "to", "the", "java", "world");
        List<String> words1 = Arrays.asList("Welcome1", "to1", "the1", "java1", "world1");

        /*Map<Character, Long> charFrequency = words.stream() //Stream<String>
                .flatMap(a -> a.chars().mapToObj(c -> (char) c)) // Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charFrequency);

        List<String> newList = Stream.of(words,words1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());*/


        List<Integer > allWords = Stream.of(words,words1)
                .peek(a ->System.out.println("after  stream: "+a))
                .flatMap(Collection::stream)
                .peek(a ->System.out.println("after flatMap stream: "+a))
                .map(b -> b.length())
                .distinct()
                .sorted((a,b) -> b-a)
                .collect(Collectors.toList());
                //System.out.println("Final list: "+allWords);
                

        Student s1 = new Student(1,"Tauseef");
        Student s2 = new Student(2,"Ruby");
        Student s3 = new Student(3,"Taufiaque");
        Student s4 = new Student(4,"Chunna");
        Student s5 = new Student(5,"Nikhat");




        List<Student> students = Stream.of(s1, s5, s3, s4, s2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //System.out.println(students);

        Comparator<Student> rollThenNameComparator = Comparator
                .comparing(Student::getRollNo)
                .thenComparing(Student::getName);

        List<Student> students2 = Stream.of(s1, s5, s3, s4, s2).sorted(rollThenNameComparator).collect(Collectors.toList());
        //System.out.println(students2);


        List<Student> students3 = Stream.of(s1, s5, s3, s4, s2).sorted(rollThenNameComparator.reversed()).collect(Collectors.toList());
        System.out.println(students3);

        //students3.forEach(System.out::println);

        List<String> studentsName = Stream.of(s1, s5, s3, s4, s2).map(s -> s.getName()).collect(Collectors.toList());
        studentsName.forEach(System.out::println);
    }
}
