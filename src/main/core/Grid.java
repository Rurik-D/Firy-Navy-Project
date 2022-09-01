package main.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import resources.ImagesManagement;
import resources.TextManagement;

public class Grid extends JLabel{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private static int lblBorder = 5;
	private static int parameterBorder = 30;
	private final int W = 300;
	private final int H = 300;
	private JLabel attackGridCover = ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H);
	private Color backgroundColor = Color.orange.darker().darker().darker().darker().darker();
	private static int boxSide = (int) 300/10;
	
	public Grid (int x, int y) {
		addParameters();
		setLayout(null);
		setBounds(x, y, W + parameterBorder + lblBorder, H + parameterBorder + lblBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		setNavyGrid();
		
	}
	
	public Grid (int x, int y, List<List<int[]>> computerNavy) {
		addParameters();
		setLayout(null);
		setBounds(x, y, W + parameterBorder + lblBorder, H + parameterBorder + lblBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		add(attackGridCover);

	}
	
	public static int getLblBorder() {
		return lblBorder;
	}
	
	public static int getBoxSide() {
		return boxSide;
	}
	
	
	public Grid getGrid() {
		return this;
	}
	
	public int getParameterBorder() {
		return parameterBorder;
	}
	
	private  void setNavyGrid() {
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				box = new JButton("");
				box.setName( letters[j] +  "" + i );
				box.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
				box.setBorderPainted(true);
				box.setEnabled(false);
				this.add(box);
			}
		}
		add(ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H));
	}
	
	public void setAttackGrid(List<List<int[]>> computerNavy) {	
		TextManagement text = Main.getText();
		attackGridCover.setVisible(false);
		
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				JLabel hitLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( i + "" + j );
				hitLbl.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(boxSide));
				
				box = new JButton("");
				box.setName( letters[j] +  "" + i );
				box.setBounds(boxSide*i + parameterBorder, boxSide*j + parameterBorder, boxSide, boxSide);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
				box.setBorderPainted(true);
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean hit = false;
						hit:
						for (List<int[]> ship: computerNavy) {
							for (int[] occupiedBox : ship) {	

								if ( box.getName().equals(letters[occupiedBox[1]] + "" + occupiedBox[0])) {
									String coordinates = box.getName();
									hit = true;
									text.hitMessage(1, coordinates);
									hitLbl.setVisible(true);
									break hit;
								}
							}
						}
						if (!hit) { text.missMessage(1, box.getName()); }
						
						box.setVisible(false);
					}
				});
				add(hitLbl);
				add(box);
			}
		}
		add(ImagesManagement.getGridBackground(parameterBorder, parameterBorder, W, H));
	}
	
	private void addParameters() {
		Font paramFont = TextManagement.getParameterFont();
		for (int i = 0; i < 10; i++) {
			JLabel number = new JLabel("" + i);
			JLabel letter = new JLabel("" + letters[i]);
			
			number.setFont(paramFont);
			letter.setFont(paramFont);
			
			number.setForeground(Color.white);
			letter.setForeground(Color.white);
			
			number.setBounds(boxSide*i + parameterBorder + (int) boxSide/3, 1, 30, 30);
			letter.setBounds(10, boxSide*i + parameterBorder, 30, 30);
			
			add(number);
			add(letter);
			
			number.setVisible(true);
			letter.setVisible(true);

		}
	}
}
