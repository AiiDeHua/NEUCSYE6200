package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.group.ThirtySixToFortySevenGroup;

public class ThirtySixToFortySevenClassroom extends Classroom {
    @Override
    int getLimitSize() {
        return 3;
    }

    public ThirtySixToFortySevenClassroom() {
        newGroup();
    }

    @Override
    void newGroup() {
        for(int i = 0;i<getLimitSize();i++){
            getGroupList().add(new ThirtySixToFortySevenGroup());
        }
    }
}
