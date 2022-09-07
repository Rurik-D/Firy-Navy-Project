package main.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import resources.*;
import main.frame.*;


/**
 * Firy Navy Project is a version of the classic pen-and-paper game Battleships (or Sea Battle).
 * The aim is simple: destroy the enemy navy before the opponent destroy your navy.
 * 
 * This class starts the program esecution, creates the frame and the main panel and instantiates
 * classes that do not use static methods.
 * 
 * @see main.core.Grid
 * @see main.core.Navy
 * @see utils.FrameProportion
 *
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 * 
 * @version 1.0
 */
public class Main{
	
	/*
	 * With these first three lines the program obtains the screen size and saves it in two final 
	 * variables (width and height), on which all the proportions of the window will be based.
	 */
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	public static final int WIDTH = (int)screenSize.getWidth();
//	public static final int HEIGHT = (int)screenSize.getHeight();
	public static final int WIDTH = 1536;
	public static final int HEIGHT = 864;
	
	private static JPanel mainPanel = new JPanel();	
	private static JFrame frame = new JFrame("Firy Navy Project");
	private static JLabel oldScroll = ImagesManagement.getOldScroll(100, 550, 700, 300);
	private static TextManagement textManage = new TextManagement();
	private static JScrollPane scrollPnl = new JScrollPane(textManage.getTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	
	/**
	 * This constructor creates the window and adds the main panel where all the 
	 * graphics components will be implemented.
	 * 
	 * @see main.frame.GameButtons
	 * @see main.frame.MenuButtons
	 */
	public Main() {
		setFrame();
		setMainPanel();
	}
	
	
	/**
	 * The main method begins the project esecution by instantiating the constructor
	 * of the class.
	 * 
	 * @param args eventual command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * 
	 * @return mainPanel
	 */
	public static  JPanel getMainPanel() {
		return mainPanel;
		
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JScrollPane getScrollPnl() {
		return scrollPnl;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static TextManagement getTextManage() {
		return textManage;
	}
	

	
	/**
	 * Returns a label containing the image of an old scroll, on which ships 
	 * will be spawned.
	 * 
	 * @see resources.ImagesManagement
	 * @see main.core.Navy
	 * 
	 * @return JLabel with the image of an old scroll 
	 * 
	 */
	public static JLabel getOldScroll() {
		return oldScroll;
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setFrame() {
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		ImagesManagement.setCursor(frame);
		ImagesManagement.setFrameIcon(frame);
		SoundsManagement.start("menuSong");
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setMainPanel() {
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		new GameButtons(mainPanel);
		new MenuButtons(mainPanel);
		
		setScrollPnl();
		addShipsLabels();
		addGrids();
		addImages();
	}


	/**
	 * 
	 * 
	 */
	private void setScrollPnl() {
		mainPanel.add(scrollPnl);
		textManage.setTextArea();
		scrollPnl.setBackground(Color.YELLOW.darker().darker());
		scrollPnl.setBounds(860, 560, 500, 280);
		scrollPnl.setBorder(BorderFactory.createLineBorder(new Color(209, 191, 138).darker().darker().darker(), 5));
		scrollPnl.setVisible(false);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void addShipsLabels() {
		for (int i = 0; i<10; i++) {
			mainPanel.add(Pve.getNavy().getPlayerNavy().get(i));
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	private void addGrids() {
		mainPanel.add(Pve.getPositionGrid());
		mainPanel.add(Pve.getAttackGrid());
	}
	
	
	/**
	 * 
	 * 
	 */
	private void addImages() {
		mainPanel.add(oldScroll);
		mainPanel.add(ImagesManagement.getTitle());
		mainPanel.add(ImagesManagement.getMenuBackground());
		mainPanel.add(ImagesManagement.getGameBackground());
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void closeFrame() {
		frame.dispose();
	}

}