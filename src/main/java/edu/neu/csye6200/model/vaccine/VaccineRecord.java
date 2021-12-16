package edu.neu.csye6200.model.vaccine;

import edu.neu.csye6200.util.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VaccineRecord {
    private Vaccine vaccine;
    private List<Date> dateList;

    public VaccineRecord(Vaccine vaccine, List<Date> dateList) {
        this.vaccine = vaccine;
        this.dateList = dateList;
    }
    public List<Date> getDateList(){return dateList;}
    public String getVacName(){return vaccine.getName();}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("vaccine name ");
        sb.append(vaccine.getName()).append(",");
        sb.append(" dates of inoculation \n");
        for(Date date:dateList){
            sb.append(DateUtil.formatter.format(date)).append(" ");
        }
        if(dateList.size()>0){
            sb.append("\n");
        }
        return sb.toString();
    }
    public Vaccine getVaccine(){
        return this.vaccine;
    }

    public static void main(String[] args) {
        String a= "a:b";
        String[] b= a.split(":");
        System.out.println(b.length);
        System.out.println(Arrays.asList(b));
    }


}
