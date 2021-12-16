package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.group.SixToTwelveGroup;

public class SixToTwelveClassroom extends Classroom {
    @Override
    int getLimitSize() {
        return 3;
    }

    public SixToTwelveClassroom() {
        newGroup();
    }

    @Override
    void newGroup() {
        for(int i = 0;i<getLimitSize();i++){
            getGroupList().add(new SixToTwelveGroup());
        }
    }
}
