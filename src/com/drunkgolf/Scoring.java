package com.drunkgolf;

enum Scoring {
    EAGLE(-2),
    BIRDIE(-1),
    PAR(0),
    BOGEY(1),
    DOUBLE_BOGEY(2);

    private int score;

    Scoring(int score) {
        this.score = score;
    }

    int getEagle() {
        return Scoring.EAGLE.score;
    }

    int getBirdie() {
        return Scoring.BIRDIE.score;
    }

    int getPar() {
        return Scoring.PAR.score;
    }

    int getBogey() {
        return Scoring.BOGEY.score;
    }

    int getDoubleBogey() {
        return Scoring.DOUBLE_BOGEY.score;
    }
}
