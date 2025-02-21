package com.practic.designpattern.facade;

public class FacadePatternExample {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();
        Lights lights = new Lights();
        BluRayPlayer bluRayPlayer = new BluRayPlayer();

        // Create the facade object
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amplifier, projector, screen, lights, bluRayPlayer);

        // Client uses the simplified interface to watch a movie
        homeTheater.watchMovie("Inception");

        // When the movie is done, shut down the system
        homeTheater.endMovie();
    }
}
