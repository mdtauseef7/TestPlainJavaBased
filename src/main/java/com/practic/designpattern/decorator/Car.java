package com.practic.designpattern.decorator;

public interface Car {
    void makeCar();

}

class BasicCar implements Car{
    @Override
    public void makeCar() {
        System.out.println("BasicCar Car");
    }
}

class  CarDecorator implements  Car{
    protected Car car;
    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void makeCar() {
      this.car.makeCar();
    }

}

class SportsCar extends CarDecorator{
    public SportsCar(Car car){
      super(car);
    }
    @Override
    public void makeCar() {
        super.makeCar();
        System.out.println("SportsCar Car");
    }
}

class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car){
        super(car);
    }
    @Override
    public void makeCar() {
        super.makeCar();
        System.out.println("LuxuryCar Car");
    }
}


