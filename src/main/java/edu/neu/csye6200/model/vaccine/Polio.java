package edu.neu.csye6200.model.vaccine;

public class Polio implements Vaccine{
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int[] getExpiringTime() {
        return new int[0];
    }
}
