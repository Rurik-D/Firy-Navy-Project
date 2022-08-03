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
	private final int WIDTH = 1536;
	private final int HEIGHT = 864;
	private JFrame frame;
	//private JPanel menu;
	private Background background = new Background(WIDTH, HEIGHT);
	private Option option = new Option(WIDTH, HEIGHT);
	
	
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
		
		frame = new JFrame();
		//frame.add(menu);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		frame.setSize(WIDTH, HEIGHT); 
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		//menu.setLayout(null);
		
		
		JButton startBtn = new JButton("START");
		startBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		startBtn.setBounds(68, 679-60, 218, 21);
		frame.getContentPane().add(startBtn);
		//menu.add(startBtn);
		
		JButton optionBtn = new JButton("OPTION");
		optionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frame.add(option.getOption());
				//option.start();
				frame.getContentPane().setVisible(false);
				
			}
		});

		optionBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		optionBtn.setBounds(68, 679-30, 218, 21);
		frame.getContentPane().add(optionBtn);
		//menu.add(optionBtn);
		
		JButton exitBtn = new JButton("EXIT");
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				
				JPanel exit = new JPanel();
				//exit.setBounds(1536/2, 864/2, 100, 60);
				//exit.setVisible(true);
			}
		});
		
		exitBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		exitBtn.setBounds(68, 679, 218, 21);
		frame.getContentPane().add(exitBtn);
		//menu.add(exitBtn);
		
		
		
		frame.getContentPane().add(background.getBackground());
		//menu.add(background.getBackground());

		

		
	}
}