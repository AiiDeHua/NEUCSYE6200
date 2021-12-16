package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.group.TwentyFiveToThirtyFiveGroup;

public class TwentyFiveToThirtyFiveClassroom extends Classroom {
    @Override
    int getLimitSize() {
        return 3;
    }

    public TwentyFiveToThirtyFiveClassroom() {
        newGroup();
    }

    @Override
    void newGroup() {
        for(int i = 0;i<getLimitSize();i++){
            getGroupList().add(new TwentyFiveToThirtyFiveGroup());
        }
    }
}
