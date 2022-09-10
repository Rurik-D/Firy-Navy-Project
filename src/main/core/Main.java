package main.core;

import java.awt.EventQueue;
import main.gui.MainFrame;


/**
 * Firy Navy Project is a version of the classic pen-and-paper game Battleships (or Sea Battle).
 * The aim is simple: destroy the enemy navy before the opponent destroy your navy.
 * 
 * This class starts the program esecution, creates the frame and the main panel and instantiates
 * classes that do not use static methods.
 * 
 * @see main.gui.Grid
 * @see main.navy.Navy
 * @see utils.FrameProportion
 *
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 * 
 * @version 1.0
 */
public class Main{
	/**
	 * The main method begins the project esecution by instantiating the MainFrame class.
	 * 
	 * @param args eventual command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}