package edu.neu.csye6200.model;

import edu.neu.csye6200.model.vaccine.Vaccine;
import edu.neu.csye6200.model.vaccine.VaccineRecord;
import org.apache.poi.ss.usermodel.Row;

import java.util.Calendar;
import java.util.Date;

public class Student extends Person{
    public Student(int age, String name) {
        super(age, name);
    }

    public Student(Row row) {
        super(row);
    }

    public Date getNextVaxDate(String name){

        Calendar c = Calendar.getInstance();

        VaccineRecord re= getVaccineRecords(name);
        //System.out.println(re.getVacName()+" "+re.getDateList().toString());
        Vaccine k =re.getVaccine();

        if(k.getExpiringTime().length==0) {return null;}
        if(re.getDateList().size()==0) {
            c.setTime(new Date());
            return c.getTime();
        }
        Date LastVaxDate=re.getDateList().get(re.getDateList().size()-1);
        int tempExpire= k.getExpiringTime()[0];
        c.setTime(LastVaxDate);
        c.add(Calendar.DATE,tempExpire);
        return c.getTime();

    }

}