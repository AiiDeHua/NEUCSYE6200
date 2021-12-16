package edu.neu.csye6200.controller;

import edu.neu.csye6200.common.Constant;
import edu.neu.csye6200.model.classroom.ClassroomRecord;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.util.FileUtil;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class);

    Controller() {
    }

    public void readData() {
        //call view?
        List<Student> studentList = readStudentInput(Constant.EXCEL_PATH);
        List<Teacher> teacherList = readTeacherInput(Constant.EXCEL_PATH);
        studentList.forEach(x -> logger.info(x.toString()));
//        studentList.forEach(logger::info);
        teacherList.forEach(x -> logger.info(x.toString()));
        spreadToClassroom(studentList, teacherList);
    }

    public ClassroomRecord spreadToClassroom(List<Student> studentList, List<Teacher> teacherList) {
        ClassroomRecord classroomRecord = new ClassroomRecord();
        List<Student> copyStudentList = new ArrayList<>(studentList.size());
        copyStudentList.addAll(studentList);
        List<Teacher> copyTeacherList = new ArrayList<>(teacherList.size());
        copyTeacherList.addAll(teacherList);
        for (Teacher teacher : teacherList) {
            classroomRecord.addTeacher(teacher);
        }
        for (Student student : studentList) {
            classroomRecord.addStudent(student);
        }

        return classroomRecord;
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

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readData();
    }
}
