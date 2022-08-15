package main.frame;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import resources.*;

public class Menu {
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //1536 * 864
	public static final int WIDTH = (int)screenSize.getWidth();
	public static final int HEIGHT = (int)screenSize.getHeight();
	//public static final int WIDTH = 1536;
	//public static final int HEIGHT = 864;
	private JFrame frame = new JFrame("Firy Navy Project");
	private JPanel menu = new JPanel();
	private Toolkit kit = Toolkit.getDefaultToolkit();
	
	
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

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
		    	Image image = kit.getImage("src/resources/images/missile.png");
		    	Cursor a = kit.createCustomCursor(image , new Point(1, 1), null);
		    	frame.setCursor (a);
			}
		});

		Image img = kit.getImage("src/resources/images/ship.png");
		frame.setIconImage(img);
		
		frame.getContentPane().add(menu);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		menu.setLayout(null);
		
		Sounds.backgroundSong();
		new Buttons(menu, frame);

		menu.add(Background.getTitle());
		menu.add(Background.getMenuBackground());
		menu.add(Background.getGameBackground());
		
		menu.setVisible(true);
		
	}
	
}