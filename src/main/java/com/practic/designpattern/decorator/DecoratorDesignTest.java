package com.practic.designpattern.decorator;

public class DecoratorDesignTest {
    public static void main(String[] args) {
        Car luxurySuperCar = new LuxuryCar(new SportsCar(new BasicCar()));
         luxurySuperCar.makeCar();
    }
}
