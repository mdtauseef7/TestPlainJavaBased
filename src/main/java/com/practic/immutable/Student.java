package com.practic.immutable;

import java.util.stream.Stream;

public final class  Student {
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    private final int rollNo;
    private final String name;
    private final Address address;
    public int getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public Address getAddress() {
        return new Address(address.getHouseNo(),address.getLocation());
    }

    public Student(int rollNo, String name, Address address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address =  new Address(address.getHouseNo(),address.getLocation());;
    }
}


class Address {
    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", location='" + location + '\'' +
                '}';
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getLocation() {
        return location;
    }

    private final int houseNo;
    private final String location;
    public Address(int houseNo, String location) {
        this.houseNo = houseNo;
        this.location = location;
    }

}
