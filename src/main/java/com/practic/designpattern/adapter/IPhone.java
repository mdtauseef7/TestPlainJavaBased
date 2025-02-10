package com.practic.designpattern.adapter;

public interface IPhone {
    public void OnCharge();
}


class IPhone4S implements  IPhone{
    @Override
    public void OnCharge() {
        System.out.println("===============IPhone4S============");
    }
}

class IPhone6S implements  IPhone{
    IPhone6STo4SChargerAdapter iPhone6STo4SChargerAdapter;

    public IPhone6S(IPhone6STo4SChargerAdapter iPhone6STo4SChargerAdapter) {
        this.iPhone6STo4SChargerAdapter = iPhone6STo4SChargerAdapter;
    }

    @Override
    public void OnCharge() {
        System.out.println("===============IPhone6S============");
        iPhone6STo4SChargerAdapter.charge();
    }
}

