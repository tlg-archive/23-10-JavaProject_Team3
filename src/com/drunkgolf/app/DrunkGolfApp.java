package com.drunkgolf.app;

import com.drunkgolf.ClubType;
import com.drunkgolf.Course;

import java.util.Scanner;

// Controller
public class DrunkGolfApp {
    private final Scanner scanner = new Scanner(System.in);
    private ClubType club;


    public void execute() {
        welcome();
        int courseNum = promptForCourse();
        teeOff(courseNum);
        endResults();

    }

    public void welcome() {
        System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
        System.out.println("W E L C O M E   T O   D R U N K   G O L F");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
    }

    public void teeOff(int courseNum) {
        Course currentCourse = new Course(courseNum);
        currentCourse.buildCourse();
        while (!currentCourse.isComplete()) {
            currentCourse.play();
        }
        System.out.println(currentCourse.getScore());
    }

    private int promptForCourse() {
        boolean validInput = false;
        int courseSize = 0;

        while (!validInput) {
            printRules();
            System.out.println("Enter amount of holes: ");
            String userInput = scanner.nextLine().trim();
            courseSize = Integer.parseInt(userInput);
            if (userInput.matches("\\d{1,2}")) {
                if (courseSize == 1 || courseSize == 9 || courseSize == 18) {
                    validInput = true;
                }
            }
        }
        return courseSize;
    }

    private void printRules() {
        System.out.println("You can only enter: [1] [9] [18]");
    }


    private void endResults() {

        System.out.println();
        System.out.println("+ + + + + + + + + + + + + +");
        System.out.println("Y O U   A R E   T R A S H");
        System.out.println("+ + + + + + + + + + + + + +");
    }


}