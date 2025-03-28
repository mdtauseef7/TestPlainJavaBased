package com.practic.methodreference;

public class Student implements Comparable<Student>{
    private int rollNo;
    private String name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student { " +
                "rollNo: = " + rollNo +
                ", name: = " + name +
                '}';
    }
    @Override
    public int compareTo(Student o) {
        if (this.rollNo != o.rollNo) {
            return this.rollNo - o.rollNo;
        }
        return this.name.compareTo(o.name);
    }
}
