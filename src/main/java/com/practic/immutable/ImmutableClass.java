package com.practic.immutable;

public class ImmutableClass {

    public static void main(String[] args) {

        Address address = new Address(10,"Katihar");
        Student s1 = new Student(1,"Tauseef",address);

        System.out.println(s1);

        Address address1 = s1.getAddress();

        address1 = new Address(11,"Patna");
        s1 = new Student(1,"Tauseef",address1);

        System.out.println(s1);

    }
}
