package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.*;

import java.util.ArrayList;
import java.util.List;

public class ClassroomRecord {

    enum ClassCode {
        SixToTwelve(0), ThirteenToTwentyFour(1), TwentyFiveToThirtyFive(2), ThirtySixToFortySeven(3), FortyEightToFiftyNine(4), Sixty(5);
        public final int code;
        ClassCode(int code) {
            this.code = code;
        }
    }

    private List<List<Classroom>> classroomRecord = new ArrayList<>();

    public List<List<Classroom>> getClassroomRecord() {
        return classroomRecord;
    }

    public ClassroomRecord() {
        List<Classroom> sixToTwelveClassroomList = new ArrayList<>();
        sixToTwelveClassroomList.add(new SixToTwelveClassroom());
        classroomRecord.add(sixToTwelveClassroomList);
        List<Classroom> ThirteenToTwentyFourClassroomList = new ArrayList<>();
        ThirteenToTwentyFourClassroomList.add(new ThirteenToTwentyFourClassroom());
        classroomRecord.add(ThirteenToTwentyFourClassroomList);
        List<Classroom> TwentyFiveToThirtyFiveClassroomList = new ArrayList<>();
        TwentyFiveToThirtyFiveClassroomList.add(new TwentyFiveToThirtyFiveClassroom());
        classroomRecord.add(TwentyFiveToThirtyFiveClassroomList);
        List<Classroom> ThirtySixToFortySevenClassroomList = new ArrayList<>();
        ThirtySixToFortySevenClassroomList.add(new ThirtySixToFortySevenClassroom());
        classroomRecord.add(ThirtySixToFortySevenClassroomList);
        List<Classroom> FortyEightToFiftyNineClassroomList = new ArrayList<>();
        FortyEightToFiftyNineClassroomList.add(new FortyEightToFiftyNineClassroom());
        classroomRecord.add(FortyEightToFiftyNineClassroomList);
        List<Classroom> SixtyClassroomList = new ArrayList<>();
        SixtyClassroomList.add(new SixtyClassroom());
        classroomRecord.add(SixtyClassroomList);
    }

    private void addClassRoom(){
        for(int i = 0;i<5;i++){
            for(Classroom classroom:classroomRecord.get(i)){
                if(classroom.isFull()){
                    classroomRecord.get(i).add(getClassroom(i));
                    addClassRoom();
                    return;
                }
            }
        }

    }

    public void addStudent(Student student) {
        List<Classroom> classroomList = classroomRecord.get(getClassPosition(student.getAge()));
        for(Classroom classroom:classroomList){
            classroom.addStudent(student);
        }
    }

    public void addTeacher(Teacher teacher) {
        for(List<Classroom> classroomList:classroomRecord){
            for(Classroom classroom:classroomList){
                if(classroom.addTeacher(teacher)){
                    return;
                }
            }
        }
    }

    public int getClassPosition(int age){
        if(age >= 6 && age <= 12){
            return 0;
        }else if(age >= 13 && age <= 24){
            return 1;
        }else if(age >= 25 && age <= 35){
            return 2;
        }else if(age >= 36 && age <= 47){
            return 3;
        }else if(age >= 48 && age <= 59){
            return 4;
        }else if(age >= 60){
            return 5;
        }
        return 0;
    }

    public Classroom getClassroom(int code){
        if(code == 0){
            return new SixToTwelveClassroom();
        }else if(code == 1){
            return new ThirteenToTwentyFourClassroom();
        }else if(code == 2){
            return new TwentyFiveToThirtyFiveClassroom();
        }else if(code == 3){
            return new ThirtySixToFortySevenClassroom();
        }else if(code == 4){
            return new FortyEightToFiftyNineClassroom();
        }else {
            return new SixtyClassroom();
        }
    }
}
