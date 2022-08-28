package main.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import resources.*;
import main.core.Grid;
import main.core.Ships;

public class Main{
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //1536 * 864
//	public static final int WIDTH = (int)screenSize.getWidth();
//	public static final int HEIGHT = (int)screenSize.getHeight();
	public static final int WIDTH = 1536;
	public static final int HEIGHT = 864;
	private static JFrame frame = new JFrame("Firy Navy Project");
	private static Grid playerGrid = new Grid(300, 300, 300, 300, false);
	private static Grid enemyGrid = new Grid(950, 300, 300, 300, true);
	private static Ships ships = new Ships();

	private static JPanel mainPanel = new JPanel();	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		mainPanel.setLayout(null);
		
		for (int i = 0; i<10; i++) {
			mainPanel.add(ships.getNavy().get(i));
		}

		mainPanel.add(playerGrid);
		mainPanel.add(enemyGrid);
		
		new GameButtons(mainPanel);
		new MenuButtons(mainPanel);

		mainPanel.add(ImagesManagement.getTitle());
		mainPanel.add(ImagesManagement.getMenuBackground());
		mainPanel.add(ImagesManagement.getGameBackground());
		ImagesManagement.setCursor(frame);
		ImagesManagement.setFrameIcon(frame);
		SoundsManagement.backgroundSong();
		
		mainPanel.setVisible(true);
		
	}
	
	public static void closeFrame() {
		frame.dispose();
	}
	
	public static JFrame getFrame() {
		return frame;
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
}