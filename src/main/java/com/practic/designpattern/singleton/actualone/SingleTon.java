package com.practic.designpattern.singleton.actualone;

public class SingleTon {
    public static void main(String[] args) {
        SingleTonObj singleTon = SingleTonObj.getSingleTonObj();
    }

}

class SingleTonObj {

    private static SingleTonObj singleTonObj;

    private SingleTonObj() {
    }

    public static synchronized SingleTonObj getSingleTonObj() {

        if (singleTonObj == null) {
                singleTonObj = new SingleTonObj();
        }
        return singleTonObj;
    }
}
