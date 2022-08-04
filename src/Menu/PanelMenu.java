package Menu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Assets.Background;

public class PanelMenu {
	private final int WIDTH = 1536;
	private final int HEIGHT = 864;
	private JFrame frame = new JFrame("Firy Navy Project");
	private JPanel menu = new JPanel();
	private JPanel exitPanel = new JPanel();
	private Background background = new Background(WIDTH, HEIGHT);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelMenu window = new PanelMenu();
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
	public PanelMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().add(exitPanel);
		frame.getContentPane().add(menu);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		menu.setLayout(null);
		
		new Buttons(menu, exitPanel, frame);
		
		menu.add(background.getBackground());
		menu.setVisible(true);
		
	}
	
}