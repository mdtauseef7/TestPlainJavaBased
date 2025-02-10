package com.practic.designpattern.factorymethod;

public interface Factory {
    Car makeCar();
}

class MakeTataCar implements Factory{
    @Override
    public Car makeCar() {
        return new TataCar();
    }
}

class MakeMarutiCar implements Factory{
    @Override
    public Car makeCar() {
        return new MarutiCar();
    }
}

