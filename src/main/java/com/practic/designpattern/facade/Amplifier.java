package com.practic.designpattern.facade;

class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }
}

class Screen {
    public void up() {
        System.out.println("Screen is up");
    }

    public void down() {
        System.out.println("Screen is down");
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%");
    }

    public void on() {
        System.out.println("Lights on");
    }
}

class BluRayPlayer {
    public void on() {
        System.out.println("Blu-ray player is on");
    }

    public void off() {
        System.out.println("Blu-ray player is off");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}
