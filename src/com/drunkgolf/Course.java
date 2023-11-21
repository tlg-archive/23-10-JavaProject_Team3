package com.drunkgolf;

import com.apps.util.Console;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.drunkgolf.ClubType.*;
import static com.drunkgolf.ClubType.PUTTER;
import static com.drunkgolf.HoleResult.*;
import static com.drunkgolf.HoleResult.DOUBLE_BOGEY;

public class Course {

    //fields
    int courseSize;
    boolean complete = false;
    boolean holeComplete = false;
    Hole hole;
    private Path golfTeeAscii = Path.of("art/golfteeAscii.txt");
    private Path golfSwingAscii = Path.of("art/golfswingAscii.txt");

    //ctor
    public Course(int courseSize) {
        setCourseSize(courseSize);
    }

    //lists
    List<Integer> scoreCard = new ArrayList<>();
    List<Hole> course = new ArrayList<>();

    //methods
    public void buildCourse() { //adds Holes to course list (1, 9, 18)
        for (int i = 0; i < courseSize; i++) {
            Hole hole = new Hole();
            course.add(hole);
        }
        int holeCount = 1;
        showCourse(holeCount);
    }

    public Hole getHole() { //gets next hole and gives information about it
        hole = course.get(0);
        printScore();
        try {
            List<String> asciiArt = Files.readAllLines(golfTeeAscii);
            printAscii(asciiArt);
        } catch (IOException e) {

        }
        System.out.printf("\n\nHole %s: is %s yards away.\n" +
                "The par for the hole is: %s \n" +
                "Score Card: %s\n", scoreCard.size() + 1, hole.getDistanceToHole(), hole.getPar(), getScore());
        printClubRanges();
        holeComplete = false;
        return hole;
    }

    public void play(ClubType clubType) {
        Console.clear();
        System.out.println("Swinging with your " + clubType.toString(clubType));
        try {
            List<String> asciiArt = Files.readAllLines(golfSwingAscii);
            printAscii(asciiArt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hole.updateDistance(clubType.swingClub(clubType));

    }

    public void currentHoleInfo() { //tells you information about the current hole and prints ascii
        hole = course.get(0);
        printScore();
        try {
            List<String> asciiArt = Files.readAllLines(golfTeeAscii);
            printAscii(asciiArt);
        } catch (IOException e) {
        }

        if (!hole.holeComplete()) {
            System.out.printf("\n\nHole %s: is %s yards away.\n" +
                    "The par for the hole is: %s \n" +
                    "Lying: %s\n" +
                    "Score Card: %s\n", scoreCard.size() + 1, hole.getDistanceToHole(), hole.getPar(), hole.getSwingsTaken() + 1, getScore());
            printClubRanges();
        } else {
            System.out.printf("\n\nScore Card: %s\n", getScore());
        }

    }

    public void setHoleComplete() {
        //gives feedback based on your score or swingsTaken adds your score for the hole to your scorecard and
        //      removes the hole form the course list

        if (getHoleComplete()) {
            if (hole.getSwingsTaken() == Hole.HOLE_IN_ONE) {
                System.out.println("HOLE IN ONE!!!!!!!!");
            } else if (hole.score() == ALBATROSS.getAlbatross()) {
                System.out.println("! I'M AN ALBATROSS !");
            } else if (hole.score() == EAGLE.getEagle()) {
                System.out.println("KA-KAW");
            } else if (hole.score() == BIRDIE.getBirdie()) {
                System.out.println("Birdie");
            } else if (hole.score() == PAR.getPar()) {
                System.out.println("Par");
            } else if (hole.score() == BOGEY.getBogey()) {
                System.out.println("Bogeyyyyyyy");
            } else if (hole.score() == DOUBLE_BOGEY.getDoubleBogey()) {
                System.out.println("Double Bogey");
            }
            scoreCard.add(hole.score());
            course.remove(hole);
        }
    }

    //accessors
    public boolean isComplete() { //sets course to complete
        if (course.isEmpty()) {
            complete = true;
        }
        return complete;
    }

    public int getCourseSize() {
        return courseSize;
    }

    public void setCourseSize(int courseSize) {
        this.courseSize = courseSize;
    }

    public List<Integer> getScoreCard() {
        return scoreCard;
    }

    public int getScore() { //keeps a running talley of your overall score
        int sum = 0;
        for (int score : scoreCard) {
            sum += score;
        }
        return sum;
    }

    private void showCourse(int holeCount) {
        //prints entire course by assigning the hole a number and putting the initialDistance beside it
        for (Hole hole : course) {
            System.out.printf("Hole Number %s: is %s yards away.\n", holeCount, hole.getInitialDistance());
            holeCount++;
        }
    }

    public boolean getHoleComplete() { //checks if current hole in the hole list is complete
        return hole.holeComplete();
    }

    private void printScore() {
        System.out.println("Score: " + scoreCard);
    }

    private void printAscii(List<String> asciiArt) {
        for (String line : asciiArt) {
            System.out.println(line);
        }
    }

    private void printClubRanges() { //displays the ranges of each club for the end user
        System.out.println("-----------------------");
        System.out.println(
                "Driver Range: " + DRIVER.getDriverRange() +
                        "\nIron Range: " + IRON.getIronRange() +
                        "\nWedge Range: " + WEDGE.getWedgeRange() +
                        "\nPutter Range: " + PUTTER.getPutterRange()
        );
        System.out.println("-----------------------");
    }
}