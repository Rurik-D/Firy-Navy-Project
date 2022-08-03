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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		frame.setSize(1536, 864); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		JButton startBtn = new JButton("START");
		startBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		startBtn.setBounds(68, 679-60, 218, 21);
		frame.getContentPane().add(startBtn);
		
		JButton optionBtn = new JButton("OPTION");
		optionBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		optionBtn.setBounds(68, 679-30, 218, 21);
		frame.getContentPane().add(optionBtn);
		
		JButton exitBtn = new JButton("EXIT");
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				
				//JPanel exit = new JPanel();
				//exit.setBounds(1536/2, 864/2, 100, 60);
				//exit.setVisible(true);
			}
		});
		
		exitBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		exitBtn.setBounds(68, 679, 218, 21);
		frame.getContentPane().add(exitBtn);
		
		image = img.getScaledInstance(frame.getWidth(), frame.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		frame.getContentPane().setLayout(null);
		label = new JLabel(imageIcon);
		label.setBounds(0, 0, 1536, 864);
		
		frame.getContentPane().add(label);
		

		

		
	}
}