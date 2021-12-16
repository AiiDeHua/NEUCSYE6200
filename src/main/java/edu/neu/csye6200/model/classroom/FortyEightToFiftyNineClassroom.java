package edu.neu.csye6200.model.classroom;

import edu.neu.csye6200.model.group.FortyEightToFiftyNineGroup;

public class FortyEightToFiftyNineClassroom extends Classroom{
    @Override
    int getLimitSize() {
        return 2;
    }

    public FortyEightToFiftyNineClassroom() {
        newGroup();
    }

    @Override
    void newGroup() {
        for(int i = 0;i<getLimitSize();i++){
            getGroupList().add(new FortyEightToFiftyNineGroup());
        }
    }
}
