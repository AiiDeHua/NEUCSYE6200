package edu.neu.csye6200.model.vaccine;

public class DTaP implements Vaccine{

    @Override
    public String getDescription() {
        return this.getClass().getSimpleName()+" description";
    }

    @Override
    public int[] getExpiringTime() {
        return new int[]{3650};
    }

    public static void main(String[] args) {
        DTaP a = new DTaP();
        System.out.println(a.getName());
    }
}
