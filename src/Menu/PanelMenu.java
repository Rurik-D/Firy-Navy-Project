package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assets.Background;

public class PanelMenu {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final int WIDTH = (int)screenSize.getWidth();
	private final int HEIGHT = (int)screenSize.getHeight();
	private JFrame frame = new JFrame("Firy Navy Project");

	private JPanel menu = new JPanel();
	private JPanel exitPanel = new JPanel();
	private Background background = new Background();
	
	
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
		
		exitPanel.setBounds(WIDTH/2-250, HEIGHT/2-100, 500, 200);
		exitPanel.setLayout(null);
		exitPanel.setVisible(false);
		exitPanel.setBackground(Color.ORANGE);
		
		new Buttons(menu, exitPanel, frame);

		
		menu.add(background.getTitle());
		menu.add(background.getMenuBackground(WIDTH, HEIGHT));
		
		menu.setVisible(true);
		
	}
	
}