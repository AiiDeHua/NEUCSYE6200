package edu.neu.csye6200.old.Controller;

import edu.neu.csye6200.old.Main.mData;
import edu.neu.csye6200.old.Model.mModel;
import edu.neu.csye6200.old.View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class Controller {
	// global variable
	private View view;
	private mModel mm;
	public Action drawAction;;
//	private int time;
//	private int hp;
//	private ArrayList<Quest> quests_good;
//	private ArrayList<Quest> quests_bad;
	private int shp;
	private mData data;
	
	// default by false;
	public static boolean gamestart = false;
	public static boolean game_restart = false;

	// constructor
	public Controller(int delay) {

		// initiate

		// mModel is the main model for the class
		// getting info from model class for view
		// class to use
		mm = new mModel();
		data = new mData();
		
		// initiate view and get data from model
		view = new View(data);
		//serializing mModel
		try {
			serializemModel(mm);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// since using timer
		// this action would be execute every delay time that we defined in main
		// class;
		drawAction = new AbstractAction() {

			private static final long serialVersionUID = 1L;
			private int time_msec = 0;
			private int hp_score = mm.getHp().getSize();
			private int isQuest = 0;

			public void actionPerformed(ActionEvent e) {
				// check if the game need to restart and
				// reset everything if needed
				if (game_restart) {
					time_msec = 0;
					isQuest = 0;
					mm.reset();
					view.getMainScreen().getMui().init();
					view.getMainScreen().getMui().reset();
					hp_score = mm.getHp().getSize();
					gamestart = false;
					game_restart = false;
					
				//if the game is already start
				//keep things going
				} else if (gamestart) {
					// update game
					mm.updateMM(time_msec, isQuest);
					shp = mModel.getHp_score();
					data.update();
					isQuest = 0;
					view.getMainScreen().update(data);
					
					try {
						time_msec += delay;
						// indicates 1 sec in real time
						if (time_msec >= 1000 && time_msec % 1000 == 0) {

							hp_score = mModel.getHp_score();
							// if health is 0, exit the game
							if (hp_score <= 0) {
								view.updateData(data);
								view.getEnd().doClick();
							}
							// if time is over 60 sec, end the game
							if (time_msec >= 90 * 1000) {
								view.updateData(data);
								view.getEnd().doClick();
							}
						}
						// generate quest every 4 sec
						// generate two quests when started
						if (time_msec % 4000 == 0) {
							isQuest = 1;
						} else if (time_msec == 1000) {
							isQuest = 1;
						} else if (time_msec == 2000) {
							isQuest = 1;
						}
						Thread.sleep(1);

					} catch (Exception f) {

					}

				}
			}
		};
	}
	/**
	 * 
	 * @param mm
	 * @throws IOException
	 */
	private void serializemModel(mModel mm)throws IOException {
		mModel model=mm;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("mModel.txt")));
        oos.writeObject(model);
        System.out.println("serialize");
        oos.close();
	}
	
	private static mModel deserializemModel() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("mModel.txt")));
        mModel mm = (mModel) ois.readObject();
        System.out.println("deserialization！");
        return mm;
    }

	public static boolean isGamestart() {
		return gamestart;
	}
	
	/**
	 * 
	 * @param gamestart1
	 */
	public static void setGamestart(boolean gamestart1) {
		gamestart = gamestart1;
	}
	/**
	 * 
	 * @param game_restart1
	 */
	public static void setGameRestart(boolean game_restart1) {
		game_restart = game_restart1;
	}

}
