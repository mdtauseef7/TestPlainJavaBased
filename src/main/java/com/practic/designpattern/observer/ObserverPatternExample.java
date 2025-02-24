package com.practic.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(String message) {
        System.out.println(observerName + " received update: " + message);
    }
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Main class to test the Observer Pattern
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a subject (ConcreteSubject)
        ConcreteSubject subject = new ConcreteSubject();

        // Create observers (ConcreteObservers)
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        // Register observers to the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Change the state of the subject, which will notify observers
        subject.setState("New State 1");

        // Change the state again to see how observers react
        subject.setState("New State 2");
    }
}
