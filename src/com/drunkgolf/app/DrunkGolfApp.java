package com.drunkgolf.app;

import static com.drunkgolf.ClubType.*;

import com.apps.util.Prompter;
import com.drunkgolf.ClubType;
import com.drunkgolf.Course;
import com.apps.util.Console;

import java.util.List;
import java.util.Scanner;

// Controller
public class DrunkGolfApp {
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private ClubType club;
    private int score;
    private List<Integer> results;


    public void execute() {
        welcome();
        int courseNum = promptForCourse();
        if (courseNum == 20) {
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
        return prompter.prompt("").equalsIgnoreCase("");
        //return scanner.nextLine().equalsIgnoreCase("");
    }

    public void teeOff(int courseNum) {
        Course currentCourse = new Course(courseNum);
        currentCourse.buildCourse();
        waitAndClear();
        while (!currentCourse.isComplete()) {
            currentCourse.getHole();
            while (!currentCourse.getHoleComplete()) {
                club = promptForClub();
                currentCourse.play(club);
                waitAndClear();
                currentCourse.currentHoleInfo();
            }
            currentCourse.setHoleComplete();
            Console.clear();
        }
        Console.clear();
        score = currentCourse.getScore();
        results = currentCourse.getScoreCard();
    }

    private void waitAndClear() {
        prompter.prompt("Hit enter to continue.");
        Console.clear();
    }

    private int promptForCourse() {
        boolean validInput = false;
        int courseSize = 0;

        while (!validInput) {
            printRules();
            String userInput = prompter.prompt("Enter amount of holes: ").trim();
//            if (userInput.equalsIgnoreCase("b")) {
//                return -1;
//            }
            courseSize = Integer.parseInt(userInput);
            if (userInput.matches("\\d{1,2}")) {
                if (courseSize == 1 || courseSize == 9 || courseSize == 18 || courseSize == 20) {
                    validInput = true;
                }
            }
        }
        return courseSize;
    }

    private ClubType promptForClub() {
        boolean validInput = false;
        ClubType club = null;


        while (!validInput) {
            //System.out.println("Please choose: [D]river, [I]ron, [W]edge, [P]utter, [R]ange for club ranges.");
            String userInput = prompter.prompt("Please choose: [D]river, [I]ron, [W]edge, [P]utter, [R]ange for club ranges.").trim().toUpperCase();
            //String userInput = scanner.nextLine().trim().toUpperCase();
            if (userInput.matches("[A-Z]")) {
                if ("D".equals(userInput)) {
                    club = ClubType.DRIVER;
                    validInput = true;
                }
                if ("I".equals(userInput)) {
                    club = ClubType.IRON;
                    validInput = true;
                }
                if ("W".equals(userInput)) {
                    club = ClubType.WEDGE;
                    validInput = true;
                }
                if ("P".equals(userInput)) {
                    club = ClubType.PUTTER;
                    validInput = true;
                }
                if ("R".equals(userInput)) {
                    System.out.println(
                            "Driver Range: " + DRIVER.getDriverRange() +
                                    "\nIron Range: " + IRON.getIronRange() +
                                    "\nWedge Range: " + WEDGE.getWedgeRange() +
                                    "\nPutter Range: " + PUTTER.getPutterRange()
                    );

                }
            }
        }
        return club;
    }

    private void printRules() {
        System.out.println("You can only enter [1] [9] [18]: ");
    }

    private void bonusLevel() {
        printChar("Welcome to the Bonus Level!\n");
        System.out.println("Press the [Enter] as many times as you can in 5 seconds to hit the ball hard!");
        waitAndClear();

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

        if (score > 0) {
            System.out.println("Score card: " + results);
            System.out.println(score);
            System.out.println();
            System.out.println("+ + + + + + + + + + + + + +");
            System.out.println("Y O U   A R E   T R A S H");
            System.out.println("+ + + + + + + + + + + + + +");
        }
        if (score == 0) {
            System.out.println("Score card: " + results);
            System.out.println(score);
            System.out.println();
            System.out.println("+ + + + + + + + + + + +");
            System.out.println("Y O U   A R E   M I D");
            System.out.println("+ + + + + + + + + + + +");
        }
        if (score < 0) {
            System.out.println("Score card: " + results);
            System.out.println(score);
            System.out.println("+ + + + + + + + + + + + + +");
            System.out.println("Y O U   W I N - K A C H O W");
            System.out.println("+ + + + + + + + + + + + + +");
        }


    }


}