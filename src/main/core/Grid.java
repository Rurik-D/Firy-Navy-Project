package main.core;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import resources.ImagesManagement;

public class Grid extends JLabel{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private static int lblBorder = 5;
	private final int W = 300;
	private final int H = 300;
	private JLabel attackGridCover = ImagesManagement.getGridBackground(lblBorder, lblBorder, W, H);
	private static int boxSide = (int) 300/10;
	
	public Grid (int x, int y) {
		setLayout(null);
		setBounds(x, y, W + lblBorder * 2, H + lblBorder * 2);
		setOpaque(true);
		setBackground(Color.BLACK);
		setVisible(false);
		setNavyGrid();
		
	}
	
	public Grid (int x, int y, List<List<int[]>> computerNavy) {
		setLayout(null);
		setBounds(x, y, W + lblBorder * 2, H + lblBorder * 2);
		setOpaque(true);
		setBackground(Color.RED.darker().darker().darker());
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
	
	private  void setNavyGrid() {
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				box = new JButton("");
				box.setName( j + "" + i );
				box.setBounds(boxSide*i + lblBorder, boxSide*j + lblBorder, boxSide, boxSide);
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(true);
				box.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
				box.setBorderPainted(true);
				box.setEnabled(false);
				this.add(box);
			}
		}
		add(ImagesManagement.getGridBackground(lblBorder, lblBorder, W, H));
	}
	
	public void setAttackGrid(List<List<int[]>> computerNavy) {		
		attackGridCover.setVisible(false);
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton box;
				JLabel hitLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( i + "" + j );
				hitLbl.setBounds(boxSide*i + lblBorder, boxSide*j + lblBorder, boxSide, boxSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(boxSide));
				
				box = new JButton("");
				box.setName( i + "" + j );
				box.setBounds(boxSide*i + lblBorder, boxSide*j + lblBorder, boxSide, boxSide);
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

								if ( box.getName().equals(occupiedBox[0] + "" + occupiedBox[1])) {
									hit = true;
									hitLbl.setVisible(true);
									break hit;
								}
							}
						}
						if (hit) {
							System.out.println(box.getName() + ", colpito!");
						} else { System.out.println(box.getName() + ", mancato!"); }
						
						box.setVisible(false);
					}
				});
				add(hitLbl);
				add(box);
			}
		}
		add(ImagesManagement.getGridBackground(lblBorder, lblBorder, W, H));
	}
}
