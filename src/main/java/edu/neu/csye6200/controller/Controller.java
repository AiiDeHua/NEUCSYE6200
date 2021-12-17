package edu.neu.csye6200.controller;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.classroom.ClassroomRecord;
import edu.neu.csye6200.util.FileUtil;
import edu.neu.csye6200.view.Login;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class);

    Controller() {
    }

    public static List<Student> readStudentData() {
        JFileChooser j = new JFileChooser(System.getProperty("user.dir"));
        j.showOpenDialog(null);
        return readStudentInput(j.getSelectedFile().getName());
    }

    public static ClassroomRecord spreadToClassroomWithInputData(){
        return spreadToClassroom(getStudentData(),getTeacherData());
    }

    private static ClassroomRecord spreadToClassroom(List<Student> studentList, List<Teacher> teacherList) {
        ClassroomRecord classroomRecord = new ClassroomRecord();
        for (Teacher teacher : teacherList) {
            classroomRecord.addTeacher(teacher);
        }
        for (Student student : studentList) {
            classroomRecord.addStudent(student);
        }
        return classroomRecord;
    }

    public static List<Student> getStudentData(){
        return readStudentInput(Constant.EXCEL_PATH);
    }

    public static List<Teacher> getTeacherData(){
        return readTeacherInput(Constant.EXCEL_PATH);
    }

    public static List<Student> readStudentInput(String path) {
        List<Row> rowList = FileUtil.readExcelRowBySheet(path, 0);
        List<Student> studentList = new ArrayList<>(rowList.size());
        for (int i = 0; i < rowList.size(); i++) {
            if (i == 0) {
                continue;
            }
            studentList.add(new Student(rowList.get(i)));
        }

        return studentList;
    }

    public static List<Teacher> readTeacherInput(String path) {
        List<Row> rowList = FileUtil.readExcelRowBySheet(path, 1);
        List<Teacher> teacherList = new ArrayList<>(rowList.size());
        for (int i = 0; i < rowList.size(); i++) {
            if (i == 0) {
                continue;
            }
            teacherList.add(new Teacher(rowList.get(i)));
        }
        return teacherList;
    }

    public static void updateStudent(String stuInfo,String path){
        FileUtil.writeExcelRowBySheet(stuInfo,path, 0);
    }

    public static void updateTeacher(String teachInfo,String path){
        FileUtil.writeExcelRowBySheet(teachInfo,path, 1);
    }

    public static void main(String args[]) {
        Login tf = new Login();
        tf.showFrame();
    }
}
