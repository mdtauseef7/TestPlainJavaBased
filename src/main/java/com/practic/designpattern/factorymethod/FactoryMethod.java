package com.practic.designpattern.factorymethod;

public class FactoryMethod {
    public static void main(String[] args) {
       Factory factory = new MakeMarutiCar();
       Car car = factory.makeCar();
       car.make();
    }
}
