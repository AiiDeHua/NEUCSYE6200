package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.group.Group;

import java.util.ArrayList;
import java.util.List;

public abstract class Classroom {
    private List<Group> groupList = new ArrayList<>(getLimitSize());
    abstract int getLimitSize();
    abstract void newGroup();

    public boolean addStudent(Student student){
        for(Group group:groupList){
            if(!group.isFull()){
                return group.addStudent(student);
            }else {
                if(groupList.size()<getLimitSize()){
                    return group.addStudent(student);
                }
            }
        }
        return false;
    }

    public boolean addTeacher(Teacher teacher){
        for(Group group:groupList){
            if(group.getTeacher() == null){
                group.setTeacher(teacher);
                return true;
            }
        }
        return false;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public boolean isFull(){
        if(groupList.size() == 0 || groupList.size() < getLimitSize()){
            return false;
        }
        for(Group group:groupList){
            if(!group.isFull()){
                return false;
            }
        }
        return true;
    }
}
