package com.drunkgolf;

class Hole {
    private int par;
    private int swingsTaken;
    private int distanceToHole;

    // ctor
    public Hole(int par, int initialDistance) {
        this.par = par;
        this.swingsTaken = 0;
        this.distanceToHole = initialDistance;
    }

    // score
    public int score() {
        return swingsTaken - par;
    }

    // method to update the distance after swing
    private void updateDistance(int distance) {
        distanceToHole -= distance;
    }

    public boolean endHole() {
        return swingsTaken >= par + 2;
    }

    public int getPar() {
        return par;
    }

    public int getSwingsTaken() {
        return swingsTaken;
    }

    public int getDistanceToHole() {
        return distanceToHole;
    }
}