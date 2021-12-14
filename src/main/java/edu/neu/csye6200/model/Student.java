package edu.neu.csye6200.model;

import org.apache.poi.ss.usermodel.Row;

public class Student extends Person{
    public Student(int age, String name) {
        super(age, name);
    }

    public Student(Row row) {
        super(row);
    }

}