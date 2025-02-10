package com.practic.designpattern.factorymethod;

public interface Car {
    void make();
}

class TataCar implements Car {
    @Override
    public void make() {
        System.out.println("========TataCar======");
    }
}

class MarutiCar implements Car {
    @Override
    public void make() {
        System.out.println("========MarutiCar======");
    }
}
