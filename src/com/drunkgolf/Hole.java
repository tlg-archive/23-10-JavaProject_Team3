package com.drunkgolf;

public class Hole {
    static final int MIN_DISTANCE = 100;
    static final int MAX_DISTANCE = 500;
    static final int WIN_TOLERANCE = 8;
    static final int PAR_TOLERANCE = 2;
    static final int HOLE_IN_ONE = 1;


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
        return getSwingsTaken() - getPar();
    }

    // method to update the distance after swing
    public void updateDistance(int distance) {
        if (distanceToHole > WIN_TOLERANCE) {
            ++swingsTaken;
            distanceToHole = Math.abs(distanceToHole - distance);
        }
    }

    boolean holeComplete() {
        boolean holeComplete = false;
        if (distanceToHole <= WIN_TOLERANCE) {
            holeComplete = true;
        } else if (swingsTaken == getPar() + PAR_TOLERANCE) {
            holeComplete = true;
            System.out.println("TRASH BRUH ;-;\n");
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

    public int getSwingsTaken() {
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