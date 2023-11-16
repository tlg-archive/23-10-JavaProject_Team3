package com.drunkgolf;

public enum ClubType {
    DRIVER(200, 300),
    IRON(100, 180),
    WEDGE(20, 80),
    PUTTER(1, 10);

    public int minRange;
    public int maxRange;

    ClubType(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

}
