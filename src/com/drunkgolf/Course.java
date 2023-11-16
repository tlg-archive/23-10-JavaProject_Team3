package com.drunkgolf;

import java.util.ArrayList;
import java.util.List;

class Course {

    //fields
    int courseSize = 1; //should be course number not num of holes
    int totalPar = 3;

    //ctor
    public Course(int courseSize, int totalPar) {
        setCourseSize(courseSize);
        setTotalPar(totalPar);
    }

    //lists
    List<Integer> scoreCard = new ArrayList<>();

    //methods
    public boolean isComplete() {
        boolean complete = false;
        if (Hole.isComplete = true) {
            complete = true;
            scoreCard.add(hole.swings);
        }
        return complete;
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



    //toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", holes= " + getCourseSize() + ", par= " + getTotalPar();
    }
}