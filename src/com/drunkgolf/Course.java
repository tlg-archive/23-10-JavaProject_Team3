package com.drunkgolf;

import java.util.*;

import com.apps.util.Console;
import com.apps.util.Prompter;

import static com.drunkgolf.Scoring.*;
import static com.drunkgolf.Scoring.DOUBLE_BOGEY;

public class Course {

    //fields
    int courseSize;
    boolean complete = false;
    boolean holeComplete = false;
    Hole hole;

    //ctor
    public Course(int courseSize) {
        this.courseSize = courseSize;
    }


    //lists
    List<Integer> scoreCard = new ArrayList<>();
    List<Hole> course = new ArrayList<>();

    //methods
    public boolean isComplete() {
        if (course.isEmpty()) {
            complete = true;
        }
        return complete;
    }

    public void buildCourse() {
        for (int i = 0; i < courseSize; i++) {
            Hole hole = new Hole();
            course.add(hole);
        }
        int holeCount = 1;
        showCourse(holeCount);
    }

    public Hole getHole() {
        hole = course.get(0);
        printScore();
        System.out.printf("\n\nHole %s: is %s yards away.\n" +
                "The par for the hole is: %s \n" +
                "Score Card: %s\n",scoreCard.size() + 1, hole.getDistanceToHole(), hole.getPar(), getScore());
        holeComplete = false;
        return hole;
    }
    public void currentHoleInfo() {
        hole = course.get(0);
        printScore();
        if(!hole.holeComplete()) {
            System.out.printf("\n\nHole %s: is %s yards away.\n" +
                    "The par for the hole is: %s \n" +
                    "Lying: %s\n" +
                    "Score Card: %s\n",scoreCard.size() + 1, hole.getDistanceToHole(), hole.getPar(), hole.getSwingsTaken() + 1, getScore());
        }
        else {
            System.out.printf("\n\nScore Card: %s\n",getScore());
        }

    }

    public void play(ClubType clubType) {

        System.out.println("Swinging with your " + clubType.toString(clubType));
        hole.updateDistance(clubType.swingClub(clubType));

    }
    public void setHoleComplete() {

        if(getHoleComplete()){
            if (hole.getSwingsTaken() == Hole.HOLE_IN_ONE  ) {
                System.out.println("HOLE IN ONE!!!!!!!!");
            }
            else if(hole.score() == ALBATROSS.getAlbatross()) {
                System.out.println("! I'M AN ALBATROSS !");
            }
            else if (hole.score() == EAGLE.getEagle()) {
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
    public int getCourseSize() {
        return courseSize;
    }

    public void setCourseSize(int courseSize) {
        this.courseSize = courseSize;
    }

    public List<Integer> getScoreCard() {
        return scoreCard;
    }

    public int getScore() {
        int sum = 0;
        for (int score : scoreCard) {
            sum += score;
        }
        return sum;
    }

    private void showCourse(int holeCount) {
        for (Hole hole : course) {
            System.out.printf("Hole Number %s: is %s yards away.\n", holeCount, hole.getInitialDistance());
            holeCount++;
        }
    }
    public boolean getHoleComplete() {
        return hole.holeComplete();
    }
    private void printScore() {
        System.out.println("Score: " + scoreCard);
    }

    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", holes= " + getCourseSize();
    }
}