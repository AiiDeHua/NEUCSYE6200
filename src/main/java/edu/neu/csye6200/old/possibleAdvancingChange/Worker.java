package edu.neu.csye6200.old.possibleAdvancingChange;


import edu.neu.csye6200.old.Model.Quest;

import javax.tools.Tool;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


abstract class Worker {
	//save for possible future use
	BufferedImage[] workerAnimation;
	int workerFrame;
	int[] location;
	int movementSpeed;
	
	Worker workerSelected; 
	Tool toolSelected;
	Quest counterSelected;
	
	ArrayList<Tool> inventory;
	Tool item1;
	Tool item2;
	Tool item3;
	int item1DMG;
	int item2DMG;
	int item3DMG;
	
	abstract void setSelectedWorker(Event e);
	abstract void setSelectedTool(Event e);
	
	abstract void move(Event e);
	abstract void updateCoordinates(Worker workerSelected);
	abstract void calcToolCounter();
	
	abstract int getWorkerFrame();
	abstract int[] getLocation();
	abstract int getMovementSpeed();
	
	abstract Worker getWorkerSelected();
	abstract Tool getToolSelected();
	
}
