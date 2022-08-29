package main.core;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import resources.ImagesManagement;

public class Grid extends JLabel{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private static int boxSide;
	private static int lblBorder = 5;
	
	public Grid (int x, int y, int w, int h, boolean interactable) {
	
	this.setLayout(null);
	this.setBounds(x, y, w + lblBorder * 2, h + lblBorder * 2);
	this.setBackground(Color.BLACK);
	this.setOpaque(true);
	this.boxSide = (int) w/10;
	
	for (int i = 0; i<10; i++) {
		for (int j = 0; j<10; j++) {
			JButton box;

			box = new JButton("");
			box.setName("" + letters[j] + i);
			box.setBounds(boxSide*i + lblBorder, boxSide*j + lblBorder, boxSide, boxSide);
			box.setOpaque(false);
			box.setContentAreaFilled(false);
			box.setVisible(true);
			box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
			box.setBorderPainted(true);
			if (interactable) {
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print(box.getName() + " ");
					}
				});
			}
			box.setEnabled(interactable);
			this.add(box);
			
		}
		
	}
	this.add(ImagesManagement.getGridBackground(lblBorder, lblBorder, w, h));
	this.setVisible(false);
	}
	
	public static int getLblBorder() {
		return lblBorder;
	}
	
	public static int getBoxSide() {
		return boxSide;
	}
}
