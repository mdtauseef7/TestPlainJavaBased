package com.practic.sort.comperator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {

        Student student1 = new Student("Tauseef",2,"Math");
        Student student2 = new Student("Ruby",5,"Physics");
        Student student3 = new Student("Taufiaque",4,"Hindi");
        Student student4 = new Student("Rekha",6,"Chemistary");

        List<Student> studentList = Arrays.asList(student1,student2,student4,student3);

        Collections.sort(studentList,new NameComparator());

        System.out.println(studentList);

        Collections.sort(studentList,(o1,o2) -> {
            return Integer.compare(o1.getRollNo(),o2.getRollNo());
        });

        System.out.println(studentList);
    }
}

class RollNoComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getRollNo(),o2.getRollNo());
    }
}

class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getSubject() {
        return subject;
    }

    private String name;
    private int rollNo;
    private String subject;

    public Student(String name, int rollNo, String subject) {
        this.name = name;
        this.rollNo = rollNo;
        this.subject = subject;
    }
}



