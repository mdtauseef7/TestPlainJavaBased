package com.practic.designpattern.adapter;

public class IPhone4SChargeTo6SChargerMainClass {

    public static void main(String[] args) {
        IPhone6S iPhone6S = new IPhone6S(new IPhone6STo4SChargerAdapter());
        iPhone6S.OnCharge();
    }

}
