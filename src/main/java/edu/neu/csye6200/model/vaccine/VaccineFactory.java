package edu.neu.csye6200.model.vaccine;

public class VaccineFactory {
    public static Vaccine getVaccine(String vaccineName) {
        if (vaccineName == null || vaccineName.isEmpty())
            return null;
        if (VaccineName.DTaP.name().equals(vaccineName)) {
            return new DTaP();
        } else if (VaccineName.HepatitisB.name().equals(vaccineName)) {
            return new HepatitisB();
        } else if (VaccineName.Hib.name().equals(vaccineName)) {
            return new Hib();
        } else if (VaccineName.MMR.name().equals(vaccineName)) {
            return new MMR();
        } else if (VaccineName.Polio.name().equals(vaccineName)) {
            return new Polio();
        } else if (VaccineName.Varicella.name().equals(vaccineName)) {
            return new Varicella();
        }
        return null;
    }
}
