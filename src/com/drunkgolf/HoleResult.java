package com.drunkgolf;

enum HoleResult {
    ALBATROSS(-3),
    EAGLE(-2),
    BIRDIE(-1),
    PAR(0),
    BOGEY(1),
    DOUBLE_BOGEY(2);

    private int score;

    HoleResult(int score) {
        this.score = score;
    }

    int getAlbatross() {
        return ALBATROSS.score;
    }

    int getEagle() {
        return EAGLE.score;
    }

    int getBirdie() {
        return BIRDIE.score;
    }

    int getPar() {
        return PAR.score;
    }

    int getBogey() {
        return BOGEY.score;
    }

    int getDoubleBogey() {
        return DOUBLE_BOGEY.score;
    }
}
