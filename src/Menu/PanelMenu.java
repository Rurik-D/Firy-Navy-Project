package Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

public class PanelMenu {

	private JFrame frame;
	private Image image;
	private JLabel label;
	
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

		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\Users\\manud\\eclipse-workspace\\Firy Navy Project\\img\\yamato.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//frame.setSize(1920, 1080); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		image = img.getScaledInstance(frame.getWidth(), frame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		//image = new ImageIcon(this.getClass().getResource("/yamato.jpg"));
		label = new JLabel(imageIcon);
		
		
		frame.add(label);
		

		
	}
}
