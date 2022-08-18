package main.game_logic;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import resources.ImagesManagement;

public class Grid {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grid window = new Grid();
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
	public Grid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.CYAN);
		
		JPanel grid = new JPanel();
		
		grid.setBounds(100, 100, 300, 300);
		frame.getContentPane().add(grid);
		grid.setLayout(null);
		grid.setBackground(Color.RED.darker().darker());
		
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				box = new JButton("");
				box.setBounds(30*i, 30*j, 30, 30);
				box.setFont(new Font("Arial", Font.BOLD, 12));
				box.setName("" + letters[j] + i);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				box.setBorderPainted(true);
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print(box.getName() + " ");
					}
				});
				grid.add(box);
			}
			
		}
		grid.add(ImagesManagement.getGridBackground(300, 300));

		
		grid.setVisible(true);

	}
}
/*

*/