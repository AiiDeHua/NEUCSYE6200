package edu.neu.csye6200.old.Main;

import edu.neu.csye6200.old.Model.Item;
import edu.neu.csye6200.old.Model.Quest;
import edu.neu.csye6200.old.Model.Team;
import edu.neu.csye6200.old.Model.mModel;
import edu.neu.csye6200.old.View.Map;

import java.awt.*;
import java.util.ArrayList;

public class mData {
    //mData is a package of data from mModel
    public static Map map;
    public static int tmp = 0;
    public int time;
    public static int width, height;
    public static boolean isFirst = true;
    private static Point mcl;
    public int hp;
    public int health_score;
    public Team[] team;
    public Item[] item;
    public ArrayList<Quest> quests_good;
    public ArrayList<Quest> quests_bad;
    public int QuestFinish = 0;
    public int QuestNotFinish = 0;


    public mData() {
        this.map = mModel.getMap();
        this.team = mModel.getTeam();
        this.item = mModel.getItem();
        this.hp = mModel.getHp_score();
        this.time = mModel.gettime_msc();
        this.quests_good = mModel.getQuests_good();
        this.quests_bad = mModel.getQuests_need_to_be_solved();
        this.QuestFinish = mModel.getQuestFinish();
        this.QuestNotFinish = mModel.getQuestNotFinish();


    }

    public void update() {

        this.map = mModel.getMap();
        this.team = mModel.getTeam();
        this.item = mModel.getItem();
        this.time = mModel.gettime_msc();
        this.hp = mModel.getHp_score();

        this.quests_good = mModel.getQuests_good();
        this.quests_bad = mModel.getQuests_need_to_be_solved();

        this.QuestFinish = mModel.getQuestFinish();
        this.QuestNotFinish = mModel.getQuestNotFinish();
    }

}
