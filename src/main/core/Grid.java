package main.core;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import resources.ImagesManagement;

public class Grid extends JLabel{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private int boxSide;
	
	public Grid (int x, int y, int w, int h, int border) {
	
	this.setLayout(null);
	this.setBounds(x, y, w + border * 2, h + border * 2);
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	this.setBackground(Color.BLACK);
	this.setOpaque(true);
	this.boxSide = (int) w/10;
	
	for (int i = 0; i<10; i++) {
		for (int j = 0; j<10; j++) {
			JButton box;
			box = new JButton("");
			box.setName("" + letters[j] + i);
			box.setBounds(boxSide*i + border, boxSide*j + border, boxSide, boxSide);
			box.setOpaque(false);
			box.setContentAreaFilled(false);
			box.setVisible(true);
			box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
			box.setBorderPainted(true);
			box.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.print(box.getName() + " ");
				}
			});
		this.add(box);
		}
		
	}
	this.add(ImagesManagement.getGridBackground(border, border, w, h));
	this.setVisible(false);
	}
}
