package edu.neu.csye6200.model;
import edu.neu.csye6200.model.vaccine.VaccineFactory;
import edu.neu.csye6200.model.vaccine.VaccineRecord;
import edu.neu.csye6200.util.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

    private int age;
    private String name;
    private List<VaccineRecord> vaccineRecords = new ArrayList<>();

    public Person() {}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(Row row) {
        this.name = row.getCell(0).toString();
        this.age = (int) row.getCell(1).getNumericCellValue();
        String[] vaccineRecords = row.getCell(2).getStringCellValue().split(",");
        if(vaccineRecords.length<2){
            return;
        }
        for(int i = 0;i<vaccineRecords.length;i+=2){
            List<Date> dateList = new ArrayList<>(4);
            String[] inputDateList = vaccineRecords[i+1].split(":");
            if(inputDateList.length>1){
                for(String inputDate:inputDateList){
                    try {
                        dateList.add(DateUtil.formatter.parse(inputDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.vaccineRecords.add(new VaccineRecord(VaccineFactory.getVaccine(vaccineRecords[i]),dateList));
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name ");
        sb.append(name);
        sb.append(" age ");
        sb.append(age).append("\n");
        for(VaccineRecord vaccineRecord:vaccineRecords){
            sb.append(vaccineRecord);
        }
        sb.append("\n");
        return sb.toString();
    }
}
