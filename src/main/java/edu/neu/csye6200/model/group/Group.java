package edu.neu.csye6200.model.group;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public abstract class Group {
    private int id;
    private Teacher teacher;
    private List<Student> studentList = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (studentList.size() < getLimitSize()) {
            studentList.add(student);
            return true;
        }
        return false;
    }

    public boolean setStudentList(List<Student> studentList) {
        int i = 0;
        int count = 0;
        while (studentList.size() <= getLimitSize()) {
            this.studentList.add(studentList.get(i));
            count++;
            i++;
        }
        return count == studentList.size();
    }

    abstract int getLimitSize();

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public boolean isFull() {
        return studentList.size() == getLimitSize();
    }
}
