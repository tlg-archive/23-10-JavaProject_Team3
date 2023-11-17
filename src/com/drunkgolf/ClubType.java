package com.drunkgolf;


public enum ClubType {
    DRIVER(200, 300),
    IRON(100, 180),
    WEDGE(30, 90),
    PUTTER(6, 20);

    public int minRange;
    public int maxRange;

    ClubType(int minRange, int maxRange) {

        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int swingClub(ClubType club) {
        double rand = Math.random() * (club.maxRange - club.minRange + 1) + club.minRange;
        System.out.printf("Your ball went %.2f yards!\n", rand);
        return (int) rand;
    }

    String getDriverRange() {
        return ClubType.DRIVER.minRange + " - " + ClubType.DRIVER.maxRange;
    }

    String getIronRange() {
        return ClubType.IRON.minRange + " - " + ClubType.IRON.maxRange;
    }

    String getWedgeRange() {
        return ClubType.WEDGE.minRange + " - " + ClubType.WEDGE.maxRange;
    }

    String getPutterRange() {
        return ClubType.PUTTER.minRange + " - " + ClubType.PUTTER.maxRange;
    }
}
