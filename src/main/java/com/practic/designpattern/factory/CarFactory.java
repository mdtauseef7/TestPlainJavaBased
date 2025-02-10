package com.practic.designpattern.factory;


class CarFactory {
    public static Car makeCar(String name) {
    /*  return switch (name){
            case "Tata" -> new TataCar();
            case "Maruti" -> new MarutiCar();
            default ->  null;
        };*/

        return switch (name){
            case "Tata" : yield new TataCar();
            case "Maruti": yield new MarutiCar();
            default: yield null;
        };
    }
}
