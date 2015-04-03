package com.example.lc2.randomworkoutgenerator;

/**
 * Created by Hyungryul on 4/1/2015.
 */
public class Workouts {
    private long id;
    private String workout;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return workout;
    }
}