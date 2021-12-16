package edu.neu.csye6200.model;

import org.apache.poi.ss.usermodel.Row;

public class Teacher extends Person{
    private double credit;

    public Teacher(int age, String name,double a) {
        super(age, name);
    }

    public Teacher(Row row) {
        super(row);
        credit = row.getCell(3).getNumericCellValue();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + this.getAge() +
                "credit=" + credit +
                ", name='" + this.getName() + '\'' +
                '}';
    }

}
