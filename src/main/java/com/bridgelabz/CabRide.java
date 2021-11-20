package com.bridgelabz;

public class CabRide {
    private final double distance;
    private final int time;

    //ride constructor assign distance and time values
    public CabRide(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
