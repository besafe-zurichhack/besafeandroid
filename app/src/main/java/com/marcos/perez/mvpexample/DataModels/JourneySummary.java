package com.marcos.perez.mvpexample.DataModels;

/**
 * Created by Prestec on 10/14/2017.
 */

public class JourneySummary {
    private int score;
    private long timeElapsed;
    private double distanceTraveled;

    public JourneySummary(){}

    public JourneySummary(int score, long timeElapsed, double distanceTraveled) {
        this.score = score;
        this.timeElapsed = timeElapsed;
        this.distanceTraveled = distanceTraveled;
    }

    public int getScore() {
        return score;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setScore(int score){
        this.score=score;
    }
    public void setTimeElapsed(long timeElapsed){
        this.timeElapsed=timeElapsed;
    }
    public void setDistanceTraveled(double distanceTraveled){
        this.distanceTraveled=distanceTraveled;
    }
}
