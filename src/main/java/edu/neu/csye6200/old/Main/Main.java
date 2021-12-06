package edu.neu.csye6200.old.Main;

import edu.neu.csye6200.old.Controller.Controller;

import java.awt.EventQueue;
import javax.swing.Timer;


public class Main {
	static final int delay = 100;//msec 10 fps is good enough
	
	//basically just start the game by call the constructor of the controller
	//within given time delay
	public static void main(String args[]) {
		EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						Controller controller = new Controller(delay);
						Timer t = new Timer(delay, controller.drawAction);
						System.out.println("It worked!");
						t.start();
					}
				});

	}
}