package com.drunkgolf;

public class Hole {
    private static final int MIN_DISTANCE = 100;
    private static final int MAX_DISTANCE = 500;

    private int par;
    private int swingsTaken;
    private int distanceToHole;

    // ctor


    Hole() {
        this.distanceToHole = generateHole();
        setPar(distanceToHole);
        this.swingsTaken = 0;
    }

    // score
    public int score() {
        return swingsTaken - par;

        // scoreCard.add(Hole.score());
    }

    // method to update the distance after swing
    public void updateDistance(int distance) {
        distanceToHole -= distance;
    }

    private boolean endHole() {
        // TODO: adding tolerance for distance | if returning string.
        return swingsTaken >= par + 2;
    }

    public int getPar() {
        return par;
    }

    private void setPar(int distance){
        // TODO: switch\if case to calculate par based on distance;

    }

    private int getSwingsTaken() {
        return swingsTaken;
    }

    public int getDistanceToHole() {
        return distanceToHole;
    }

    private int generateHole(){
        double rand = Math.random() * (MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
        System.out.printf("The hole is %.2f yards.", rand);
        return (int) rand;
    }
}