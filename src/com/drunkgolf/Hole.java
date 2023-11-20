package com.drunkgolf;

public class Hole {
    private static final int MIN_DISTANCE = 100;
    private static final int MAX_DISTANCE = 500;
    private static final int TOLERANCE = 8;


    private int par;
    private int swingsTaken;
    private int distanceToHole;
    private double initialHoleDistance;


    // ctor


    Hole() {
        this.distanceToHole = generateHole();
        setPar(initialHoleDistance);
    }

    // score
    public int score() {
        return swingsTaken - par;

    }

    // method to update the distance after swing
    public void updateDistance(int distance) {
        distanceToHole = Math.abs(distanceToHole - distance);
        ++swingsTaken;
        System.out.printf("The hole is %s yards away.\n", distanceToHole);
    }

    boolean holeComplete() {
        boolean holeComplete = false;
        if (distanceToHole < TOLERANCE) {
            holeComplete = true;
            printChar("G O O D   J O B   B U D!");
        }
        else if (swingsTaken > getPar() + 1) {
            holeComplete = true;
            printChar("B A D   J O B   B U D");
        }
        return holeComplete;
    }

    private void printChar(String text) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPar() {
        return par;
    }

    private void setPar(double distance) {
        // TODO: switch\if case to calculate par based on distance;
        if (distance > 450) {
            par = 5;
        } else if (distance > 350) {
            par = 4;
        } else {
            par = 3;
        }
    }

    public int getInitialDistance() {
        return (int) initialHoleDistance;
    }

    private int getSwingsTaken() {
        return swingsTaken;
    }

    public int getDistanceToHole() {
        return distanceToHole;
    }

    private int generateHole() {
        initialHoleDistance = Math.random() * (MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
        return (int) initialHoleDistance;
    }
}