package com.practic.designpattern.abstractfactory;

public class AbstractFactory {

    public static void main(String[] args) {
        WinFactory winFactory = new WinFactory();
        winFactory.createButton();
        winFactory.createCheckbox();
    }
}

// Abstract Products
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Products
class WinButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class WinCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

