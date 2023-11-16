package com.drunkgolf;

import java.util.ArrayList;
import java.util.List;

public class Course {

    //fields
    int courseSize = 1;
    int totalPar = 3;
    boolean complete = false;

    //ctor
    public Course(int courseSize) {
        this.courseSize = courseSize;
    }

    public Course(int courseSize, int totalPar) {
        this(courseSize);
        setTotalPar(totalPar);
    }

    //lists
    List<Integer> scoreCard = new ArrayList<>();
    List<Hole> holes = new ArrayList<>();

    //methods
    public boolean isComplete() { // says course is complete after one hole is complete
        if (Hole.isComplete = true) {
            complete = true;
            scoreCard.add(Hole.score());
        }
        return complete;
    }

    public void getHoles(){
        for (int i = 0; i < courseSize; i++){
            Hole hole = new Hole();
            holes.add(hole);
        }
        System.out.println(holes);
    }

    //accessors
    public int getCourseSize() {
        return courseSize;
    }

    public int getTotalPar() {
        return totalPar;
    }

    public void setCourseSize(int courseSize) {
        this.courseSize = courseSize;
    }

    public void setTotalPar(int totalPar) {
        this.totalPar = totalPar;
    }

    public void getScoreCard() {
        System.out.println(scoreCard);
    }

    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", holes= " + getCourseSize() + ", par= " + getTotalPar();
    }
}