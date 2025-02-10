package com.practic.designpattern.adapter;

public interface Charger {
    void charge();
}

class IPhone4SCharger implements  Charger{
    @Override
    public void charge() {
        System.out.println("===============IPhone4SCharger============");
    }
}

class IPhone6STo4SChargerAdapter implements  Charger{
    IPhone4SCharger iPhone4SCharger;
    public IPhone6STo4SChargerAdapter() {
        this.iPhone4SCharger = new IPhone4SCharger();
    }
    @Override
    public void charge() {
        System.out.println("===============IPhone6STo4SChargerAdapter============");
        iPhone4SCharger.charge();
    }

}

