package com.practic.designpattern.builder;

public class Student {
    private String name;
    private int rollNo;
    private String subject;
    public Student(Builder builder) {
        this.name = builder.name;
        this.rollNo = builder.rollNo;
        this.subject = builder.subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                '}';
    }
    public static class Builder{
        private String name;
        private int rollNo;
        private String subject;

        public Builder  name(String name){
            this.name = name;
            return this;
        }

        public Builder  rollNo(int  rollNo){
            this.rollNo = rollNo;
            return this;
        }

        public Builder  subject(String subject){
            this.subject = subject;
            return this;
        }

        public Student built(){
            return new Student(this);
        }
    }
}
