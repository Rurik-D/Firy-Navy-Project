package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import resources.ImagesManagement;
import resources.TextManagement;
import main.core.*;
import main.navy.ComputerShip;
import main.navy.PlayerShip;
import utils.FrameProportion;



/**
 * This class generates attack and position grids.
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Grid extends JLabel implements FrameProportion{
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	private JLabel attackGridCover = ImagesManagement.getGridBackground(paramBorder, paramBorder, gridSide, gridSide);
	private Color backgroundColor = Color.orange.darker().darker().darker().darker().darker();
	private List<JLabel> missList = new ArrayList<>();
	private List<JLabel> hitList = new ArrayList<>();
	private Grid positionGrid;
	private JLabel gridBackground = ImagesManagement.getGridBackground(paramBorder, paramBorder, gridSide, gridSide);
	
	
	/**
	 * Player grid constructor
	 * 
	 */
	public Grid (int x, int y) {
		addParameters();
		setLayout(null);
		setBounds(x, y, gridSide + paramBorder + gridBorder, gridSide + paramBorder + gridBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		setNavyGrid();
	}
	
	/**
	 * Attack grid constructor
	 * 
	 */
	public Grid (int x, int y, Grid postionGrid) {
		this.positionGrid = postionGrid;
		addParameters();
		setLayout(null);
		setBounds(x, y, gridSide + paramBorder + gridBorder, gridSide + paramBorder + gridBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
		add(attackGridCover);
	}
	
	
	/**
	 * 
	 * 
	 */
	public static int getGridBorder() {
		return gridBorder;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static int getSquareSide() {
		return squareSide;
	}
	
	
	/**
	 * 
	 * 
	 */
	public Grid getGrid() {
		return this;
	}
	
	
	/**
	 * 
	 * 
	 */
	public JLabel getGridBackground() {
		return gridBackground;
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<JLabel> getHitList() {
		return hitList;
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<JLabel> getMissList() {
		return missList;
	}
	
	
	/**
	 * 
	 * 
	 */
	private  void setNavyGrid() {
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton square;
				JLabel hitLbl;
				JLabel missLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( letters[j] +  "" + i );
				hitLbl.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(squareSide));
				
				missLbl = new JLabel("");
				missLbl.setName( letters[j] +  "" + i );
				missLbl.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				missLbl.setVisible(false);
				missLbl.setIcon(ImagesManagement.getMissLbl(squareSide));
				
				square = new JButton("");
				square.setName( letters[j] +  "" + i );
				square.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				square.setOpaque(false);
				square.setContentAreaFilled(false);
				square.setVisible(true);
				square.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(), 1));
				square.setBorderPainted(true);
				square.setEnabled(false);
				
				add(missLbl);
				add(hitLbl);
				add(square);
				
				hitList.add(hitLbl);
				missList.add(missLbl);
				
			}
		}
		add(gridBackground);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void setAttackGrid(List<ComputerShip> computerNavy, List<PlayerShip> playerNavy) {	
		attackGridCover.setVisible(false);
		
		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				JButton square;
				JLabel hitLbl;
				JLabel missLbl;
				
				hitLbl = new JLabel("");
				hitLbl.setName( i + "" + j );
				hitLbl.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				hitLbl.setVisible(false);
				hitLbl.setIcon(ImagesManagement.getHitLbl(squareSide));
				
				missLbl = new JLabel("");
				missLbl.setName( letters[j] +  "" + i );
				missLbl.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				missLbl.setVisible(false);
				missLbl.setIcon(ImagesManagement.getMissLbl(squareSide));
				
				square = new JButton("");
				square.setName( letters[j] +  "" + i );
				square.setBounds(squareSide*i + paramBorder, squareSide*j + paramBorder, squareSide, squareSide);
				square.setOpaque(false);
				square.setContentAreaFilled(false);
				square.setVisible(true);
				square.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker().darker().darker().darker(),1));
				square.setBorderPainted(true);
				square.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Pve.makeAttack(hitLbl, missLbl, square);
					}
				});
				add(missLbl);
				add(hitLbl);
				add(square);
			}
		}
		add(gridBackground);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void addParameters() {
		Font paramFont = TextManagement.getParameterFont();
		for (int i = 0; i < 10; i++) {
			JLabel number = new JLabel("" + i);
			JLabel letter = new JLabel("" + letters[i]);
			
			number.setFont(paramFont);
			letter.setFont(paramFont);
			
			number.setForeground(Color.white);
			letter.setForeground(Color.white);
			
			number.setBounds(squareSide*i + paramBorder + (int) squareSide/3, 1, 30, 30);
			letter.setBounds(10, squareSide*i + paramBorder, 30, 30);
			
			add(number);
			add(letter);
			
			number.setVisible(true);
			letter.setVisible(true);

		}
	}
}
