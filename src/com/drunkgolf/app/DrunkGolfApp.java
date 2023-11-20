package com.drunkgolf.app;

import com.drunkgolf.ClubType;
import com.drunkgolf.Course;
import com.apps.util.Console;

import java.util.Scanner;

// Controller
public class DrunkGolfApp {
    private final Scanner scanner = new Scanner(System.in);
    private ClubType club;
    private int score;


    public void execute() {
        welcome();
        int courseNum = promptForCourse();

        if (courseNum == -1) {
            bonusLevel();
        } else {
            teeOff(courseNum);
            endResults();
        }
    }

    public void welcome() {
        printChar("+ + + + + + + + + + + + + + + + + + + + +\n");
        printChar("W E L C O M E   T O   D R U N K   G O L F\n");
        printChar("+ + + + + + + + + + + + + + + + + + + + +\n");
    }

    private void printChar(String text) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isEnterPressed() {
        return scanner.nextLine().equalsIgnoreCase("");
    }

    public void teeOff(int courseNum) {
        Course currentCourse = new Course(courseNum);
        currentCourse.buildCourse();
        while (!currentCourse.isComplete()) {
            currentCourse.play();
        }
        Console.clear();
        score = currentCourse.getScore();
        System.out.println(currentCourse.getScore());
    }

    private int promptForCourse() {
        boolean validInput = false;
        int courseSize = 0;

        while (!validInput) {
            printRules();
            System.out.println("Enter amount of holes: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("b")) {
                return -1;
            }

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

    public void bonusLevel() {
        printChar("Welcome to the Bonus Level!");
        System.out.println("Press the 'Space' bar as many times as you can in 5 seconds to hit the ball hard!");

        for (int i = 3; i > 0; i--) {
            System.out.println("Starting in " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("go!");

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5000;


        int enterCount = 0;

        while (System.currentTimeMillis() < endTime) {
            if (isEnterPressed()) { //make this method
                enterCount++;
            }
        }

        int mashedDistance = enterCount * 15;
        System.out.println("Distance: " + mashedDistance + " yards");
    }


    private void endResults() {

        if(score > 0) {
            System.out.println();
            System.out.println("+ + + + + + + + + + + + + +");
            System.out.println("Y O U   A R E   T R A S H");
            System.out.println("+ + + + + + + + + + + + + +");
        }
        if(score == 0) {
            System.out.println();
            System.out.println("+ + + + + + + + + + + +");
            System.out.println("Y O U   A R E   M I D");
            System.out.println("+ + + + + + + + + + + +");
        }
        if(score < 0) {
            System.out.println();
            System.out.println("+ + + + + + + + + + + + + +");
            System.out.println("Y O U   W I N - K A C H O W");
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣴⣶⣶⣿⠿⠿⠿⢿⣶⣶⣤⣀⣀⣀⣠⣤⣤⣦⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⡿⠿⠛⠛⠉⠉⠀⠀⠀⠀⠀⠈⢿⡏⠉⢻⣿⣿⣿⣿⣿⡆⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠋⠀⠀⠀⣴⣶⡄⠀⠀⢰⣿⠀⠀⠀⠘⣷⡀⠀⢹⣿⣿⣿⣿⣿⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣇⣀⣤⣤⣤⣾⣿⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⡆\n" +
                    "⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃\n" +
                    "⠀⣰⠋⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣁⣀⣠⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n" +
                    "⣰⣷⣦⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⣿⣿⣿⣿⣿⣿⣿⠁⠈⠙⢿⣿⣿⣿⣿⠀⣿⠀\n" +
                    "⣿⣿⣿⣿⣿⣷⡀⠀⠈⠉⠉⠉⠉⠁⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠘⣿⣿⣿⣿⠀⣿⠀\n" +
                    "⣿⣿⣿⣿⣿⣿⣷⣤⣀⣀⣀⣀⣀⣀⣀⣠⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⢀⣿⣿⣿⣿⣀⣿⠀\n" +
                    "⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢀⣼⣿⠛⠛⠛⠛⠃⠀\n" +
                    "⠀⠈⠙⠻⢿⣿⣿⣿⠿⠟⠛⠛⠛⠛⠛⠉⠉⠉⠉⠉⠀⠈⠻⣿⣿⣿⣷⣶⣶⣿⡿⠁⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀");
        }


    }


}