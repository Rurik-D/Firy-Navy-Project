package main.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import resources.*;

public class Menu{
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //1536 * 864
//	public static final int WIDTH = (int)screenSize.getWidth();
//	public static final int HEIGHT = (int)screenSize.getHeight();
	public static final int WIDTH = 1536;
	public static final int HEIGHT = 864;
	private static JFrame frame = new JFrame("Firy Navy Project");
	private JPanel menu = new JPanel();	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.getContentPane().add(menu);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		menu.setLayout(null);
		
		new GameButtons(menu);
		new MenuButtons(menu);
		
		menu.add(ImagesManagement.getTitle());
		menu.add(ImagesManagement.getMenuBackground());
		menu.add(ImagesManagement.getGameBackground());
		ImagesManagement.setCursor(frame);
		ImagesManagement.setFrameIcon(frame);
		SoundsManagement.backgroundSong();
		
		menu.setVisible(true);
		
	}
	
	
	public static void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}