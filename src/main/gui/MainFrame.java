package main.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.core.Pve;
import resources.*;
import utils.FrameProportion;


/**
 * The purpose of this class is to create and manage the main frame and all
 * the graphics components associated with it.
 *
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 * 
 * @version 1.0
 */
public class MainFrame implements FrameProportion{
	

	
	private static JPanel mainPanel = new JPanel();	
	private static JFrame frame = new JFrame("Firy Navy Project");
	private static TextManagement textManage = new TextManagement();
	private static JScrollPane scrollPnl = new JScrollPane(textManage.getTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	
	/**
	 * This constructor creates the window and adds the main panel where 
	 * all the graphics components will be implemented.
	 * 
	 */
	public MainFrame() {
		setFrame();
		setMainPanel();
		setButtons();
		setScrollPnl();
		addShipsLabels();
		addGrids();
		addBackground();
	}
	
	
	
	/**
	 * @return mainPanel
	 * 
	 * @see main.gui.GameButtons
	 */
	public static  JPanel getMainPanel() {
		return mainPanel;
		
	}
	
	
	
	/**
	 * @return scrollPnl
	 * 
	 * @see main.gui.GameButtons
	 * @see main.gui.MenuButtons
	 */
	public static JScrollPane getScrollPnl() {
		return scrollPnl;
	}
	
	
	
	/**
	 * @return textManage
	 * 
	 * @see main.core.Pve
	 * @see main.gui.GameButtons
	 * @see main.gui.MenuButtons
	 */
	public static TextManagement getTextManage() {
		return textManage;
	}
	
	
	
	/**
	 * Sets frame parameters, program and cursor icons and starts menu
	 * background track.
	 */
	private void setFrame() {
		frame.add(mainPanel);
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
	
	
	
	private void setMainPanel() {
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
	}
	
	
	
	/**
	 * Instantiate button classes, which create all the buttons needed for 
	 * the GUI.
	 */
	private void setButtons() {
		new GameButtons(mainPanel);
		new MenuButtons(mainPanel);
	}
	


	/**
	 * Create the scroll panel which will show all the in-game activities.
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
	 * Adds all labels used for the ships to the main panel.
	 */
	private void addShipsLabels() {
		for (int i = 0; i<10; i++) {
			mainPanel.add(Pve.getNavy().getPlayerNavy().get(i));
		}
	}
	
	
	
	/**
	 * Adds the position-grid, for the positioning of the user's ships, and
	 * the attack-grid, used by the user to attack the computer.
	 */
	private void addGrids() {
		mainPanel.add(Pve.getPositionGrid());
		mainPanel.add(Pve.getAttackGrid());
	}
	
	
	
	/**
	 * Adds background images and elements.
	 */
	private void addBackground() {
		mainPanel.add(TextManagement.getTitle());
		mainPanel.add(ImagesManagement.getOldScroll());
		mainPanel.add(ImagesManagement.getMenuBackground());
		mainPanel.add(ImagesManagement.getGameBackground());
	}
	
	
	
	/**
	 * This method closes the frame (the program is in full-screen, so the 
	 * upper bar is hidden, and the program cannot be closed normally). 
	 */
	public static void closeFrame() {
		frame.dispose();
	}

}
