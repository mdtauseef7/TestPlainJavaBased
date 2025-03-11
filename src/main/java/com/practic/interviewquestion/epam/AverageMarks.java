package com.practic.interviewquestion.epam;
/*Given a list of `StudentGrade` objects containing each student's name and grades in various subjects,
your objective is to determine the average grade for each subject across all students and identify the
the highest average grade among all subject. How would you approach this task*/




import java.util.*;
import java.util.stream.Collectors;

public class AverageMarks {

    public static void main(String[] args) {

        List<StudentGrade> studentGrades = new ArrayList<>();
        Map<String, Integer> val = new HashMap<>();
        val.put("Math", 90);
        val.put("Physics", 85);
        val.put("History", 78);
        StudentGrade student1 = new StudentGrade("Student1", val);
        Map<String, Integer> val2 = new HashMap<>();
        val2.put("Math", 92);
        val2.put("Physics", 88);
        val2.put("History", 75);
        StudentGrade student2 = new StudentGrade("Student2", val2);
        Map<String, Integer> val3 = new HashMap<>();
        val3.put("Math", 85);
        val3.put("Physics", 95);
        val3.put("History", 80);
        StudentGrade student3 = new StudentGrade("Student3", val3);

        studentGrades.add(student1);
        studentGrades.add(student2);
        studentGrades.add(student3);


        studentGrades.stream().flatMap(studentGrade -> studentGrade.grades.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.averagingDouble(Map.Entry::getValue)))
                .entrySet().stream().mapToDouble(Map.Entry::getValue).max().ifPresent(System.out::println);
    }

}

class StudentGrade {

    String name;
    Map<String, Integer> grades;

    public StudentGrade(String name,Map<String, Integer> grades) {
        this.grades = grades;
        this.name = name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }
}
