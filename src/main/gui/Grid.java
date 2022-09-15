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
	private JLabel gridBackground = ImagesManagement.getGridBackground(paramBorder, paramBorder, gridSide, gridSide);
	private int x;
	private int y;
	
	
	/**
	 * Grid constructor can creates a position-grid
	 * 
	 * @param int x is the x position from which to create the grid
	 * @param int y is the y position from which to create the grid
	 * @param int type is the type of the grid: 1 position grid, 2 attack grid
	 * 
	 * @see main.core.Pve
	 * @see main.core.Pvp
	 * 
	 */
	public Grid (int x, int y, int type) {
		this.x = x;
		this.y = y;
		setGrid();
		
		if (type == 1) {
			setPosGridButtons();
		} else {
			add(attackGridCover);
		}
	}
	
	
	/**
	 * @see main.navy.PlayerShip
	 */
	public static int getGridBorder() {
		return gridBorder;
	}
	
	
	/**
	 * @see main.navy.Ship
	 */
	public static int getSquareSide() {
		return squareSide;
	}
	
	
	/**
	 * @see main.gui.GameButtons
	 */
	public JLabel getGridBackground() {
		return gridBackground;
	}
	
	
	/**
	 * @see main.core.Pve
	 */
	public List<JLabel> getHitList() {
		return hitList;
	}
	
	
	/**
	 * @see main.core.Pve
	 */
	public List<JLabel> getMissList() {
		return missList;
	}
	
	
	/**
	 * Sets grid parameters
	 */
	private void setGrid() {
		addParameters();
		setLayout(null);
		setBounds(x, y, gridSide + paramBorder + gridBorder, gridSide + paramBorder + gridBorder);
		setOpaque(true);
		setBackground(backgroundColor);
		setVisible(false);
	}
	
	
	/**
	 * 
	 * 
	 */
	private  void setPosGridButtons() {
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
	public void setAttGridButtons(List<ComputerShip> computerNavy, List<PlayerShip> playerNavy) {	
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
