package com.drunkgolf;

import static com.drunkgolf.Scoring.*;

public class Hole {
    private static final int MIN_DISTANCE = 100;
    private static final int MAX_DISTANCE = 500;
    private static final int WIN_TOLERANCE = 8;
    private static final int PAR_TOLERANCE = 2;
    private static final int HOLE_IN_ONE = 1;


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
        ++swingsTaken;
        distanceToHole = Math.abs(distanceToHole - distance);
        System.out.printf("The hole is %s yards away.\n", distanceToHole);
    }

    boolean holeComplete() {
        boolean holeComplete = false;
        if (distanceToHole < WIN_TOLERANCE) {
            holeComplete = true;
            if (swingsTaken == HOLE_IN_ONE) {
                System.out.println("HOLE IN ONE!!!!!!!!");
            }
            else if(score() == ALBATROSS.getAlbatross()) {
                System.out.println("! I'M AN ALBATROSS !");
            }
            else if (score() == EAGLE.getEagle()) {
                System.out.println("KA-KAW");
            } else if (score() == BIRDIE.getBirdie()) {
                System.out.println("Birdie");
            } else if (score() == PAR.getPar()) {
                System.out.println("Par");
            } else if (score() == BOGEY.getBogey()) {
                System.out.println("Bogeyyyyyyy");
            } else if (score() == DOUBLE_BOGEY.getDoubleBogey()) {
                System.out.println("Double Bogey");
            }
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