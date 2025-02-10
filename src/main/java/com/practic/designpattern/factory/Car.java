package com.practic.designpattern.factory;

public interface Car {
    void makeCar();

}

class TataCar implements  Car{
    @Override
    public void makeCar() {
        System.out.println("=============TataCar===========");
    }
}

class MarutiCar implements Car{
    @Override
    public void makeCar() {
        System.out.println("=============MarutiCar===========");
    }
}
