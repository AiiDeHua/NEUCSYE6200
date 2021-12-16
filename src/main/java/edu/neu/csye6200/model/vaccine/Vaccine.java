package edu.neu.csye6200.model.vaccine;

public interface Vaccine {
    default String getName(){
        return this.getClass().getSimpleName();
    }
    String getDescription();
    int[] getExpiringTime();
}

