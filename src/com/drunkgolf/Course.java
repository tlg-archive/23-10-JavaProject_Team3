package com.drunkgolf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
    private final Scanner scanner = new Scanner(System.in);

    //fields
    int courseSize;
    boolean complete = false;

    //ctor
    public Course(int courseSize) {
        this.courseSize = courseSize;
    }


    //lists
    List<Integer> scoreCard = new ArrayList<>();
    List<Hole> course = new ArrayList<>();

    //methods
    public boolean isComplete() {
        if(course.isEmpty()) {
            complete = true;
        }
        return complete;
    }

    public void getCourse(){
        for (int i = 0; i < courseSize; i++){
            Hole hole = new Hole();
            course.add(hole);
        }
    }

    public void play() {
        Hole hole = course.get(0);
        System.out.printf("\n\nThe hole is %s yards away.\n" +
                "The par for the hole is: %s \n" +
                "Score Card: %s\n ", hole.getDistanceToHole(), hole.getPar(), getScore());
        while(!hole.holeComplete()){
            ClubType clubType = promptForClub();
            hole.updateDistance(clubType.swingClub(clubType));
        }
        scoreCard.add(hole.score());
        course.remove(hole);
        System.out.println(getScoreCard());
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
        for(int score : scoreCard) {
            sum += score;
        }
        return sum;
    }
    private ClubType promptForClub(){
        boolean validInput = false;
        ClubType club = null;


        while(!validInput) {
            System.out.println("Please choose: [D]river, [I]ron, [W]edge, [P]utter");
            String userInput = scanner.nextLine().trim().toUpperCase();
            if(userInput.matches("[A-Z]")) {
                if("D".equals(userInput)) {
                    club = ClubType.DRIVER;
                    validInput = true;
                }
                if("I".equals(userInput)){
                    club = ClubType.IRON;
                    validInput = true;
                }
                if("W".equals(userInput)) {
                    club = ClubType.WEDGE;
                    validInput = true;
                }
                if("P".equals(userInput)) {
                    club = ClubType.PUTTER;
                    validInput = true;
                }
            }
        }
        return club;
    }

    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", holes= " + getCourseSize();
    }
}