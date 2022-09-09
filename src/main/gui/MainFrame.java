package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.core.Main;
import main.core.Pve;
import resources.ImagesManagement;
import resources.SoundsManagement;
import resources.TextManagement;

public class MainFrame {
	
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
	private static TextManagement textManage = new TextManagement();
	private static JScrollPane scrollPnl = new JScrollPane(textManage.getTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	
	/**
	 * This constructor creates the window and adds the main panel where all the 
	 * graphics components will be implemented.
	 * 
	 * @see main.frame.GameButtons
	 * @see main.frame.MenuButtons
	 */
	public MainFrame() {
		setFrame();
		setMainPanel();
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
	 * @return scrollPnl
	 */
	public static JScrollPane getScrollPnl() {
		return scrollPnl;
	}
	
	
	/**
	 * 
	 * @return textManage
	 */
	public static TextManagement getTextManage() {
		return textManage;
	}
	
	
	/**
	 * Sets frame parameters, program and cursor icons and starts menu
	 * background track.
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
		mainPanel.add(ImagesManagement.getOldScroll());
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
