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
    public int swingClub(ClubType club){
        double rand = Math.random() * (club.maxRange - club.minRange + 1) + club.minRange;
        System.out.printf("Your ball went %.2f yards!", rand);
        return (int) rand;
    }

}
