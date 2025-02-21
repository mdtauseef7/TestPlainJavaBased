package com.practic.designpattern.facade;

class HomeTheaterFacade {
    private Amplifier amplifier;
    private Projector projector;
    private Screen screen;
    private Lights lights;
    private BluRayPlayer bluRayPlayer;

    public HomeTheaterFacade(Amplifier amplifier, Projector projector, Screen screen, Lights lights, BluRayPlayer bluRayPlayer) {
        this.amplifier = amplifier;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.bluRayPlayer = bluRayPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(20);
        bluRayPlayer.on();
        bluRayPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the theater...");
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        bluRayPlayer.off();
    }
}

