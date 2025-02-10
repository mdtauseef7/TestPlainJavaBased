package com.practic.sort.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {

        Student student1 = new Student("Tauseef",2,"Math");
        Student student2 = new Student("Ruby",5,"Physics");
        Student student3 = new Student("Taufiaque",4,"Hindi");
        Student student4 = new Student("Rekha",6,"Chemistary");


        List<Student> studentList = Arrays.asList(student1,student2,student4,student3);

        Collections.sort(studentList);

        System.out.println(studentList);

    }


}


class Student implements Comparable{
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                '}';
    }

    private String name;
    private int rollNo;
    private String subject;

    public Student(String name, int rollNo, String subject) {
        this.name = name;
        this.rollNo = rollNo;
        this.subject = subject;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student)o;
        return student.name.compareTo(this.name);
    }
}


