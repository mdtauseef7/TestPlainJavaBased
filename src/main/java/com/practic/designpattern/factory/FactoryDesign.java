package com.practic.designpattern.factory;

public class FactoryDesign {
    public static void main(String[] args) {
        Car car = CarFactory.makeCar("Tata");
        car.makeCar();
    }
}
