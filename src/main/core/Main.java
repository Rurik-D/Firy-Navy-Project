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


public class Main{
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	public static final int WIDTH = (int)screenSize.getWidth();
//	public static final int HEIGHT = (int)screenSize.getHeight();
	public static final int WIDTH = 1536;
	public static final int HEIGHT = 864;
	private static JPanel mainPanel = new JPanel();	
	private static JFrame frame = new JFrame("Firy Navy Project");
	private static JLabel oldScroll = ImagesManagement.getOldScroll(100, 550, 700, 300);
	private static Grid playerGrid = new Grid(300, 200);
	private static Ships ships = new Ships();
	private static Grid enemyGrid = new Grid(950, 200, playerGrid);
	private static TextManagement text = new TextManagement();
	private static JScrollPane scrollPnl = new JScrollPane(text.getTextArea(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public Main() {
		setFrame();
		setMainPanel();
	}

	public static JFrame getFrame() {
		return frame;
	}
	
	public static JLabel getOldScroll() {
		return oldScroll;
	}
	
	public static JPanel getMainPanel() {
		return mainPanel;
	}
	
	public static Grid getPlayerGrid() {
		return playerGrid;
	}
	
	public static Grid getEnemyGrid() {
		return enemyGrid;
	}
	
	public static Ships getShips() {
		return ships;
	}
	
	public static JScrollPane getScrollPnl() {
		return scrollPnl;
	}
	
	public static TextManagement getText() {
		return text;
	}
	
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
		SoundsManagement.backgroundSong();
	}
	
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
	
	private void setScrollPnl() {
		mainPanel.add(scrollPnl);
		text.setTextArea();
		scrollPnl.setBackground(Color.YELLOW.darker().darker());
		scrollPnl.setBounds(860, 560, 500, 280);
		scrollPnl.setBorder(BorderFactory.createLineBorder(new Color(209, 191, 138).darker().darker().darker(), 5));
		scrollPnl.setVisible(false);
	}
	
	private void addShipsLabels() {
		for (int i = 0; i<10; i++) {
			mainPanel.add(ships.getNavy().get(i));
		}
	}
	
	private void addGrids() {
		mainPanel.add(playerGrid);
		mainPanel.add(enemyGrid);
	}
	
	private void addImages() {
		mainPanel.add(oldScroll);
		mainPanel.add(ImagesManagement.getTitle());
		mainPanel.add(ImagesManagement.getMenuBackground());
		mainPanel.add(ImagesManagement.getGameBackground());
	}
	
	public static void closeFrame() {
		frame.dispose();
	}
}