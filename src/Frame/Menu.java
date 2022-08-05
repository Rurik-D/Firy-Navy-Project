package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assets.Background;
import Assets.Sounds;

public class Menu {
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //1536 * 864
	public static final int WIDTH = (int)screenSize.getWidth();
	public static final int HEIGHT = (int)screenSize.getHeight();
	//public static final int WIDTH = 1536;
	//public static final int HEIGHT = 864;
	private JFrame frame = new JFrame("Firy Navy Project");

	private JPanel menu = new JPanel();
	static JPanel exitPanel = new JPanel();
	
	
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
		int exitPnlW = (int)Math.round(WIDTH * 32.552 / 100);
		int exitPnlH = (int)Math.round(HEIGHT * 23.148 / 100);
		
		frame.getContentPane().add(exitPanel);
		frame.getContentPane().add(menu);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		menu.setLayout(null);
		
		exitPanel.setBounds(WIDTH/2 - exitPnlW/2, HEIGHT/2 - exitPnlH/2, exitPnlW, exitPnlH);
		exitPanel.setLayout(null);
		exitPanel.setVisible(false);
		exitPanel.setBackground(Color.ORANGE);
		Sounds.backgroundSong();
		new Buttons(menu, exitPanel, frame);

		menu.add(Background.getTitle());
		menu.add(Background.getMenuBackground(WIDTH, HEIGHT));
		
		menu.setVisible(true);
		
	}
	
}